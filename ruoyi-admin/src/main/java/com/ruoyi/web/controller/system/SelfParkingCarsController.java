package com.ruoyi.web.controller.system;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.mapper.SelfParkingCarsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SelfParkingCars;
import com.ruoyi.system.service.ISelfParkingCarsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆Controller
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@RestController
@RequestMapping("/system/cars")
public class SelfParkingCarsController extends BaseController
{
    @Autowired
    private ISelfParkingCarsService selfParkingCarsService;

    @Autowired
    private SelfParkingCarsMapper selfParkingCarsMapper;

    /**
     * 查询车辆列表
     */
    @PreAuthorize("@ss.hasPermi('system:cars:list')")
    @GetMapping("/list")
    public TableDataInfo list(SelfParkingCars selfParkingCars)
    {
        startPage();
        List<SelfParkingCars> list = selfParkingCarsService.selectSelfParkingCarsList(selfParkingCars);
        return getDataTable(list);
    }

    /**
     * 导出车辆列表
     */
    @PreAuthorize("@ss.hasPermi('system:cars:export')")
    @Log(title = "车辆", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfParkingCars selfParkingCars)
    {
        List<SelfParkingCars> list = selfParkingCarsService.selectSelfParkingCarsList(selfParkingCars);
        ExcelUtil<SelfParkingCars> util = new ExcelUtil<SelfParkingCars>(SelfParkingCars.class);
        util.exportExcel(response, list, "车辆数据");
    }

    /**
     * 获取车辆详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cars:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfParkingCarsService.selectSelfParkingCarsById(id));
    }

    /**
     * 新增车辆
     */
    @PreAuthorize("@ss.hasPermi('system:cars:add')")
    @Log(title = "车辆", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfParkingCars selfParkingCars)
    {
        return toAjax(selfParkingCarsService.insertSelfParkingCars(selfParkingCars));
    }

    /**
     * 修改车辆
     */
    @PreAuthorize("@ss.hasPermi('system:cars:edit')")
    @Log(title = "车辆", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfParkingCars selfParkingCars)
    {
        String parking = String.valueOf(1);
        String leaving = String.valueOf(2);
        SelfParkingCars cars = selfParkingCars;
        if (parking.equals(cars.getStateParking())) {
            Date inTime = new Date();
            cars.setCarInTime(inTime);
            cars.setCarOutTime(null);
            return toAjax(selfParkingCarsMapper.updateOutTimeToNull(cars));
        } else if (leaving.equals(cars.getStateParking())) {
            Date now = new Date();
            cars.setCarOutTime(now);
        }
        return toAjax(selfParkingCarsService.updateSelfParkingCars(cars));
    }

    /**
     * 删除车辆
     */
    @PreAuthorize("@ss.hasPermi('system:cars:remove')")
    @Log(title = "车辆", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfParkingCarsService.deleteSelfParkingCarsByIds(ids));
    }

    /**
     * 车辆入场
     */
    @PreAuthorize("@ss.hasPermi('system:cars:parking')")
    @Log(title = "车辆入场", businessType = BusinessType.INSERT)
    @GetMapping("/parkingCars/{carIdKey}")
    public AjaxResult parking(@PathVariable String carIdKey) {
        // 获取所有已入场但未出场的车辆信息
        List<SelfParkingCars> carsList = this.selfParkingCarsMapper.selectUnfinishedParkingCars();
        for (SelfParkingCars car : carsList) {
            if (carIdKey.equals(car.getCarId())) {
                return AjaxResult.error("车辆已在停车场中！");
            }
        }
        SelfParkingCars selfParkingCars = new SelfParkingCars();
        selfParkingCars.setCarId(carIdKey);
        Date date = new Date();
        selfParkingCars.setCarInTime(date);
        selfParkingCars.setStateParking("1");
        selfParkingCars.setParkingCost("3");
        selfParkingCarsService.calculateAndUpdateParkingFee();
        return toAjax(selfParkingCarsService.insertSelfParkingCars(selfParkingCars));
    }

    /**
     * 车辆出场
     */
    @PreAuthorize("@ss.hasPermi('system:cars:leaving')")
    @Log(title = "车辆出场", businessType = BusinessType.UPDATE)
    @GetMapping("/leavingCars/{carIdKey}")
    public AjaxResult leaving(@PathVariable String carIdKey) {
        // 获取所有已入场但未出场的车辆信息
        List<SelfParkingCars> carsList = this.selfParkingCarsMapper.selectUnfinishedParkingCars();
        // 循环查找未出场的车牌号
        for (SelfParkingCars selfParkingCars : carsList) {
            if (carIdKey.equals(selfParkingCars.getCarId())) {
                Date now = new Date();
                // 设定车辆出场时间和出场状态
                selfParkingCars.setCarOutTime(now);
                selfParkingCars.setStateParking("2");
                // 更新车辆出场最终票价
                Date carInTime = selfParkingCars.getCarInTime();
                long diffMillis = now.getTime() - carInTime.getTime();
                long diffHours = TimeUnit.MILLISECONDS.toHours(diffMillis);
                int unitPrice = 2; // 假设单价为2元/小时
                int parkingFee = (int) (diffHours * unitPrice) + 3;
                selfParkingCars.setParkingCost(String.valueOf(parkingFee));
                return toAjax(selfParkingCarsService.updateSelfParkingCars(selfParkingCars));
            }
        }
        return AjaxResult.error("车辆信息不存在");
    }

    /**
     * 获取车辆信息
     */
    @PreAuthorize("@ss.hasPermi('system:cars:search')")
    @GetMapping("/searchCars/{carIdKey}")
    public TableDataInfo search(@PathVariable String carIdKey) {
        SelfParkingCars car = new SelfParkingCars();
        car.setCarId(carIdKey);
        List<SelfParkingCars> carList = this.selfParkingCarsMapper.selectSelfParkingCarsList(car);
        // 获取当前日期（年月日）
        LocalDate currentDate = LocalDate.now();
        // 创建新的列表，用于存储年月日相同的元素
        List<SelfParkingCars> filteredList = new ArrayList<>();
        // 遍历carList中的每个元素
        for (SelfParkingCars parkingCar : carList) {
            // 提取carInTime的年月日
            LocalDate carInDate = parkingCar.getCarInTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            // 将提取的年月日与当前日期进行比较
            if (carInDate.isEqual(currentDate)) {
                // 入场年月日相同，将元素添加到新的列表中
                filteredList.add(parkingCar);
            } else if (parkingCar.getCarOutTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isEqual(currentDate)) {
                // 出场年月日相同，将元素添加到新的列表中
                filteredList.add(parkingCar);
            }
        }
        System.out.println(filteredList);
        return getDataTable(filteredList);
    }

    /**
     * 定时触发计算并更新停车费用任务
     */
    @Scheduled(fixedRate = 60000) // 每隔1分钟触发一次
    public void scheduledCalculateParkingFee() {
        selfParkingCarsService.calculateAndUpdateParkingFee();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println("计算并更新停车费用成功 - " + formattedDateTime);
        // calculateParkingCounts();
    }

    /**
     * 出入场时计算并更新停车场车辆数据
     */
    @GetMapping("/getParkingCount")
    public TableDataInfo calculateParkingCounts() {
        List countsList = new ArrayList<>();
        int totalCount = 10; //停车场车位总数
        int parkingCount = selfParkingCarsMapper.getCurrentParkingCounts();
        // 创建totalCount的键值对，并添加到countsList中
        Map<String, Object> totalCountMap = new HashMap<>();
        totalCountMap.put("name", "totalCount");
        totalCountMap.put("value", totalCount);
        countsList.add(totalCountMap);
        // 创建parkingCount的键值对，并添加到countsList中
        Map<String, Object> parkingCountMap = new HashMap<>();
        parkingCountMap.put("name", "parkingCount");
        parkingCountMap.put("value", parkingCount);
        countsList.add(parkingCountMap);
        System.out.println("获取停车场停车数成功 - " + parkingCount);
        return getDataTable(countsList);
    }

}

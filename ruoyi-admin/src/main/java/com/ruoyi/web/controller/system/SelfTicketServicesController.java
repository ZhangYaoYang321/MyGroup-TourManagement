package com.ruoyi.web.controller.system;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.SelfParkingCars;
import com.ruoyi.system.domain.SelfTicketPrices;
import com.ruoyi.system.domain.SelfVisitors;
import com.ruoyi.system.mapper.SelfTicketServicesMapper;
import com.ruoyi.system.service.ISelfTicketPricesService;
import com.ruoyi.system.service.ISelfVisitorsService;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SelfTicketServices;
import com.ruoyi.system.service.ISelfTicketServicesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 票务Controller
 *
 * @author ruoyi
 * @date 2023-06-26
 */
@RestController
@RequestMapping("/system/ticket_services")
public class SelfTicketServicesController extends BaseController
{
    @Autowired
    private ISelfTicketServicesService selfTicketServicesService;

    @Autowired
    private ISelfVisitorsService selfVisitorsService;

    @Autowired
    private SelfTicketServicesMapper selfTicketServicesMapper;

    @Autowired
    private ISelfTicketPricesService selfTicketPricesService;

    /**
     * 查询票务列表
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:list')")
    @GetMapping("/list")
    public TableDataInfo list(SelfTicketServices selfTicketServices)
    {
        startPage();
        List<SelfTicketServices> list = selfTicketServicesService.selectSelfTicketServicesList(selfTicketServices);
        return getDataTable(list);
    }

    /**
     * 导出票务列表
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:export')")
    @Log(title = "票务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfTicketServices selfTicketServices)
    {
        List<SelfTicketServices> list = selfTicketServicesService.selectSelfTicketServicesList(selfTicketServices);
        ExcelUtil<SelfTicketServices> util = new ExcelUtil<SelfTicketServices>(SelfTicketServices.class);
        util.exportExcel(response, list, "票务数据");
    }

    /**
     * 获取票务详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfTicketServicesService.selectSelfTicketServicesById(id));
    }

    /**
     * 新增票务
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:add')")
    @Log(title = "票务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfTicketServices selfTicketServices)
    {
        SelfTicketServices selfTicketServices11 = selfTicketServices;
//        System.out.println(selfTicketServices11);
        selfTicketServices11.setTypeTicket("0");
        return toAjax(selfTicketServicesService.insertSelfTicketServices(selfTicketServices11));
    }

    /**
     * 修改票务
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:edit')")
    @Log(title = "票务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfTicketServices selfTicketServices)
    {
        return toAjax(selfTicketServicesService.updateSelfTicketServices(selfTicketServices));
    }

    /**
     * 删除票务
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:remove')")
    @Log(title = "票务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfTicketServicesService.deleteSelfTicketServicesByIds(ids));
    }


    //结合时间和游客的cnID，写一个函数，使用哈希求出一个9位的票号
    public String getTicketIdHash(String cnId){
        String time = String.valueOf(System.currentTimeMillis());
        String hash = String.valueOf((cnId + time).hashCode()).substring(1,9);
        return hash;
    }

    /**
     * 游客预约
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:appoint')")
    @Log(title = "票务", businessType = BusinessType.INSERT)
    @PostMapping("/appoint")
    public AjaxResult appoint(@RequestBody SelfTicketServices selfTicketServices)
    {
        if(selfTicketServices.getScheduledDate().toInstant().
                atZone(ZoneId.systemDefault()).toLocalDate().isBefore(LocalDate.now())){
            return AjaxResult.error("预约时间不能早于当前时间");
        }

        SelfTicketServices selfTicketServices11 = selfTicketServices;
        System.out.println(selfTicketServices11);
        selfTicketServices11.setTicketId(Long.valueOf(getTicketIdHash(selfTicketServices11.getCnId())));

        SelfVisitors selfVisitors = new SelfVisitors();
        selfVisitors.setVisitorsName(selfTicketServices11.getVisitorsName());
        selfVisitors.setPhoneNumber(selfTicketServices11.getPhoneNumber());
        selfVisitors.setCnId(selfTicketServices11.getCnId());
        selfVisitors.setTicketId(selfTicketServices11.getTicketId());

        List<SelfTicketServices> list = selfTicketServicesService.selectSelfTicketServicesByCnId(selfTicketServices11.getCnId());
        for(SelfTicketServices selfTicketServices1 : list){
            if(selfTicketServices1.getScheduledDate().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate().equals(
                            selfTicketServices.getScheduledDate().toInstant()
                                    .atZone(ZoneId.systemDefault()).toLocalDate()
                    )){
                return AjaxResult.error("该游客已经预约了当日门票!");
            }
        }

        selfTicketServices11.setStateVisit("0");

        selfVisitorsService.insertSelfVisitors(selfVisitors);//插入游客信息数据库中

        return toAjax(selfTicketServicesService.insertSelfTicketServices(selfTicketServices11));
    }

    /**
     * 游客查询信息
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:checkInfo')")
    @GetMapping(value = "/checkInfo/{cnId}")
    public TableDataInfo checkInfo(@PathVariable("cnId") String cnId)
    {
//        Long cnIdLong = Long.valueOf(cnId);
        List<SelfTicketServices> list = selfTicketServicesService.selectSelfTicketServicesByCnId(cnId);
        System.out.println(list);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('system:ticket_services:inPark')")
    @GetMapping(value = "/inPark/{cnId}")
    public AjaxResult inPark(@PathVariable("cnId") String cnId)
    {
        List<SelfTicketServices> list = selfTicketServicesService.selectSelfTicketServicesByCnId(cnId);
        int i = 0;
        List<SelfTicketServices> listIsToday = new ArrayList<>();

        for (SelfTicketServices sts : list) {
            LocalDate currentDate = LocalDate.now();
            boolean isScheduledTime = sts.getScheduledDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isEqual(currentDate);
            i++;
            if (isScheduledTime) listIsToday.add(sts);
            System.out.println(sts.getStateVisit() + " " + Objects.equals(sts.getStateVisit(), "1"));
        }

        if (!listIsToday.isEmpty()) {
            for (SelfTicketServices j : listIsToday) {
                if (cnId.equals(j.getCnId()) && j.getStateVisit()!=null &&
                        Objects.equals(j.getStateVisit(), "1")) {
                    if(i != list.size()) continue;
                    return AjaxResult.error("请勿重复登记入园！");
                }

                if (cnId.equals(j.getCnId()) && j.getStateVisit()!=null &&
                        Objects.equals(j.getStateVisit(), "2")){
                    if(i != list.size()) continue;
                    return AjaxResult.error("该票已经过期！请重新预约！");
                }
                return toAjax(selfTicketServicesService.updateVisitorInTime2(j.getId()));
            }
        } else {
            if(i != list.size()) return AjaxResult.error("请在预约日期当天入园！");
        }

        return AjaxResult.error("该游客未预约！");
    }

    @PreAuthorize("@ss.hasPermi('system:ticket_services:outPark')")
    @GetMapping(value = "/outPark/{cnId}")
    public AjaxResult outPark(@PathVariable("cnId") String cnId)
    {
        List<SelfTicketServices> list = selfTicketServicesService.selectSelfTicketServicesByCnId(cnId);
        int i = 0;
        for (SelfTicketServices sts : list) {
            LocalDate currentDate = LocalDate.now();
            boolean isScheduledTime = sts.getScheduledDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isEqual(currentDate);
            i++;
            if (cnId.equals(sts.getCnId()) && !isScheduledTime) {
                if(i != list.size()) continue;
                return AjaxResult.error("请在预约日期当天入园！");
            }
            if (cnId.equals(sts.getCnId()) && sts.getStateVisit()!=null &&
                    Objects.equals(sts.getStateVisit(), "0")) {
                if(i != list.size()) continue;
                return AjaxResult.error("该游客未入园！");
            }
            if (cnId.equals(sts.getCnId()) && sts.getStateVisit()!=null &&
                    Objects.equals(sts.getStateVisit(), "2")){
                if(i != list.size()) continue;
                return AjaxResult.error("该游客已出园！");
            }
            return toAjax(selfTicketServicesService.updateVisitorOutTime2(sts.getId()));
        }
        return AjaxResult.error("请刷新重试！！");
    }

    @GetMapping(value = "/getPeopleCounts")
    public TableDataInfo getPeopleCounts()
    {
        List countsList = new ArrayList<>();
        int totalCount = 10;
        int peopleCount = selfTicketServicesMapper.getPeopleCounts();
        Map<String, Object> totalCountMap = new HashMap<>();
        totalCountMap.put("name", "totalCount");
        totalCountMap.put("value", totalCount);
        countsList.add(totalCountMap); // 创建peopleCount的键值对，并添加到countsList中
        Map<String, Object> peopleCountMap = new HashMap<>();
        peopleCountMap.put("name", "peopleCount");
        peopleCountMap.put("value", peopleCount);
        countsList.add(peopleCountMap);
        System.out.println("获取景区当前在园人数成功 : " + peopleCount);
        List<SelfTicketPrices> tickets = selfTicketPricesService.selectSelfTicketPricesList(new SelfTicketPrices());
        countsList.add(tickets);
        return getDataTable(countsList);
    }

}

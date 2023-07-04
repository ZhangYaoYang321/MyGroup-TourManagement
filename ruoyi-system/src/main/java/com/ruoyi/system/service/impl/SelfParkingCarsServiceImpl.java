package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfParkingCarsMapper;
import com.ruoyi.system.domain.SelfParkingCars;
import com.ruoyi.system.service.ISelfParkingCarsService;

/**
 * 车辆Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@Service
public class SelfParkingCarsServiceImpl implements ISelfParkingCarsService 
{
    @Autowired
    private SelfParkingCarsMapper selfParkingCarsMapper;

    /**
     * 查询车辆
     * 
     * @param id 车辆主键
     * @return 车辆
     */
    @Override
    public SelfParkingCars selectSelfParkingCarsById(Long id)
    {
        return selfParkingCarsMapper.selectSelfParkingCarsById(id);
    }

    /**
     * 查询车辆列表
     * 
     * @param selfParkingCars 车辆
     * @return 车辆
     */
    @Override
    public List<SelfParkingCars> selectSelfParkingCarsList(SelfParkingCars selfParkingCars)
    {
        return selfParkingCarsMapper.selectSelfParkingCarsList(selfParkingCars);
    }

    /**
     * 新增车辆
     * 
     * @param selfParkingCars 车辆
     * @return 结果
     */
    @Override
    public int insertSelfParkingCars(SelfParkingCars selfParkingCars)
    {
        return selfParkingCarsMapper.insertSelfParkingCars(selfParkingCars);
    }

    /**
     * 修改车辆
     * 
     * @param selfParkingCars 车辆
     * @return 结果
     */
    @Override
    public int updateSelfParkingCars(SelfParkingCars selfParkingCars)
    {
        return selfParkingCarsMapper.updateSelfParkingCars(selfParkingCars);
    }

    /**
     * 批量删除车辆
     * 
     * @param ids 需要删除的车辆主键
     * @return 结果
     */
    @Override
    public int deleteSelfParkingCarsByIds(Long[] ids)
    {
        return selfParkingCarsMapper.deleteSelfParkingCarsByIds(ids);
    }

    /**
     * 删除车辆信息
     * 
     * @param id 车辆主键
     * @return 结果
     */
    @Override
    public int deleteSelfParkingCarsById(Long id)
    {
        return selfParkingCarsMapper.deleteSelfParkingCarsById(id);
    }

    /**
     * 更新停车费
     */
    @Override
    public void calculateAndUpdateParkingFee() {
        // 获取所有已入场但未出场的车辆信息
        List<SelfParkingCars> carsList = selfParkingCarsMapper.selectUnfinishedParkingCars();
        // 遍历车辆列表，计算并更新停车费用
        for (SelfParkingCars car : carsList) {
            Date carInTime = car.getCarInTime();
            Date now = new Date();
            long diffMillis = now.getTime() - carInTime.getTime();
            long diffHours = TimeUnit.MILLISECONDS.toHours(diffMillis);
            int unitPrice = 2; // 假设单价为2元/小时
            int parkingFee = (int) (diffHours * unitPrice) + 3;
            // 更新停车费用
            car.setParkingCost(String.valueOf(parkingFee));
            selfParkingCarsMapper.updateSelfParkingCars(car);
        }
    }

}

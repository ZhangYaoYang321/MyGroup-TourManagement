package com.ruoyi.system.mapper;

import java.util.Date;
import java.util.List;
import com.ruoyi.system.domain.SelfParkingCars;

/**
 * 车辆Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public interface SelfParkingCarsMapper 
{
    /**
     * 查询车辆
     * 
     * @param id 车辆主键
     * @return 车辆
     */
    public SelfParkingCars selectSelfParkingCarsById(Long id);

    /**
     * 查询车辆列表
     * 
     * @param selfParkingCars 车辆
     * @return 车辆集合
     */
    public List<SelfParkingCars> selectSelfParkingCarsList(SelfParkingCars selfParkingCars);

    /**
     * 新增车辆
     * 
     * @param selfParkingCars 车辆
     * @return 结果
     */
    public int insertSelfParkingCars(SelfParkingCars selfParkingCars);

    /**
     * 修改车辆
     * 
     * @param selfParkingCars 车辆
     * @return 结果
     */
    public int updateSelfParkingCars(SelfParkingCars selfParkingCars);

    /**
     * 删除车辆
     * 
     * @param id 车辆主键
     * @return 结果
     */
    public int deleteSelfParkingCarsById(Long id);

    /**
     * 批量删除车辆
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSelfParkingCarsByIds(Long[] ids);

    /**
     * 查询所有已入场但未出场的车辆信息
     */
    List<SelfParkingCars> selectUnfinishedParkingCars();

    /**
     * 车辆入场状态时将出场时间设置为空
     */
    public int updateOutTimeToNull(SelfParkingCars selfParkingCars);

    /**
     * 查询当前停车场停车数
     */
    public int getCurrentParkingCounts();

}

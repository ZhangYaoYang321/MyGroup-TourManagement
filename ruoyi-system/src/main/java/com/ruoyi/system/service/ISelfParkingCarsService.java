package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SelfParkingCars;

/**
 * 车辆Service接口
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public interface ISelfParkingCarsService 
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
     * 批量删除车辆
     * 
     * @param ids 需要删除的车辆主键集合
     * @return 结果
     */
    public int deleteSelfParkingCarsByIds(Long[] ids);

    /**
     * 删除车辆信息
     * 
     * @param id 车辆主键
     * @return 结果
     */
    public int deleteSelfParkingCarsById(Long id);

    /**
     * 计算并更新停车费用
     */
    public void calculateAndUpdateParkingFee();

    /**
     * 对列表进行排序
     *
     * @param sortedList 排序列表
     * @return 排序后的车辆集合
     */
    public List<SelfParkingCars> pageByList(List sortedList, Integer pageNum, Integer pageSize);

}

package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SelfEmergencyComplete;

/**
 * 事件处理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-27
 */
public interface SelfEmergencyCompleteMapper 
{
    /**
     * 查询事件处理
     * 
     * @param id 事件处理主键
     * @return 事件处理
     */
    public SelfEmergencyComplete selectSelfEmergencyCompleteById(Long id);

    /**
     * 查询事件处理列表
     * 
     * @param selfEmergencyComplete 事件处理
     * @return 事件处理集合
     */
    public List<SelfEmergencyComplete> selectSelfEmergencyCompleteList(SelfEmergencyComplete selfEmergencyComplete);

    /**
     * 新增事件处理
     * 
     * @param selfEmergencyComplete 事件处理
     * @return 结果
     */
    public int insertSelfEmergencyComplete(SelfEmergencyComplete selfEmergencyComplete);

    /**
     * 修改事件处理
     * 
     * @param selfEmergencyComplete 事件处理
     * @return 结果
     */
    public int updateSelfEmergencyComplete(SelfEmergencyComplete selfEmergencyComplete);

    /**
     * 删除事件处理
     * 
     * @param id 事件处理主键
     * @return 结果
     */
    public int deleteSelfEmergencyCompleteById(Long id);

    /**
     * 批量删除事件处理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSelfEmergencyCompleteByIds(Long[] ids);
}

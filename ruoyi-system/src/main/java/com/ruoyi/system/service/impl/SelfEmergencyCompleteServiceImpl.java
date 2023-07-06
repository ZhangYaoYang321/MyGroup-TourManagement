package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfEmergencyCompleteMapper;
import com.ruoyi.system.domain.SelfEmergencyComplete;
import com.ruoyi.system.service.ISelfEmergencyCompleteService;

/**
 * 事件处理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-27
 */
@Service
public class SelfEmergencyCompleteServiceImpl implements ISelfEmergencyCompleteService 
{
    @Autowired
    private SelfEmergencyCompleteMapper selfEmergencyCompleteMapper;

    /**
     * 查询事件处理
     * 
     * @param id 事件处理主键
     * @return 事件处理
     */
    @Override
    public SelfEmergencyComplete selectSelfEmergencyCompleteById(Long id)
    {
        return selfEmergencyCompleteMapper.selectSelfEmergencyCompleteById(id);
    }

    /**
     * 查询事件处理列表
     * 
     * @param selfEmergencyComplete 事件处理
     * @return 事件处理
     */
    @Override
    public List<SelfEmergencyComplete> selectSelfEmergencyCompleteList(SelfEmergencyComplete selfEmergencyComplete)
    {
        return selfEmergencyCompleteMapper.selectSelfEmergencyCompleteList(selfEmergencyComplete);
    }

    /**
     * 新增事件处理
     * 
     * @param selfEmergencyComplete 事件处理
     * @return 结果
     */
    @Override
    public int insertSelfEmergencyComplete(SelfEmergencyComplete selfEmergencyComplete)
    {
        return selfEmergencyCompleteMapper.insertSelfEmergencyComplete(selfEmergencyComplete);
    }

    /**
     * 修改事件处理
     * 
     * @param selfEmergencyComplete 事件处理
     * @return 结果
     */
    @Override
    public int updateSelfEmergencyComplete(SelfEmergencyComplete selfEmergencyComplete)
    {
        return selfEmergencyCompleteMapper.updateSelfEmergencyComplete(selfEmergencyComplete);
    }

    /**
     * 批量删除事件处理
     * 
     * @param ids 需要删除的事件处理主键
     * @return 结果
     */
    @Override
    public int deleteSelfEmergencyCompleteByIds(Long[] ids)
    {
        return selfEmergencyCompleteMapper.deleteSelfEmergencyCompleteByIds(ids);
    }

    /**
     * 删除事件处理信息
     * 
     * @param id 事件处理主键
     * @return 结果
     */
    @Override
    public int deleteSelfEmergencyCompleteById(Long id)
    {
        return selfEmergencyCompleteMapper.deleteSelfEmergencyCompleteById(id);
    }
}

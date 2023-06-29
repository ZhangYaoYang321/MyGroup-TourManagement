package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfEmergencyAddMapper;
import com.ruoyi.system.domain.SelfEmergencyAdd;
import com.ruoyi.system.service.ISelfEmergencyAddService;

/**
 * 事件Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-27
 */
@Service
public class SelfEmergencyAddServiceImpl implements ISelfEmergencyAddService 
{
    @Autowired
    private SelfEmergencyAddMapper selfEmergencyAddMapper;

    /**
     * 查询事件
     * 
     * @param id 事件主键
     * @return 事件
     */
    @Override
    public SelfEmergencyAdd selectSelfEmergencyAddById(Long id)
    {
        return selfEmergencyAddMapper.selectSelfEmergencyAddById(id);
    }

    /**
     * 查询事件列表
     * 
     * @param selfEmergencyAdd 事件
     * @return 事件
     */
    @Override
    public List<SelfEmergencyAdd> selectSelfEmergencyAddList(SelfEmergencyAdd selfEmergencyAdd)
    {
        return selfEmergencyAddMapper.selectSelfEmergencyAddList(selfEmergencyAdd);
    }

    /**
     * 新增事件
     * 
     * @param selfEmergencyAdd 事件
     * @return 结果
     */
    @Override
    public int insertSelfEmergencyAdd(SelfEmergencyAdd selfEmergencyAdd)
    {
        return selfEmergencyAddMapper.insertSelfEmergencyAdd(selfEmergencyAdd);
    }

    /**
     * 修改事件
     * 
     * @param selfEmergencyAdd 事件
     * @return 结果
     */
    @Override
    public int updateSelfEmergencyAdd(SelfEmergencyAdd selfEmergencyAdd)
    {
        return selfEmergencyAddMapper.updateSelfEmergencyAdd(selfEmergencyAdd);
    }

    /**
     * 批量删除事件
     * 
     * @param ids 需要删除的事件主键
     * @return 结果
     */
    @Override
    public int deleteSelfEmergencyAddByIds(Long[] ids)
    {
        return selfEmergencyAddMapper.deleteSelfEmergencyAddByIds(ids);
    }

    /**
     * 删除事件信息
     * 
     * @param id 事件主键
     * @return 结果
     */
    @Override
    public int deleteSelfEmergencyAddById(Long id)
    {
        return selfEmergencyAddMapper.deleteSelfEmergencyAddById(id);
    }
}

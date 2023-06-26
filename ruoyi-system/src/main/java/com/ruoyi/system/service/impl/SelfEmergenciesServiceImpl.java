package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfEmergenciesMapper;
import com.ruoyi.system.domain.SelfEmergencies;
import com.ruoyi.system.service.ISelfEmergenciesService;

/**
 * 事件Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@Service
public class SelfEmergenciesServiceImpl implements ISelfEmergenciesService 
{
    @Autowired
    private SelfEmergenciesMapper selfEmergenciesMapper;

    /**
     * 查询事件
     * 
     * @param id 事件主键
     * @return 事件
     */
    @Override
    public SelfEmergencies selectSelfEmergenciesById(Long id)
    {
        return selfEmergenciesMapper.selectSelfEmergenciesById(id);
    }

    /**
     * 查询事件列表
     * 
     * @param selfEmergencies 事件
     * @return 事件
     */
    @Override
    public List<SelfEmergencies> selectSelfEmergenciesList(SelfEmergencies selfEmergencies)
    {
        return selfEmergenciesMapper.selectSelfEmergenciesList(selfEmergencies);
    }

    /**
     * 新增事件
     * 
     * @param selfEmergencies 事件
     * @return 结果
     */
    @Override
    public int insertSelfEmergencies(SelfEmergencies selfEmergencies)
    {
        return selfEmergenciesMapper.insertSelfEmergencies(selfEmergencies);
    }

    /**
     * 修改事件
     * 
     * @param selfEmergencies 事件
     * @return 结果
     */
    @Override
    public int updateSelfEmergencies(SelfEmergencies selfEmergencies)
    {
        return selfEmergenciesMapper.updateSelfEmergencies(selfEmergencies);
    }

    /**
     * 批量删除事件
     * 
     * @param ids 需要删除的事件主键
     * @return 结果
     */
    @Override
    public int deleteSelfEmergenciesByIds(Long[] ids)
    {
        return selfEmergenciesMapper.deleteSelfEmergenciesByIds(ids);
    }

    /**
     * 删除事件信息
     * 
     * @param id 事件主键
     * @return 结果
     */
    @Override
    public int deleteSelfEmergenciesById(Long id)
    {
        return selfEmergenciesMapper.deleteSelfEmergenciesById(id);
    }
}

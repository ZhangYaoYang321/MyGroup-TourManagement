package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SelfEmergencies;

/**
 * 事件Service接口
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public interface ISelfEmergenciesService 
{
    /**
     * 查询事件
     * 
     * @param id 事件主键
     * @return 事件
     */
    public SelfEmergencies selectSelfEmergenciesById(Long id);

    /**
     * 查询事件列表
     * 
     * @param selfEmergencies 事件
     * @return 事件集合
     */
    public List<SelfEmergencies> selectSelfEmergenciesList(SelfEmergencies selfEmergencies);

    /**
     * 新增事件
     * 
     * @param selfEmergencies 事件
     * @return 结果
     */
    public int insertSelfEmergencies(SelfEmergencies selfEmergencies);

    /**
     * 修改事件
     * 
     * @param selfEmergencies 事件
     * @return 结果
     */
    public int updateSelfEmergencies(SelfEmergencies selfEmergencies);

    /**
     * 批量删除事件
     * 
     * @param ids 需要删除的事件主键集合
     * @return 结果
     */
    public int deleteSelfEmergenciesByIds(Long[] ids);

    /**
     * 删除事件信息
     * 
     * @param id 事件主键
     * @return 结果
     */
    public int deleteSelfEmergenciesById(Long id);
}

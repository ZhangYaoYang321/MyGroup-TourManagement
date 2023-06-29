package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SelfEmergencyAdd;

/**
 * 事件Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-27
 */
public interface SelfEmergencyAddMapper 
{
    /**
     * 查询事件
     * 
     * @param id 事件主键
     * @return 事件
     */
    public SelfEmergencyAdd selectSelfEmergencyAddById(Long id);

    /**
     * 查询事件列表
     * 
     * @param selfEmergencyAdd 事件
     * @return 事件集合
     */
    public List<SelfEmergencyAdd> selectSelfEmergencyAddList(SelfEmergencyAdd selfEmergencyAdd);

    /**
     * 新增事件
     * 
     * @param selfEmergencyAdd 事件
     * @return 结果
     */
    public int insertSelfEmergencyAdd(SelfEmergencyAdd selfEmergencyAdd);

    /**
     * 修改事件
     * 
     * @param selfEmergencyAdd 事件
     * @return 结果
     */
    public int updateSelfEmergencyAdd(SelfEmergencyAdd selfEmergencyAdd);

    /**
     * 删除事件
     * 
     * @param id 事件主键
     * @return 结果
     */
    public int deleteSelfEmergencyAddById(Long id);

    /**
     * 批量删除事件
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSelfEmergencyAddByIds(Long[] ids);
}

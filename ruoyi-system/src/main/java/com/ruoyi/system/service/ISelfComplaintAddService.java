package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SelfComplaintAdd;

/**
 * 投诉Service接口
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public interface ISelfComplaintAddService 
{
    /**
     * 查询投诉
     * 
     * @param id 投诉主键
     * @return 投诉
     */
    public SelfComplaintAdd selectSelfComplaintAddById(Long id);

    /**
     * 查询投诉列表
     * 
     * @param selfComplaintAdd 投诉
     * @return 投诉集合
     */
    public List<SelfComplaintAdd> selectSelfComplaintAddList(SelfComplaintAdd selfComplaintAdd);

    /**
     * 新增投诉
     * 
     * @param selfComplaintAdd 投诉
     * @return 结果
     */
    public int insertSelfComplaintAdd(SelfComplaintAdd selfComplaintAdd);

    /**
     * 修改投诉
     * 
     * @param selfComplaintAdd 投诉
     * @return 结果
     */
    public int updateSelfComplaintAdd(SelfComplaintAdd selfComplaintAdd);

    /**
     * 批量删除投诉
     * 
     * @param ids 需要删除的投诉主键集合
     * @return 结果
     */
    public int deleteSelfComplaintAddByIds(Long[] ids);

    /**
     * 删除投诉信息
     * 
     * @param id 投诉主键
     * @return 结果
     */
    public int deleteSelfComplaintAddById(Long id);
}

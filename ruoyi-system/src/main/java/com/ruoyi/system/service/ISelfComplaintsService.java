package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SelfComplaints;

/**
 * 投诉Service接口
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public interface ISelfComplaintsService 
{
    /**
     * 查询投诉
     * 
     * @param id 投诉主键
     * @return 投诉
     */
    public SelfComplaints selectSelfComplaintsById(Long id);

    /**
     * 查询投诉列表
     * 
     * @param selfComplaints 投诉
     * @return 投诉集合
     */
    public List<SelfComplaints> selectSelfComplaintsList(SelfComplaints selfComplaints);

    /**
     * 新增投诉
     * 
     * @param selfComplaints 投诉
     * @return 结果
     */
    public int insertSelfComplaints(SelfComplaints selfComplaints);

    /**
     * 修改投诉
     * 
     * @param selfComplaints 投诉
     * @return 结果
     */
    public int updateSelfComplaints(SelfComplaints selfComplaints);

    /**
     * 批量删除投诉
     * 
     * @param ids 需要删除的投诉主键集合
     * @return 结果
     */
    public int deleteSelfComplaintsByIds(Long[] ids);

    /**
     * 删除投诉信息
     * 
     * @param id 投诉主键
     * @return 结果
     */
    public int deleteSelfComplaintsById(Long id);
}

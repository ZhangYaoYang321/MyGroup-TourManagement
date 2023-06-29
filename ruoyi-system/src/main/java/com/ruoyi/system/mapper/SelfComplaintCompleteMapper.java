package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SelfComplaintComplete;

/**
 * 投诉Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-27
 */
public interface SelfComplaintCompleteMapper 
{
    /**
     * 查询投诉
     * 
     * @param id 投诉主键
     * @return 投诉
     */
    public SelfComplaintComplete selectSelfComplaintCompleteById(Long id);

    /**
     * 查询投诉列表
     * 
     * @param selfComplaintComplete 投诉
     * @return 投诉集合
     */
    public List<SelfComplaintComplete> selectSelfComplaintCompleteList(SelfComplaintComplete selfComplaintComplete);

    /**
     * 新增投诉
     * 
     * @param selfComplaintComplete 投诉
     * @return 结果
     */
    public int insertSelfComplaintComplete(SelfComplaintComplete selfComplaintComplete);

    /**
     * 修改投诉
     * 
     * @param selfComplaintComplete 投诉
     * @return 结果
     */
    public int updateSelfComplaintComplete(SelfComplaintComplete selfComplaintComplete);

    /**
     * 删除投诉
     * 
     * @param id 投诉主键
     * @return 结果
     */
    public int deleteSelfComplaintCompleteById(Long id);

    /**
     * 批量删除投诉
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSelfComplaintCompleteByIds(Long[] ids);
}

package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfComplaintCompleteMapper;
import com.ruoyi.system.domain.SelfComplaintComplete;
import com.ruoyi.system.service.ISelfComplaintCompleteService;

/**
 * 投诉Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-27
 */
@Service
public class SelfComplaintCompleteServiceImpl implements ISelfComplaintCompleteService 
{
    @Autowired
    private SelfComplaintCompleteMapper selfComplaintCompleteMapper;

    /**
     * 查询投诉
     * 
     * @param id 投诉主键
     * @return 投诉
     */
    @Override
    public SelfComplaintComplete selectSelfComplaintCompleteById(Long id)
    {
        return selfComplaintCompleteMapper.selectSelfComplaintCompleteById(id);
    }

    /**
     * 查询投诉列表
     * 
     * @param selfComplaintComplete 投诉
     * @return 投诉
     */
    @Override
    public List<SelfComplaintComplete> selectSelfComplaintCompleteList(SelfComplaintComplete selfComplaintComplete)
    {
        return selfComplaintCompleteMapper.selectSelfComplaintCompleteList(selfComplaintComplete);
    }

    /**
     * 新增投诉
     * 
     * @param selfComplaintComplete 投诉
     * @return 结果
     */
    @Override
    public int insertSelfComplaintComplete(SelfComplaintComplete selfComplaintComplete)
    {
        return selfComplaintCompleteMapper.insertSelfComplaintComplete(selfComplaintComplete);
    }

    /**
     * 修改投诉
     * 
     * @param selfComplaintComplete 投诉
     * @return 结果
     */
    @Override
    public int updateSelfComplaintComplete(SelfComplaintComplete selfComplaintComplete)
    {
        return selfComplaintCompleteMapper.updateSelfComplaintComplete(selfComplaintComplete);
    }

    /**
     * 批量删除投诉
     * 
     * @param ids 需要删除的投诉主键
     * @return 结果
     */
    @Override
    public int deleteSelfComplaintCompleteByIds(Long[] ids)
    {
        return selfComplaintCompleteMapper.deleteSelfComplaintCompleteByIds(ids);
    }

    /**
     * 删除投诉信息
     * 
     * @param id 投诉主键
     * @return 结果
     */
    @Override
    public int deleteSelfComplaintCompleteById(Long id)
    {
        return selfComplaintCompleteMapper.deleteSelfComplaintCompleteById(id);
    }
}

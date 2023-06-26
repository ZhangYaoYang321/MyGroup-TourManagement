package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfComplaintsMapper;
import com.ruoyi.system.domain.SelfComplaints;
import com.ruoyi.system.service.ISelfComplaintsService;

/**
 * 投诉Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@Service
public class SelfComplaintsServiceImpl implements ISelfComplaintsService 
{
    @Autowired
    private SelfComplaintsMapper selfComplaintsMapper;

    /**
     * 查询投诉
     * 
     * @param id 投诉主键
     * @return 投诉
     */
    @Override
    public SelfComplaints selectSelfComplaintsById(Long id)
    {
        return selfComplaintsMapper.selectSelfComplaintsById(id);
    }

    /**
     * 查询投诉列表
     * 
     * @param selfComplaints 投诉
     * @return 投诉
     */
    @Override
    public List<SelfComplaints> selectSelfComplaintsList(SelfComplaints selfComplaints)
    {
        return selfComplaintsMapper.selectSelfComplaintsList(selfComplaints);
    }

    /**
     * 新增投诉
     * 
     * @param selfComplaints 投诉
     * @return 结果
     */
    @Override
    public int insertSelfComplaints(SelfComplaints selfComplaints)
    {
        return selfComplaintsMapper.insertSelfComplaints(selfComplaints);
    }

    /**
     * 修改投诉
     * 
     * @param selfComplaints 投诉
     * @return 结果
     */
    @Override
    public int updateSelfComplaints(SelfComplaints selfComplaints)
    {
        return selfComplaintsMapper.updateSelfComplaints(selfComplaints);
    }

    /**
     * 批量删除投诉
     * 
     * @param ids 需要删除的投诉主键
     * @return 结果
     */
    @Override
    public int deleteSelfComplaintsByIds(Long[] ids)
    {
        return selfComplaintsMapper.deleteSelfComplaintsByIds(ids);
    }

    /**
     * 删除投诉信息
     * 
     * @param id 投诉主键
     * @return 结果
     */
    @Override
    public int deleteSelfComplaintsById(Long id)
    {
        return selfComplaintsMapper.deleteSelfComplaintsById(id);
    }
}

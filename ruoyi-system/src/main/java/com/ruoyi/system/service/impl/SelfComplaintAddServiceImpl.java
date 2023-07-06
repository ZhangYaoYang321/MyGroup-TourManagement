package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfComplaintAddMapper;
import com.ruoyi.system.domain.SelfComplaintAdd;
import com.ruoyi.system.service.ISelfComplaintAddService;

/**
 * 投诉Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@Service
public class SelfComplaintAddServiceImpl implements ISelfComplaintAddService 
{
    @Autowired
    private SelfComplaintAddMapper selfComplaintAddMapper;

    /**
     * 查询投诉
     * 
     * @param id 投诉主键
     * @return 投诉
     */
    @Override
    public SelfComplaintAdd selectSelfComplaintAddById(Long id)
    {
        return selfComplaintAddMapper.selectSelfComplaintAddById(id);
    }

    /**
     * 查询投诉列表
     * 
     * @param selfComplaintAdd 投诉
     * @return 投诉
     */
    @Override
    public List<SelfComplaintAdd> selectSelfComplaintAddList(SelfComplaintAdd selfComplaintAdd)
    {
        return selfComplaintAddMapper.selectSelfComplaintAddList(selfComplaintAdd);
    }

    /**
     * 新增投诉
     * 
     * @param selfComplaintAdd 投诉
     * @return 结果
     */
    @Override
    public int insertSelfComplaintAdd(SelfComplaintAdd selfComplaintAdd)
    {
        return selfComplaintAddMapper.insertSelfComplaintAdd(selfComplaintAdd);
    }

    /**
     * 修改投诉
     * 
     * @param selfComplaintAdd 投诉
     * @return 结果
     */
    @Override
    public int updateSelfComplaintAdd(SelfComplaintAdd selfComplaintAdd)
    {
        return selfComplaintAddMapper.updateSelfComplaintAdd(selfComplaintAdd);
    }

    /**
     * 批量删除投诉
     * 
     * @param ids 需要删除的投诉主键
     * @return 结果
     */
    @Override
    public int deleteSelfComplaintAddByIds(Long[] ids)
    {
        return selfComplaintAddMapper.deleteSelfComplaintAddByIds(ids);
    }

    /**
     * 删除投诉信息
     * 
     * @param id 投诉主键
     * @return 结果
     */
    @Override
    public int deleteSelfComplaintAddById(Long id)
    {
        return selfComplaintAddMapper.deleteSelfComplaintAddById(id);
    }
}

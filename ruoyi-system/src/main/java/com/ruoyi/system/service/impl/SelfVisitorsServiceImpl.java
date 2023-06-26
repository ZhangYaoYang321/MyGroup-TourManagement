package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfVisitorsMapper;
import com.ruoyi.system.domain.SelfVisitors;
import com.ruoyi.system.service.ISelfVisitorsService;

/**
 * 游客Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@Service
public class SelfVisitorsServiceImpl implements ISelfVisitorsService 
{
    @Autowired
    private SelfVisitorsMapper selfVisitorsMapper;

    /**
     * 查询游客
     * 
     * @param id 游客主键
     * @return 游客
     */
    @Override
    public SelfVisitors selectSelfVisitorsById(Long id)
    {
        return selfVisitorsMapper.selectSelfVisitorsById(id);
    }

    /**
     * 查询游客列表
     * 
     * @param selfVisitors 游客
     * @return 游客
     */
    @Override
    public List<SelfVisitors> selectSelfVisitorsList(SelfVisitors selfVisitors)
    {
        return selfVisitorsMapper.selectSelfVisitorsList(selfVisitors);
    }

    /**
     * 新增游客
     * 
     * @param selfVisitors 游客
     * @return 结果
     */
    @Override
    public int insertSelfVisitors(SelfVisitors selfVisitors)
    {
        return selfVisitorsMapper.insertSelfVisitors(selfVisitors);
    }

    /**
     * 修改游客
     * 
     * @param selfVisitors 游客
     * @return 结果
     */
    @Override
    public int updateSelfVisitors(SelfVisitors selfVisitors)
    {
        return selfVisitorsMapper.updateSelfVisitors(selfVisitors);
    }

    /**
     * 批量删除游客
     * 
     * @param ids 需要删除的游客主键
     * @return 结果
     */
    @Override
    public int deleteSelfVisitorsByIds(Long[] ids)
    {
        return selfVisitorsMapper.deleteSelfVisitorsByIds(ids);
    }

    /**
     * 删除游客信息
     * 
     * @param id 游客主键
     * @return 结果
     */
    @Override
    public int deleteSelfVisitorsById(Long id)
    {
        return selfVisitorsMapper.deleteSelfVisitorsById(id);
    }
}

package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfAttendancesMapper;
import com.ruoyi.system.domain.SelfAttendances;
import com.ruoyi.system.service.ISelfAttendancesService;

/**
 * 考勤信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@Service
public class SelfAttendancesServiceImpl implements ISelfAttendancesService 
{
    @Autowired
    private SelfAttendancesMapper selfAttendancesMapper;

    /**
     * 查询考勤信息
     * 
     * @param id 考勤信息主键
     * @return 考勤信息
     */
    @Override
    public SelfAttendances selectSelfAttendancesById(Long id)
    {
        return selfAttendancesMapper.selectSelfAttendancesById(id);
    }

    /**
     * 查询考勤信息列表
     * 
     * @param selfAttendances 考勤信息
     * @return 考勤信息
     */
    @Override
    public List<SelfAttendances> selectSelfAttendancesList(SelfAttendances selfAttendances)
    {
        return selfAttendancesMapper.selectSelfAttendancesList(selfAttendances);
    }

    /**
     * 新增考勤信息
     * 
     * @param selfAttendances 考勤信息
     * @return 结果
     */
    @Override
    public int insertSelfAttendances(SelfAttendances selfAttendances)
    {
        return selfAttendancesMapper.insertSelfAttendances(selfAttendances);
    }

    /**
     * 修改考勤信息
     * 
     * @param selfAttendances 考勤信息
     * @return 结果
     */
    @Override
    public int updateSelfAttendances(SelfAttendances selfAttendances)
    {
        return selfAttendancesMapper.updateSelfAttendances(selfAttendances);
    }

    /**
     * 批量删除考勤信息
     * 
     * @param ids 需要删除的考勤信息主键
     * @return 结果
     */
    @Override
    public int deleteSelfAttendancesByIds(Long[] ids)
    {
        return selfAttendancesMapper.deleteSelfAttendancesByIds(ids);
    }

    /**
     * 删除考勤信息信息
     * 
     * @param id 考勤信息主键
     * @return 结果
     */
    @Override
    public int deleteSelfAttendancesById(Long id)
    {
        return selfAttendancesMapper.deleteSelfAttendancesById(id);
    }
}

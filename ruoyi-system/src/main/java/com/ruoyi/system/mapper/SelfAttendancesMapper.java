package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SelfAttendances;

/**
 * 考勤信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public interface SelfAttendancesMapper 
{
    /**
     * 查询考勤信息
     * 
     * @param id 考勤信息主键
     * @return 考勤信息
     */
    public SelfAttendances selectSelfAttendancesById(Long id);

    /**
     * 查询考勤信息列表
     * 
     * @param selfAttendances 考勤信息
     * @return 考勤信息集合
     */
    public List<SelfAttendances> selectSelfAttendancesList(SelfAttendances selfAttendances);

    /**
     * 新增考勤信息
     * 
     * @param selfAttendances 考勤信息
     * @return 结果
     */
    public int insertSelfAttendances(SelfAttendances selfAttendances);

    /**
     * 修改考勤信息
     * 
     * @param selfAttendances 考勤信息
     * @return 结果
     */
    public int updateSelfAttendances(SelfAttendances selfAttendances);

    /**
     * 删除考勤信息
     * 
     * @param id 考勤信息主键
     * @return 结果
     */
    public int deleteSelfAttendancesById(Long id);

    /**
     * 批量删除考勤信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSelfAttendancesByIds(Long[] ids);
    public int resetKQAttendancesByIds(Long[] ids);

}

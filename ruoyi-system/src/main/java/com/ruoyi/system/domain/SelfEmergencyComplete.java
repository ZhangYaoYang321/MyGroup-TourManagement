package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 事件处理对象 self_emergencies
 * 
 * @author ruoyi
 * @date 2023-06-27
 */
public class SelfEmergencyComplete extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 事件地点 */
    @Excel(name = "事件地点")
    private String location;

    /** 事件信息 */
    @Excel(name = "事件信息")
    private String emergenciesMessage;

    /** 处理部门 */
    @Excel(name = "处理部门")
    private String department;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String stateEmergencies;

    /** 紧急程度 */
    @Excel(name = "紧急程度")
    private String emergenciesLevel;

    /** 发生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    @Excel(name = "发生日期", width = 30, dateFormat = "yyyy-MM-dd'T'hh:mm:ss")
    private Date emergenciesTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setEmergenciesMessage(String emergenciesMessage) 
    {
        this.emergenciesMessage = emergenciesMessage;
    }

    public String getEmergenciesMessage() 
    {
        return emergenciesMessage;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setStateEmergencies(String stateEmergencies) 
    {
        this.stateEmergencies = stateEmergencies;
    }

    public String getStateEmergencies() 
    {
        return stateEmergencies;
    }
    public void setEmergenciesLevel(String emergenciesLevel) 
    {
        this.emergenciesLevel = emergenciesLevel;
    }

    public String getEmergenciesLevel() 
    {
        return emergenciesLevel;
    }
    public void setEmergenciesTime(Date emergenciesTime) 
    {
        this.emergenciesTime = emergenciesTime;
    }

    public Date getEmergenciesTime() 
    {
        return emergenciesTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("location", getLocation())
            .append("emergenciesMessage", getEmergenciesMessage())
            .append("department", getDepartment())
            .append("stateEmergencies", getStateEmergencies())
            .append("emergenciesLevel", getEmergenciesLevel())
            .append("emergenciesTime", getEmergenciesTime())
            .toString();
    }
}

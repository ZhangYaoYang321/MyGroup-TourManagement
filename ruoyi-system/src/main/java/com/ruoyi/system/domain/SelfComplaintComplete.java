package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 投诉对象 self_complaints
 * 
 * @author ruoyi
 * @date 2023-06-27
 */
public class SelfComplaintComplete extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 投诉ID */
    @Excel(name = "投诉ID")
    private Long complaintsId;

    /** 投诉信息 */
    @Excel(name = "投诉信息")
    private String complaintsMessage;

    /** 投诉日期 */
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    @Excel(name = "投诉日期", width = 30, dateFormat = "yyyy-MM-dd'T'hh:mm:ss")
    private Date complaintsDate;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String stateComplaints;

    /** 回复日期 */
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    @Excel(name = "回复日期", width = 30, dateFormat = "yyyy-MM-dd'T'hh:mm:ss")
    private Date complaintsReplyDate;

    /** 回复信息 */
    @Excel(name = "回复信息")
    private String complaintsReplyMessage;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setComplaintsId(Long complaintsId) 
    {
        this.complaintsId = complaintsId;
    }

    public Long getComplaintsId() 
    {
        return complaintsId;
    }
    public void setComplaintsMessage(String complaintsMessage) 
    {
        this.complaintsMessage = complaintsMessage;
    }

    public String getComplaintsMessage() 
    {
        return complaintsMessage;
    }
    public void setComplaintsDate(Date complaintsDate) 
    {
        this.complaintsDate = complaintsDate;
    }

    public Date getComplaintsDate() 
    {
        return complaintsDate;
    }
    public void setStateComplaints(String stateComplaints) 
    {
        this.stateComplaints = stateComplaints;
    }

    public String getStateComplaints() 
    {
        return stateComplaints;
    }
    public void setComplaintsReplyDate(Date complaintsReplyDate) 
    {
        this.complaintsReplyDate = complaintsReplyDate;
    }

    public Date getComplaintsReplyDate() 
    {
        return complaintsReplyDate;
    }
    public void setComplaintsReplyMessage(String complaintsReplyMessage) 
    {
        this.complaintsReplyMessage = complaintsReplyMessage;
    }

    public String getComplaintsReplyMessage() 
    {
        return complaintsReplyMessage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("complaintsId", getComplaintsId())
            .append("complaintsMessage", getComplaintsMessage())
            .append("complaintsDate", getComplaintsDate())
            .append("stateComplaints", getStateComplaints())
            .append("complaintsReplyDate", getComplaintsReplyDate())
            .append("complaintsReplyMessage", getComplaintsReplyMessage())
            .toString();
    }
}

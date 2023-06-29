package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 酒店退定对象 self_hotel_checkout
 *
 * @author ruoyi
 * @date 2023-06-26
 */
public class SelfHotelCheckIn extends BaseEntity {
    private Long id;

    /** 订单号 */
    @Excel(name = "订单号")
    private Long orderId;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String cnId;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNum;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 开始日期 */
    @Excel(name = "开始日期")
    private String startDate;

    /** 截至日期 */
    @Excel(name = "截至日期")
    private String endDate;

    /** 房价类型 */
    @Excel(name = "类型")
    private String type;

    /** 房间号 */
    @Excel(name = "房间号")
    private int roomNum;

    /** 房间状态 */
    @Excel(name = "房间状态")
    private String state;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = "已预约";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type=type;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrderId(Long orderId)
    {

        this.orderId = orderId;
    }

    public Long getOrderId()
    {
        return orderId;
    }
    public void setCnId(String cnId)
    {
        this.cnId = cnId;
    }

    public String getCnId()
    {
        return cnId;
    }

    @Override
    public String toString() {
        return "SelfHotelReservation{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", cnId='" + cnId + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", type='" + type + '\'' +
                ", roomNum=" + roomNum +
                ", state=" + state + '\''+
                '}';
    }
}

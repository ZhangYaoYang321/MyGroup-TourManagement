package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间对象 self_hotel_rooms
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public class SelfHotelRooms extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 房间号 */
    @Excel(name = "房间号")
    private Long roomId;

    /** 房间类型 */
    @Excel(name = "房间类型")
    private String typeRoom;

    /** 订单号 */
    @Excel(name = "订单号")
    private Long orderId;

    /** 入住情况 */
    @Excel(name = "入住情况")
    private String stateRoom;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setTypeRoom(String typeRoom) 
    {
        this.typeRoom = typeRoom;
    }

    public String getTypeRoom() 
    {
        return typeRoom;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setStateRoom(String stateRoom) 
    {
        this.stateRoom = stateRoom;
    }

    public String getStateRoom() 
    {
        return stateRoom;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("roomId", getRoomId())
            .append("typeRoom", getTypeRoom())
            .append("orderId", getOrderId())
            .append("stateRoom", getStateRoom())
            .toString();
    }
}

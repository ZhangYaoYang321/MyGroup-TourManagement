package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 酒店价格对象 self_hotel_prices
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public class SelfHotelPrices extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 房间类型 */
    @Excel(name = "房间类型")
    private String typeRoom;

    /** 房间价格 */
    @Excel(name = "房间价格")
    private String priceRoom;

    /** 房间总数 */
    @Excel(name = "房间总数")
    private Long totalRooms;

    /** 空余房数 */
    @Excel(name = "空余房数")
    private Long freeRooms;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTypeRoom(String typeRoom) 
    {
        this.typeRoom = typeRoom;
    }

    public String getTypeRoom() 
    {
        return typeRoom;
    }
    public void setPriceRoom(String priceRoom) 
    {
        this.priceRoom = priceRoom;
    }

    public String getPriceRoom() 
    {
        return priceRoom;
    }
    public void setTotalRooms(Long totalRooms) 
    {
        this.totalRooms = totalRooms;
    }

    public Long getTotalRooms() 
    {
        return totalRooms;
    }
    public void setFreeRooms(Long freeRooms) 
    {
        this.freeRooms = freeRooms;
    }

    public Long getFreeRooms() 
    {
        return freeRooms;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("typeRoom", getTypeRoom())
            .append("priceRoom", getPriceRoom())
            .append("totalRooms", getTotalRooms())
            .append("freeRooms", getFreeRooms())
            .toString();
    }
}

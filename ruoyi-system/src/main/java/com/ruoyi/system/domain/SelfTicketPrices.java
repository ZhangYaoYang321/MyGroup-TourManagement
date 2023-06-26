package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 票价对象 self_ticket_prices
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public class SelfTicketPrices extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 门票类型 */
    @Excel(name = "门票类型")
    private String typeTicket;

    /** 门票价格 */
    @Excel(name = "门票价格")
    private String priceTicket;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTypeTicket(String typeTicket) 
    {
        this.typeTicket = typeTicket;
    }

    public String getTypeTicket() 
    {
        return typeTicket;
    }
    public void setPriceTicket(String priceTicket) 
    {
        this.priceTicket = priceTicket;
    }

    public String getPriceTicket() 
    {
        return priceTicket;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("typeTicket", getTypeTicket())
            .append("priceTicket", getPriceTicket())
            .toString();
    }
}

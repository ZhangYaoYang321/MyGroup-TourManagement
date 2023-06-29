package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SelfHotelCheckIn;
import com.ruoyi.system.domain.SelfHotelCheckOut;

import java.util.List;

public interface SelfHotelCheckOutMapper {
    /**
     * 查询酒店订单列表
     *
     * @param selfHotelCheckOut 酒店订单
     * @return 酒店订单集合
     */
    public List<SelfHotelCheckOut> selectSelfHotelCheckOutList(SelfHotelCheckOut selfHotelCheckOut);

    public int checkOutSelfHotelCheckOutById(long id);
}

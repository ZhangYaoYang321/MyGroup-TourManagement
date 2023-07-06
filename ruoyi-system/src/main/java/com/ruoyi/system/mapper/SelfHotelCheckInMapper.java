package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SelfHotelCheckIn;
import com.ruoyi.system.domain.SelfHotelCheckOut;
import com.ruoyi.system.domain.SelfHotelReservation;

import java.util.List;

public interface SelfHotelCheckInMapper {
    /**
     * 查询酒店订单列表
     *
     * @param selfHotelCheckIn 酒店订单
     * @return 酒店订单集合
     */
    public List<SelfHotelCheckIn> selectSelfHotelCheckInList(SelfHotelCheckIn selfHotelCheckIn);

    public int checkInSelfHotelCheckInById(long id);

    public List<String> checkInSelfHotelRooms(String date);
}

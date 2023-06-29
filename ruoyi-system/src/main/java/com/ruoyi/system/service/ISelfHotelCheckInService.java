package com.ruoyi.system.service;

import com.ruoyi.system.domain.SelfHotelCheckIn;
import com.ruoyi.system.domain.SelfHotelReservation;

import java.util.List;

/**
 * 酒店退房Service接口
 *
 * @author ruoyi
 * @date 2023-06-26
 */
public interface ISelfHotelCheckInService {
    /**
     * 查询酒店订单列表
     *
     * @param selfHotelCheckIn 酒店订单
     * @return 酒店订单集合
     */
    public List<SelfHotelCheckIn> selectSelfHotelCheckInList(SelfHotelCheckIn selfHotelCheckIn);
    /**
     * 修改酒店订单
     *
     * @param id 酒店订单
     * @return 结果
     */
    public int checkInSelfHotelCheckInById(long id);
}

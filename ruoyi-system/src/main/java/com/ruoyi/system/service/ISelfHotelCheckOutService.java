package com.ruoyi.system.service;

import com.ruoyi.system.domain.SelfHotelCheckIn;
import com.ruoyi.system.domain.SelfHotelCheckOut;

import java.util.List;

/**
 * 酒店退房Service接口
 *
 * @author ruoyi
 * @date 2023-06-26
 */
public interface ISelfHotelCheckOutService {
    /**
     * 查询酒店订单列表
     *
     * @param selfHotelCheckOut 酒店订单
     * @return 酒店订单集合
     */
    public List<SelfHotelCheckOut> selectSelfHotelCheckOutList(SelfHotelCheckOut selfHotelCheckOut);
    /**
     * 修改酒店订单
     *
     * @param id 酒店订单
     * @return 结果
     */
    public int checkOutSelfHotelCheckOutById(long id);
}

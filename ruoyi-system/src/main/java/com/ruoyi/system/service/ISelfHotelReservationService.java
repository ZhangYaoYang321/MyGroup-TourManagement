package com.ruoyi.system.service;

import com.ruoyi.system.domain.SelfHotelOrders;
import com.ruoyi.system.domain.SelfHotelReservation;

import java.util.List;

/**
 * 酒店预约Service接口
 *
 * @author ruoyi
 * @date 2023-06-26
 */
public interface ISelfHotelReservationService {

    /**
     * 新增酒店订单
     *
     * @param selfHotelReservation 酒店订单
     * @return 结果
     */
    public int insertSelfHotelReservation(SelfHotelReservation selfHotelReservation);


    /**
     * 查询酒店订单
     *
     * @param id 酒店订单主键
     * @return 酒店订单
     */
    public SelfHotelReservation selectSelfHotelReservationById(Long id);

    /**
     * 查询酒店订单列表
     *
     * @param selfHotelReservation 酒店订单
     * @return 酒店订单集合
     */
    public List<SelfHotelReservation> selectSelfHotelReservationList(SelfHotelReservation selfHotelReservation);
    /**
     * 修改酒店订单
     *
     * @param selfHotelReservation 酒店订单
     * @return 结果
     */
    public int updateSelfHotelReservation(SelfHotelReservation selfHotelReservation);

    /**
     * 删除酒店订单信息
     *
     * @param id 酒店订单主键
     * @return 结果
     */
    public int deleteSelfHotelReservationById(Long id);

    /**
     * 查询酒店房间信息
     *
     * @param date 酒店订单主键
     * @return 结果
     */
    public List<Integer> selectSelfHotelReservationRoomsByDate(String date);

}

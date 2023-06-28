package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SelfHotelOrders;
import com.ruoyi.system.domain.SelfHotelReservation;

import java.util.List;

/**
 * 酒店预约Mapper接口
 *
 * @author ruoyi
 * @date 2023-06-26
 */
public interface SelfHotelReservationMapper {

    /**
     * 新增酒店订单
     *
     * @param selfHotelReservation 酒店订单
     * @return 结果
     */
    public int insertSelfHotelReservation1(SelfHotelReservation selfHotelReservation);
    public int insertSelfHotelReservation2(Long id,String type,int roomNum,String state,String date);

    public int insertSelfHotelReservation3(SelfHotelReservation selfHotelReservation);

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
    public int updateSelfHotelReservation1(SelfHotelReservation selfHotelReservation);
    public int updateSelfHotelReservation2(SelfHotelReservation selfHotelReservation);

    /**
     * 删除酒店订单
     *
     * @param id 酒店订单主键
     * @return 结果
     */
    public int deleteSelfHotelReservationById1(Long id);
}

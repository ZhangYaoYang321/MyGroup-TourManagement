package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SelfHotelOrders;

/**
 * 酒店订单Mapper接口
 *
 * @author ruoyi
 * @date 2023-06-26
 */
public interface SelfHotelOrdersMapper
{
    /**
     * 查询酒店订单
     *
     * @param id 酒店订单主键
     * @return 酒店订单
     */
    public SelfHotelOrders selectSelfHotelOrdersById(Long id);
    public List<Integer> selectSelfHotelOrdersRoomsByDate2(String date,int roomNum);

    /**
     * 查询酒店订单列表
     *
     * @param selfHotelOrders 酒店订单
     * @return 酒店订单集合
     */
    public List<SelfHotelOrders> selectSelfHotelOrdersList(SelfHotelOrders selfHotelOrders);

    /**
     * 新增酒店订单
     *
     * @param selfHotelOrders 酒店订单
     * @return 结果
     */
    public int insertSelfHotelOrders1(SelfHotelOrders selfHotelOrders);
    public int insertSelfHotelOrders2(Long id,String type,int roomNum,String state,String date);

    public int insertSelfHotelOrders3(SelfHotelOrders selfHotelOrders);

    /**
     * 修改酒店订单
     *
     * @param selfHotelOrders 酒店订单
     * @return 结果
     */
    public int updateSelfHotelOrders1(SelfHotelOrders selfHotelOrders);
    public int updateSelfHotelOrders2(SelfHotelOrders selfHotelOrders);

    /**
     * 删除酒店订单
     *
     * @param id 酒店订单主键
     * @return 结果
     */
    public int deleteSelfHotelOrdersById(Long id);

    /**
     * 批量删除酒店订单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSelfHotelOrdersByIds(Long[] ids);
}

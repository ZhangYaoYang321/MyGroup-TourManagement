package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SelfHotelOrders;

/**
 * 酒店订单Service接口
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public interface ISelfHotelOrdersService 
{
    /**
     * 查询酒店订单
     * 
     * @param id 酒店订单主键
     * @return 酒店订单
     */
    public SelfHotelOrders selectSelfHotelOrdersById(Long id);

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
    public int insertSelfHotelOrders(SelfHotelOrders selfHotelOrders);

    /**
     * 修改酒店订单
     * 
     * @param selfHotelOrders 酒店订单
     * @return 结果
     */
    public int updateSelfHotelOrders(SelfHotelOrders selfHotelOrders);

    /**
     * 批量删除酒店订单
     * 
     * @param ids 需要删除的酒店订单主键集合
     * @return 结果
     */
    public int deleteSelfHotelOrdersByIds(Long[] ids);

    /**
     * 删除酒店订单信息
     * 
     * @param id 酒店订单主键
     * @return 结果
     */
    public int deleteSelfHotelOrdersById(Long id);
}

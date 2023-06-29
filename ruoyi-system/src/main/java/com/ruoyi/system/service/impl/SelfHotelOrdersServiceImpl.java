package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfHotelOrdersMapper;
import com.ruoyi.system.domain.SelfHotelOrders;
import com.ruoyi.system.service.ISelfHotelOrdersService;

/**
 * 酒店订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@Service
public class SelfHotelOrdersServiceImpl implements ISelfHotelOrdersService 
{
    @Autowired
    private SelfHotelOrdersMapper selfHotelOrdersMapper;

    /**
     * 查询酒店订单
     * 
     * @param id 酒店订单主键
     * @return 酒店订单
     */
    @Override
    public SelfHotelOrders selectSelfHotelOrdersById(Long id)
    {
        return selfHotelOrdersMapper.selectSelfHotelOrdersById(id);
    }

    /**
     * 查询酒店订单列表
     * 
     * @param selfHotelOrders 酒店订单
     * @return 酒店订单
     */
    @Override
    public List<SelfHotelOrders> selectSelfHotelOrdersList(SelfHotelOrders selfHotelOrders)
    {
        return selfHotelOrdersMapper.selectSelfHotelOrdersList(selfHotelOrders);
    }

    /**
     * 新增酒店订单
     * 
     * @param selfHotelOrders 酒店订单
     * @return 结果
     */
    @Override
    public int insertSelfHotelOrders(SelfHotelOrders selfHotelOrders)
    {
        return selfHotelOrdersMapper.insertSelfHotelOrders(selfHotelOrders);
    }

    /**
     * 修改酒店订单
     * 
     * @param selfHotelOrders 酒店订单
     * @return 结果
     */
    @Override
    public int updateSelfHotelOrders(SelfHotelOrders selfHotelOrders)
    {
        return selfHotelOrdersMapper.updateSelfHotelOrders(selfHotelOrders);
    }

    /**
     * 批量删除酒店订单
     * 
     * @param ids 需要删除的酒店订单主键
     * @return 结果
     */
    @Override
    public int deleteSelfHotelOrdersByIds(Long[] ids)
    {
        return selfHotelOrdersMapper.deleteSelfHotelOrdersByIds(ids);
    }

    /**
     * 删除酒店订单信息
     * 
     * @param id 酒店订单主键
     * @return 结果
     */
    @Override
    public int deleteSelfHotelOrdersById(Long id)
    {
        return selfHotelOrdersMapper.deleteSelfHotelOrdersById(id);
    }
}

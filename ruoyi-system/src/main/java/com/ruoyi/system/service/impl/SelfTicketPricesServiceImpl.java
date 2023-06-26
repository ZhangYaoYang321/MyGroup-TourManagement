package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfTicketPricesMapper;
import com.ruoyi.system.domain.SelfTicketPrices;
import com.ruoyi.system.service.ISelfTicketPricesService;

/**
 * 票价Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@Service
public class SelfTicketPricesServiceImpl implements ISelfTicketPricesService 
{
    @Autowired
    private SelfTicketPricesMapper selfTicketPricesMapper;

    /**
     * 查询票价
     * 
     * @param id 票价主键
     * @return 票价
     */
    @Override
    public SelfTicketPrices selectSelfTicketPricesById(Long id)
    {
        return selfTicketPricesMapper.selectSelfTicketPricesById(id);
    }

    /**
     * 查询票价列表
     * 
     * @param selfTicketPrices 票价
     * @return 票价
     */
    @Override
    public List<SelfTicketPrices> selectSelfTicketPricesList(SelfTicketPrices selfTicketPrices)
    {
        return selfTicketPricesMapper.selectSelfTicketPricesList(selfTicketPrices);
    }

    /**
     * 新增票价
     * 
     * @param selfTicketPrices 票价
     * @return 结果
     */
    @Override
    public int insertSelfTicketPrices(SelfTicketPrices selfTicketPrices)
    {
        return selfTicketPricesMapper.insertSelfTicketPrices(selfTicketPrices);
    }

    /**
     * 修改票价
     * 
     * @param selfTicketPrices 票价
     * @return 结果
     */
    @Override
    public int updateSelfTicketPrices(SelfTicketPrices selfTicketPrices)
    {
        return selfTicketPricesMapper.updateSelfTicketPrices(selfTicketPrices);
    }

    /**
     * 批量删除票价
     * 
     * @param ids 需要删除的票价主键
     * @return 结果
     */
    @Override
    public int deleteSelfTicketPricesByIds(Long[] ids)
    {
        return selfTicketPricesMapper.deleteSelfTicketPricesByIds(ids);
    }

    /**
     * 删除票价信息
     * 
     * @param id 票价主键
     * @return 结果
     */
    @Override
    public int deleteSelfTicketPricesById(Long id)
    {
        return selfTicketPricesMapper.deleteSelfTicketPricesById(id);
    }
}

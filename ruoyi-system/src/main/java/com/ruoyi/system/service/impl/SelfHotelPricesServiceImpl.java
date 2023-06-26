package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfHotelPricesMapper;
import com.ruoyi.system.domain.SelfHotelPrices;
import com.ruoyi.system.service.ISelfHotelPricesService;

/**
 * 酒店价格Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@Service
public class SelfHotelPricesServiceImpl implements ISelfHotelPricesService 
{
    @Autowired
    private SelfHotelPricesMapper selfHotelPricesMapper;

    /**
     * 查询酒店价格
     * 
     * @param id 酒店价格主键
     * @return 酒店价格
     */
    @Override
    public SelfHotelPrices selectSelfHotelPricesById(Long id)
    {
        return selfHotelPricesMapper.selectSelfHotelPricesById(id);
    }

    /**
     * 查询酒店价格列表
     * 
     * @param selfHotelPrices 酒店价格
     * @return 酒店价格
     */
    @Override
    public List<SelfHotelPrices> selectSelfHotelPricesList(SelfHotelPrices selfHotelPrices)
    {
        return selfHotelPricesMapper.selectSelfHotelPricesList(selfHotelPrices);
    }

    /**
     * 新增酒店价格
     * 
     * @param selfHotelPrices 酒店价格
     * @return 结果
     */
    @Override
    public int insertSelfHotelPrices(SelfHotelPrices selfHotelPrices)
    {
        return selfHotelPricesMapper.insertSelfHotelPrices(selfHotelPrices);
    }

    /**
     * 修改酒店价格
     * 
     * @param selfHotelPrices 酒店价格
     * @return 结果
     */
    @Override
    public int updateSelfHotelPrices(SelfHotelPrices selfHotelPrices)
    {
        return selfHotelPricesMapper.updateSelfHotelPrices(selfHotelPrices);
    }

    /**
     * 批量删除酒店价格
     * 
     * @param ids 需要删除的酒店价格主键
     * @return 结果
     */
    @Override
    public int deleteSelfHotelPricesByIds(Long[] ids)
    {
        return selfHotelPricesMapper.deleteSelfHotelPricesByIds(ids);
    }

    /**
     * 删除酒店价格信息
     * 
     * @param id 酒店价格主键
     * @return 结果
     */
    @Override
    public int deleteSelfHotelPricesById(Long id)
    {
        return selfHotelPricesMapper.deleteSelfHotelPricesById(id);
    }
}

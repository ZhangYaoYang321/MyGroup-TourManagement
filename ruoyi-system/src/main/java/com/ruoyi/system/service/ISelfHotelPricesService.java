package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SelfHotelPrices;

/**
 * 酒店价格Service接口
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public interface ISelfHotelPricesService 
{
    /**
     * 查询酒店价格
     * 
     * @param id 酒店价格主键
     * @return 酒店价格
     */
    public SelfHotelPrices selectSelfHotelPricesById(Long id);

    /**
     * 查询酒店价格列表
     * 
     * @param selfHotelPrices 酒店价格
     * @return 酒店价格集合
     */
    public List<SelfHotelPrices> selectSelfHotelPricesList(SelfHotelPrices selfHotelPrices);

    /**
     * 新增酒店价格
     * 
     * @param selfHotelPrices 酒店价格
     * @return 结果
     */
    public int insertSelfHotelPrices(SelfHotelPrices selfHotelPrices);

    /**
     * 修改酒店价格
     * 
     * @param selfHotelPrices 酒店价格
     * @return 结果
     */
    public int updateSelfHotelPrices(SelfHotelPrices selfHotelPrices);

    /**
     * 批量删除酒店价格
     * 
     * @param ids 需要删除的酒店价格主键集合
     * @return 结果
     */
    public int deleteSelfHotelPricesByIds(Long[] ids);

    /**
     * 删除酒店价格信息
     * 
     * @param id 酒店价格主键
     * @return 结果
     */
    public int deleteSelfHotelPricesById(Long id);
}

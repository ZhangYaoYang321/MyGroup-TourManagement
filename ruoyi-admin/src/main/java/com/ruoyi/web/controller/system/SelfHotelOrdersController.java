package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SelfHotelOrders;
import com.ruoyi.system.service.ISelfHotelOrdersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 酒店订单Controller
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@RestController
@RequestMapping("/system/orders")
public class SelfHotelOrdersController extends BaseController
{
    @Autowired
    private ISelfHotelOrdersService selfHotelOrdersService;

    /**
     * 查询酒店订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:orders:list')")
    @GetMapping("/list")
    public TableDataInfo list(SelfHotelOrders selfHotelOrders)
    {
        startPage();
        List<SelfHotelOrders> list = selfHotelOrdersService.selectSelfHotelOrdersList(selfHotelOrders);
        return getDataTable(list);
    }

    /**
     * 导出酒店订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:orders:export')")
    @Log(title = "酒店订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfHotelOrders selfHotelOrders)
    {
        List<SelfHotelOrders> list = selfHotelOrdersService.selectSelfHotelOrdersList(selfHotelOrders);
        ExcelUtil<SelfHotelOrders> util = new ExcelUtil<SelfHotelOrders>(SelfHotelOrders.class);
        util.exportExcel(response, list, "酒店订单数据");
    }

    /**
     * 获取酒店订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:orders:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfHotelOrdersService.selectSelfHotelOrdersById(id));
    }

    /**
     * 新增酒店订单
     */
    @PreAuthorize("@ss.hasPermi('system:orders:add')")
    @Log(title = "酒店订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfHotelOrders selfHotelOrders)
    {
        return toAjax(selfHotelOrdersService.insertSelfHotelOrders(selfHotelOrders));
    }

    /**
     * 修改酒店订单
     */
    @PreAuthorize("@ss.hasPermi('system:orders:edit')")
    @Log(title = "酒店订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfHotelOrders selfHotelOrders)
    {
        return toAjax(selfHotelOrdersService.updateSelfHotelOrders(selfHotelOrders));
    }

    /**
     * 删除酒店订单
     */
    @PreAuthorize("@ss.hasPermi('system:orders:remove')")
    @Log(title = "酒店订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfHotelOrdersService.deleteSelfHotelOrdersByIds(ids));
    }
}

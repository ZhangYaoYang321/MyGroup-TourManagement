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
import com.ruoyi.system.domain.SelfTicketPrices;
import com.ruoyi.system.service.ISelfTicketPricesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 票价Controller
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@RestController
@RequestMapping("/system/ticket_prices")
public class SelfTicketPricesController extends BaseController
{
    @Autowired
    private ISelfTicketPricesService selfTicketPricesService;

    /**
     * 查询票价列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SelfTicketPrices selfTicketPrices)
    {
        startPage();
        List<SelfTicketPrices> list = selfTicketPricesService.selectSelfTicketPricesList(selfTicketPrices);
        return getDataTable(list);
    }

    /**
     * 导出票价列表
     */
    @Log(title = "票价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfTicketPrices selfTicketPrices)
    {
        List<SelfTicketPrices> list = selfTicketPricesService.selectSelfTicketPricesList(selfTicketPrices);
        ExcelUtil<SelfTicketPrices> util = new ExcelUtil<SelfTicketPrices>(SelfTicketPrices.class);
        util.exportExcel(response, list, "票价数据");
    }

    /**
     * 获取票价详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfTicketPricesService.selectSelfTicketPricesById(id));
    }

    /**
     * 新增票价
     */
    @Log(title = "票价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfTicketPrices selfTicketPrices)
    {
        return toAjax(selfTicketPricesService.insertSelfTicketPrices(selfTicketPrices));
    }

    /**
     * 修改票价
     */
    @Log(title = "票价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfTicketPrices selfTicketPrices)
    {
        return toAjax(selfTicketPricesService.updateSelfTicketPrices(selfTicketPrices));
    }

    /**
     * 删除票价
     */
    @Log(title = "票价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfTicketPricesService.deleteSelfTicketPricesByIds(ids));
    }
}

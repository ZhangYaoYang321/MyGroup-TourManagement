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
import com.ruoyi.system.domain.SelfTicketServices;
import com.ruoyi.system.service.ISelfTicketServicesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 票务Controller
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@RestController
@RequestMapping("/system/ticket_services")
public class SelfTicketServicesController extends BaseController
{
    @Autowired
    private ISelfTicketServicesService selfTicketServicesService;

    /**
     * 查询票务列表
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:list')")
    @GetMapping("/list")
    public TableDataInfo list(SelfTicketServices selfTicketServices)
    {
        startPage();
        List<SelfTicketServices> list = selfTicketServicesService.selectSelfTicketServicesList(selfTicketServices);
        return getDataTable(list);
    }

    /**
     * 导出票务列表
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:export')")
    @Log(title = "票务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfTicketServices selfTicketServices)
    {
        List<SelfTicketServices> list = selfTicketServicesService.selectSelfTicketServicesList(selfTicketServices);
        ExcelUtil<SelfTicketServices> util = new ExcelUtil<SelfTicketServices>(SelfTicketServices.class);
        util.exportExcel(response, list, "票务数据");
    }

    /**
     * 获取票务详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfTicketServicesService.selectSelfTicketServicesById(id));
    }

    /**
     * 新增票务
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:add')")
    @Log(title = "票务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfTicketServices selfTicketServices)
    {
        return toAjax(selfTicketServicesService.insertSelfTicketServices(selfTicketServices));
    }

    /**
     * 修改票务
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:edit')")
    @Log(title = "票务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfTicketServices selfTicketServices)
    {
        return toAjax(selfTicketServicesService.updateSelfTicketServices(selfTicketServices));
    }

    /**
     * 删除票务
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_services:remove')")
    @Log(title = "票务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfTicketServicesService.deleteSelfTicketServicesByIds(ids));
    }
}

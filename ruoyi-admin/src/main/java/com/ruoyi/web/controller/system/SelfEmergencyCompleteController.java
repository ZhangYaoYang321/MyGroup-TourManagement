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
import com.ruoyi.system.domain.SelfEmergencyComplete;
import com.ruoyi.system.service.ISelfEmergencyCompleteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 事件处理Controller
 * 
 * @author ruoyi
 * @date 2023-06-27
 */
@RestController
@RequestMapping("/system/emergency_complete")
public class SelfEmergencyCompleteController extends BaseController
{
    @Autowired
    private ISelfEmergencyCompleteService selfEmergencyCompleteService;

    /**
     * 查询事件处理列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SelfEmergencyComplete selfEmergencyComplete)
    {
        startPage();
        List<SelfEmergencyComplete> list = selfEmergencyCompleteService.selectSelfEmergencyCompleteList(selfEmergencyComplete);
        return getDataTable(list);
    }

    /**
     * 导出事件处理列表
     */
    @Log(title = "事件处理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfEmergencyComplete selfEmergencyComplete)
    {
        List<SelfEmergencyComplete> list = selfEmergencyCompleteService.selectSelfEmergencyCompleteList(selfEmergencyComplete);
        ExcelUtil<SelfEmergencyComplete> util = new ExcelUtil<SelfEmergencyComplete>(SelfEmergencyComplete.class);
        util.exportExcel(response, list, "事件处理数据");
    }

    /**
     * 获取事件处理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfEmergencyCompleteService.selectSelfEmergencyCompleteById(id));
    }

    /**
     * 新增事件处理
     */
    @Log(title = "事件处理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfEmergencyComplete selfEmergencyComplete)
    {
        return toAjax(selfEmergencyCompleteService.insertSelfEmergencyComplete(selfEmergencyComplete));
    }

    /**
     * 修改事件处理
     */
    @Log(title = "事件处理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfEmergencyComplete selfEmergencyComplete)
    {
        return toAjax(selfEmergencyCompleteService.updateSelfEmergencyComplete(selfEmergencyComplete));
    }

    /**
     * 删除事件处理
     */
    @Log(title = "事件处理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfEmergencyCompleteService.deleteSelfEmergencyCompleteByIds(ids));
    }
}

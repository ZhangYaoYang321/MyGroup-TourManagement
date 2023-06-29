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
import com.ruoyi.system.domain.SelfEmergencyAdd;
import com.ruoyi.system.service.ISelfEmergencyAddService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 事件Controller
 * 
 * @author ruoyi
 * @date 2023-06-27
 */
@RestController
@RequestMapping("/system/emergency_add")
public class SelfEmergencyAddController extends BaseController
{
    @Autowired
    private ISelfEmergencyAddService selfEmergencyAddService;

    /**
     * 查询事件列表
     */
    @PreAuthorize("@ss.hasPermi('system:emergency_add:list')")
    @GetMapping("/list")
    public TableDataInfo list(SelfEmergencyAdd selfEmergencyAdd)
    {
        startPage();
        List<SelfEmergencyAdd> list = selfEmergencyAddService.selectSelfEmergencyAddList(selfEmergencyAdd);
        return getDataTable(list);
    }

    /**
     * 导出事件列表
     */
    @PreAuthorize("@ss.hasPermi('system:emergency_add:export')")
    @Log(title = "事件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfEmergencyAdd selfEmergencyAdd)
    {
        List<SelfEmergencyAdd> list = selfEmergencyAddService.selectSelfEmergencyAddList(selfEmergencyAdd);
        ExcelUtil<SelfEmergencyAdd> util = new ExcelUtil<SelfEmergencyAdd>(SelfEmergencyAdd.class);
        util.exportExcel(response, list, "事件数据");
    }

    /**
     * 获取事件详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:emergency_add:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfEmergencyAddService.selectSelfEmergencyAddById(id));
    }

    /**
     * 新增事件
     */
    @PreAuthorize("@ss.hasPermi('system:emergency_add:add')")
    @Log(title = "事件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfEmergencyAdd selfEmergencyAdd)
    {
        return toAjax(selfEmergencyAddService.insertSelfEmergencyAdd(selfEmergencyAdd));
    }

    /**
     * 修改事件
     */
    @PreAuthorize("@ss.hasPermi('system:emergency_add:edit')")
    @Log(title = "事件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfEmergencyAdd selfEmergencyAdd)
    {
        return toAjax(selfEmergencyAddService.updateSelfEmergencyAdd(selfEmergencyAdd));
    }

    /**
     * 删除事件
     */
    @PreAuthorize("@ss.hasPermi('system:emergency_add:remove')")
    @Log(title = "事件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfEmergencyAddService.deleteSelfEmergencyAddByIds(ids));
    }
}

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
import com.ruoyi.system.domain.SelfComplaintAdd;
import com.ruoyi.system.service.ISelfComplaintAddService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 投诉Controller
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@RestController
@RequestMapping("/system/complaint_add")
public class SelfComplaintAddController extends BaseController
{
    @Autowired
    private ISelfComplaintAddService selfComplaintAddService;

    /**
     * 查询投诉列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SelfComplaintAdd selfComplaintAdd)
    {
        startPage();
        List<SelfComplaintAdd> list = selfComplaintAddService.selectSelfComplaintAddList(selfComplaintAdd);
        return getDataTable(list);
    }

    /**
     * 导出投诉列表
     */
    @Log(title = "投诉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfComplaintAdd selfComplaintAdd)
    {
        List<SelfComplaintAdd> list = selfComplaintAddService.selectSelfComplaintAddList(selfComplaintAdd);
        ExcelUtil<SelfComplaintAdd> util = new ExcelUtil<SelfComplaintAdd>(SelfComplaintAdd.class);
        util.exportExcel(response, list, "投诉数据");
    }

    /**
     * 获取投诉详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfComplaintAddService.selectSelfComplaintAddById(id));
    }

    /**
     * 新增投诉
     */
    @Log(title = "投诉", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfComplaintAdd selfComplaintAdd)
    {
        return toAjax(selfComplaintAddService.insertSelfComplaintAdd(selfComplaintAdd));
    }

    /**
     * 修改投诉
     */
    @Log(title = "投诉", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfComplaintAdd selfComplaintAdd)
    {
        return toAjax(selfComplaintAddService.updateSelfComplaintAdd(selfComplaintAdd));
    }

    /**
     * 删除投诉
     */
    @Log(title = "投诉", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfComplaintAddService.deleteSelfComplaintAddByIds(ids));
    }
}

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
import com.ruoyi.system.domain.SelfComplaintComplete;
import com.ruoyi.system.service.ISelfComplaintCompleteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 投诉Controller
 * 
 * @author ruoyi
 * @date 2023-06-27
 */
@RestController
@RequestMapping("/system/complaint_complete")
public class SelfComplaintCompleteController extends BaseController
{
    @Autowired
    private ISelfComplaintCompleteService selfComplaintCompleteService;

    /**
     * 查询投诉列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SelfComplaintComplete selfComplaintComplete)
    {
        startPage();
        List<SelfComplaintComplete> list = selfComplaintCompleteService.selectSelfComplaintCompleteList(selfComplaintComplete);
        return getDataTable(list);
    }

    /**
     * 导出投诉列表
     */
    @Log(title = "投诉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfComplaintComplete selfComplaintComplete)
    {
        List<SelfComplaintComplete> list = selfComplaintCompleteService.selectSelfComplaintCompleteList(selfComplaintComplete);
        ExcelUtil<SelfComplaintComplete> util = new ExcelUtil<SelfComplaintComplete>(SelfComplaintComplete.class);
        util.exportExcel(response, list, "投诉数据");
    }

    /**
     * 获取投诉详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfComplaintCompleteService.selectSelfComplaintCompleteById(id));
    }

    /**
     * 新增投诉
     */
    @Log(title = "投诉", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfComplaintComplete selfComplaintComplete)
    {
        return toAjax(selfComplaintCompleteService.insertSelfComplaintComplete(selfComplaintComplete));
    }

    /**
     * 修改投诉
     */
    @Log(title = "投诉", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfComplaintComplete selfComplaintComplete)
    {
        return toAjax(selfComplaintCompleteService.updateSelfComplaintComplete(selfComplaintComplete));
    }

    /**
     * 删除投诉
     */
    @Log(title = "投诉", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfComplaintCompleteService.deleteSelfComplaintCompleteByIds(ids));
    }
}

package com.ruoyi.web.controller.system;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.SelfEmergencies;
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
import com.ruoyi.system.domain.SelfComplaints;
import com.ruoyi.system.service.ISelfComplaintsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 投诉Controller
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@RestController
@RequestMapping("/system/complaints")
public class SelfComplaintsController extends BaseController
{
    @Autowired
    private ISelfComplaintsService selfComplaintsService;

    /**
     * 查询投诉列表
     */
    @PreAuthorize("@ss.hasPermi('system:complaints:list')")
    @GetMapping("/list")
    public TableDataInfo list(SelfComplaints selfComplaints)
    {
        startPage();
        List<SelfComplaints> list = selfComplaintsService.selectSelfComplaintsList(selfComplaints);
        return getDataTable(list);
    }

    /**
     * 导出投诉列表
     */
    @PreAuthorize("@ss.hasPermi('system:complaints:export')")
    @Log(title = "投诉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfComplaints selfComplaints)
    {
        List<SelfComplaints> list = selfComplaintsService.selectSelfComplaintsList(selfComplaints);
        ExcelUtil<SelfComplaints> util = new ExcelUtil<SelfComplaints>(SelfComplaints.class);
        util.exportExcel(response, list, "投诉数据");
    }

    /**
     * 获取投诉详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:complaints:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfComplaintsService.selectSelfComplaintsById(id));
    }

    /**
     * 新增投诉
     */
    @PreAuthorize("@ss.hasPermi('system:complaints:add')")
    @Log(title = "投诉", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfComplaints selfComplaints)
    {
        return toAjax(selfComplaintsService.insertSelfComplaints(selfComplaints));
    }

    /**
     * 修改投诉
     */
    @PreAuthorize("@ss.hasPermi('system:complaints:edit')")
    @Log(title = "投诉", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfComplaints selfComplaints)
    {
        return toAjax(selfComplaintsService.updateSelfComplaints(selfComplaints));
    }

    /**
     * 删除投诉
     */
    @PreAuthorize("@ss.hasPermi('system:complaints:remove')")
    @Log(title = "投诉", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfComplaintsService.deleteSelfComplaintsByIds(ids));
    }

    /**
     * 获取当日投诉
     */
    @GetMapping("/getTodayComplaints")
    public TableDataInfo getTodayComplaints() {
        List<SelfComplaints> todayComplaints = new ArrayList<>();
        List<SelfComplaints> complaints = selfComplaintsService.selectSelfComplaintsList(new SelfComplaints());
        LocalDate currentDate = LocalDate.now();
        for (SelfComplaints sc : complaints) {
            if (sc.getComplaintsDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isEqual(currentDate)) {
                todayComplaints.add(sc);
            }
        }
        System.out.println(todayComplaints);
        return getDataTable(todayComplaints);
    }
}

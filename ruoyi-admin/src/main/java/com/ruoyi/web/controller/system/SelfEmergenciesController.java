package com.ruoyi.web.controller.system;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.SelfTicketServices;
import com.ruoyi.system.service.ISysDeptService;
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
import com.ruoyi.system.domain.SelfEmergencies;
import com.ruoyi.system.service.ISelfEmergenciesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 事件Controller
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@RestController
@RequestMapping("/system/emergencies")
public class SelfEmergenciesController extends BaseController
{
    @Autowired
    private ISelfEmergenciesService selfEmergenciesService;

    @Autowired
    private ISysDeptService sysDeptService;

    /**
     * 查询事件列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SelfEmergencies selfEmergencies)
    {
        startPage();
        List<SelfEmergencies> list = selfEmergenciesService.selectSelfEmergenciesList(selfEmergencies);
        return getDataTable(list);
    }

    /**
     * 导出事件列表
     */
    @Log(title = "事件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfEmergencies selfEmergencies)
    {
        List<SelfEmergencies> list = selfEmergenciesService.selectSelfEmergenciesList(selfEmergencies);
        ExcelUtil<SelfEmergencies> util = new ExcelUtil<SelfEmergencies>(SelfEmergencies.class);
        util.exportExcel(response, list, "事件数据");
    }

    /**
     * 获取事件详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfEmergenciesService.selectSelfEmergenciesById(id));
    }

    /**
     * 新增事件
     */
    @Log(title = "事件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfEmergencies selfEmergencies)
    {
        return toAjax(selfEmergenciesService.insertSelfEmergencies(selfEmergencies));
    }

    /**
     * 修改事件
     */
    @Log(title = "事件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfEmergencies selfEmergencies)
    {
        return toAjax(selfEmergenciesService.updateSelfEmergencies(selfEmergencies));
    }

    /**
     * 删除事件
     */
    @Log(title = "事件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfEmergenciesService.deleteSelfEmergenciesByIds(ids));
    }

    /**
     * 获取当日事件
     */
    @GetMapping("/getTodayEmergencies")
    public TableDataInfo getTodayEmergencies() {
        List<SelfEmergencies> todayEmergencies = new ArrayList<>();
        List<SelfEmergencies> emergencies = selfEmergenciesService.selectSelfEmergenciesList(new SelfEmergencies());
        LocalDate currentDate = LocalDate.now();
        for (SelfEmergencies se : emergencies) {
            if (se.getEmergenciesTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isEqual(currentDate)) {
                if (se.getDepartment() != null) {
                    se.setDepartment(sysDeptService.selectDeptById(Long.valueOf(se.getDepartment())).getDeptName());
                }
                todayEmergencies.add(se);
            }
        }
        return getDataTable(todayEmergencies);
    }
}

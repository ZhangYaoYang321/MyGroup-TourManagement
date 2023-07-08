package com.ruoyi.web.controller.system;

import java.util.LinkedList;
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
import com.ruoyi.system.domain.SelfAttendances;
import com.ruoyi.system.service.ISelfAttendancesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 考勤信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@RestController
@RequestMapping("/system/attendances")
public class SelfAttendancesController extends BaseController
{
    @Autowired
    private ISelfAttendancesService selfAttendancesService;

    /**
     * 查询考勤信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SelfAttendances selfAttendances)
    {
        startPage();
        List<SelfAttendances> list = selfAttendancesService.selectSelfAttendancesList(selfAttendances);
        return getDataTable(list);
    }

    @GetMapping("/listcur")
    public TableDataInfo listcur(SelfAttendances selfAttendances)
    {
        startPage();
        Long userId = getLoginUser().getUserId();
        SelfAttendances selfAttendances1 = selfAttendancesService.selectSelfAttendancesById(userId);
        List<SelfAttendances> list = new LinkedList<>();
        list.add(selfAttendances1);
        return getDataTable(list);
    }

    /**
     * 导出考勤信息列表
     */
    @Log(title = "考勤信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfAttendances selfAttendances)
    {
        List<SelfAttendances> list = selfAttendancesService.selectSelfAttendancesList(selfAttendances);
        ExcelUtil<SelfAttendances> util = new ExcelUtil<SelfAttendances>(SelfAttendances.class);
        util.exportExcel(response, list, "考勤信息数据");
    }

    /**
     * 获取考勤信息详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfAttendancesService.selectSelfAttendancesById(id));
    }

    /**
     * 新增考勤信息
     */
    @Log(title = "考勤信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfAttendances selfAttendances)
    {
        return toAjax(selfAttendancesService.insertSelfAttendances(selfAttendances));
    }

    /**
     * 修改考勤信息
     */
    @Log(title = "考勤信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfAttendances selfAttendances)
    {
        return toAjax(selfAttendancesService.updateSelfAttendances(selfAttendances));
    }

    /**
     * 删除考勤信息
     */
    @Log(title = "考勤信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfAttendancesService.deleteSelfAttendancesByIds(ids));
    }

    @Log(title = "考勤信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/resetKQAttendances/{ids}")
    public AjaxResult resetKQAttendances(@PathVariable Long[] ids)
    {
        return toAjax(selfAttendancesService.resetKQAttendances(ids));
    }
}

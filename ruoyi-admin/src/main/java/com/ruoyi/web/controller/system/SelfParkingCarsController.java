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
import com.ruoyi.system.domain.SelfParkingCars;
import com.ruoyi.system.service.ISelfParkingCarsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆Controller
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@RestController
@RequestMapping("/system/cars")
public class SelfParkingCarsController extends BaseController
{
    @Autowired
    private ISelfParkingCarsService selfParkingCarsService;

    /**
     * 查询车辆列表
     */
    @PreAuthorize("@ss.hasPermi('system:cars:list')")
    @GetMapping("/list")
    public TableDataInfo list(SelfParkingCars selfParkingCars)
    {
        startPage();
        List<SelfParkingCars> list = selfParkingCarsService.selectSelfParkingCarsList(selfParkingCars);
        return getDataTable(list);
    }

    /**
     * 导出车辆列表
     */
    @PreAuthorize("@ss.hasPermi('system:cars:export')")
    @Log(title = "车辆", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfParkingCars selfParkingCars)
    {
        List<SelfParkingCars> list = selfParkingCarsService.selectSelfParkingCarsList(selfParkingCars);
        ExcelUtil<SelfParkingCars> util = new ExcelUtil<SelfParkingCars>(SelfParkingCars.class);
        util.exportExcel(response, list, "车辆数据");
    }

    /**
     * 获取车辆详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cars:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfParkingCarsService.selectSelfParkingCarsById(id));
    }

    /**
     * 新增车辆
     */
    @PreAuthorize("@ss.hasPermi('system:cars:add')")
    @Log(title = "车辆", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfParkingCars selfParkingCars)
    {
        return toAjax(selfParkingCarsService.insertSelfParkingCars(selfParkingCars));
    }

    /**
     * 修改车辆
     */
    @PreAuthorize("@ss.hasPermi('system:cars:edit')")
    @Log(title = "车辆", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfParkingCars selfParkingCars)
    {
        return toAjax(selfParkingCarsService.updateSelfParkingCars(selfParkingCars));
    }

    /**
     * 删除车辆
     */
    @PreAuthorize("@ss.hasPermi('system:cars:remove')")
    @Log(title = "车辆", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfParkingCarsService.deleteSelfParkingCarsByIds(ids));
    }
}

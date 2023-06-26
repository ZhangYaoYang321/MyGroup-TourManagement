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
import com.ruoyi.system.domain.SelfHotelRooms;
import com.ruoyi.system.service.ISelfHotelRoomsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房间Controller
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@RestController
@RequestMapping("/system/rooms")
public class SelfHotelRoomsController extends BaseController
{
    @Autowired
    private ISelfHotelRoomsService selfHotelRoomsService;

    /**
     * 查询房间列表
     */
    @PreAuthorize("@ss.hasPermi('system:rooms:list')")
    @GetMapping("/list")
    public TableDataInfo list(SelfHotelRooms selfHotelRooms)
    {
        startPage();
        List<SelfHotelRooms> list = selfHotelRoomsService.selectSelfHotelRoomsList(selfHotelRooms);
        return getDataTable(list);
    }

    /**
     * 导出房间列表
     */
    @PreAuthorize("@ss.hasPermi('system:rooms:export')")
    @Log(title = "房间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SelfHotelRooms selfHotelRooms)
    {
        List<SelfHotelRooms> list = selfHotelRoomsService.selectSelfHotelRoomsList(selfHotelRooms);
        ExcelUtil<SelfHotelRooms> util = new ExcelUtil<SelfHotelRooms>(SelfHotelRooms.class);
        util.exportExcel(response, list, "房间数据");
    }

    /**
     * 获取房间详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:rooms:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfHotelRoomsService.selectSelfHotelRoomsById(id));
    }

    /**
     * 新增房间
     */
    @PreAuthorize("@ss.hasPermi('system:rooms:add')")
    @Log(title = "房间", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfHotelRooms selfHotelRooms)
    {
        return toAjax(selfHotelRoomsService.insertSelfHotelRooms(selfHotelRooms));
    }

    /**
     * 修改房间
     */
    @PreAuthorize("@ss.hasPermi('system:rooms:edit')")
    @Log(title = "房间", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfHotelRooms selfHotelRooms)
    {
        return toAjax(selfHotelRoomsService.updateSelfHotelRooms(selfHotelRooms));
    }

    /**
     * 删除房间
     */
    @PreAuthorize("@ss.hasPermi('system:rooms:remove')")
    @Log(title = "房间", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(selfHotelRoomsService.deleteSelfHotelRoomsByIds(ids));
    }
}

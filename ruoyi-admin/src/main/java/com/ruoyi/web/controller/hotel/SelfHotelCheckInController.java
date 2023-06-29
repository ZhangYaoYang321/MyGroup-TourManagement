package com.ruoyi.web.controller.hotel;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SelfHotelCheckIn;
import com.ruoyi.system.domain.SelfHotelReservation;
import com.ruoyi.system.service.ISelfHotelCheckInService;
import com.ruoyi.system.service.ISelfHotelCheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 酒店退房Controller
 *
 * @author ruoyi
 * @date 2023-06-26
 */

@RestController
@RequestMapping("/hotel/checkin")
public class SelfHotelCheckInController extends BaseController {
    @Autowired
    private ISelfHotelCheckInService selfHotelCheckInService;

    /**
     * 查询酒店订单列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:checkin:list')")
    @GetMapping("/list")
    public TableDataInfo list(SelfHotelCheckIn selfHotelCheckIn)
    {
        startPage();
        List<SelfHotelCheckIn> list = selfHotelCheckInService.selectSelfHotelCheckInList(selfHotelCheckIn);
        return getDataTable(list);
    }
    /**
     * 删除酒店订单
     */
    @PreAuthorize("@ss.hasPermi('hotel:checkin:submit')")
    @Log(title = "酒店入住", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult checkIn(@PathVariable("id") Long id)
    {
        System.out.println(id);
        return toAjax(selfHotelCheckInService.checkInSelfHotelCheckInById(id));
    }
}

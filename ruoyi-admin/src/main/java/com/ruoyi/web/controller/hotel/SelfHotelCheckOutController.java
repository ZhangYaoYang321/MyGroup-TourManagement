package com.ruoyi.web.controller.hotel;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SelfHotelCheckIn;
import com.ruoyi.system.domain.SelfHotelCheckOut;
import com.ruoyi.system.service.ISelfHotelCheckOutService;
import com.ruoyi.system.service.ISelfHotelReservationService;
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
@RequestMapping("/hotel/checkout")
public class SelfHotelCheckOutController extends BaseController {
    @Autowired
    private ISelfHotelCheckOutService selfHotelCheckOutService;
    /**
     * 查询酒店订单列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SelfHotelCheckOut selfHotelCheckOut)
    {
        startPage();
        List<SelfHotelCheckOut> list = selfHotelCheckOutService.selectSelfHotelCheckOutList(selfHotelCheckOut);
        return getDataTable(list);
    }
    /**
     * 删除酒店订单
     */
    @Log(title = "酒店入住", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult checkOut(@PathVariable("id") Long id)
    {
        System.out.println(id);
        return toAjax(selfHotelCheckOutService.checkOutSelfHotelCheckOutById(id));
    }
}

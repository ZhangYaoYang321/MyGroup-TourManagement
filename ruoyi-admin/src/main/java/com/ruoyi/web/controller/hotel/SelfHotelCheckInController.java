package com.ruoyi.web.controller.hotel;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.system.domain.SelfHotelCheckIn;
import com.ruoyi.system.domain.SelfHotelReservation;
import com.ruoyi.system.service.ISelfHotelCheckInService;
import com.ruoyi.system.service.ISelfHotelCheckOutService;
import com.ruoyi.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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
     * 查询酒店房间数
     */
    @PreAuthorize("@ss.hasPermi('hotel:checkin:query')")
    @GetMapping("/rooms")
    public TableDataInfo listRoom(SelfHotelCheckIn selfHotelCheckIn)
    {
        startPage();
        System.out.println("aaaaaaaaaaaaaaa");
        List<String> list = selfHotelCheckInService.checkInSelfHotelRooms(getDate());
        System.out.println(list.get(1));
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

    public String getDate(){
        Date d=new Date();
        SimpleDateFormat dmDate = new SimpleDateFormat("yyyy-MM-dd");
        String date = dmDate.format(d);
        String[] s=date.split("-");
        date=String.valueOf(Integer.parseInt(s[0]))+'-'+String.valueOf(Integer.parseInt(s[1]))+'-'+String.valueOf(Integer.parseInt(s[2]));
        return date;
    }
}

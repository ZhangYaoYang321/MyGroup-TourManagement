package com.ruoyi.web.controller.hotel;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SelfHotelOrders;
import com.ruoyi.system.domain.SelfHotelReservation;
import com.ruoyi.system.service.ISelfHotelOrdersService;
import com.ruoyi.system.service.ISelfHotelReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 酒店预约Controller
 *
 * @author ruoyi
 * @date 2023-06-26
 */

@RestController
@RequestMapping("/hotel/reservation")
public class SelfHotelReservationController extends BaseController {
    @Autowired
    private ISelfHotelReservationService selfHotelReservationService;


    /**
     * 查询酒店订单列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:reservation:list')")
    @GetMapping("/list")
    public TableDataInfo list(SelfHotelReservation selfHotelReservation)
    {
        startPage();
        List<SelfHotelReservation> list = selfHotelReservationService.selectSelfHotelReservationList(selfHotelReservation);
        return getDataTable(list);
    }

    /**
     * 新增酒店订单
     */
    @PreAuthorize("@ss.hasPermi('hotel:reservation:add')")
    @Log(title = "酒店预约", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SelfHotelReservation selfHotelReservation)
    {
        selfHotelReservation.setOrderId(randomOrderCode());
        return toAjax(selfHotelReservationService.insertSelfHotelReservation(selfHotelReservation));
    }
    /**
     * 获取酒店订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('hotel:reservation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(selfHotelReservationService.selectSelfHotelReservationById(id));
    }

    /**
     * 获取酒店房间详细信息
     */
    @PreAuthorize("@ss.hasPermi('hotel:reservation:query')")
    @GetMapping(value = "/1/{date}")
    public TableDataInfo listRooms(@PathVariable("date") String date)
    {
        System.out.println(date);
        startPage();
        List<Integer> list=selfHotelReservationService.selectSelfHotelReservationRoomsByDate(date);
        //System.out.println(list);
        return getDataTable(list);
    }


    /**
     * 修改酒店订单
     */
    @PreAuthorize("@ss.hasPermi('hotel:reservation:edit')")
    @Log(title = "酒店预约", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SelfHotelReservation selfHotelReservation)
    {
        System.out.println("22222222222222222");
        return toAjax(selfHotelReservationService.updateSelfHotelReservation(selfHotelReservation));
    }

    /**
     * 删除酒店订单
     */
    @PreAuthorize("@ss.hasPermi('hotel:reservation:remove')")
    @Log(title = "酒店预约", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        System.out.println(id);
        return toAjax(selfHotelReservationService.deleteSelfHotelReservationById(id));
    }

    public static long randomOrderCode() {
        SimpleDateFormat dmDate = new SimpleDateFormat("yyyyMMddHHmmss");
        Random r=new Random();
        long randata=0;
        for(int i=0;i<2;i++){
            randata=randata*10+r.nextInt(10);
        }
        String.valueOf(randata);
        Date date = new Date();
        String dateran = dmDate.format(date);
        String Xsode = dateran + randata;
        long code=Long.valueOf(Xsode);

        return code;
    }


}

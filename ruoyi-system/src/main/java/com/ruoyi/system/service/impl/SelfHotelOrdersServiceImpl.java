package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfHotelOrdersMapper;
import com.ruoyi.system.domain.SelfHotelOrders;
import com.ruoyi.system.service.ISelfHotelOrdersService;

/**
 * 酒店订单Service业务层处理
 *
 * @author ruoyi
 * @date 2023-06-26
 */
@Service
public class SelfHotelOrdersServiceImpl implements ISelfHotelOrdersService
{
    @Autowired
    private SelfHotelOrdersMapper selfHotelOrdersMapper;

    /**
     * 查询酒店订单
     *
     * @param id 酒店订单主键
     * @return 酒店订单
     */
    @Override
    public SelfHotelOrders selectSelfHotelOrdersById(Long id)
    {
        return selfHotelOrdersMapper.selectSelfHotelOrdersById(id);
    }

    /**
     * 查询酒店订单列表
     *
     * @param selfHotelOrders 酒店订单
     * @return 酒店订单
     */
    @Override
    public List<SelfHotelOrders> selectSelfHotelOrdersList(SelfHotelOrders selfHotelOrders)
    {
        return selfHotelOrdersMapper.selectSelfHotelOrdersList(selfHotelOrders);
    }

    /**
     * 新增酒店订单
     *
     * @param selfHotelOrders 酒店订单
     * @return 结果
     */
    @Override
    public int insertSelfHotelOrders(SelfHotelOrders selfHotelOrders)
    {
        String sDate=selfHotelOrders.getStartDate();
        String eDate=selfHotelOrders.getEndDate();
        String[] start=sDate.split("-");
        String[] end=eDate.split("-");
        int sy=Integer.parseInt(start[0]),sm=Integer.parseInt(start[1]),sd=Integer.parseInt(start[2]);
        int ey=Integer.parseInt(end[0]),em=Integer.parseInt(end[1]),ed=Integer.parseInt(end[2]);
        int roomnum=selfHotelOrders.getRoomNum();
        for(int y=sy;y<=ey;y++) {
            for (int m = sm; m <= em; m++) {
                for (int d = sd; d <= ed; d++) {
                    String date=String.valueOf(y)+"-"+String.valueOf(m)+"-"+String.valueOf(d);
                    List<Integer> list=selfHotelOrdersMapper.selectSelfHotelOrdersRoomsByDate2(date,roomnum);
                    if(list.size()!=0){
                        return 0;
                    }
                }
            }
        }


        int one=selfHotelOrdersMapper.insertSelfHotelOrders1(selfHotelOrders);
        int two=0;
        System.out.println(11111);
        for(int y=sy;y<=ey;y++){
            for (int m=sm;m<=em;m++){
                for(int d=sd;d<=ed;d++){

                    String dd=String.valueOf(y)+"-"+String.valueOf(m)+"-"+String.valueOf(d);
                    long ll=selfHotelOrders.getOrderId();
                    System.out.println(ll);
                    int tt=selfHotelOrdersMapper.insertSelfHotelOrders2(ll,selfHotelOrders.getType(),selfHotelOrders.getRoomNum(),selfHotelOrders.getState(),dd);
                    two=two+tt;
                }
            }
        }
        int three=selfHotelOrdersMapper.insertSelfHotelOrders3(selfHotelOrders);


        return one+two;
    }

    /**
     * 修改酒店订单
     *
     * @param selfHotelOrders 酒店订单
     * @return 结果
     */
    @Override
    public int updateSelfHotelOrders(SelfHotelOrders selfHotelOrders)
    {
        String sDate=selfHotelOrders.getStartDate();
        String eDate=selfHotelOrders.getEndDate();
        String[] start=sDate.split("-");
        String[] end=eDate.split("-");
        int sy=Integer.parseInt(start[0]),sm=Integer.parseInt(start[1]),sd=Integer.parseInt(start[2]);
        int ey=Integer.parseInt(end[0]),em=Integer.parseInt(end[1]),ed=Integer.parseInt(end[2]);
        int roomnum=selfHotelOrders.getRoomNum();
        for(int y=sy;y<=ey;y++) {
            for (int m = sm; m <= em; m++) {
                for (int d = sd; d <= ed; d++) {
                    String date=String.valueOf(y)+"-"+String.valueOf(m)+"-"+String.valueOf(d);
                    List<Integer> list=selfHotelOrdersMapper.selectSelfHotelOrdersRoomsByDate2(date,roomnum);
                    if(list.size()!=0){
                        return 0;
                    }
                }
            }
        }


        selfHotelOrdersMapper.updateSelfHotelOrders2(selfHotelOrders);
        int two=0;
        System.out.println(11111);
        for(int y=sy;y<=ey;y++){
            for (int m=sm;m<=em;m++){
                for(int d=sd;d<=ed;d++){
                    String dd=String.valueOf(y)+"-"+String.valueOf(m)+"-"+String.valueOf(d);
                    long ll=selfHotelOrders.getOrderId();
                    System.out.println(ll);
                    int tt=selfHotelOrdersMapper.insertSelfHotelOrders2(ll,selfHotelOrders.getType(),selfHotelOrders.getRoomNum(),selfHotelOrders.getState(),dd);
                    two=two+tt;
                }
            }
        }
        return selfHotelOrdersMapper.updateSelfHotelOrders1(selfHotelOrders);
    }

    /**
     * 批量删除酒店订单
     *
     * @param ids 需要删除的酒店订单主键
     * @return 结果
     */
    @Override
    public int deleteSelfHotelOrdersByIds(Long[] ids)
    {
        return selfHotelOrdersMapper.deleteSelfHotelOrdersByIds(ids);
    }

    /**
     * 删除酒店订单信息
     *
     * @param id 酒店订单主键
     * @return 结果
     */
    @Override
    public int deleteSelfHotelOrdersById(Long id)
    {
        return selfHotelOrdersMapper.deleteSelfHotelOrdersById(id);
    }
}

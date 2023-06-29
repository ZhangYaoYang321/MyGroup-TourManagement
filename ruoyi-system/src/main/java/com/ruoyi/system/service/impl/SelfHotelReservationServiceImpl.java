package com.ruoyi.system.service.impl;
/**
 * 酒店预约Service业务层处理
 *
 * @author ruoyi
 * @date 2023-06-26
 */
import com.ruoyi.system.domain.SelfHotelOrders;
import com.ruoyi.system.domain.SelfHotelReservation;
import com.ruoyi.system.mapper.SelfHotelOrdersMapper;
import com.ruoyi.system.mapper.SelfHotelReservationMapper;
import com.ruoyi.system.service.ISelfHotelReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfHotelReservationServiceImpl implements ISelfHotelReservationService {

    @Autowired
    private SelfHotelReservationMapper selfHotelReservationMapper;

    /**
     * 新增酒店订单
     *
     * @param selfHotelReservation 酒店订单
     * @return 结果
     */

    @Override
    public int insertSelfHotelReservation(SelfHotelReservation selfHotelReservation) {
        int one=selfHotelReservationMapper.insertSelfHotelReservation1(selfHotelReservation);
        String sDate=selfHotelReservation.getStartDate();
        String eDate=selfHotelReservation.getEndDate();
        String[] start=sDate.split("-");
        String[] end=eDate.split("-");
        int sy=Integer.parseInt(start[0]),sm=Integer.parseInt(start[1]),sd=Integer.parseInt(start[2]);
        int ey=Integer.parseInt(end[0]),em=Integer.parseInt(end[1]),ed=Integer.parseInt(end[2]);
        int two=0;
        System.out.println(11111);
        for(int y=sy;y<=ey;y++){
            for (int m=sm;m<=em;m++){
                for(int d=sd;d<=ed;d++){

                    String dd=String.valueOf(y)+"-"+String.valueOf(m)+"-"+String.valueOf(d);
                    long ll=selfHotelReservation.getOrderId();
                    System.out.println(ll);
                    int tt=selfHotelReservationMapper.insertSelfHotelReservation2(ll,selfHotelReservation.getType(),selfHotelReservation.getRoomNum(),selfHotelReservation.getState(),dd);
                    two=two+tt;
                }
            }
        }
        int three=selfHotelReservationMapper.insertSelfHotelReservation3(selfHotelReservation);


        return one+two;
    }

    @Override
    public SelfHotelReservation selectSelfHotelReservationById(Long id) {
        return selfHotelReservationMapper.selectSelfHotelReservationById(id);
    }

    @Override
    public List<SelfHotelReservation> selectSelfHotelReservationList(SelfHotelReservation selfHotelReservation) {
        return selfHotelReservationMapper.selectSelfHotelReservationList(selfHotelReservation);
    }

    @Override
    public int updateSelfHotelReservation(SelfHotelReservation selfHotelReservation) {
        System.out.println("333333333333");
        selfHotelReservationMapper.updateSelfHotelReservation2(selfHotelReservation);
        String sDate=selfHotelReservation.getStartDate();
        String eDate=selfHotelReservation.getEndDate();
        String[] start=sDate.split("-");
        String[] end=eDate.split("-");
        int sy=Integer.parseInt(start[0]),sm=Integer.parseInt(start[1]),sd=Integer.parseInt(start[2]);
        int ey=Integer.parseInt(end[0]),em=Integer.parseInt(end[1]),ed=Integer.parseInt(end[2]);
        int two=0;
        System.out.println(11111);
        for(int y=sy;y<=ey;y++){
            for (int m=sm;m<=em;m++){
                for(int d=sd;d<=ed;d++){

                    String dd=String.valueOf(y)+"-"+String.valueOf(m)+"-"+String.valueOf(d);
                    long ll=selfHotelReservation.getOrderId();
                    System.out.println(ll);
                    int tt=selfHotelReservationMapper.insertSelfHotelReservation2(ll,selfHotelReservation.getType(),selfHotelReservation.getRoomNum(),selfHotelReservation.getState(),dd);
                    two=two+tt;
                }
            }
        }
        return selfHotelReservationMapper.updateSelfHotelReservation1(selfHotelReservation);
    }

    @Override
    public int deleteSelfHotelReservationById(Long id) {
        System.out.println(id);
        return selfHotelReservationMapper.deleteSelfHotelReservationById1(id);
    }

}

package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SelfHotelCheckIn;
import com.ruoyi.system.mapper.SelfHotelCheckInMapper;
import com.ruoyi.system.mapper.SelfHotelReservationMapper;
import com.ruoyi.system.service.ISelfHotelCheckInService;
import com.ruoyi.system.service.ISelfHotelCheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfHotelCheckInServiceImpl implements ISelfHotelCheckInService {

    @Autowired
    private SelfHotelCheckInMapper selfHotelCheckInMapper;
    @Override
    public List<SelfHotelCheckIn> selectSelfHotelCheckInList(SelfHotelCheckIn selfHotelCheckIn) {
        return selfHotelCheckInMapper.selectSelfHotelCheckInList(selfHotelCheckIn);
    }


    @Override
    public int checkInSelfHotelCheckInById(long id) {
        return selfHotelCheckInMapper.checkInSelfHotelCheckInById(id);
    }

    @Override
    public List<String> checkInSelfHotelRooms(String date) {
        return selfHotelCheckInMapper.checkInSelfHotelRooms(date);
    }
}

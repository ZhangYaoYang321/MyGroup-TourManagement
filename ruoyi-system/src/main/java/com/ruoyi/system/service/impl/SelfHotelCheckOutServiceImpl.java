package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SelfHotelCheckOut;
import com.ruoyi.system.mapper.SelfHotelCheckInMapper;
import com.ruoyi.system.mapper.SelfHotelCheckOutMapper;
import com.ruoyi.system.service.ISelfHotelCheckOutService;
import com.ruoyi.system.service.ISelfHotelReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfHotelCheckOutServiceImpl implements ISelfHotelCheckOutService {

    @Autowired
    private SelfHotelCheckOutMapper selfHotelCheckOutMapper;
    @Override
    public List<SelfHotelCheckOut> selectSelfHotelCheckOutList(SelfHotelCheckOut selfHotelCheckOut) {
        return selfHotelCheckOutMapper.selectSelfHotelCheckOutList(selfHotelCheckOut);
    }

    @Override
    public int checkOutSelfHotelCheckOutById(long id) {
        return selfHotelCheckOutMapper.checkOutSelfHotelCheckOutById(id);
    }
}

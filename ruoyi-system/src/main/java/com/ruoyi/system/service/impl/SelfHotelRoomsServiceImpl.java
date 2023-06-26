package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelfHotelRoomsMapper;
import com.ruoyi.system.domain.SelfHotelRooms;
import com.ruoyi.system.service.ISelfHotelRoomsService;

/**
 * 房间Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
@Service
public class SelfHotelRoomsServiceImpl implements ISelfHotelRoomsService 
{
    @Autowired
    private SelfHotelRoomsMapper selfHotelRoomsMapper;

    /**
     * 查询房间
     * 
     * @param id 房间主键
     * @return 房间
     */
    @Override
    public SelfHotelRooms selectSelfHotelRoomsById(Long id)
    {
        return selfHotelRoomsMapper.selectSelfHotelRoomsById(id);
    }

    /**
     * 查询房间列表
     * 
     * @param selfHotelRooms 房间
     * @return 房间
     */
    @Override
    public List<SelfHotelRooms> selectSelfHotelRoomsList(SelfHotelRooms selfHotelRooms)
    {
        return selfHotelRoomsMapper.selectSelfHotelRoomsList(selfHotelRooms);
    }

    /**
     * 新增房间
     * 
     * @param selfHotelRooms 房间
     * @return 结果
     */
    @Override
    public int insertSelfHotelRooms(SelfHotelRooms selfHotelRooms)
    {
        return selfHotelRoomsMapper.insertSelfHotelRooms(selfHotelRooms);
    }

    /**
     * 修改房间
     * 
     * @param selfHotelRooms 房间
     * @return 结果
     */
    @Override
    public int updateSelfHotelRooms(SelfHotelRooms selfHotelRooms)
    {
        return selfHotelRoomsMapper.updateSelfHotelRooms(selfHotelRooms);
    }

    /**
     * 批量删除房间
     * 
     * @param ids 需要删除的房间主键
     * @return 结果
     */
    @Override
    public int deleteSelfHotelRoomsByIds(Long[] ids)
    {
        return selfHotelRoomsMapper.deleteSelfHotelRoomsByIds(ids);
    }

    /**
     * 删除房间信息
     * 
     * @param id 房间主键
     * @return 结果
     */
    @Override
    public int deleteSelfHotelRoomsById(Long id)
    {
        return selfHotelRoomsMapper.deleteSelfHotelRoomsById(id);
    }
}

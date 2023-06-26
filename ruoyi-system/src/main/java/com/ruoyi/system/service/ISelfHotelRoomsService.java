package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SelfHotelRooms;

/**
 * 房间Service接口
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public interface ISelfHotelRoomsService 
{
    /**
     * 查询房间
     * 
     * @param id 房间主键
     * @return 房间
     */
    public SelfHotelRooms selectSelfHotelRoomsById(Long id);

    /**
     * 查询房间列表
     * 
     * @param selfHotelRooms 房间
     * @return 房间集合
     */
    public List<SelfHotelRooms> selectSelfHotelRoomsList(SelfHotelRooms selfHotelRooms);

    /**
     * 新增房间
     * 
     * @param selfHotelRooms 房间
     * @return 结果
     */
    public int insertSelfHotelRooms(SelfHotelRooms selfHotelRooms);

    /**
     * 修改房间
     * 
     * @param selfHotelRooms 房间
     * @return 结果
     */
    public int updateSelfHotelRooms(SelfHotelRooms selfHotelRooms);

    /**
     * 批量删除房间
     * 
     * @param ids 需要删除的房间主键集合
     * @return 结果
     */
    public int deleteSelfHotelRoomsByIds(Long[] ids);

    /**
     * 删除房间信息
     * 
     * @param id 房间主键
     * @return 结果
     */
    public int deleteSelfHotelRoomsById(Long id);
}

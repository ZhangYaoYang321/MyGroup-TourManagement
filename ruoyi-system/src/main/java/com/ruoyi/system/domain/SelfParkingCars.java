package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆对象 self_parking_cars
 * 
 * @author ruoyi
 * @date 2023-06-26
 */
public class SelfParkingCars extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carId;

    /** 入场时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入场时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date carInTime;

    /** 出场时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出场时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date carOutTime;

    /** 停车费 */
    @Excel(name = "停车费")
    private String parkingCost;

    /** 停车状态 */
    @Excel(name = "停车状态")
    private String stateParking;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCarId(String carId) 
    {
        this.carId = carId;
    }

    public String getCarId() 
    {
        return carId;
    }
    public void setCarInTime(Date carInTime) 
    {
        this.carInTime = carInTime;
    }

    public Date getCarInTime() 
    {
        return carInTime;
    }
    public void setCarOutTime(Date carOutTime) 
    {
        this.carOutTime = carOutTime;
    }

    public Date getCarOutTime() 
    {
        return carOutTime;
    }
    public void setParkingCost(String parkingCost) 
    {
        this.parkingCost = parkingCost;
    }

    public String getParkingCost() 
    {
        return parkingCost;
    }
    public void setStateParking(String stateParking) 
    {
        this.stateParking = stateParking;
    }

    public String getStateParking() 
    {
        return stateParking;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carId", getCarId())
            .append("carInTime", getCarInTime())
            .append("carOutTime", getCarOutTime())
            .append("parkingCost", getParkingCost())
            .append("stateParking", getStateParking())
            .toString();
    }
}

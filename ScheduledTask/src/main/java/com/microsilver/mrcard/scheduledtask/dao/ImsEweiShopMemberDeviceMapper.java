package com.microsilver.mrcard.scheduledtask.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberDevice;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberDeviceExample;

public interface ImsEweiShopMemberDeviceMapper {
    int countByExample(ImsEweiShopMemberDeviceExample example);

    int deleteByExample(ImsEweiShopMemberDeviceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsEweiShopMemberDevice record);

    int insertSelective(ImsEweiShopMemberDevice record);

    List<ImsEweiShopMemberDevice> selectByExample(ImsEweiShopMemberDeviceExample example);

    ImsEweiShopMemberDevice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsEweiShopMemberDevice record, @Param("example") ImsEweiShopMemberDeviceExample example);

    int updateByExample(@Param("record") ImsEweiShopMemberDevice record, @Param("example") ImsEweiShopMemberDeviceExample example);

    int updateByPrimaryKeySelective(ImsEweiShopMemberDevice record);

    int updateByPrimaryKey(ImsEweiShopMemberDevice record);
}
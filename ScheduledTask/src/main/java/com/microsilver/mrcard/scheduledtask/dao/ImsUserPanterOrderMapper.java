package com.microsilver.mrcard.scheduledtask.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microsilver.mrcard.scheduledtask.model.ImsUserPanterOrder;
import com.microsilver.mrcard.scheduledtask.model.ImsUserPanterOrderExample;

public interface ImsUserPanterOrderMapper {
    int countByExample(ImsUserPanterOrderExample example);

    int deleteByExample(ImsUserPanterOrderExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(ImsUserPanterOrder record);

    Long insertSelective(ImsUserPanterOrder record);

    List<ImsUserPanterOrder> selectByExample(ImsUserPanterOrderExample example);

    ImsUserPanterOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsUserPanterOrder record, @Param("example") ImsUserPanterOrderExample example);

    int updateByExample(@Param("record") ImsUserPanterOrder record, @Param("example") ImsUserPanterOrderExample example);

    int updateByPrimaryKeySelective(ImsUserPanterOrder record);

    int updateByPrimaryKey(ImsUserPanterOrder record);
}
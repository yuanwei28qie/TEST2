package com.microsilver.mrcard.scheduledtask.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivity;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityExample;

public interface ImsEweiShopActivityMapper {
    int countByExample(ImsEweiShopActivityExample example);

    int deleteByExample(ImsEweiShopActivityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsEweiShopActivity record);

    int insertSelective(ImsEweiShopActivity record);

    List<ImsEweiShopActivity> selectByExample(ImsEweiShopActivityExample example);

    ImsEweiShopActivity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImsEweiShopActivity record, @Param("example") ImsEweiShopActivityExample example);

    int updateByExample(@Param("record") ImsEweiShopActivity record, @Param("example") ImsEweiShopActivityExample example);

    int updateByPrimaryKeySelective(ImsEweiShopActivity record);

    int updateByPrimaryKey(ImsEweiShopActivity record);
}
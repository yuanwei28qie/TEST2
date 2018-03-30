package com.microsilver.mrcard.scheduledtask.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityConfig;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityConfigExample;

public interface ImsEweiShopActivityConfigMapper {
    int countByExample(ImsEweiShopActivityConfigExample example);

    int deleteByExample(ImsEweiShopActivityConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsEweiShopActivityConfig record);

    int insertSelective(ImsEweiShopActivityConfig record);

    List<ImsEweiShopActivityConfig> selectByExample(ImsEweiShopActivityConfigExample example);

    ImsEweiShopActivityConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsEweiShopActivityConfig record, @Param("example") ImsEweiShopActivityConfigExample example);

    int updateByExample(@Param("record") ImsEweiShopActivityConfig record, @Param("example") ImsEweiShopActivityConfigExample example);

    int updateByPrimaryKeySelective(ImsEweiShopActivityConfig record);

    int updateByPrimaryKey(ImsEweiShopActivityConfig record);

	List<ImsEweiShopActivityConfig> calLowestPriceAndCashBackMax(ImsEweiShopActivityConfigExample example);

	ImsEweiShopActivityConfig calSortWeight(ImsEweiShopActivityConfigExample example);
}
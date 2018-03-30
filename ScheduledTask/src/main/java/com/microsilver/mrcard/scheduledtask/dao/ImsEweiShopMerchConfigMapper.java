package com.microsilver.mrcard.scheduledtask.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMerchConfig;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMerchConfigExample;

public interface ImsEweiShopMerchConfigMapper {
    int countByExample(ImsEweiShopMerchConfigExample example);

    int deleteByExample(ImsEweiShopMerchConfigExample example);

    int deleteByPrimaryKey(Long merchId);

    int insert(ImsEweiShopMerchConfig record);

    int insertSelective(ImsEweiShopMerchConfig record);

    List<ImsEweiShopMerchConfig> selectByExample(ImsEweiShopMerchConfigExample example);

    ImsEweiShopMerchConfig selectByPrimaryKey(Long merchId);

    int updateByExampleSelective(@Param("record") ImsEweiShopMerchConfig record, @Param("example") ImsEweiShopMerchConfigExample example);

    int updateByExample(@Param("record") ImsEweiShopMerchConfig record, @Param("example") ImsEweiShopMerchConfigExample example);

    int updateByPrimaryKeySelective(ImsEweiShopMerchConfig record);

    int updateByPrimaryKey(ImsEweiShopMerchConfig record);
}
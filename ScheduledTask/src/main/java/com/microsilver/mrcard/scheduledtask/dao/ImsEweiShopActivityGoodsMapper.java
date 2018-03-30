package com.microsilver.mrcard.scheduledtask.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityGoods;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopActivityGoodsExample;

public interface ImsEweiShopActivityGoodsMapper {
    int countByExample(ImsEweiShopActivityGoodsExample example);

    int deleteByExample(ImsEweiShopActivityGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsEweiShopActivityGoods record);

    int insertSelective(ImsEweiShopActivityGoods record);

    List<ImsEweiShopActivityGoods> selectByExample(ImsEweiShopActivityGoodsExample example);

    ImsEweiShopActivityGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsEweiShopActivityGoods record, @Param("example") ImsEweiShopActivityGoodsExample example);

    int updateByExample(@Param("record") ImsEweiShopActivityGoods record, @Param("example") ImsEweiShopActivityGoodsExample example);

    int updateByPrimaryKeySelective(ImsEweiShopActivityGoods record);

    int updateByPrimaryKey(ImsEweiShopActivityGoods record);

	List<ImsEweiShopActivityGoods> selectActivityGoods();

	List<ImsEweiShopActivityGoods> selectMerchActivityOff();
}
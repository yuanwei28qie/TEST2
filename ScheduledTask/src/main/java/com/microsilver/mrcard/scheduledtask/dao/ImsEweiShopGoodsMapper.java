package com.microsilver.mrcard.scheduledtask.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopGoods;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopGoodsExample;

public interface ImsEweiShopGoodsMapper {
    int countByExample(ImsEweiShopGoodsExample example);

    int deleteByExample(ImsEweiShopGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsEweiShopGoodsExample record);

    int insertSelective(ImsEweiShopGoodsExample record);

    List<ImsEweiShopGoods> selectByExample(ImsEweiShopGoodsExample example);

    ImsEweiShopGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsEweiShopGoodsExample record, @Param("example") ImsEweiShopGoodsExample example);

    int updateByExample(@Param("record") ImsEweiShopGoods record, @Param("example") ImsEweiShopGoodsExample example);

    int updateByPrimaryKeySelective(ImsEweiShopGoods record);

    int updateByPrimaryKey(ImsEweiShopGoods record);

	ImsEweiShopGoods selectByPrimaryKeyForUpdate(Integer goodsId);
}
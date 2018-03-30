package com.microsilver.mrcard.serviceplatform.dao;

import java.util.List;

import com.microsilver.mrcard.serviceplatform.dto.ShopOrderGoodsDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrderGoods;

public interface IShopOrderGoodsDao {
    int deleteByPrimaryKey(Integer id);
    int insert(ImsEweiShopOrderGoods record);
    ImsEweiShopOrderGoods selectByPrimaryKey(Integer id);
    List<ShopOrderGoodsDto> selectDtoByOrderId(Long orderId);
    int updateByPrimaryKeySelective(ImsEweiShopOrderGoods record);
}
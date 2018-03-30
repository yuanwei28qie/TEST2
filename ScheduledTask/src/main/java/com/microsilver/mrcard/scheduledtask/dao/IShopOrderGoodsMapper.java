package com.microsilver.mrcard.scheduledtask.dao;

import java.util.List;

import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopOrderGoods;


public interface IShopOrderGoodsMapper {
    List<ImsEweiShopOrderGoods> selectOrderGoodsByOrderId(Integer orderId);
}
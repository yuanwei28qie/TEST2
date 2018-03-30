package com.microsilver.mrcard.scheduledtask.dao;

import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopOrder;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopOrderExample;
import java.util.List;

public interface ImsEweiShopOrderMapper {

	ImsEweiShopOrder selectByPrimaryKey(Long id);

	List<ImsEweiShopOrder> selectByExample(ImsEweiShopOrderExample example);

	List<ImsEweiShopOrder> selectHotelByStatu(ImsEweiShopOrderExample data);

	int updateByPrimaryKeySelective(ImsEweiShopOrder record);
}
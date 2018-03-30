package com.microsilver.mrcard.serviceplatform.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.microsilver.mrcard.serviceplatform.dto.HotelRoomOrderDto;
import com.microsilver.mrcard.serviceplatform.dto.MerchOrderDto;
import com.microsilver.mrcard.serviceplatform.dto.ShopOrderDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrderExample;
import com.microsilver.mrcard.serviceplatform.model.query.OrderQuery;

public interface IShopOrderDao {
    
    ImsEweiShopOrder selectByPrimaryKey(Long id);
    ImsEweiShopOrder selectByOrdersn(String ordersn);
    List<ImsEweiShopOrder> selectByExample(ImsEweiShopOrderExample example);
    /**
     * 获取订单详情
     * @param id
     * @return
     */
    ShopOrderDto selectOrderInfoById(Long id);
    List<ShopOrderDto> selectByQuery(OrderQuery query);
    List<ShopOrderDto> selectDiscountOrderByQuery(OrderQuery query);
    List<ShopOrderDto> selectForCourier(Long memberId);
    List<ShopOrderDto> selectForCourierByQuery(OrderQuery query);
    int updateByPrimaryKeySelective(ImsEweiShopOrder record);
    Integer statCountByMerchId(OrderQuery query);
    BigDecimal statAmountByMerchId(OrderQuery query);
    int insert(ImsEweiShopOrder order);

    /**
     * 查询会员订单
     * @param query
     * @return
     */
    List<ShopOrderDto> selectForMemberByQuery(OrderQuery query);
    
    void updateOrderStatus(Map map);
	List<ImsEweiShopOrder> selectTotalByExample(ImsEweiShopOrderExample example);
	List<MerchOrderDto> selectOrdersByExample(ImsEweiShopOrderExample example);
	MerchOrderDto selectOrdersDetailsByPrimaryKey(Long id);
	
	HotelRoomOrderDto selectHotelRoom(Long orderId);
}
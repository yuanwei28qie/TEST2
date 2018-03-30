package com.microsilver.mrcard.serviceplatform.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.microsilver.mrcard.serviceplatform.dto.ShopOrderGoodsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.dao.IShopMemberAddressDao;
import com.microsilver.mrcard.serviceplatform.dao.IShopOrderDao;
import com.microsilver.mrcard.serviceplatform.dao.IShopOrderGoodsDao;
import com.microsilver.mrcard.serviceplatform.dto.HotelRoomOrderDto;
import com.microsilver.mrcard.serviceplatform.dto.MerchStatDto;
import com.microsilver.mrcard.serviceplatform.dto.ShopOrderDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrderExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrderExample.Criteria;
import com.microsilver.mrcard.serviceplatform.model.query.OrderQuery;

import javax.annotation.Resource;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.service.ShopOrderSmpl
 * @Description 订单服务类
 * 
 * @Author bruce
 * @Version 2017年7月4日 下午12:07:53
 * @Copyright Micro Silver
 *
 */
@Service
public class ShopOrderSmpl {
	private final static Logger logger = LoggerFactory.getLogger(ShopOrderSmpl.class);
	@Autowired
	IShopOrderDao iShopOrderDao;
	@Autowired
	IShopOrderGoodsDao iShopOrderGoodsDao;
	@Autowired
	IShopMemberAddressDao iShopMemberAddressDao;

	@Resource
	IFinanceRemoteSmpl financeRemoteSmpl;


	public List<ShopOrderGoodsDto> getOrderDetail(Long orderId){
	  List<ShopOrderGoodsDto> list = iShopOrderGoodsDao.selectDtoByOrderId(orderId);
	  return list;
	}

	public List<ImsEweiShopOrder> getOrderByMemberId(Long memberId){
		ImsEweiShopOrderExample example = new ImsEweiShopOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andMemberIdEqualTo(memberId);
		criteria.andStatusGreaterThan((byte)Consts.ORDER_STATUS_PAY);
		criteria.andStatusNotEqualTo((byte)Consts.ORDER_STATUS_CANCLE);
		criteria.andOrderTypeEqualTo((byte)Consts.ORDER_TYPE_SUPER);
		List<ImsEweiShopOrder> orders = iShopOrderDao.selectByExample(example);
		return orders;
	}
	
	public List<ShopOrderDto> listOrderByStatus(Long merchId, int status,Integer dispatchtype,Integer orderType,Integer pageNum) {
		OrderQuery query = new OrderQuery();
		query.setMerchId(merchId);
		if (status > -2)
			query.setStatus(status);
		if(orderType != null && orderType >0)
			query.setOrderType(orderType.byteValue());
		if(orderType != null && orderType != 2)//非面对面支付订单，需要配送方式
			query.setDispatchtype(dispatchtype);
		PageHelper.startPage(pageNum, Consts.PAGE_SIZE);
		if(orderType != null && 2 == orderType)
			return iShopOrderDao.selectDiscountOrderByQuery(query);
		else
			return iShopOrderDao.selectByQuery(query);
	}

	/**
	 * 商家分拣
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public boolean sorting(Long orderId, String remarksaler) throws Exception {
		boolean result = false;
		ImsEweiShopOrder shopOrder = iShopOrderDao.selectByPrimaryKey(orderId);
		if (shopOrder != null&& shopOrder.getDispatchtype()==0 && shopOrder.getStatus() == Consts.ORDER_STATUS_PAY) {
			shopOrder.setStatus(Consts.ORDER_STATUS_SORTING);
			shopOrder.setSortingtime(Utils.getCurrentTime());
			shopOrder.setRemarksaler(remarksaler);
			iShopOrderDao.updateByPrimaryKeySelective(shopOrder);
			result = true;
		} else {
			logger.info("订单：[{}]不符合分拣条件", shopOrder.getOrdersn());
			throw new Exception("订单不符合分拣条件");
		}
		return result;
	}

	/**
	 * 快递员抢单
	 * 
	 * @param orderId
	 * @param memberId
	 * @return
	 */
	public boolean grabOrder(Long orderId, Long memberId) {
		boolean result = false;
		synchronized (this) {
			ImsEweiShopOrder shopOrder = iShopOrderDao.selectByPrimaryKey(orderId);
			if (shopOrder != null && shopOrder.getStatus() == Consts.ORDER_STATUS_SORTING) {
				shopOrder.setStatus(Consts.ORDER_STATUS_FETCH);
				shopOrder.setCourier(memberId);
				shopOrder.setFetchtime(Utils.getCurrentTime());
				iShopOrderDao.updateByPrimaryKeySelective(shopOrder);
				result = true;
			}
		}
		return result;
	}

    public ImsEweiShopOrder selectByPrimaryKey(Long id){
    	return iShopOrderDao.selectByPrimaryKey(id);
    }
    public ImsEweiShopOrder selectByOrdersn(String ordersn){
    	return iShopOrderDao.selectByOrdersn(ordersn);
    }

	public boolean sendGoods(Long orderId) {
		boolean result = true;
		ImsEweiShopOrder shopOrder = iShopOrderDao.selectByPrimaryKey(orderId);
		if (shopOrder != null && shopOrder.getStatus() == Consts.ORDER_STATUS_FETCH) {
			shopOrder.setStatus(Consts.ORDER_STATUS_SEND);
			shopOrder.setSendtime(Utils.getCurrentTime());
			iShopOrderDao.updateByPrimaryKeySelective(shopOrder);
		} else {
			logger.info("订单：[{}]不符合发货条件", shopOrder.getOrdersn());
			result = false;
		}
		return result;
	}

	public boolean recieveGoods(Long orderId) {
		boolean result = true;
		ImsEweiShopOrder shopOrder = iShopOrderDao.selectByPrimaryKey(orderId);
		if(shopOrder==null){
			result = false;
			logger.info("订单：[{}]不存在", shopOrder.getOrdersn());
			return result;
		}
		if (shopOrder.getDispatchtype()==0 && shopOrder.getStatus() == Consts.ORDER_STATUS_SEND) {
			shopOrder.setStatus(Consts.ORDER_STATUS_RECIEVE);
			shopOrder.setFinishtime(Utils.getCurrentTime());
			iShopOrderDao.updateByPrimaryKeySelective(shopOrder);
		} 
		else if(shopOrder.getOrderType()==1 && shopOrder.getStatus() == Consts.ORDER_STATUS_PAY){
			shopOrder.setStatus(Consts.ORDER_STATUS_RECIEVE);
			shopOrder.setFinishtime(Utils.getCurrentTime());
			iShopOrderDao.updateByPrimaryKeySelective(shopOrder);
		}
		else {
			logger.info("订单：[{}]状态错误", shopOrder.getOrdersn());
			result = false;
		}
		return result;
	}

	/**
	 * 获取订单详情
	 * 
	 * @param orderId
	 * @return
	 */
	public ShopOrderDto getShopOrder(Long orderId) {
		ShopOrderDto orderDto = iShopOrderDao.selectOrderInfoById(orderId);
		if (orderDto == null) {
			return orderDto;
		}
		orderDto.setGoodsList(iShopOrderGoodsDao.selectDtoByOrderId(orderId));
		return orderDto;
	}

	/**
	 * 查询送货员能够看得订单
	 * 
	 * @param memberId
	 * @return
	 */
	public List<ShopOrderDto> listOrderForCourier(Long memberId) {
		return iShopOrderDao.selectForCourier(memberId);
	}

	/**
	 * 根据状态查询送货员订单
	 * 
	 * @param memberId
	 * @param status
	 * @return
	 */
	public List<ShopOrderDto> listForCourierByQuery(long memberId, int status,int pageNum) {
		OrderQuery query = new OrderQuery();
		query.setCourier(memberId);
		query.setStatus(status);
        PageHelper.startPage(pageNum, Consts.PAGE_SIZE);
		return iShopOrderDao.selectForCourierByQuery(query);
	}

	/**
	 * 商家订单合计信息
	 * 
	 * @param merchId
	 * @return
	 */
	public MerchStatDto countOrderByMerchId(Long merchId,Long memberId,Long identity,Integer orderType) {
		MerchStatDto msDto = new MerchStatDto();
		OrderQuery query = new OrderQuery();
		query.setMerchId(merchId);
		if(orderType!=null){
			query.setOrderType(orderType.byteValue());
		}
		msDto.setTotalCount(iShopOrderDao.statCountByMerchId(query));
		msDto.setTotalAmount(iShopOrderDao.statAmountByMerchId(query));
		query.setPayTime(Long.valueOf(Utils.getDayBeginTimestamp()));
		msDto.setCountForToday(iShopOrderDao.statCountByMerchId(query));
		msDto.setAmountForToday(iShopOrderDao.statAmountByMerchId(query));

		try {
			BigDecimal realAmount = financeRemoteSmpl.searchFinanceCustomer(memberId, merchId, identity).getRealAmount();
			msDto.setRealAmount(realAmount);
		}catch (Exception ex){
			msDto.setRealAmount(new BigDecimal(0));
			logger.error("统计商家可提现金额出错:{}{}",merchId,ex.getMessage());
		}

		return msDto;
	}
	
	public List<ShopOrderDto> listForMemberByQuery(Long memberId,int status,int pageNum){
		OrderQuery query = new OrderQuery();
		query.setOrderType((byte)3);
		query.setMemberId(memberId);
		if(status>-2){
			query.setStatus(status);
		}
		PageHelper.startPage(pageNum, Consts.PAGE_SIZE);
		return iShopOrderDao.selectForMemberByQuery(query);
	}
	/**
	 * 更新订单状态
	 * @param orderId
	 * @param status
	 * @return
	 */
	public boolean updateOrderStatus(long orderId,int userdeleted){
		Map map = new HashMap();
		map.put("orderId",orderId);
		map.put("userdeleted", userdeleted);
		try{
			iShopOrderDao.updateOrderStatus(map);
			return true;
		}
		catch(Exception ex){
			logger.error(ex.getMessage());
			return false;
		}
		
	}
	public int updateByPrimaryKeySelective(ImsEweiShopOrder record){
		return iShopOrderDao.updateByPrimaryKeySelective(record);
	}
	
	public HotelRoomOrderDto selectHotelRoom(Long orderId) {
		return iShopOrderDao.selectHotelRoom(orderId);
	}
}

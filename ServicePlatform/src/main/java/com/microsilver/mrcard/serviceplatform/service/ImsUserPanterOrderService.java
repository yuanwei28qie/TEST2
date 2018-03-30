package com.microsilver.mrcard.serviceplatform.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dao.ImsUserPanterOrderMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsUserRecommendMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsUserPanterOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsUserRecommend;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;

@Service
public class ImsUserPanterOrderService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ImsUserPanterOrderMapper OrderMapper;
	@Autowired
	ImsUserRecommendMapper recommendMapper;
	
	//根据业务单号查询业务原单据
	public ImsUserPanterOrder selectImsUserPanterOrderByOrdersn(String ordersn) {
		return OrderMapper.selectByOrdersnKey(ordersn);
		
	}
	
	
	
	
	public String addPartner(ImsUserPanterOrder panterOrder) throws Exception {
		if(panterOrder.getMemberId()==null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		
		String orderSn = Utils.createOrderSn("PA");
		switch(panterOrder.getVipType()) {
			case 1:panterOrder.setAmount(new BigDecimal(Consts.PARTNER_COST));break;
			case 2:panterOrder.setAmount(new BigDecimal(Consts.SENIOR_PANTER_COST));break;
			case 3:panterOrder.setAmount(new BigDecimal(Consts.SUPER_PANTER_COST));break;
			case 10:panterOrder.setAmount(new BigDecimal(Consts.VIP_MEMBER_COST));break;
			default:
				throw new Exception("未定义的VIP类型");	
		}
		panterOrder.setCreateTime(Utils.getCurrentTime());
		panterOrder.setStatus((byte)0);
		panterOrder.setOrdersn(orderSn);
		/*
		if(panterOrder.getVipType()==10) {
			ImsUserPanterOrderExample example = new ImsUserPanterOrderExample();
			example.createCriteria().andMemberIdEqualTo(panterOrder.getMemberId()).andVipTypeEqualTo(panterOrder.getVipType());
			List<ImsUserPanterOrder> orders = orderMapper.selectByExample(example);
			if(orders.size()>0) {
				return orders.get(0).getOrdersn();
			}else {
				orderMapper.insertSelective(panterOrder);
			}
		}else {
			orderMapper.insertSelective(panterOrder);
		}*/
		OrderMapper.insertSelective(panterOrder);
		return orderSn;
	}
	public ImsUserRecommend selectUserRecommendByOrder(long orderId) {
		ImsUserPanterOrder paterOrder = OrderMapper.selectByPrimaryKey(orderId);
		ImsUserRecommend userRecommend= recommendMapper.selectByPrimaryKey(paterOrder.getMemberId());
		if(userRecommend.getLevel1ParentId()>0) {
			ImsUserRecommend parentRecommend=recommendMapper.selectByPrimaryKey(userRecommend.getLevel1ParentId());
			if(parentRecommend==null||parentRecommend.getVipType()==0) {
				logger.info("合伙人订单：{},一级推荐人:{}不是合伙人或是VIP，一级推荐人不能分润",orderId,userRecommend.getLevel1ParentId());
				return null;
			}else {
				if(userRecommend.getLevel2ParentId()>0) {
					ImsUserRecommend level2Recommend = recommendMapper.selectByPrimaryKey(userRecommend.getLevel2ParentId());
					if(level2Recommend==null||level2Recommend.getVipType()==0) {
						logger.info("合伙人订单：{},二级推荐人:{}不是合伙人或是VIP，二级推荐人不能分润",orderId,userRecommend.getLevel2ParentId());
						userRecommend.setLevel2ParentId(0L);
					}
				}
			}
		}
		return userRecommend;
	}
	
	
}

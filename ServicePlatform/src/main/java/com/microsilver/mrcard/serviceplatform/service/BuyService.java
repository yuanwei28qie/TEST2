package com.microsilver.mrcard.serviceplatform.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microsilver.mrcard.serviceplatform.common.RongCloud;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dto.BuyIndexDto;
import com.microsilver.mrcard.serviceplatform.dto.PersonalCenterDto;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMember;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAdditional;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentity;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentityAdditional;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;

@Service
public class BuyService {

	@Resource
	private ImsEweiShopMemberIdentityAdditionalService additionalService;
	@Resource
	private ImsCrowdsourcingOrderService orderService;
	@Resource
	private MemberSmpl memberSmpl;
	@Resource
	private ImsEweiShopMemberIdentityService identityService;
	@Resource
	private ImsEweiShopMemberAdditionalService memberAdditionalService;

	public BuyIndexDto constituteIndex(Long memberId) {
		if (memberId == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		// 如果是骑士 查看是否被禁用
		List<ImsEweiShopMemberIdentity> shopMemberIdentity = identityService.getShopMemberIdentity(memberId);
		if (shopMemberIdentity.size() > 0) {
			ImsEweiShopMemberIdentity identity = shopMemberIdentity.get(0);
			if (identity.getStatus() == 2) {
				throw new BusinessException(EWarning.DisableAccount);
			}
		}
		BuyIndexDto dto = new BuyIndexDto();
		// 判断当前用户是否提交过实名认证 或 是否通过
		ImsEweiShopMemberAdditional memberAdditional = memberAdditionalService
				.getImsEweiShopMemberAdditionalById(memberId);
		if (memberAdditional != null) {
			dto.setCheckStatus(memberAdditional.getCheckStatus());
		} else {
			dto.setCheckStatus((byte) -1);
		}

		// 获取骑手信息
		List<ImsEweiShopMemberIdentityAdditional> additional = additionalService
				.getShopMemberIdentityAdditional(memberId);
		if (additional.size() > 0) {
			dto.setScore(additional.get(0).getScore());
			dto.setIsWork(additional.get(0).getIsWork());
		}
		//如果骑士审核未通过则不用数据库的存的分数
		if(dto.getCheckStatus()!=2) {
			dto.setScore(new BigDecimal(0));
		}
		
		// 今日已完成订单统计
		ImsCrowdsourcingOrder order = orderService.selectTodayDetails(memberId, true);
		if (order != null) {
			dto.setFinishedOrder(order.getCreateTime());
			BigDecimal dispatchPrice = order.getDispatchPrice();
			if (dispatchPrice == null) {
				dispatchPrice = new BigDecimal(0);
			}
			BigDecimal tipPrice = order.getTipPrice();
			if (tipPrice == null) {
				tipPrice = new BigDecimal(0);
			}
			dto.setMoney(dispatchPrice.add(tipPrice));
		}

		// 未完成的订单(包含已完成未评价的订单)
		List<ImsCrowdsourcingOrder> orders = orderService.listUnFinishedOrders(memberId);
		if (orders.size() > 0) {
			ImsCrowdsourcingOrder imsCrowdsourcingOrder = orders.get(0);
			dto.setOrderId(imsCrowdsourcingOrder.getId());
			dto.setStatus(imsCrowdsourcingOrder.getStatus());
		}
		// 获取我的今日订单
		List<ImsCrowdsourcingOrder> listMyOrders = orderService.listMyOrders(memberId, (byte) -2, null, true);
		dto.setOrders(listMyOrders);
		return dto;
	}

	/**
	 * 我的订单
	 * 
	 * @param memberId
	 *            骑士id
	 * @param status
	 *            订单状态
	 * @param pageNum
	 *            页码
	 * @return
	 */
	public List<ImsCrowdsourcingOrder> listMyOrders(Long memberId, Byte status, Integer pageNum) {
		if (memberId == null || pageNum == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		List<ImsCrowdsourcingOrder> listMyOrders = orderService.listMyOrders(memberId, status, pageNum, false);
		return listMyOrders;
	}

	/**
	 * 待抢订单
	 * 
	 * @param pageNum
	 * @return
	 */
	public List<ImsCrowdsourcingOrder> ordering(String lat, String lng, Integer pageNum) {
		if (lat == null || lng == null || pageNum == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		List<ImsCrowdsourcingOrder> listMyOrders = orderService.ordering(lat, lng, pageNum);
		return listMyOrders;
	}

	/**
	 * 休息/开工
	 * 
	 * @param pageNum
	 * @return
	 */
	public int isWork(Long memberId, Boolean isWork) {
		if (memberId == null || isWork == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return additionalService.isWork(memberId, isWork);
	}

	/**
	 * 骑士抢单
	 * 
	 * @param memberId
	 * @param orderId
	 * @return
	 */
	public int takeOrder(Long memberId, Long orderId) {
		if (memberId == null || orderId == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return orderService.takeOrder(memberId, orderId);
	}

	/**
	 * 设置订单协商价格
	 * 
	 * @param orderId
	 * @param goodsConsultPrice
	 * @return
	 */
	public int setGoodsConsultPrice(Long orderId, Double goodsConsultPrice) {
		if (orderId == null || goodsConsultPrice == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return orderService.setGoodsConsultPrice(orderId, goodsConsultPrice);
	}

	/**
	 * 已买到商品
	 * 
	 * @param orderId
	 * @return
	 */
	public int buyGoods(Long orderId) {
		if (orderId == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return orderService.buyGoods(orderId);
	}

	/**
	 * 配送中
	 * 
	 * @param orderId
	 *            订单号
	 * @param lat
	 *            骑士经度
	 * @param lng
	 *            骑士纬度
	 * @return
	 */
	public Map<String,String> sending(Long orderId, String lat, String lng) {
		if (orderId == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return orderService.sending(orderId,lat,lng);
	}

	/**
	 * 用户已收货
	 * 
	 * @param orderId
	 * @param pickupNumber
	 * @return
	 */
	public int receiveGoods(Long orderId, String pickupNumber) {
		if (orderId == null || pickupNumber == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return orderService.receiveGoods(orderId, pickupNumber);
	}

	/**
	 * 骑士上传经纬度信息
	 * 
	 * @param memberId
	 * @param lat
	 * @param lng
	 * @return
	 */
	public int uploadLocation(Long memberId, Byte identity,String lat, String lng) {
		if (memberId == null || lat == null || lng == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return additionalService.updateLocation(memberId,identity, lat, lng);
	}

	/**
	 * 获取订单详情
	 * 
	 * @param orderId
	 * @return
	 */
	public ImsCrowdsourcingOrder getOrderDetails(Long orderId,Long memberId) {
		if (orderId == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return orderService.getOrderDetails(orderId,memberId);
	}

	/**
	 * 锁定订单
	 * 
	 * @param orderId
	 * @return
	 */
	public int lockOrder(Long orderId) {
		if (orderId == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return orderService.lockOrder(orderId);
	}

	/**
	 * 取消订单
	 * 
	 * @param orderId
	 * @param who
	 *            1.用户 2.骑士
	 * @return
	 */
	public int cancleOrder(Long orderId, String reason, Byte who) {
		if (orderId == null || who == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return orderService.cancleOrder(orderId, reason, who);
	}

	/**
	 * 个人中心
	 * 
	 * @param memberId
	 * @return
	 */
	public PersonalCenterDto constitutePersionalCenter(Long memberId) {
		if (memberId == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		PersonalCenterDto dto = new PersonalCenterDto();
		// 获取骑士头像与真实姓名
		ImsEweiShopMember member = memberSmpl.selectMemberById(memberId);
		if (member != null) {
			dto.setAvatar(member.getAvatar());
			dto.setRealName(member.getRealname());
		}
		// 获取骑士评分
		List<ImsEweiShopMemberIdentityAdditional> additional = additionalService
				.getShopMemberIdentityAdditional(memberId);
		if (additional.size() > 0) {
			dto.setScore(additional.get(0).getScore());
		}
		
		ImsEweiShopMemberAdditional memberAdditional = memberAdditionalService
				.getImsEweiShopMemberAdditionalById(memberId);
		if (memberAdditional != null) {
			if(memberAdditional.getCheckStatus()!=2) {
				dto.setScore(new BigDecimal(0));
			}
		} 
		
		// 今日已完成订单统计
		ImsCrowdsourcingOrder order = orderService.selectTodayDetails(memberId, true);
		if (order != null) {
			dto.setTodayFinishedOrder(order.getCreateTime());
			BigDecimal dispatchPrice = order.getDispatchPrice();
			if (dispatchPrice == null) {
				dispatchPrice = new BigDecimal(0);
			}
			BigDecimal tipPrice = order.getTipPrice();
			if (tipPrice == null) {
				tipPrice = new BigDecimal(0);
			}
			dto.setTodayMoney(dispatchPrice.add(tipPrice));
		}
		// 历史已完成订单统计
		order = orderService.selectTodayDetails(memberId, false);
		if (order != null) {
			dto.setTotalFinishedOrder(order.getCreateTime());
			BigDecimal dispatchPrice = order.getDispatchPrice();
			if (dispatchPrice == null) {
				dispatchPrice = new BigDecimal(0);
			}
			BigDecimal tipPrice = order.getTipPrice();
			if (tipPrice == null) {
				tipPrice = new BigDecimal(0);
			}
			dto.setTotalMoney(dispatchPrice.add(tipPrice));
		}
		// 设置骑士荣誉称号
		Integer totalFinishedOrder = dto.getTotalFinishedOrder();
		dto.setHonor(convertHonor(totalFinishedOrder));

		return dto;
	}

	/**
	 * 评估骑士荣誉等级
	 * 
	 * @param num
	 *            历史订单总量
	 * @return
	 */
	private String convertHonor(Integer num) {
		/*
		 * 1.接单少于200单为：倔强青铜 2.接单到达200单为：不屈白银 3.接单到达400单为：荣耀黄金 4.接单到达800单为：华贵铂金
		 * 5.接单到达1600单为：璀璨钻石 6.接单到达2400单为：超凡大师 7.接单到达3200单为：最强王者
		 */
		String honor = "";
		if (num == null)
			num = 0;
		if (num < 200) {
			honor = "倔强青铜";
		} else if (num < 400) {
			honor = "不屈白银";
		} else if (num < 800) {
			honor = "荣耀黄金";
		} else if (num < 1600) {
			honor = "华贵铂金";
		} else if (num < 2400) {
			honor = "璀璨钻石";
		} else if (num < 3200) {
			honor = "超凡大师";
		} else {
			honor = "最强王者";
		}
		return honor;
	}

	/**
	 * 实名认证
	 * 
	 * @param memberAdditional
	 * @return
	 */
	@Transactional
	public int applyCertification(ImsEweiShopMemberAdditional memberAdditional) {
		Long memberId = memberAdditional.getMemberId();
		String avatar = memberAdditional.getAvatar();
		String realname = memberAdditional.getRealname();
		String alipayAccount = memberAdditional.getAlipayAccount();
		String identityCardNo = memberAdditional.getIdentityCardNo();
		String identityCardFront = memberAdditional.getIdentityCardFront();
		String identityCardBack = memberAdditional.getIdentityCardBack();
		String identityCardGroup = memberAdditional.getIdentityCardGroup();
		Long province = memberAdditional.getProvince();
		Long city = memberAdditional.getCity();
		Long county = memberAdditional.getCounty();
		if (memberId == null || avatar == null || realname == null || alipayAccount == null || identityCardNo == null
				|| identityCardFront == null || identityCardBack == null || identityCardGroup == null
				|| province == null || city == null || county == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		ImsEweiShopMemberAdditional imsEweiShopMemberAdditionalById = memberAdditionalService
				.getImsEweiShopMemberAdditionalById(memberId);
		int result = 0;
		if (imsEweiShopMemberAdditionalById == null) {
			memberAdditional.setCheckStatus((byte) 1);// 审核状态(0:审核未通过,1:待审核,2:已审核)
			memberAdditional.setCreateTime(Utils.getCurrentTime());
			// 添加认证记录
			result = memberAdditionalService.addShopMemberAdditional(memberAdditional);
			ImsEweiShopMemberIdentity memberIdentity = new ImsEweiShopMemberIdentity();
			if (result == 1) {
				// 添加用户身份记录
				memberIdentity.setIdentity((byte) 13);
				memberIdentity.setAreas(county + "");
				memberIdentity.setCreatetime(Utils.getCurrentTime());
				memberIdentity.setMemberId(memberId);
				memberIdentity.setMerchId(0l);
				memberIdentity.setStatus((byte) 0);// 状态(0:未审核,1:有效,2:禁用,3:删除)
				String token = RongCloud.getToken(memberId + "" + 13, "", "");
				memberIdentity.setRongcloudToken(token);
				result = identityService.addMemberIdentity(memberIdentity);
			}
			if (result == 1) {
				ImsEweiShopMemberIdentityAdditional identityAdditional = new ImsEweiShopMemberIdentityAdditional();
				// identityAdditional.setIdttId(memberIdentity.getId());
				identityAdditional.setIdentity((byte) 13);
				identityAdditional.setIsWork(true);
				identityAdditional.setMemberId(memberId);
				result = additionalService.addIdentityAdditional(identityAdditional);
			}
		} else {
			memberAdditional.setCheckStatus((byte) 1);
			memberAdditional.setRemark("");
			result = memberAdditionalService.updateShopMemberAdditional(memberAdditional);
		}
		return result;
	}

	/**
	 * 获取上一次申请实名认证的信息
	 * 
	 * @param memberId
	 * @return
	 */
	public ImsEweiShopMemberAdditional getLastCertification(Long memberId) {
		if (memberId == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return memberAdditionalService.getImsEweiShopMemberAdditionalById(memberId);
	}

	public String deleteOrders(String orderIds, Byte userType) {
		if (orderIds == null || userType == null) {
			throw new BusinessException(EWarning.ErrorParams);
		}
		return orderService.deleteOrders(orderIds, userType);
	}
}

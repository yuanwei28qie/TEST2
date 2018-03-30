package com.microsilver.mrcard.serviceplatform.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.microsilver.mrcard.mq.coordinateMQ;
import com.microsilver.mrcard.serviceplatform.mq.MQSendMsgHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dto.BuyIndexDto;
import com.microsilver.mrcard.serviceplatform.dto.PersonalCenterDto;
import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAdditional;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.service.BuyService;
import com.microsilver.mrcard.serviceplatform.service.IFinanceRemoteSmpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "/api/buy", description = "小飞侠接口")
@RequestMapping("/api/buy")
public class BuyController {

	@Resource
	private BuyService service;
	@Resource
	IFinanceRemoteSmpl financeRemoteSmpl;

	@Autowired
	private MQSendMsgHelper mqsendMsgHelper;

	@RequestMapping("index")
	@ApiOperation(value = "获取小飞侠首页", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id") })
	public RespBaseDto<BuyIndexDto> index(Long memberId) {
		RespBaseDto<BuyIndexDto> result = new RespBaseDto<>();
		try {
			BuyIndexDto constituteIndex = this.service.constituteIndex(memberId);
			result.setData(constituteIndex);
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@RequestMapping("/ordering")
	@ApiOperation(value = "待抢订单", httpMethod = "POST")
	public RespBaseDto<List<ImsCrowdsourcingOrder>> ordering(Long memberId, String lat, String lng, Integer pageNum) {
		RespBaseDto<List<ImsCrowdsourcingOrder>> result = new RespBaseDto<>();
		try {
			coordinateMQ coordinate = new coordinateMQ();
			coordinate.setMemberId(memberId);
			coordinate.setLat(lat);
			coordinate.setLng(lng);
			coordinate.setIdentity((byte)13);
			mqsendMsgHelper.coordinateMSG(coordinate);
			List<ImsCrowdsourcingOrder> ordering = this.service.ordering(lat, lng, pageNum);
			result.setData(ordering);
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@RequestMapping("/listMyOrders")
	@ApiOperation(value = "我的订单", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id"),
			@ApiImplicitParam(name = "status", value = "订单状态 -2.全部订单(1:创建,2:已接单,3:已协商费用,4:已支付,5:已购买商品,6:已收货,7:订单重置,0:订单取消,-1:订单已锁定）"),
			@ApiImplicitParam(name = "pageNum", value = "页码") })
	public RespBaseDto<List<ImsCrowdsourcingOrder>> myOrders(Long memberId,
			@RequestParam(defaultValue = "-2") Byte status, Integer pageNum) {
		RespBaseDto<List<ImsCrowdsourcingOrder>> result = new RespBaseDto<>();
		try {
			List<ImsCrowdsourcingOrder> listMyOrders = this.service.listMyOrders(memberId, status, pageNum);
			result.setData(listMyOrders);
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@RequestMapping("/isWork")
	@ApiOperation(value = "休息/开工", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id"),
			@ApiImplicitParam(name = "isWork", value = "true.开工 false.休息") })
	public RespBaseDto<String> isWork(Long memberId, Boolean isWork) {
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			int r = service.isWork(memberId, isWork);
			if (r == 1)
				result.setData("OK");
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@RequestMapping("/takeOrder")
	@ApiOperation(value = "抢单", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id"),
			@ApiImplicitParam(name = "orderId", value = "订单id") })
	public RespBaseDto<String> takeOrder(Long memberId, Long orderId) {
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			int r = service.takeOrder(memberId, orderId);
			if (r == 1) {
				result.setData("OK");
			}
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@RequestMapping("/setGoodsConsultPrice")
	@ApiOperation(value = "设置价格", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "orderId", value = "订单id"),
			@ApiImplicitParam(name = "goodsConsultPrice", value = "协商价格") })
	public RespBaseDto<String> setGoodsConsultPrice(Long orderId, Double goodsConsultPrice) {
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			int r = service.setGoodsConsultPrice(orderId, goodsConsultPrice);
			if (r == 1)
				result.setData("OK");
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@RequestMapping("/buyGoods")
	@ApiOperation(value = "已买到商品", httpMethod = "POST")
	@ApiImplicitParams({@ApiImplicitParam(name = "orderId", value = "订单id")})
	public RespBaseDto<String> buyGoods(Long orderId) {
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			int r = service.buyGoods(orderId);
			if (r == 1)
				result.setData("OK");
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	@RequestMapping("/sending")
	@ApiOperation(value = "配送中", httpMethod = "POST")
	@ApiImplicitParams({@ApiImplicitParam(name = "orderId", value = "订单id"),@ApiImplicitParam(name = "lat", value = "骑士经度"),@ApiImplicitParam(name = "lng", value = "骑士纬度")})
	public RespBaseDto<Map<String,String>> sending(Long orderId,String lat,String lng) {
		RespBaseDto<Map<String,String>> result = new RespBaseDto<Map<String,String>>();
		try {
			Map<String,String> map = service.sending(orderId,lat,lng);
			result.setData(map);
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@RequestMapping("/receiveGoods")
	@ApiOperation(value = "用户已收货", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "orderId", value = "订单id"),
			@ApiImplicitParam(name = "pickupNumber", value = "验证码") })
	public RespBaseDto<String> receiveGoods(Long orderId, String pickupNumber) {
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			int r = service.receiveGoods(orderId, pickupNumber);
			if (r == 1)
				result.setData("OK");
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@RequestMapping("/uploadLocation")
	@ApiOperation(value = "上传经纬度", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "骑士id"),
			@ApiImplicitParam(name = "lat", value = "经度"), @ApiImplicitParam(name = "lng", value = "纬度") })
	public RespBaseDto<String> uploadLocation(Long memberId,Byte identity, String lat, String lng) {
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			coordinateMQ coordinate = new coordinateMQ();
			coordinate.setMemberId(memberId);
			coordinate.setLat(lat);
			coordinate.setLng(lng);
			coordinate.setIdentity(identity);
			mqsendMsgHelper.coordinateMSG(coordinate);
			/*int r = service.uploadLocation(memberId, lat, lng);
			if (r == 1)*/
				result.setData("OK");
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@RequestMapping("/getOrderDetails")
	@ApiOperation(value = "获取订单详情", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "orderId", value = "订单id") })
	public RespBaseDto<ImsCrowdsourcingOrder> orderDetails(Long orderId,Long memberId) {
		RespBaseDto<ImsCrowdsourcingOrder> result = new RespBaseDto<>();
		try {
			ImsCrowdsourcingOrder order = service.getOrderDetails(orderId,memberId);
			result.setData(order);
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@RequestMapping("/lockOrder")
	@ApiOperation(value = "订单锁定", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "orderId", value = "订单id") })
	public RespBaseDto<String> lockOrder(Long orderId) {
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			int r = service.lockOrder(orderId);
			if (r == 1) {
				result.setData("OK");
			}
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@RequestMapping("/cancleOrder")
	@ApiOperation(value = "取消订单", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "orderId", value = "订单id"),
			@ApiImplicitParam(name = "reason", value = "订单取消的原因"),
			@ApiImplicitParam(name = "who", value = "谁取消订单(1.用户 2.骑士)") })
	public RespBaseDto<Long> cancleOrder(Long orderId, String reason, Byte who) {
		RespBaseDto<Long> result = new RespBaseDto<>();
		try {
			int r = service.cancleOrder(orderId, reason, who);
			if (r == 1) {
				result.setData(orderId);
			}
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	@RequestMapping("/personalCenter")
	@ApiOperation(value = "个人中心", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id") })
	public RespBaseDto<PersonalCenterDto> personalCenter(Long memberId) {
		RespBaseDto<PersonalCenterDto> result = new RespBaseDto<>();
		try {
			PersonalCenterDto centerDto = service.constitutePersionalCenter(memberId);
			result.setData(centerDto);
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	/**
	 * 申请实名认证
	 * @param memberAdditional
	 * @return
	 */
	@RequestMapping("/applyCertification")
	@ApiOperation(value = "申请实名认证(没有注释的参数不传)", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id"),
		@ApiImplicitParam(name = "avatar", value = "头像"),
		@ApiImplicitParam(name = "realname", value = "真实姓名"),
			@ApiImplicitParam(name = "alipayAccount", value = "支付宝账号"),
			@ApiImplicitParam(name = "identityCardNo", value = "身份证号码"),
			@ApiImplicitParam(name = "identityCardFront", value = "身份证正面"),
			@ApiImplicitParam(name = "identityCardBack", value = "身份证背面"),
			@ApiImplicitParam(name = "identityCardGroup", value = "身份证合照"),
			@ApiImplicitParam(name = "province", value = "省份id"), @ApiImplicitParam(name = "city", value = "市id"),
			@ApiImplicitParam(name = "county", value = "区县id")})
	public RespBaseDto<String> applyCertification(ImsEweiShopMemberAdditional memberAdditional) {
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			int r = service.applyCertification(memberAdditional);
			if (r == 1) {
				result.setData("OK");
			}else{
				result.setMessage(EWarning.Unknown.getName());
				result.setState(EWarning.Unknown.getValue());
			}
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	/**
	 * 获取上一次申请实名认证的信息
	 * @param memberAdditional
	 * @return
	 */
	@RequestMapping("/getLastCertification")
	@ApiOperation(value = "获取上一次申请实名认证的信息", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id")})
	public RespBaseDto<ImsEweiShopMemberAdditional> getLastCertification(Long memberId) {
		RespBaseDto<ImsEweiShopMemberAdditional> result = new RespBaseDto<>();
		try {
			ImsEweiShopMemberAdditional memberAdditional = service.getLastCertification(memberId);
			result.setData(memberAdditional);
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	/**
	 * 我的余额
	 * @param memberAdditional
	 * @return
	 */
	@RequestMapping("/myBalance")
	@ApiOperation(value = "我的余额", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id")})
	public RespBaseDto<Map<String,String>> myBalance(Long memberId) {
		RespBaseDto<Map<String,String>> result = new RespBaseDto<>();
		try {
			MrcardFinanceCustomer financeCustomer = financeRemoteSmpl.searchFinanceCustomer(memberId, 0l, 13l);
			Map<String,String> map = new HashMap<>();
			map.put("advance", financeCustomer.getAdvanceAmount()+"");
			map.put("balance", financeCustomer.getUnrecordedAmount()+"");
			result.setData(map);
		}  catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	/**
	 * 删除订单
	 * @param memberAdditional
	 * @return
	 */
	@RequestMapping("/deleteOrders")
	@ApiOperation(value = "删除订单", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "orderIds", value = "订单号 多个订单用逗号分隔"),@ApiImplicitParam(name = "userType", value = "用户类型 1.小飞侠 2.用户")})
	public RespBaseDto<String> deleteOrders(String orderIds,Byte userType) {
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			String orders = service.deleteOrders(orderIds,userType);
			result.setData(orders);
		}  catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		}catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
}

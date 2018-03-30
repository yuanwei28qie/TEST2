package com.microsilver.mrcard.serviceplatform.controller.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.microsilver.mrcard.serviceplatform.controller.BaseController;
import com.microsilver.mrcard.serviceplatform.dto.BusinessDto;
import com.microsilver.mrcard.serviceplatform.dto.MerchStatDto;
import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.dto.ShopOrderDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrder;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.service.ShopOrderSmpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.controller.api.
 *       ShopOrderController
 * @Description 订单控制器
 * 
 * @Author bruce
 * @Version 2017年7月4日 下午12:10:03
 * @Copyright Micro Silver
 *
 */

@Controller
@RequestMapping("/api/ShopOrder")
@Api(value = "/api/ShopOrder", description = "订单相关API")
public class ShopOrderController extends BaseController {

	@Autowired
	ShopOrderSmpl shopOrderSmpl;

	/**
	 * 商家根据状态查询订单
	 * 
	 * @param merchId
	 * @param status
	 * @return
	 */
	@ApiOperation(value = "商家根据状态查询订单", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "merchId",value = "商家编号"),
			@ApiImplicitParam(name = "status", value = "订单状态(1:(用户)已付款,11:(商家)分拣,12:(快递员)抢单,2：(商家)已发货,3:(用户)已收货)"),
			@ApiImplicitParam(name = "dispatchtype",value = "配送方式(0 镖师配送 ,1 自提"),
			@ApiImplicitParam(name = "orderType",value = "订单类型：1.卡先生订单 2.面对面支付 3.超级订订单")
	})
	@RequestMapping(value = "/listOrderByStatus", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<List<ShopOrderDto>> listOrderByStatus(long merchId,
															 @RequestParam(value = "status", defaultValue = "-2") int status,
															 @RequestParam(required = false) Integer dispatchtype,
															 @RequestParam(required = false)Integer orderType,
															 @RequestParam(value="pageNum",defaultValue="1") Integer pageNum) {
		RespBaseDto<List<ShopOrderDto>> result = new RespBaseDto<List<ShopOrderDto>>();
		result.setMessage("OK");
		List<ShopOrderDto> shopOrderDtos = shopOrderSmpl.listOrderByStatus(merchId, status,dispatchtype,orderType,pageNum);
		result.setData(shopOrderDtos);
		return result;
	}

	/**
	 * 商家分拣订单
	 * 
	 * @param orderId
	 * @param merchId
	 * @return
	 */
	@ApiOperation(value = "商家分拣订单", httpMethod = "POST")
	@RequestMapping(value = "/sortingOrder", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<String> sortingOrder(Long orderId, Long merchId, String remarksaler) {
		RespBaseDto<String> result = new RespBaseDto<String>();
		try {
			if (shopOrderSmpl.sorting(orderId, remarksaler)) {
				result.setMessage("OK");
			} else {
				result.setMessage(EWarning.Order_ErrorStatus.getName());
				result.setState(EWarning.Order_ErrorStatus.getValue());
			}
		} catch (Exception ex) {
			result.setMessage(ex.getMessage());
			result.setState(EWarning.Order_ErrorStatus.getValue());
		}
		return result;
	}

	/**
	 * 快递员抢单
	 * 
	 * @param memberId
	 * @param orderId
	 */
	@ApiOperation(value = "快递员抢单", httpMethod = "POST")
	@RequestMapping(value = "/grabOrder", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<String> grabOrder(Long memberId, Long orderId) {
		RespBaseDto<String> result = new RespBaseDto<String>();
		try {
			if (shopOrderSmpl.grabOrder(orderId, memberId)) {
				result.setMessage("OK");
			} else {
				result.setMessage(EWarning.Unknown.getName());
				result.setState(EWarning.Unknown.getValue());
			}
		} catch (Exception ex) {
			result.setMessage(ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	/**
	 * 商家发货
	 * 
	 * @param orderId
	 */
	@ApiOperation(value = "商家发货", httpMethod = "POST")
	@RequestMapping(value = "/sendGoods", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<String> sendGoods(Long orderId) {
		RespBaseDto<String> result = new RespBaseDto<String>();
		if (shopOrderSmpl.sendGoods(orderId)) {
			result.setMessage("OK");
		} else {
			result.setMessage(EWarning.Order_ErrorStatus.getName());
			result.setState(EWarning.Order_ErrorStatus.getValue());
		}
		return result;
	}

	/**
	 * 买家收货
	 * 
	 * @param orderId
	 */
	@ApiOperation(value = "买家收货", httpMethod = "POST")
	@RequestMapping(value = "/recieveGoods", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<String> recieveGoods(Long orderId) {
		RespBaseDto<String> result = new RespBaseDto<String>();
		if (shopOrderSmpl.recieveGoods(orderId)) {
			result.setMessage("OK");
		} else {
			result.setMessage(EWarning.Order_ErrorStatus.getName());
			result.setState(EWarning.Order_ErrorStatus.getValue());
		}
		return result;
	}

	/**
	 * 获取订单详情
	 * 
	 * @param orderId
	 * @return
	 */
	@ApiOperation(value = "获取订单详情", httpMethod = "POST")
	@RequestMapping(value = "/getShopOrder", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<ShopOrderDto> getShopOrder(Long orderId) {
		RespBaseDto<ShopOrderDto> result = new RespBaseDto<ShopOrderDto>();
		try {
			ShopOrderDto orderDto = shopOrderSmpl.getShopOrder(orderId);
			if (orderDto != null) {
				result.setMessage("OK");
				result.setData(orderDto);
			} else {
				result.setState(EWarning.Order_NonExistent.getValue());
				result.setMessage(EWarning.Order_NonExistent.getName());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMessage(ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	/**
	 * 查询送货员能够看得订单(快递员首页使用)
	 * 
	 * @param memberId
	 * @return
	 */
	@ApiOperation(value = "查询送货员能够看得订单(快递员首页使用)", httpMethod = "POST")
	@RequestMapping(value = "/listOrderForCourier", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<List<ShopOrderDto>> listOrderForCourier(Long memberId) {
		RespBaseDto<List<ShopOrderDto>> result = new RespBaseDto<List<ShopOrderDto>>();
		try {
			result.setMessage("OK");
			result.setData(shopOrderSmpl.listOrderForCourier(memberId));
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMessage(ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	/**
	 * 根据状态查询送货员订单
	 * 
	 * @param memberId
	 * @param status
	 * @return
	 */
	@ApiOperation(value = "根据状态查询送货员订单(快递员)", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "status", value = "订单状态(1:(用户)已付款,11:(商家)分拣,12:(快递员)抢单,2：(商家)已发货,3:(用户)已收货)") })
	@RequestMapping(value = "/listForCourierByQuery", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<List<ShopOrderDto>> listForCourierByQuery(long memberId, int status,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum) {
		RespBaseDto<List<ShopOrderDto>> result = new RespBaseDto<List<ShopOrderDto>>();
		try {
			result.setMessage("OK");
			result.setData(shopOrderSmpl.listForCourierByQuery(memberId, status,pageNum));
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMessage(ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	/**
	 * 统计商家订单信息(个人中心首页使用)
	 * 
	 * @param merchId
	 * @return
	 */
	@ApiOperation(value = "统计商家订单信息(个人中心首页使用)", httpMethod = "POST")
	@RequestMapping(value = "/getMerchOrderInfo", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<MerchStatDto> countOrderByMerchId(long merchId,
														 @RequestParam(required = false) Long memberId,
														 @RequestParam(required = false) Long identity,
														 @RequestParam(required = false)Integer orderType
	) {
		RespBaseDto<MerchStatDto> result = new RespBaseDto<MerchStatDto>();
		try {
			result.setData(shopOrderSmpl.countOrderByMerchId(merchId,memberId,identity,orderType));
			result.setMessage("OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMessage(ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	/**
	 * 会员查询订单
	 * @param memberId
	 * @param status
	 * @return
	 */
	@ApiOperation(value = "会员查询订单", httpMethod = "POST")
	@RequestMapping(value = "/listMemberOrder", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<List<ShopOrderDto>> listForMemberByQuery(Long memberId,@RequestParam(value = "status", defaultValue = "-2") int status,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum){
		RespBaseDto<List<ShopOrderDto>> result = new RespBaseDto<List<ShopOrderDto>>();
		try{
			result.setMessage("OK");
			result.setData(shopOrderSmpl.listForMemberByQuery(memberId, status,pageNum));
		}
		catch (Exception ex) {
			logger.error(ex.getMessage());
			result.setMessage(ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	@ApiOperation(value = "会员删除订单", httpMethod = "POST")
	@RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<String> deleteOrder(String orderIds){
		RespBaseDto<String> result = new RespBaseDto<String>();
		if(orderIds!=null&&!orderIds.equals("")){
			String[] orders = orderIds.split(",");
			for (String string : orders) {
				Long oId = Long.valueOf(string);
				ImsEweiShopOrder order = shopOrderSmpl.selectByPrimaryKey(oId);
				if(order.getStatus()!=1){
					shopOrderSmpl.updateOrderStatus(oId,1);
				}
			}
		}
		result.setMessage("OK");
		return result;
	}
	
}

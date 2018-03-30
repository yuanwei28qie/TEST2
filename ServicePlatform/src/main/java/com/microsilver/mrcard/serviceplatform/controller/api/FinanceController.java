package com.microsilver.mrcard.serviceplatform.controller.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.microsilver.mrcard.cloud.finance.dto.CarryoverKnightDto;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.CommissionFlowSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.CustomerDto;
import com.microsilver.mrcard.cloud.finance.dto.FinanceCommissionFlowResultDto;
import com.microsilver.mrcard.cloud.finance.dto.FinanceMerchFlowResultDto;
import com.microsilver.mrcard.cloud.finance.dto.MerchFlowDBSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.MerchFlowSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.PaymentDto;
import com.microsilver.mrcard.cloud.finance.dto.SettlementSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.WithdrawDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceSettlement;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceTransactionFlow;
import com.microsilver.mrcard.mq.ExtraSMS;
import com.microsilver.mrcard.mq.OrderMQ;
import com.microsilver.mrcard.mq.PushMsg;
import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.dto.HotelRoomOrderDto;
import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.model.ImsCrowdsourcingOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopCash;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMember;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentity;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrder;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.mq.MQSendMsgHelper;
import com.microsilver.mrcard.serviceplatform.service.IFinanceRemoteSmpl;
import com.microsilver.mrcard.serviceplatform.service.ImsCrowdsourcingOrderService;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopCashSmpl;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopMemberIdentityService;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopMerchUserSmpl;
import com.microsilver.mrcard.serviceplatform.service.MemberSmpl;
import com.microsilver.mrcard.serviceplatform.service.ShopOrderSmpl;

import feign.FeignException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.controller.api.FinanceController
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月26日 下午9:27:46
 * @Copyright Micro Silver
 *
 */
@Api(value = "/api/Finance", description = "财务相关API")
@Controller
@RequestMapping("/api/Finance")
public class FinanceController {
	private final static Logger logger = LoggerFactory.getLogger(FinanceController.class);
	@Autowired
	IFinanceRemoteSmpl iFinanceRemoteSmpl;

	@Autowired
	ImsEweiShopMemberIdentityService imsEweiShopMemberIdentityService;

	@Autowired
	ImsCrowdsourcingOrderService imsCrowdsourcingOrderService;

	@Autowired
	ImsEweiShopCashSmpl imsEweiShopCashSmpl;
	@Autowired
	ShopOrderSmpl shopOrderSmpl;
	@Autowired
	private MQSendMsgHelper mqsendMsgHelper;

	@ApiOperation(value = "查询客户财务资料", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "merchId",value = "商家编号"),
			@ApiImplicitParam(name = "memberId",value = "会员编号"),
			@ApiImplicitParam(name = "identity",value = "身分")
	})
	@RequestMapping(value = "/searchCustomer", method = RequestMethod.POST)
	@ResponseBody
	public MrcardFinanceCustomer searchFinanceCustomer(@RequestParam(value ="memberId")long memberId,
													   @RequestParam(value ="merchId")long merchId,
													   @RequestParam(value ="identity")long identity){
		return iFinanceRemoteSmpl.searchFinanceCustomer(memberId, merchId, identity);
	}
	@ApiOperation(value = "客户端获取账务信息", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "merchId",value = "商家编号"),
			@ApiImplicitParam(name = "memberId",value = "会员编号"),
			@ApiImplicitParam(name = "identity",value = "身分")
	})
	@RequestMapping(value = "/getMyFinanceInfo", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<MrcardFinanceCustomer> getFinanceCustomer(@RequestParam(value ="memberId")long memberId,
													   @RequestParam(value ="merchId")long merchId,
													   @RequestParam(value ="identity")long identity){
		MrcardFinanceCustomer me = iFinanceRemoteSmpl.searchFinanceCustomer(memberId, merchId, identity);
		RespBaseDto<MrcardFinanceCustomer> result = new RespBaseDto<>();
		try{
			result.setMessage("OK");
			result.setData(me);
		}
		catch(Exception ex){
			ex.printStackTrace();
			result.setState(EWarning.FINANCE_EXCEPTION.getValue());
			result.setMessage(ex.getMessage());
		}
		return result;
	}

	@ApiOperation(value = "新增交易流水", httpMethod = "POST")
	@RequestMapping(value = "/addTransFlow",method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<String> addTransFlow(MrcardFinanceTransactionFlow transFlow){
		RespBaseDto<String> result = new RespBaseDto<String>();
		try{
			if(iFinanceRemoteSmpl.addTransFlow(transFlow)){
				logger.info("新增交易流水记录 :{}",transFlow);
				result.setMessage("OK");
			}else{
				result.setState(EWarning.FINANCE_EXCEPTION.getValue());
				result.setMessage(EWarning.FINANCE_EXCEPTION.getName());
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			result.setState(EWarning.FINANCE_EXCEPTION.getValue());
			result.setMessage(ex.getMessage());
		}
		return result;
	}

	@ApiOperation(value = "提现流水查询",httpMethod = "POST")
	@RequestMapping(value = "/searchwithdraw",method = RequestMethod.POST)
	public @ResponseBody RespBaseDto<List<MrcardFinanceMerchFlow>> searchWithdraw(MerchFlowSearchDto flowSearch){
		RespBaseDto<List<MrcardFinanceMerchFlow>> result = new RespBaseDto<>();

		List<MrcardFinanceMerchFlow> list =  null;
		try {
			list = iFinanceRemoteSmpl.searchWithdraw(flowSearch);
			result.setData(list);
			result.setState(0);
			result.setMessage("OK");
		}catch (Exception ex){
			result.setState(EWarning.FINANCE_EXCEPTION.getValue());
			result.setMessage(ex.getMessage());
			logger.error(ex.getMessage());
		}
		return result;
	}

	@ApiOperation(value = "财务流水查询",httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "merchId",value = "商家编号"),
			@ApiImplicitParam(name = "memberId",value = "会员编号"),
			@ApiImplicitParam(name = "identity",value = "身分"),
			@ApiImplicitParam(name = "type", value = "1 订单流水（销售收入），5 提现流水"),
			@ApiImplicitParam(name = "orderSn",value = "财务流水Id（业务Id）"),
			@ApiImplicitParam(name = "pageNum",value = "分页")
	})
	@RequestMapping(value = "/searchflow",method = RequestMethod.POST)
	public @ResponseBody RespBaseDto<PageInfo<MrcardFinanceMerchFlow>> searchFlow(long merchId,long memberId,short identity,
																			  @RequestParam(required = false,value = "beginTime") Integer beginTime,
																			  @RequestParam(required = false,value = "endTime") Integer endTime,
																			  @RequestParam(required = false) Integer type,
																			  @RequestParam(required = false) String orderSn,
																			  @RequestParam(value="pageNum",defaultValue="1") Integer pageNum){
		RespBaseDto<PageInfo<MrcardFinanceMerchFlow>> result = new RespBaseDto<>();

		MerchFlowSearchDto flowSearch = new MerchFlowSearchDto();
		flowSearch.setMerchId(merchId);
		flowSearch.setMemberId(memberId);
		flowSearch.setIdentity(identity);
		flowSearch.setBeginTime(beginTime);
		flowSearch.setEndTime(endTime);
		flowSearch.setPageNum(pageNum);
		if(null != type)
			flowSearch.setType(type.byteValue());
		if(null != orderSn)
			flowSearch.setOrdersn(orderSn);


		PageInfo<MrcardFinanceMerchFlow> list =  null;
		try {
			list = iFinanceRemoteSmpl.searchflow(flowSearch);
			result.setData(list);
			result.setState(0);
			result.setMessage("OK");
		}catch (Exception ex){
			result.setState(EWarning.FINANCE_EXCEPTION.getValue());
			result.setMessage(ex.getMessage());
			logger.error(ex.getMessage());
		}
		return result;
	}

	@ApiOperation(value = "财务流水查询总后台",httpMethod = "POST")
	@ApiImplicitParams({
			/*@ApiImplicitParam(name = "merchs",value = "商家编号组【1,2,3】"),
			@ApiImplicitParam(name = "members",value = "会员编号组【1,2,3】"),
			@ApiImplicitParam(name = "identity",value = "身份编号组【1,2,3】"),*/
			@ApiImplicitParam(name = "merchId",value = "商家编号"),
			@ApiImplicitParam(name = "type",value = "1 订单流水（销售收入），5 提现流水"),
			@ApiImplicitParam(name = "pageNum",value = "页码"),
			@ApiImplicitParam(name = "pageSize",value = "条数")
	})
	@RequestMapping(value = "/searchflowbd",method = RequestMethod.POST)
	public @ResponseBody RespBaseDto<PageInfo<FinanceMerchFlowResultDto>> searchFlowBD(/*@RequestParam(required = false,value = "merchs") String merchs,
																					   @RequestParam(required = false,value = "members") String members,
																					   @RequestParam(required = false,value = "identity") String identity,*/
																					   @RequestParam(required = false,value = "merchId") Long merchId,
																					   @RequestParam(required = false,value = "type") Byte type  ,
																					   @RequestParam(required = false,value = "beginTime") Integer beginTime,
																					   @RequestParam(required = false,value = "endTime") Integer endTime,
																					   @RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
																					   @RequestParam(value="pageSize",defaultValue="10") Integer pageSize){
		RespBaseDto<PageInfo<FinanceMerchFlowResultDto>> result = new RespBaseDto<>();
		PageInfo<FinanceMerchFlowResultDto> list =  null;
		try {
			MerchFlowDBSearchDto dbSearch = new MerchFlowDBSearchDto();
			if(merchId != null) {
				List<Long> merches = new ArrayList<>();
				merches.add(merchId);
				dbSearch.setMerchIds(merches);
			}
			dbSearch.setType(type);
			dbSearch.setBeginTime(beginTime);
			dbSearch.setEndTime(endTime);
			dbSearch.setPageNum(pageNum);
			dbSearch.setPageSize(pageSize);

			list = iFinanceRemoteSmpl.searchflowBD(dbSearch);
			result.setData(list);
			result.setState(0);
			result.setMessage("OK");
		}catch (Exception ex){
			result.setState(EWarning.FINANCE_EXCEPTION.getValue());
			result.setMessage(ex.getMessage());
			logger.error(ex.getMessage());
		}
		return result;
	}

	@ApiOperation(value = "订单分润流水查询总后台",httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "merchId",value = "商家编号"),
			@ApiImplicitParam(name = "memberId",value = "会员编号"),
			@ApiImplicitParam(name = "identity",value = "身份"),
			@ApiImplicitParam(name = "orderSn",value = "业务单号【1,2,3】"),
			@ApiImplicitParam(name = "pageNum",value = "页码"),
			@ApiImplicitParam(name = "pageSize",value = "条数")
	})
	@RequestMapping(value = "/searchcommissionflow",method = RequestMethod.POST)
	public @ResponseBody RespBaseDto<PageInfo<FinanceCommissionFlowResultDto>> searchFlowBD(
																					   @RequestParam(required = false,value = "memberId") Long memberId,
																					   @RequestParam(required = false,value = "identity") Short identity,
																					   @RequestParam(required = false,value = "merchId") Long merchId,
																					   @RequestParam(required = false,value = "orderSn") String orderSn  ,
																					   @RequestParam(required = false,value = "beginTime") Integer beginTime,
																					   @RequestParam(required = false,value = "endTime") Integer endTime,
																					   @RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
																					   @RequestParam(value="pageSize",defaultValue="10") Integer pageSize){
		RespBaseDto<PageInfo<FinanceCommissionFlowResultDto>> result = new RespBaseDto<>();
		PageInfo<FinanceCommissionFlowResultDto> list =  null;
		try {
			CommissionFlowSearchDto dbSearch = new CommissionFlowSearchDto();
			dbSearch.setMemberId(memberId);
			dbSearch.setMerchId(merchId);
			dbSearch.setIdentity(identity);
			if(null != orderSn && !"".equals(orderSn)) {
				String[] arr = orderSn.split(",");
				if(arr.length >1)
					dbSearch.setOrdersnList(Arrays.asList(arr));
				else
					dbSearch.setOrdersn(orderSn);
			}
			dbSearch.setBeginTime(beginTime);
			dbSearch.setEndTime(endTime);
			dbSearch.setPageNum(pageNum);
			dbSearch.setPageSize(pageSize);
			if(identity!=null && identity == 13) {
				list= iFinanceRemoteSmpl.searchKnightCommissionDB(dbSearch);
			}else{
				list = iFinanceRemoteSmpl.searchCommissionDB(dbSearch);
			}
			result.setData(list);
			result.setState(0);
			result.setMessage("OK");
		}catch (Exception ex){
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(EWarning.Unknown.getName());
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}
		return result;
	}
	@ApiOperation(value = "根据订单查询分润情况",httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "merchId",value = "商家编号"),
			@ApiImplicitParam(name = "memberId",value = "会员编号"),
			@ApiImplicitParam(name = "identity",value = "身份"),
			@ApiImplicitParam(name = "orderSn",value = "业务单号【1,2,3】"),
	})
	@RequestMapping(value = "/searchcommissionByOrders",method = RequestMethod.POST)
	public @ResponseBody RespBaseDto<List<FinanceCommissionFlowResultDto>> selectCommissionByOrders(
				@RequestParam(required = false,value = "memberId") Long memberId,
			    @RequestParam(required = false,value = "identity") Short identity,
			    @RequestParam(required = false,value = "merchId") Long merchId,
			    @RequestParam(required = false,value = "orderSn") String orderSn){
		RespBaseDto<List<FinanceCommissionFlowResultDto>> result = new RespBaseDto<>();
		try {
			CommissionFlowSearchDto dbSearch = new CommissionFlowSearchDto();
			dbSearch.setMemberId(memberId);
			dbSearch.setMerchId(merchId);
			dbSearch.setIdentity(identity);
			if(null != orderSn && !"".equals(orderSn)) {
				String[] arr = orderSn.split(",");
				if(arr.length >1)
					dbSearch.setOrdersnList(Arrays.asList(arr));
				else
					dbSearch.setOrdersn(orderSn);
				result.setData(iFinanceRemoteSmpl.selectCommissionByOrders(dbSearch));
			}else {
				result.setState(EWarning.ErrorParams.getValue());
				result.setMessage(EWarning.ErrorParams.getName());
			}
		}
		catch (Exception ex){
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(EWarning.Unknown.getName());
			logger.error(ex.getMessage());
		}
		return result;
	}
	
	@ApiOperation(value="提现申请",httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "type",value = "1,卡先生，2，超级定，3小飞侠-垫付货款,4会员提现")
	})
	@RequestMapping(value = "tobelance",method = RequestMethod.POST)
	public @ResponseBody RespBaseDto<String> withdraw(WithdrawDto withdraw,Integer type){
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			logger.info("提现申请:{}", JSON.toJSONString(withdraw));
			Long flowId = null;
			if(type == 3){
				flowId = iFinanceRemoteSmpl.withdrawByAdvance(withdraw);
			}else if(type == 4){
				flowId = iFinanceRemoteSmpl.Withdrawals(withdraw);
			}else {
				flowId = iFinanceRemoteSmpl.withdraw(withdraw);
			}
			if(flowId != null){
				result.setData(withdraw.getOrdersn());
				result.setState(0);
				result.setMessage("OK");
				logger.info("提现申请成功：{}",flowId);
			}else{
				result.setState(EWarning.FINANCE_EXCEPTION.getValue());
				result.setMessage(EWarning.FINANCE_EXCEPTION.getName());
			}
		}catch (Exception ex){
			result.setState(EWarning.FINANCE_EXCEPTION.getValue());
			result.setMessage(ex.getMessage());
			logger.error("提现申请出错：{}",ex.getMessage());
		}
		return result;
	}
	@ApiOperation(value = "拒绝提现申请",httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ordersn",value = "提现申请业务单据编号"),
			@ApiImplicitParam(name = "type",value = "1,卡先生，2，超级定，3小飞侠-垫付货款")
	})
	@RequestMapping(value = "topup",method = RequestMethod.POST)
	public @ResponseBody RespBaseDto<Boolean> topUP(String ordersn,Integer type){
		RespBaseDto<Boolean> result = new RespBaseDto<>();
		try {
			logger.info("提现退款申请:{}",ordersn);
			boolean refound = false;
			if(type==3){
				refound =  iFinanceRemoteSmpl.topUPAdvance(ordersn);
			}else{
				refound = iFinanceRemoteSmpl.topUP(ordersn);
			}
			result.setData(refound);
			result.setState(0);
			result.setMessage("OK");
		}catch (Exception ex){
			ex.printStackTrace();
			result.setState(EWarning.FINANCE_EXCEPTION.getValue());
			result.setMessage(ex.getMessage());
			logger.error("提现退款申请出错：{} - {}",ordersn,ex.getMessage());
		}
		return result;
	}


	/**
	 * 查询结算单
	 * @return
	 */
	@ApiOperation(value = "查询骑士结算单据",httpMethod = "POST")
	@PostMapping("searchSettlement")
	public RespBaseDto<PageInfo<MrcardFinanceSettlement>> searchSettlement(SettlementSearchDto searchDto){
		PageInfo<MrcardFinanceSettlement> list = iFinanceRemoteSmpl.searchSettlement(searchDto);
		RespBaseDto<PageInfo<MrcardFinanceSettlement>> result = new RespBaseDto<>();
		result.setData(list);
		result.setMessage("OK");
		return result;
	}

	/**
	 * 结算单据审核
	 * 审核通过，生成提现流水单据
	 * @return
	 */
	@ApiOperation(value = "结算单据审核",httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "operatorName",value = "操作者"),
			@ApiImplicitParam(name = "settlementsn",value = "审核单据编号"),
			@ApiImplicitParam(name = "status",value = "审核单据状态")
	})
	@PostMapping("carryoverExamine")
	public RespBaseDto<Boolean> tobelanceKnight(@RequestParam String operatorName ,@RequestParam String settlementsn,@RequestParam Boolean status) throws Exception {
		Boolean bl =  iFinanceRemoteSmpl.tobelanceKnight(operatorName,settlementsn,status);
		RespBaseDto<Boolean> result = new RespBaseDto<>();
		result.setData(bl);
		result.setMessage("OK");
		return result;
	}


	/**
	 * 手动结算骑士数据
	 *  检查是否已经有结转单据
	 *  检查状态是否已经打款-已打款的不允许进行清除
	 *  清除前面的结转单据
	 *  重新进行结转
	 * @return
	 */
	@ApiOperation(value = "手动结算骑士数据",httpMethod = "POST")
	@PostMapping("carryoverByAdmin")
	public RespBaseDto<String> carryoverByAdmin(@RequestParam(required = false,value = "memberId") Long memberId,
												@RequestParam(required = false,value = "identity") Short identity,
												@RequestParam(required = false,value = "merchId") Long merchId,
												@RequestParam(required = false,value = "settlementSn") String settlementSn) {

		RespBaseDto<String> result = new RespBaseDto<>();

		//查询已完成未结算的订单
		//换算上周时间[上周一00:00:00 , 本周一00:00:00)
		LocalDate d = LocalDate.now();
		LocalDate.Property property = d.minusWeeks(1).dayOfWeek();
		LocalDate beginTime = property.withMinimumValue();
		LocalDate endTime = property.withMaximumValue();
		Long b1 = (beginTime.toInterval().getStartMillis()/1000);
		Long e1 = (endTime.toInterval().getEndMillis()/1000);

		List<ImsCrowdsourcingOrder> orderList = imsCrowdsourcingOrderService.selectByLOGStatus(true,(byte)1,memberId,(byte)6,b1.intValue(),e1.intValue());
		if(null == orderList || orderList.isEmpty()){
			result.setData(null);
			result.setMessage("无可结算的订单");
			result.setState(EWarning.Unknown.getValue());;
			return result;
		}else{
			logger.debug("settlement knight data ->" +JSON.toJSONString(orderList));
		}
		//全部结算成功
		ImsEweiShopMemberIdentity merchIdentity = imsEweiShopMemberIdentityService.getImsEweiShopMemberIdentity(memberId);
		CarryoverKnightDto knightDto = new CarryoverKnightDto();
		knightDto.setIdentity(merchIdentity.getIdentity());
		knightDto.setMemberId(merchIdentity.getMemberId());
		knightDto.setMerchId(merchIdentity.getMerchId());
		knightDto.setBeginTime(b1);
		knightDto.setEndTime(e1);
		List<String> snList = new ArrayList<>();

		orderList.forEach((corder)->{
			if(corder.getIsSettlement() == 1) {
				CommissionDto commissionDto = new CommissionDto();
				commissionDto.setMerchInfo(convertIdentityToCustomer(merchIdentity));
				commissionDto.setOrderSn(corder.getOrdersn());
				boolean isBound = iFinanceRemoteSmpl.TaskKnightBound(commissionDto);
				if (isBound) {
					imsCrowdsourcingOrderService.changeOrderStatusByKnight(corder.getId(), (byte) 2);
				}
			}
			snList.add(corder.getOrdersn());
		});
		knightDto.setSnList(snList);
		String settlementSN = iFinanceRemoteSmpl.carryoverByAdmin(knightDto);
		//全部结算成功 ，则执行结转
		if(null != settlementSN) {
			result.setData(JSON.toJSONString(orderList));
			result.setMessage("结算成功");
		}else {
			result.setData(JSON.toJSONString(orderList));
			result.setMessage("结算不数据不一至，不于结转请检查");
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}


	@ApiOperation(value = "会员充值", httpMethod = "POST")
	@RequestMapping(value = "/recharge",method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<String> Recharge(PaymentDto payment){
		RespBaseDto<String> result = new RespBaseDto<String>();
		try{
			payment.setRemark("会员充值");

			if(iFinanceRemoteSmpl.Recharge(payment)){
				logger.info("新增充值流水记录 :{}",JSON.toJSONString(payment));
				result.setMessage("OK");
			}else{
				result.setState(EWarning.FINANCE_EXCEPTION.getValue());
				result.setMessage(EWarning.FINANCE_EXCEPTION.getName());
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			result.setState(EWarning.FINANCE_EXCEPTION.getValue());
			result.setMessage(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * 
	 * @param withdraw
	 * time:2018.03.16
	 * @return
	 */
	@ApiOperation(value = "会员提现-扣取手续费的", httpMethod = "POST")
	@RequestMapping(value = "/withdrawals",method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<String> withdrawals(WithdrawDto withdraw){
		RespBaseDto<String> result = new RespBaseDto<>();
		try{
			if(withdraw.getAlipay() == null || "".equals(withdraw.getAlipay())){
				logger.error("请填写支付宝账号");
				result.setState(EWarning.SHOPCASH_EXCEPTION.getValue());
				result.setMessage("请填写支付宝账号");
				return result;
			}
			
			MrcardFinanceCustomer customer = iFinanceRemoteSmpl.searchFinanceCustomer(withdraw.getMemberId(),withdraw.getIdentity(),withdraw.getMerchId());
			//提现金额=用户提现+系统扣款
			BigDecimal total = withdraw.getAmount().add(withdraw.getAmount().multiply(new BigDecimal("0.056")));
			if(withdraw.getAmount().intValue() < 10){
				logger.error("提现金额必需大于10元");
				result.setState(EWarning.SHOPCASH_EXCEPTION.getValue());
				result.setMessage("提现金额必需大于10元");
				return result;
			}else if(customer.getRealAmount().doubleValue() < total.doubleValue()) {
				logger.error("余额不足，无法提现");
				result.setState(EWarning.SHOPCASH_EXCEPTION.getValue());
				result.setMessage("余额不足，无法提现");
				return result;
			}
			//获取推荐人
			ImsEweiShopMember member = memberSmpl.selectMemberById(withdraw.getMemberId());
			if(member.getReferee()!=null&&!member.getReferee().equals("")) {
				withdraw.setRefereeId(member.getReferee());
			}
			
			BigDecimal todayMoney = imsEweiShopCashSmpl.countMemberCashMoenyByTime(withdraw.getMemberId());
			if(todayMoney.add(withdraw.getAmount()).compareTo(new BigDecimal(Consts.MEMBER_CASH_LIMIT_FOR_DAY))>=0) {
				result.setState(EWarning.WITHDRAW_EXCEED_LIMIT.getValue());
				result.setMessage(EWarning.WITHDRAW_EXCEED_LIMIT.getName());
				return result;
			}
			ImsEweiShopCash cashBill = imsEweiShopCashSmpl.createCashBill(withdraw);
			if (cashBill!=null) {
				withdraw.setOrdersn(cashBill.getOrdersn());
				withdraw.setRemark("会员手动提现");
				Long dwarId = iFinanceRemoteSmpl.Withdrawals(withdraw);
				result.setMessage("OK");
				result.setData("提现成功");
				if (null == dwarId || dwarId == 0) {
					result.setState(EWarning.FINANCE_EXCEPTION.getValue());
					result.setMessage(EWarning.FINANCE_EXCEPTION.getName());
				}else {
					if(withdraw.getAmount().compareTo(new BigDecimal(Consts.MEMBER_CASH_NO_CHECK_MAX))<=0) {
//						String url=Consts.HTTP_PHP_ALIPAYURL+cashBill.getId();
//						String jsonResult  = HttpClientUtils.doGet(url);
//						logger.info("会员提现{}元,自动审核,财务单号:{},业务单号：{},转账结果 :{}",withdraw.getAmount(),dwarId,cashBill,jsonResult);
						logger.info("会员提现{}元,金额超过审核要求,需要手动审核 ,财务单号:{},业务单号：{}",withdraw.getAmount(), dwarId,cashBill);
					}else {
						logger.info("会员提现{}元,金额超过审核要求,需要手动审核 ,财务单号:{},业务单号：{}",withdraw.getAmount(), dwarId,cashBill);
					}
				}
				
			} else {
				result.setState(EWarning.SHOPCASH_EXCEPTION.getValue());
				result.setMessage(EWarning.SHOPCASH_EXCEPTION.getName());
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			result.setState(EWarning.FINANCE_EXCEPTION.getValue());
			result.setMessage(ex.getMessage());
		}
		return result;
	}

	@Autowired
	MemberSmpl memberSmpl;
	@Autowired
	ImsEweiShopMerchUserSmpl merchUserSmpl;

	@ApiOperation(value = "会员余额支付", httpMethod = "POST")
	@RequestMapping(value = "/payment",method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<Long> Payment(long memberId,String ordersn,BigDecimal amount){
		PaymentDto payment = new PaymentDto();
		payment.setMemberId(memberId);
		payment.setOrdersn(ordersn);
		payment.setAmount(amount);
		payment.setIdentity((byte)0);
		payment.setMerchId(0L);
		payment.setPayType((byte)1);
		payment.setTransType((byte)1);
		RespBaseDto<Long> result = new RespBaseDto<Long>();
		ImsEweiShopOrder shopOrder = null;
		try{
			shopOrder = shopOrderSmpl.selectByOrdersn(ordersn);
			if(shopOrder==null){
				logger.error("订单{}不存在",ordersn);
				result.setState(EWarning.Order_NonExistent.getValue());
				result.setMessage(EWarning.Order_NonExistent.getName());
				return result;
			}
			
			if(shopOrder.getStatus()==5) {
				result.setState(EWarning.Order_Overdue.getValue());
				result.setMessage(EWarning.Order_Overdue.getName());
				return result;
			}
			if(shopOrder.getStatus()==1) {
				result.setState(EWarning.Order_Repeat_Payment.getValue());
				result.setMessage(EWarning.Order_Repeat_Payment.getName());
				return result;
			}
			if(shopOrder.getPrice().compareTo(amount)==0){
				payment.setRemark("余额支付");
				String transactionNo= Utils.createOrderSn("CJF");
				payment.setTransactionNo(transactionNo);
				Long paymentSn = iFinanceRemoteSmpl.Payment(payment);
				result.setData(paymentSn);
				result.setMessage("OK");
				//更新订单状态
				shopOrder.setStatus(1);
				shopOrder.setPaytype((byte)1);
				shopOrder.setPaytime(Utils.getCurrentTime());
				shopOrder.setTransid(paymentSn.toString());
				shopOrderSmpl.updateByPrimaryKeySelective(shopOrder);

				try{
					HotelRoomOrderDto hotelRoom = shopOrderSmpl.selectHotelRoom(shopOrder.getId());
					PushMsg msg =new PushMsg();
					msg.setPushType(1);
					msg.setAppType((byte)4);
					msg.setPhone("18180874956");
					msg.setTemplateType(46759);
					ExtraSMS sms = new ExtraSMS();
					sms.setUserName(hotelRoom.getNickname());
					sms.setUserPhone(hotelRoom.getMemberMobile());
					sms.setHotel(hotelRoom.getHotolName());
					sms.setHotelPhone(hotelRoom.getHotelMobile());
					sms.setHome(hotelRoom.getRoomName());
					sms.setTime(Utils.getCurrentTime("yyyy-MM-dd HH:mm"));
					msg.setExtraSMS(sms);
					mqsendMsgHelper.sendJSONMsg(msg);
					
					if(shopOrder.getActivityId().intValue()==1){
						//零点半价发送结算消息
						OrderMQ orderMQ =new OrderMQ();
						orderMQ.setOrderId(shopOrder.getId().intValue());
						orderMQ.setType(2);
						mqsendMsgHelper.sendJSONOrderMQ(orderMQ);
						logger.info("零点半价秒到：{}",JSON.toJSONString(orderMQ));
					}
				}catch (Exception ex){
					ex.printStackTrace();
					logger.error(ex.getMessage());
				}
			}else{
				logger.error("订单[{}]支付金额不正确,订单金额{},支付金额{}",ordersn,shopOrder.getPrice(),amount);
				result.setState(EWarning.ErrorAmount.getValue());
				result.setMessage(EWarning.ErrorAmount.getName());
				return result;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			result.setState(EWarning.FINANCE_EXCEPTION.getValue());
			result.setMessage(ex.getMessage());
			return result;
		}
		return result;
	}
	@ApiOperation(value = "会员退款", httpMethod = "POST")
	@RequestMapping(value = "/refund",method = RequestMethod.POST)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberId",value = "会员Id"),
		@ApiImplicitParam(name = "identity",value = "身份"),
		@ApiImplicitParam(name = "merchId",value = "商家Id"),
		@ApiImplicitParam(name = "ordersn",value = "余额支付(payment result)时的支付ID"),
	})
	@ResponseBody
	public RespBaseDto<Boolean> refund(@RequestParam(required = false,value = "memberId") Long memberId,
									@RequestParam(required = false,value = "identity",defaultValue = "0") Short identity,
									@RequestParam(required = false,value = "merchId",defaultValue = "0") Long merchId,
									@RequestParam(required = false,value = "ordersn") Long ordersn){
		RespBaseDto<Boolean> result = new RespBaseDto<>();
		try{
			Boolean isreound = iFinanceRemoteSmpl.refund(identity,memberId,merchId,ordersn);
			result.setData(isreound);
			result.setMessage("OK");
		}
		catch(Exception ex){
			ex.printStackTrace();
			FeignException exception = (FeignException) ex.getCause();
			System.out.println(exception.getMessage());
			result.setState(EWarning.FINANCE_EXCEPTION.getValue());
			result.setMessage(ex.getMessage());
		}
		return result;
	}

	/**
	 * 没有用映射框架就先自己写转换了
	 */
	private CustomerDto convertIdentityToCustomer(ImsEweiShopMemberIdentity memberIdentity) {
		CustomerDto merchInfo = new CustomerDto();
		merchInfo.setIdentity(memberIdentity.getIdentity());
		merchInfo.setMerchId(memberIdentity.getMerchId());
		merchInfo.setMemberId(memberIdentity.getMemberId());
		merchInfo.setMemberName(memberIdentity.getName());
		return merchInfo;
	}
}

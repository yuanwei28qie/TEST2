package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.microsilver.mrcard.cloud.finance.dto.CarryoverKnightDto;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.CommissionFlowSearchDto;
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

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.service.IFinanceRemoteSmpl
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月26日 下午7:43:12
 * @Copyright Micro Silver
 *
 */
@FeignClient(value = "finance-service")
public interface IFinanceRemoteSmpl {
	@RequestMapping(value = "/finance/getCustomer", method = RequestMethod.POST)
	public MrcardFinanceCustomer getFinanceCustomer(@RequestParam(value ="financeId")Long financeId);
	@RequestMapping(value = "/finance/searchFinanceCustomer", method = RequestMethod.POST)
	public MrcardFinanceCustomer searchFinanceCustomer(@RequestParam(value ="memberId")long memberId,@RequestParam(value ="merchId")long merchId,@RequestParam(value ="identity")Long identity);
	@RequestMapping(value = "/finance/addTransFlow", method = RequestMethod.POST)
	public boolean addTransFlow(@RequestBody MrcardFinanceTransactionFlow transFlow);
	@RequestMapping(value = "/finance/withdraw/searchwithdraw", method = RequestMethod.POST)//searchflow  searchwithdraw
	public List<MrcardFinanceMerchFlow> searchWithdraw(@RequestBody MerchFlowSearchDto flowSearch);
	@RequestMapping(value = "/finance/withdraw/searchflow", method = RequestMethod.POST)//searchflow  searchwithdraw
	public PageInfo<MrcardFinanceMerchFlow> searchflow(@RequestBody MerchFlowSearchDto flowSearch);
	@RequestMapping(value = "/finance/statistics/searchflowBD", method = RequestMethod.POST)//searchflow  searchwithdraw
	public PageInfo<FinanceMerchFlowResultDto> searchflowBD(@RequestBody MerchFlowDBSearchDto dbSearch);
	@RequestMapping(value = "/finance/statistics/searchCommissionDB", method = RequestMethod.POST)
	public PageInfo<FinanceCommissionFlowResultDto> searchCommissionDB(@RequestBody CommissionFlowSearchDto dbSearch);
	@RequestMapping(value = "/finance/statistics/searchKnightCommissionDB", method = RequestMethod.POST)
	public PageInfo<FinanceCommissionFlowResultDto> searchKnightCommissionDB(@RequestBody CommissionFlowSearchDto dbSearch);
	@RequestMapping(value = "/finance/statistics/selectCommissionByOrders", method = RequestMethod.POST)
	public List<FinanceCommissionFlowResultDto> selectCommissionByOrders(@RequestBody CommissionFlowSearchDto dbSearch);
	 
	@RequestMapping(value = "/finance/withdraw/tobelance", method = RequestMethod.POST)
	public Long withdraw(@RequestBody WithdrawDto withdraw);
	@RequestMapping(value="/finance/withdraw/topup", method = RequestMethod.POST)
	public boolean topUP(@RequestParam(value ="ordersn") String ordersn);

	@RequestMapping(value = "/finance/settlement/searchSettlement",method = RequestMethod.POST)
	public PageInfo<MrcardFinanceSettlement> searchSettlement(@RequestBody  SettlementSearchDto searchDto);
	@RequestMapping(value = "/finance/settlement/carryoverExamine",method = RequestMethod.POST)
	public Boolean tobelanceKnight(@RequestParam(value = "operatorName") String operatorName ,@RequestParam(value = "settlementsn") String settlementsn,@RequestParam(value = "status") Boolean status);
	@RequestMapping(value = "/finance/settlement/carryoverByAdmin",method = RequestMethod.POST)
	public String carryoverByAdmin(@RequestBody CarryoverKnightDto carryoverKnightDto);
	@RequestMapping(value = "/finance/settlement/tobelanceAdvance",method = RequestMethod.POST)
	public Long withdrawByAdvance(@RequestBody WithdrawDto withdraw);
	@RequestMapping(value = "/finance/settlement/topupAdvance",method = RequestMethod.POST)
	public boolean topUPAdvance(@RequestParam(value = "ordersn") String ordersn);

	//骑士结算
	@RequestMapping(value = "/finance/task/knightBound",method = RequestMethod.POST)
	public boolean TaskKnightBound(@RequestBody CommissionDto commissionDto);


	@RequestMapping(value = "/finance/transaction/recharge",method = RequestMethod.POST)
	public Boolean Recharge(@RequestBody PaymentDto recharege);////用户充值
	@RequestMapping(value = "/finance/transaction/withdrawals",method = RequestMethod.POST)
	public Long Withdrawals(@RequestBody WithdrawDto withdraw);// 提现，客户提现收取6‰手续费
	@RequestMapping(value = "/finance/transaction/payment",method = RequestMethod.POST)
	public Long Payment(@RequestBody PaymentDto payment);//余额支付
	@RequestMapping(value = "/finance/transaction/refund",method = RequestMethod.POST)
	public Boolean refund(@RequestParam(value = "identity")Short identity ,@RequestParam(value = "memberId")Long memberId,@RequestParam(value = "merchId")Long merchId,@RequestParam(value = "ordersn")Long ordersn);// 调用接口失败，则使用此接口回调，退回原来的金额

}

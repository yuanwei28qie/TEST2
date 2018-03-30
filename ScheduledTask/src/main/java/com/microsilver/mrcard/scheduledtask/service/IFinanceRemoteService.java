package com.microsilver.mrcard.scheduledtask.service;

import com.microsilver.mrcard.cloud.finance.dto.CarryoverKnightDto;
import com.microsilver.mrcard.cloud.finance.dto.WithdrawDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;

import java.util.List;

/**
 * 结算服务.
 */
@FeignClient(value = "FINANCE-SERVICE")
public interface IFinanceRemoteService {

	// 订单分成(分润)
	@RequestMapping(value = "/finance/task/commibound", method = RequestMethod.POST)
	public boolean TaskCommisstion(@RequestBody CommissionDto commission);

	@RequestMapping(value = "/finance/task/commission",method = RequestMethod.POST)
	public boolean Commisstion(@RequestBody CommissionDto commission);
	@RequestMapping(value = "/finance/task/recommend",method = RequestMethod.POST)
	public boolean RecommendPreCommisstion(@RequestBody CommissionDto commission);
	@RequestMapping(value="/finance/task/recommendBound",method = RequestMethod.POST)
	public Boolean RecommendCommisstion(@RequestParam(name = "orderSn") String ordersn);

	//骑士订单分成
	@RequestMapping(value = "/finance/task/commissionKnight",method = RequestMethod.POST)
	public boolean CommissionKnight(@RequestParam(name = "orderSn") String orderSn, @RequestBody List<CommissionDto> commission);

	@RequestMapping(value = "/finance/task/bound",method = RequestMethod.POST)
	public boolean TaskBound(String orderSn);
	//骑士结算
	@RequestMapping(value = "/finance/task/knightBound",method = RequestMethod.POST)
	public boolean TaskKnightBound(@RequestBody CommissionDto commissionDto);
	//骑士结算后立即结转
	@RequestMapping(value = "/finance/task/knightCarryover",method = RequestMethod.POST)
	public String TaskKnightCarryover(@RequestBody CarryoverKnightDto commissionDto);

	@RequestMapping(value = "/finance/withdraw/tobelance",method = RequestMethod.POST)
	public Long withdraw(@RequestBody WithdrawDto withdraw);

}

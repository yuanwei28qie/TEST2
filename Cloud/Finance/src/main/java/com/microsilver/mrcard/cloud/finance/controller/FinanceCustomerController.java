package com.microsilver.mrcard.cloud.finance.controller;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceTransactionFlow;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceCustomerService;
import com.microsilver.mrcard.cloud.finance.service.impl.TransactionFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/finance")
public class FinanceCustomerController {
	private final static Logger logger = LoggerFactory.getLogger(FinanceCustomerController.class);
	
	@Resource
	MrcardFinanceCustomerService mrcardFinanceCustomerService;
	@Resource
	TransactionFlowService transactionFlowService;
	
	@PostMapping("/getCustomer")
	public MrcardFinanceCustomer getFinanceCustomer(Long financeId) {
		logger.debug("获取商户信息{}",financeId);
		MrcardFinanceCustomer customer = mrcardFinanceCustomerService.getFinanceCustomer(financeId);
		return customer;
	}
	/**
	 * 查询商家信息，没有自动创建账号
	 * @param memberId
	 * @param identity
	 * @param merchId
	 * @return
	 */
	@PostMapping("/searchFinanceCustomer")
	public MrcardFinanceCustomer searchFinanceCustomer(long memberId,short identity,long merchId){
		logger.debug("查询商户信息{},{},{}",memberId,identity,merchId);
		return mrcardFinanceCustomerService.searchFinanceCustomer(memberId, identity, merchId);
	}
	/**
	 * 增加交易流水
	 * @param transFlow
	 * @return
	 */
	@PostMapping("/addTransFlow")
	public boolean addTransFlow(@RequestBody MrcardFinanceTransactionFlow transFlow){
		logger.debug("增加交易流水{}",transFlow.getOrdersn());
		return transactionFlowService.addTransFlow(transFlow);
	}
	
}

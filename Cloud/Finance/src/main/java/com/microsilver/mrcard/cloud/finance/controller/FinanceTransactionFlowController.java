package com.microsilver.mrcard.cloud.finance.controller;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceTransactionFlow;
import com.microsilver.mrcard.cloud.finance.service.impl.TransactionFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/27 0027.
 * 交易流水记录
 * (所有和第三方的交易日志都要进入这张表)
 */
@RestController
@RequestMapping("/finance/trans")
public class FinanceTransactionFlowController {
    private final static Logger logger = LoggerFactory.getLogger(FinanceTransactionFlowController.class);

    @Resource
    TransactionFlowService transactionFlowService;

    @PostMapping("/addTransFlow")
    public boolean addTransFlow(@RequestBody MrcardFinanceTransactionFlow transFlow){
        return transactionFlowService.addTransFlow(transFlow);
    }


}

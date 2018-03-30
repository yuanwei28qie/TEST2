package com.microsilver.mrcard.cloud.finance.service.impl;

import com.microsilver.mrcard.cloud.finance.core.BussUtils;
import com.microsilver.mrcard.cloud.finance.dao.MrcardFinanceTransactionFlowMapper;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceTransactionFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceTransactionFlowExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @Name com.microsilver.mrcard.cloud.finance.service.impl.TransactionFlowService
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月26日 下午9:19:10
 * @Copyright Micro Silver
 *
 */
@Service
public class TransactionFlowService {
	private final static Logger logger = LoggerFactory.getLogger(TransactionFlowService.class);
	
	@Autowired
	MrcardFinanceTransactionFlowMapper iTransactionFlow;
	public boolean addTransFlow(MrcardFinanceTransactionFlow transFlow){
		
		try{
			if(null == transFlow.getBatchNo())
				transFlow.setBatchNo(BussUtils.createBatchNo());
			logger.info(transFlow.toString());
			iTransactionFlow.insert(transFlow);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return false;
		}
	}

	public boolean isExistsTransFlow(String transactionNo){
		MrcardFinanceTransactionFlowExample example	= new MrcardFinanceTransactionFlowExample();
		example.createCriteria().andTransactionNoEqualTo(transactionNo);
		List<MrcardFinanceTransactionFlow> lst = iTransactionFlow.selectByExample(example);
		if(lst != null && !lst.isEmpty()){
			return true;
		}
		return false;
	}
}

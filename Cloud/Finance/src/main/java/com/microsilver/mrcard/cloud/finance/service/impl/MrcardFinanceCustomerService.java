package com.microsilver.mrcard.cloud.finance.service.impl;


import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.cloud.finance.dao.MrcardFinanceCustomerMapper;
import com.microsilver.mrcard.cloud.finance.dic.CommissionFlowType;
import com.microsilver.mrcard.cloud.finance.dto.BounsDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCommissionFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomerExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class MrcardFinanceCustomerService {
	private final static Logger logger = LoggerFactory.getLogger(MrcardFinanceCustomerService.class);

	@Resource
	private MrcardFinanceCustomerMapper customerMapper;

	public int insert(MrcardFinanceCustomer record) {
		return customerMapper.insert(record);
	}


	public int insertSelective(MrcardFinanceCustomer record) {
		return customerMapper.insertSelective(record);
	}

	public boolean addUnrecordMoneyList(List<MrcardFinanceCommissionFlow> list){
		list.forEach((flow)-> addUnrecordMoney(flow));
		return true;
	}

	public boolean addKnightMoneyList(List<MrcardFinanceCommissionFlow> list){
		list.forEach((flow)-> {
			if(CommissionFlowType.SALE_ADVANCE.getIndex() == flow.getType())
				addAdvanceMoney(flow);
			else
				addUnrecordMoney(flow);
		});
		return true;
	}
	/**
	 * 预结算，添加未入账金额
	 * @param commissionFlow
	 * @return
	 */
	@Transactional
	public int addUnrecordMoney(MrcardFinanceCommissionFlow commissionFlow) {
		MrcardFinanceCustomer updateCustomer = getFinanceCustomer(commissionFlow.getFinanceId());
		if(updateCustomer != null){
			//新未入账金额=原未入账金额+新分成的金额
			BigDecimal unmoney = updateCustomer.getUnrecordedAmount();
			updateCustomer.setUnrecordedAmount(unmoney.add(commissionFlow.getCommission().abs()));
		}else{
			logger.error("客户财务资料为空：",commissionFlow);
			return 0;
		}
		//status default value 0
		// updateCustomer.setStatus((byte)0);
		return customerMapper.updateByPrimaryKey(updateCustomer);
	}
	/**
	 * 系统结算，结算部分未入账金额，进行入账（用户可提现）
	 * 	1,未入账金额 -结算入账部分金额
	 * 	2,实际金额 +结算入账部分金额
	 * 	3,总金额变更
	 * @param commissionFlow
	 * @return
	 */
	@Transactional
	public int addRealMoneyFromUnrecordMoney(MrcardFinanceCommissionFlow commissionFlow) {
		MrcardFinanceCustomer updateCustomer = getFinanceCustomer(commissionFlow.getFinanceId());
		if(updateCustomer != null){
			//结算时小心，垫付货款不参加结算
			if(CommissionFlowType.SALE_ADVANCE.getIndex() != commissionFlow.getType()) {
				//未入账金额扣除结算入账部分金额
				BigDecimal unmoney = updateCustomer.getUnrecordedAmount();
				updateCustomer.setUnrecordedAmount(unmoney.subtract(commissionFlow.getCommission()));
				//实际金额+结算入账部分金额,实际金额不变
				BigDecimal realMoney = updateCustomer.getRealAmount();
				updateCustomer.setRealAmount(realMoney.add(commissionFlow.getCommission()));
				//总金额变更
				BigDecimal totalMoney = updateCustomer.getTotalAmount();
				updateCustomer.setTotalAmount(totalMoney.add(commissionFlow.getCommission()));
			}
		}else{
			logger.error("客户财务资料为空：",commissionFlow);
			return 0;
		}
		updateCustomer.setStatus((byte)1);
		return customerMapper.updateByPrimaryKey(updateCustomer);
	}

	/**
	 * 结算出错，则执行钱原路退回
	 * @param commissionFlow
	 * @return
	 */
	@Transactional
	public int addUnrecordMoneyFromRealMoney(MrcardFinanceCommissionFlow commissionFlow) {
		MrcardFinanceCustomer updateCustomer = getFinanceCustomer(commissionFlow.getFinanceId());
		if(updateCustomer != null){
			//结算出错了，要原路退回
			if(CommissionFlowType.SALE_ADVANCE.getIndex() != commissionFlow.getType()) {
				//未入账金额增加
				BigDecimal unmoney = updateCustomer.getUnrecordedAmount();
				updateCustomer.setUnrecordedAmount(unmoney.add(commissionFlow.getCommission()));
				//实际金额减少
				BigDecimal realMoney = updateCustomer.getRealAmount();
				updateCustomer.setRealAmount(realMoney.subtract(commissionFlow.getCommission()));
				//总金额变更
				BigDecimal totalMoney = updateCustomer.getTotalAmount();
				updateCustomer.setTotalAmount(totalMoney.subtract(commissionFlow.getCommission()));
			}
		}else{
			logger.error("客户财务资料为空：",commissionFlow);
			return 0;
		}
		updateCustomer.setStatus((byte)1);
		return customerMapper.updateByPrimaryKey(updateCustomer);
	}
	@Transactional
	public int addRealMoney(MrcardFinanceCommissionFlow commissionFlow) {
		MrcardFinanceCustomer updateCustomer = getFinanceCustomer(commissionFlow.getFinanceId());
		if(updateCustomer != null){
			BigDecimal realMoney = updateCustomer.getRealAmount();
			updateCustomer.setRealAmount(realMoney.add(commissionFlow.getCommission()));
			//总金额变更
			BigDecimal totalMoney = updateCustomer.getTotalAmount();
			updateCustomer.setTotalAmount(totalMoney.add(commissionFlow.getCommission()));
		}else{
			logger.error("客户财务资料为空：",commissionFlow);
			return 0;
		}
		updateCustomer.setStatus((byte)1);
		return customerMapper.updateByPrimaryKey(updateCustomer);
	}

	/**
	 * 添加客户代收货款  货款不进总金额
	 * @param commissionFlow
	 * @return
	 */
	@Transactional
	public int addAdvanceMoney(MrcardFinanceCommissionFlow commissionFlow) {
		MrcardFinanceCustomer updateCustomer = getFinanceCustomer(commissionFlow.getFinanceId());
		if(updateCustomer != null && CommissionFlowType.SALE_ADVANCE.getIndex() == commissionFlow.getType()){
			BigDecimal advance = updateCustomer.getAdvanceAmount();
			updateCustomer.setAdvanceAmount(advance.add(commissionFlow.getCommission()));
		}else{
			logger.error("添加客户代收货款出错：",commissionFlow);
			return 0;
		}
		updateCustomer.setStatus((byte)1);
		return customerMapper.updateByPrimaryKey(updateCustomer);
	}

	@Transactional
	public int withDraw(Long id,BigDecimal money){
		MrcardFinanceCustomer customer = customerMapper.selectByPrimaryKey(id);
		BigDecimal real = customer.getRealAmount();
		customer.setRealAmount(real.subtract(money));
		return customerMapper.updateByPrimaryKey(customer);
	}
	/**
	 * 有推荐人提现
	 * @param id
	 * @param money
	 * @param remId
	 * @param remMoney
	 * @return
	 */
	@Transactional
	public int withDraw(Long id,BigDecimal money,Long remId,BigDecimal remMoney){
		MrcardFinanceCustomer customer = customerMapper.selectByPrimaryKey(id);
		BigDecimal real = customer.getRealAmount();
		customer.setRealAmount(real.subtract(money));
		int result = customerMapper.updateByPrimaryKey(customer);
		
		MrcardFinanceCustomer remCustomer = customerMapper.selectByPrimaryKey(remId);
		BigDecimal remReal = remCustomer.getRealAmount();
		remCustomer.setRealAmount(remReal.add(remMoney));
		BigDecimal total = remCustomer.getTotalAmount();
		remCustomer.setTotalAmount(total.add(remMoney));
		result += customerMapper.updateByPrimaryKey(remCustomer);
		return result;
	}
	@Transactional
	public int withDrawAdvance(Long id,BigDecimal money){
		MrcardFinanceCustomer customer = customerMapper.selectByPrimaryKey(id);
		BigDecimal real = customer.getAdvanceAmount();
		customer.setAdvanceAmount(real.subtract(money));
		return customerMapper.updateByPrimaryKey(customer);
	}

	@Transactional
	public int topUP(Long id,BigDecimal money){
		MrcardFinanceCustomer customer = customerMapper.selectByPrimaryKey(id);
		BigDecimal real = customer.getRealAmount();
		customer.setRealAmount(real.add(money));
		customer.setTotalAmount(customer.getTotalAmount().add(money));
		return customerMapper.updateByPrimaryKey(customer);
	}
	@Transactional
	public int topUPAdvance(Long id,BigDecimal money){
		MrcardFinanceCustomer customer = customerMapper.selectByPrimaryKey(id);
		BigDecimal real = customer.getAdvanceAmount();
		customer.setAdvanceAmount(real.add(money));
		return customerMapper.updateByPrimaryKey(customer);
	}

	

	public MrcardFinanceCustomer getFinanceCustomer(Long financeId) {
		MrcardFinanceCustomer customer = customerMapper.selectByPrimaryKey(financeId);
		return customer;
	}
	public MrcardFinanceCustomer searchFinanceCustomer(long memberId,short identity,long merchId){
		MrcardFinanceCustomer customer = null;
		MrcardFinanceCustomerExample example = new MrcardFinanceCustomerExample();
		example.createCriteria().andMemberIdEqualTo(memberId).andIdentityEqualTo(identity).andMerchIdEqualTo(merchId);
		List<MrcardFinanceCustomer> list = customerMapper.selectByExample(example);
		if(list.size()>0){
			customer = list.get(0);
		}else{
			customer = new MrcardFinanceCustomer();
			customer.setMemberId(memberId);
			customer.setIdentity(identity);
			customer.setMerchId(merchId);
			customer.setCreatTime((int)(System.currentTimeMillis()/1000));
			customer.setStatus((byte)1);
			customer.setTotalAmount(new BigDecimal(0));
			customer.setRealAmount(new BigDecimal(0));
			customer.setAdvanceAmount(new BigDecimal(0));
			customer.setUnrecordedAmount(new BigDecimal(0) );
			customerMapper.insertSelective(customer);
		}
		return customer;
	}

	public MrcardFinanceCustomer getCustomer(long memberId,short identity,long merchId){
		MrcardFinanceCustomer customer = null;
		MrcardFinanceCustomerExample example = new MrcardFinanceCustomerExample();
		example.createCriteria().andMemberIdEqualTo(memberId).andIdentityEqualTo(identity).andMerchIdEqualTo(merchId);
		List<MrcardFinanceCustomer> list = customerMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			throw new NullPointerException("缺少客户财务资料");
		}
		return list.get(0);
	}
	public List<MrcardFinanceCustomer> getCustomer(List<Long> merchIds){
		logger.info("search customer id : {}", JSON.toJSONString(merchIds));
		MrcardFinanceCustomerExample example = new MrcardFinanceCustomerExample();
		if(merchIds != null && merchIds.size() == 1)
			example.createCriteria().andMerchIdEqualTo(merchIds.get(0));
		else if(merchIds != null && merchIds.size()>1)
			example.createCriteria().andMerchIdIn(merchIds);

		List<MrcardFinanceCustomer> list = customerMapper.selectByExample(example);
		return list;
	}
}

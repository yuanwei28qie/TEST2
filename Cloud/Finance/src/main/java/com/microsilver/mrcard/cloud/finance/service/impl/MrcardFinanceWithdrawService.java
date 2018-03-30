package com.microsilver.mrcard.cloud.finance.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microsilver.mrcard.cloud.finance.dic.MerchFlowType;
import com.microsilver.mrcard.cloud.finance.dto.FinanceMerchFlowResultDto;
import com.microsilver.mrcard.cloud.finance.dto.MerchFlowDBSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.MerchFlowSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.WithdrawDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchFlowExample;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceSettlement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Jade
 * @Description 提现操作
 * @create 2017-08-02 下午 5:24
 * @Copyright Micro Silver
 **/

@Service
public class MrcardFinanceWithdrawService {
    private final static Logger logger = LoggerFactory.getLogger(MrcardFinanceWithdrawService.class);

    @Resource
    MrcardFinanceCustomerService customerService;

    @Resource
    MrcardFinanceMerchFlowService merchFlowService;


    public PageInfo<MrcardFinanceMerchFlow> searchMerchFlow(MerchFlowSearchDto flowSearch){
        MrcardFinanceMerchFlowExample condition = new MrcardFinanceMerchFlowExample();
        MrcardFinanceMerchFlowExample.Criteria criteria = condition.createCriteria();
        if(flowSearch.getType() != null && 0 != flowSearch.getType())
            criteria.andTypeEqualTo(flowSearch.getType());
        if(flowSearch.getOrdersn() != null)
            criteria.andOrdersnEqualTo(flowSearch.getOrdersn());
        if(flowSearch.getFinanceId() != null)
            criteria.andFinanceIdEqualTo(flowSearch.getFinanceId());
        if(flowSearch.getBeginTime() != null && flowSearch.getEndTime() != null)
            criteria.andCreateTimeBetween(flowSearch.getBeginTime(),flowSearch.getEndTime());
        condition.setOrderByClause(" create_time desc ");
        Page page = PageHelper.startPage(flowSearch.getPageNum(), flowSearch.getPageSize()).doSelectPage(()->merchFlowService.selectByExample(condition));
        PageInfo<MrcardFinanceMerchFlow> pageInfo = new PageInfo<>(page);
        return pageInfo;
    }

    private MrcardFinanceMerchFlow searchMerchFlowByBussId(String ordersn){
        List<MrcardFinanceMerchFlow> snList = searchMerchFlowListByBussId(ordersn);
        if(snList == null || snList.size() == 0){
            return null;
        }else{
            return snList.get(0);
        }
    }
    private List<MrcardFinanceMerchFlow> searchMerchFlowListByBussId(String ordersn){
        MrcardFinanceMerchFlowExample condition = new MrcardFinanceMerchFlowExample();
        condition.createCriteria().andOrdersnEqualTo(ordersn);
        List<MrcardFinanceMerchFlow> snList = merchFlowService.selectByExample(condition);
        return snList;
    }


    @Transactional
    public Long withdraw(WithdrawDto withdraw) throws Exception {
        MrcardFinanceMerchFlow record = searchMerchFlowByBussId(withdraw.getOrdersn());
        if(record != null) {
            logger.info("重复的提现申请{}-{}", withdraw.getOrdersn() ,JSON.toJSONString(withdraw));
            throw new Exception("重复的提现申请");
        }else
            logger.info("提现申请{}-{}", withdraw.getOrdersn() ,JSON.toJSONString(withdraw));
        //添加客户财务流水
        MrcardFinanceMerchFlow merchFlow = new MrcardFinanceMerchFlow();
        merchFlow.setFinanceId(withdraw.getFinanceId());
        merchFlow.setRemark("提现扣款");
        merchFlow.setType((byte) MerchFlowType.WITHDRAW.getValue());

        //提现金额  -xxx
        BigDecimal draw = new BigDecimal(0).subtract(withdraw.getAmount());
        merchFlow.setAmount(draw);
        merchFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
        merchFlow.setOrdersn(withdraw.getOrdersn());
        merchFlowService.insertMerchFlowRecord(merchFlow);

        customerService.withDraw(withdraw.getFinanceId(),withdraw.getAmount());
        return merchFlow.getId();
    }

    /**
     * 拒绝提现，退款
     */
    @Transactional
    public boolean topUP(String ordersn){
        //根据业务Id获取详细信息
        List<MrcardFinanceMerchFlow> recordList = searchMerchFlowListByBussId(ordersn);
        if(recordList.isEmpty()) {
            logger.info("退款申请记录[{}]不存在",ordersn);
            throw new NullPointerException("退款申请ID不存在");
        }else
            logger.info("拒绝退款申请 [{}]",ordersn);

        BigDecimal rt = new BigDecimal(0);
        Long financeId = 0L;
        for (MrcardFinanceMerchFlow record : recordList) {
            
            MrcardFinanceMerchFlow merchFlow = new MrcardFinanceMerchFlow();
            merchFlow.setFinanceId(record.getFinanceId());
            
            merchFlow.setOrdersn(ordersn);
            merchFlow.setType((byte) MerchFlowType.REFUND.getValue());
            merchFlow.setCreateTime((int) (System.currentTimeMillis() / 1000));
            merchFlow.setAmount(new BigDecimal(0).subtract(record.getAmount()));
            if(record.getType()==52) {
            	//推荐提现返点
            	merchFlow.setRemark("推荐用户提现退款,分润返还");
            	customerService.topUP(merchFlow.getFinanceId(),merchFlow.getAmount());
            }else {
            	merchFlow.setRemark("提现退款");
            	//添加客户财务流水
            	if(financeId == 0L)
                    financeId = record.getFinanceId();
	            rt = rt.add(merchFlow.getAmount());
            }
            merchFlowService.insertMerchFlowRecord(merchFlow);
        }
        int num = customerService.topUP(financeId,rt);
        if(num >0)
            return true;
        return false;
    }

    @Transactional
    public Long withdrawByKnight(MrcardFinanceSettlement settlement) throws Exception {
        //添加客户财务流水
        MrcardFinanceMerchFlow merchFlow = new MrcardFinanceMerchFlow();
        merchFlow.setFinanceId(settlement.getFinanceId());
        merchFlow.setRemark("收入结算");
        merchFlow.setType((byte) MerchFlowType.WITHDRAWSYS.getValue());

        //提现金额  -xxx
        BigDecimal draw = new BigDecimal(0).subtract(settlement.getTotalAmount());
        merchFlow.setAmount(draw);
        merchFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
        merchFlow.setOrdersn(settlement.getSettlementsn());
        merchFlowService.insertMerchFlowRecord(merchFlow);

        customerService.withDraw(settlement.getFinanceId(),settlement.getTotalAmount());
        return merchFlow.getId();
    }

    @Transactional
    public Long withdrawByAdvance(WithdrawDto withdraw) throws Exception {
        MrcardFinanceMerchFlow record = searchMerchFlowByBussId(withdraw.getOrdersn());
        if(record != null) {
            logger.info("重复的提现申请{}-{}", withdraw.getOrdersn() ,JSON.toJSONString(withdraw));
            throw new Exception("重复的提现申请");
        }else
            logger.info("提现申请{}-{}", withdraw.getOrdersn() ,JSON.toJSONString(withdraw));
        //添加客户财务流水
        MrcardFinanceMerchFlow merchFlow = new MrcardFinanceMerchFlow();
        merchFlow.setFinanceId(withdraw.getFinanceId());
        merchFlow.setRemark("提现流水");
        merchFlow.setType((byte) MerchFlowType.WITHDRAW.getValue());

        //提现金额  -xxx
        BigDecimal draw = new BigDecimal(0).subtract(withdraw.getAmount());
        merchFlow.setAmount(draw);
        merchFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
        merchFlow.setOrdersn(withdraw.getOrdersn());
        merchFlowService.insertMerchFlowRecord(merchFlow);

        customerService.withDrawAdvance(withdraw.getFinanceId(),withdraw.getAmount());
        return merchFlow.getId();
    }


    /**
     * 拒绝提现，退款
     */
    @Transactional
    public boolean topUPByKnight(String ordersn){
        //根据业务Id获取详细信息
        MrcardFinanceMerchFlow record = searchMerchFlowByBussId(ordersn);

        if(record == null) {
            logger.info("退款申请记录[{}]不存在",ordersn);
            throw new NullPointerException("退款申请ID不存在");
        }else
            logger.info("拒绝退款申请 [{}]",ordersn);

        BigDecimal refound = new BigDecimal(0).subtract(record.getAmount());

        //添加客户财务流水
        MrcardFinanceMerchFlow merchFlow = new MrcardFinanceMerchFlow();
        merchFlow.setFinanceId(record.getFinanceId());
        merchFlow.setRemark("提现退款【系统】");
        merchFlow.setOrdersn(ordersn);
        merchFlow.setType((byte) MerchFlowType.WITHDRAW.getValue());
        merchFlow.setAmount(refound);
        merchFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
        merchFlowService.insertMerchFlowRecord(merchFlow);

        int num = customerService.topUP(record.getFinanceId(),refound);
        if(num >0)
            return true;
        return false;
    }

    /**
     * 拒绝提现，退款
     */
    @Transactional
    public boolean topUPByAdvance(String ordersn){
        //根据业务Id获取详细信息
        MrcardFinanceMerchFlow record = searchMerchFlowByBussId(ordersn);

        if(record == null) {
            logger.info("退款申请记录[{}]不存在",ordersn);
            throw new NullPointerException("退款申请ID不存在");
        }else
            logger.info("拒绝退款申请 [{}]",ordersn);

        BigDecimal refound = new BigDecimal(0).subtract(record.getAmount());

        //添加客户财务流水
        MrcardFinanceMerchFlow merchFlow = new MrcardFinanceMerchFlow();
        merchFlow.setFinanceId(record.getFinanceId());
        merchFlow.setRemark("提现退款");
        merchFlow.setOrdersn(ordersn);
        merchFlow.setType((byte) MerchFlowType.WITHDRAW.getValue());
        merchFlow.setAmount(refound);
        merchFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
        merchFlowService.insertMerchFlowRecord(merchFlow);

        int num = customerService.topUPAdvance(record.getFinanceId(),refound);
        if(num >0)
            return true;
        return false;
    }
}

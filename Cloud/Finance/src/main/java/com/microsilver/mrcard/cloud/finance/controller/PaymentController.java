package com.microsilver.mrcard.cloud.finance.controller;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.cloud.finance.dic.MerchFlowType;
import com.microsilver.mrcard.cloud.finance.dto.PaymentDto;
import com.microsilver.mrcard.cloud.finance.dto.WithdrawDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceTransactionFlow;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceCustomerService;
import com.microsilver.mrcard.cloud.finance.service.impl.MrcardFinanceMerchFlowService;
import com.microsilver.mrcard.cloud.finance.service.impl.TransactionFlowService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Name com.microsilver.mrcard.cloud.finance.controller.PaymentController
 * @Description 钱包支付相关接口
 * 账户控制相关：
 * @Author Jade
 * @Version 2017/10/18
 * @Copyright Micro Silver
 */
@RestController
@RequestMapping("/finance/transaction/")
public class PaymentController {
    private final static Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private MrcardFinanceCustomerService mrcardFinanceCustomerService;

    @Autowired
    private TransactionFlowService transactionFlowService;

    @Autowired
    private MrcardFinanceMerchFlowService mrcardFinanceMerchFlowService;
    

    private static BigDecimal POINTS = new BigDecimal("0.006");
    private static BigDecimal REM_POINTS = new BigDecimal("0.050");

    /**
     * 向钱包充值，
     *      公司账户先收取客户充值的金额
     *      此接口，只接收充值成功回调，并把钱添加到客户realMoney中
     */
   
    
    
    @PostMapping(value = "recharge")
    public Boolean Recharge(@RequestBody PaymentDto recharege) throws Exception {
        logger.info("充值:{}",JSON.toJSONString(recharege));
        MrcardFinanceCustomer customer = mrcardFinanceCustomerService.searchFinanceCustomer(recharege.getMemberId(),recharege.getIdentity(),recharege.getMerchId());
        recharege.setFinanceId(customer.getId());
        //check transflow
        if(transactionFlowService.isExistsTransFlow(recharege.getTransactionNo())){
            logger.error("重复的交易记录");
            return true;
        }else if(recharege.getAmount().intValue() < 0){
            logger.error("充值金额必需大于零");
            throw new Exception("充值金额必需大于零");
        }else{
            MrcardFinanceTransactionFlow transFlow = new MrcardFinanceTransactionFlow();
            transFlow.setMemberId(recharege.getMemberId());
            transFlow.setAmount(recharege.getAmount());
            transFlow.setPayType(recharege.getPayType());
            transFlow.setTransType(recharege.getTransType());
            transFlow.setTransactionNo(recharege.getTransactionNo());
            transFlow.setOrdersn(recharege.getOrdersn());
            transFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
            transFlow.setIsSuccess((byte)1);
            transFlow.setRemark(recharege.getRemark());
            logger.info("充值交易记录:{}",JSON.toJSONString(transFlow));
            transactionFlowService.addTransFlow(transFlow);
        }
        //添加客户财务流水
        MrcardFinanceMerchFlow merchFlow = new MrcardFinanceMerchFlow();
        merchFlow.setOrdersn(recharege.getOrdersn());
        merchFlow.setFinanceId(recharege.getFinanceId());
        merchFlow.setRemark(recharege.getRemark());
        merchFlow.setType((byte) MerchFlowType.RECHARGE.getValue());
        merchFlow.setIsSettl(true);
        merchFlow.setAmount(recharege.getAmount());
        merchFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
        mrcardFinanceMerchFlowService.insertMerchFlowRecord(merchFlow);
        logger.info("充值财务记录:{}",JSON.toJSONString(merchFlow));
        mrcardFinanceCustomerService.topUP(recharege.getFinanceId(),recharege.getAmount());
        return true;
    }


    /**
     * 提现，客户提现收取6‰手续费
     *      客户提现申请，扣6‰手续费（支付时，三方机构收取公司6‰手续费）
     *      返回提现申请单号
     */
    @PostMapping(value = "withdrawals")
    public Long Withdrawals(@RequestBody WithdrawDto withdraw) throws Exception {
        logger.info("提现:{}",JSON.toJSONString(withdraw));
        MrcardFinanceCustomer customer = mrcardFinanceCustomerService.searchFinanceCustomer(withdraw.getMemberId(),withdraw.getIdentity(),withdraw.getMerchId());
        withdraw.setFinanceId(customer.getId());
        //提现金额=用户提现+系统扣款
        BigDecimal total = withdraw.getAmount().add(withdraw.getAmount().multiply(POINTS.add(REM_POINTS)));

        if(withdraw.getAmount().intValue() < 10){
            logger.error("提现金额必需大于10元");
            throw new Exception("提现金额必需大于10元");
        }else if(customer.getRealAmount().doubleValue() < total.doubleValue()){
            logger.error("余额不足，无法提现");
            throw new Exception("余额不足，无法提现");
        }else{
        	MrcardFinanceMerchFlow merchFlow = new MrcardFinanceMerchFlow();
           synchronized(merchFlow) {
        	   //添加客户财务流水
               merchFlow.setOrdersn(withdraw.getOrdersn());
               merchFlow.setFinanceId(withdraw.getFinanceId());
               merchFlow.setRemark(withdraw.getRemark());
               merchFlow.setType((byte) MerchFlowType.WITHDRAW.getValue());
               merchFlow.setIsSettl(true);
               merchFlow.setAmount(new BigDecimal(0).subtract(withdraw.getAmount()));
               merchFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
               mrcardFinanceMerchFlowService.insertMerchFlowRecord(merchFlow);
               //logger.info("提现财务记录:{}",JSON.toJSONString(merchFlow));
               //系统扣点流水
               MrcardFinanceMerchFlow pointsFlow = new MrcardFinanceMerchFlow();
               pointsFlow.setOrdersn(withdraw.getOrdersn());
               pointsFlow.setFinanceId(withdraw.getFinanceId());
               pointsFlow.setRemark("提现手续费");
               pointsFlow.setType((byte) MerchFlowType.WITHDRAW.getValue());
               pointsFlow.setIsSettl(true);
               pointsFlow.setAmount(new BigDecimal(0).subtract(withdraw.getAmount().multiply(POINTS.add(REM_POINTS))));
               pointsFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
               mrcardFinanceMerchFlowService.insertMerchFlowRecord(pointsFlow);
               //logger.info("提现财务记录:{}",JSON.toJSONString(pointsFlow));
               //推荐用户返点
               if(withdraw.getRefereeId()!=null) {
   	            MrcardFinanceMerchFlow remPointsFlow = new MrcardFinanceMerchFlow();
   	            MrcardFinanceCustomer remCustomer = mrcardFinanceCustomerService.searchFinanceCustomer(withdraw.getRefereeId(),(short)0,0L);
   	            remPointsFlow.setOrdersn(withdraw.getOrdersn());
   	            remPointsFlow.setFinanceId(remCustomer.getId());
   	            remPointsFlow.setRemark("推荐用户提现返点");
   	            remPointsFlow.setType((byte) 52);
   	            remPointsFlow.setIsSettl(true);
   	            remPointsFlow.setAmount(withdraw.getAmount().multiply(REM_POINTS));
   	            remPointsFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
   	            mrcardFinanceMerchFlowService.insertMerchFlowRecord(remPointsFlow);
   	            mrcardFinanceCustomerService.withDraw(withdraw.getFinanceId(),total,remCustomer.getId(),remPointsFlow.getAmount());
   	            logger.info("财务用户:{}提现,金额:{},平台手续费：{},推荐人：{}，分润:{}",customer.getId(),withdraw.getAmount(),pointsFlow.getAmount(),remPointsFlow.getFinanceId(),remPointsFlow.getAmount());
               }else {
               	mrcardFinanceCustomerService.withDraw(withdraw.getFinanceId(),total);
               	logger.info("财务用户:{}提现,金额:{},平台手续费：{}",customer.getId(),withdraw.getAmount(),pointsFlow.getAmount());
               }
               return merchFlow.getId();
           }
           
        }
    }

    /**
     * 支付 ，钱包只能够买公司相关产品
     *      扣取客户订单金额，不收手续费
     *      不再向订单已方增加订单金额，已方金额在结算时自动增加
     */
    @PostMapping(value = "payment")
    public Long Payment(@RequestBody PaymentDto payment) throws Exception {
        logger.info("支付:{}",JSON.toJSONString(payment));
        MrcardFinanceCustomer customer = mrcardFinanceCustomerService.searchFinanceCustomer(payment.getMemberId(),payment.getIdentity(),payment.getMerchId());
        payment.setFinanceId(customer.getId());
        if(payment.getAmount().doubleValue() < 0) {
            logger.error("支付金额小于零");
            throw new Exception("支付金额必需大于零");
        }else if(customer.getRealAmount().doubleValue() <= payment.getAmount().doubleValue()){
            logger.error("请求支付,余额不足");
            throw new Exception("请求支付,余额不足");
        }else if(1  == payment.getPayType() && 1 == payment.getTransType()){
            //添加客户财务流水
            MrcardFinanceMerchFlow merchFlow = new MrcardFinanceMerchFlow();
            merchFlow.setOrdersn(payment.getOrdersn());
            merchFlow.setFinanceId(payment.getFinanceId());
            merchFlow.setRemark(payment.getRemark());
            merchFlow.setType((byte) MerchFlowType.BUY.getValue());
            merchFlow.setIsSettl(true);
            merchFlow.setAmount(new BigDecimal(0).subtract(payment.getAmount()));
            merchFlow.setCreateTime((int) (System.currentTimeMillis()/1000));
            mrcardFinanceMerchFlowService.insertMerchFlowRecord(merchFlow);
            logger.info("支付财务记录:{}",JSON.toJSONString(merchFlow));
            mrcardFinanceCustomerService.withDraw(payment.getFinanceId(),payment.getAmount());
            return merchFlow.getId();
        }
        return 0L;
    }


    /**
     * 调用接口失败，则使用此接口回调，退回原来的金额
     */
    @PostMapping(value = "refund")
    public Boolean refund(Short identity ,Long memberId,Long merchId,Long ordersn) throws Exception {
        logger.info("支付退款:{}-{}-{}-{}",identity,memberId,merchId,ordersn);
        MrcardFinanceCustomer customer = mrcardFinanceCustomerService.searchFinanceCustomer(memberId,identity,merchId);
        //根据单号查询原单据
        MrcardFinanceMerchFlow flow = mrcardFinanceMerchFlowService.selectByPrimaryKey(ordersn);
        //检查是否已经有退款记录
        List<String> arr = new ArrayList<>();
        arr.add(ordersn+"");
        List<MrcardFinanceMerchFlow> refundList = mrcardFinanceMerchFlowService.selectByOrderSn(arr);
        if(null == flow || !customer.getId().equals(flow.getFinanceId())){
            logger.error("不存在业务单号 : "+ordersn);
            throw new Exception("不存在业务单号"+ordersn);
        }else if(4 != flow.getType()){
            logger.error("退款业务类型不正确 : "+ordersn);
            throw new Exception("退款业务类型不正确");
        }else if (null != refundList && !refundList.isEmpty() && ordersn.toString().equals(refundList.get(0).getOrdersn())){//refundList 只可能存在一条记录
            logger.error("重复操作退款 : "+ordersn);
            throw new Exception("重复操作退款"+ordersn);
        }else{
            flow.setType((byte) MerchFlowType.REFUND.getValue());
            flow.setId(null);
            flow.setRemark(flow.getRemark()+" 订单系统退款");
            flow.setAmount(new BigDecimal(0).subtract(flow.getAmount()));
            flow.setOrdersn(ordersn+"");
            mrcardFinanceMerchFlowService.insertMerchFlowRecord(flow);
            logger.info("退款财务记录:{}",JSON.toJSONString(flow));
            mrcardFinanceCustomerService.topUP(customer.getId(),flow.getAmount());
            return true;
        }
    }
}

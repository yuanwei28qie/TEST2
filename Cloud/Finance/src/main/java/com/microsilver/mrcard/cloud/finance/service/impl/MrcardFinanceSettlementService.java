package com.microsilver.mrcard.cloud.finance.service.impl;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microsilver.mrcard.cloud.finance.core.BussUtils;
import com.microsilver.mrcard.cloud.finance.core.Consts;
import com.microsilver.mrcard.cloud.finance.dao.MrcardFinanceSettlementMapper;
import com.microsilver.mrcard.cloud.finance.dic.CommissionFlowType;
import com.microsilver.mrcard.cloud.finance.dto.CarryoverKnightDto;
import com.microsilver.mrcard.cloud.finance.dto.MerchFlowSearchDto;
import com.microsilver.mrcard.cloud.finance.dto.SettlementSearchDto;
import com.microsilver.mrcard.cloud.finance.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MrcardFinanceSettlementService {
    private final static Logger logger = LoggerFactory.getLogger(MrcardFinanceSettlementService.class);
    @Autowired
    MrcardFinanceSettlementMapper settlementMapper;
    @Autowired
    MrcardFinanceCommissionService commissionService;
    @Autowired
    MrcardFinanceMerchFlowService merchFlowService;
    @Autowired
    MrcardFinanceCustomerService customerService;


    public PageInfo<MrcardFinanceSettlement> searchSettlement(SettlementSearchDto searchDto){
        MrcardFinanceSettlementExample example  = new MrcardFinanceSettlementExample();
        MrcardFinanceSettlementExample.Criteria criteria = example.createCriteria();
        if(searchDto.getBeginTime() != null && searchDto.getEndTime() != null){
            criteria.andCreateTimeBetween(searchDto.getBeginTime(),searchDto.getEndTime());
        }
        if(searchDto.getStatus() != null){
            criteria.andStatusEqualTo(searchDto.getStatus());
        }

        Page<MrcardFinanceSettlement> page = PageHelper.startPage(searchDto.getPageNum(), Consts.PAGE_SIZE).doSelectPage(()->settlementMapper.selectByExample(example));
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }

    public MrcardFinanceSettlement getSettlementByExamine(Long finId){
        MrcardFinanceSettlementExample example  = new MrcardFinanceSettlementExample();
        example.createCriteria().andStatusEqualTo((byte)0).andFinanceIdEqualTo(finId);
        List<MrcardFinanceSettlement> list =settlementMapper.selectByExample(example);
        if(null != list && list.size() == 1)
            return list.get(0);
        return null;
    }

    /**
     * 查询侍审核的结转单据
     * @param settlementSn
     * @return
     */
    public MrcardFinanceSettlement selectBYSettlement(String settlementSn){
        logger.debug("查询已经结转完成的订单："+settlementSn);
        MrcardFinanceSettlementExample example = new MrcardFinanceSettlementExample();
        example.createCriteria().andSettlementsnEqualTo(settlementSn).andStatusEqualTo((byte)0);
        List<MrcardFinanceSettlement> list = settlementMapper.selectByExample(example);
        if(null != list && !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    /**
     * 改变结转单据状态
     * @param settlement
     * @return
     */
    public Boolean changeSettlementByStatus(MrcardFinanceSettlement settlement){
        int num = settlementMapper.updateByPrimaryKey(settlement);
        return num > 0 ? true : false;
    }

    /**
     * 结转单生成
     * @param carryoverKnightDto
     * @return
     */
    @Transactional
    public String carryoverByKnight(CarryoverKnightDto carryoverKnightDto) {
        List<MrcardFinanceCommissionFlow> carryoverList = commissionService.getCommissionFlowByOrderSn(carryoverKnightDto.getSnList());
        MrcardFinanceCustomer knight = customerService.getCustomer(carryoverKnightDto.getMemberId(), carryoverKnightDto.getIdentity(), carryoverKnightDto.getMerchId());
        BigDecimal oldRealMoney = knight.getRealAmount();
        BigDecimal sumAdvance = new BigDecimal(0);//垫付
        BigDecimal sumTip = new BigDecimal(0);//小费
        BigDecimal sumDispatch = new BigDecimal(0);//运费
        BigDecimal sumPlatform = new BigDecimal(0);//平台抽成
        List<String> orderSnList = new ArrayList<>();
        logger.debug("结转单分成单据", JSON.toJSONString(carryoverList));
        for (MrcardFinanceCommissionFlow flowCopy : carryoverList) {
            if (!orderSnList.contains(flowCopy.getOrdersn())) {
                orderSnList.add(flowCopy.getOrdersn());
            }
            if (flowCopy.getFinanceId().equals(knight.getId()) && CommissionFlowType.SALE_ADVANCE.getName().equals(flowCopy.getRemark())) {//垫付货款
                sumAdvance = sumAdvance.add(flowCopy.getCommission());
            } else if (flowCopy.getFinanceId().equals(knight.getId()) && CommissionFlowType.SALE_TIP.getName().equals(flowCopy.getRemark())) {//销售收入
                sumDispatch = sumDispatch.add(flowCopy.getCommission());
            } else if (flowCopy.getFinanceId().equals(knight.getId()) && CommissionFlowType.SALE_NONE.getName().equals(flowCopy.getRemark())) {//小费
                sumTip = sumTip.add(flowCopy.getCommission());
            } else if (!flowCopy.getFinanceId().equals(knight.getId())) {//平台抽成
                sumPlatform = sumPlatform.add(flowCopy.getCommission());
            }
            /**
             * 变更账户资金 ，只能根据commissionFlow来进行变更，否则使用calList会出现数据不一致
             *  @2017-09-22账户资金变更迁移到生成结转单据处进行变更
             */
            if(flowCopy.getCommission().doubleValue() > 0)
            customerService.addRealMoneyFromUnrecordMoney(flowCopy);
        }

        BigDecimal total = new BigDecimal(0).add(sumDispatch).add(sumTip);

        MrcardFinanceSettlement settlement = new MrcardFinanceSettlement();
        settlement.setFinanceId(knight.getId());
        settlement.setSettlementsn(BussUtils.createBatchNo());
        settlement.setAccountPeriodBegin(carryoverKnightDto.getBeginTime().intValue());
        settlement.setAccountPeriodEnd(carryoverKnightDto.getEndTime().intValue());
        settlement.setAdvanceAmount(sumAdvance);
        settlement.setDispatchAmount(sumDispatch);
        settlement.setTipAmount(sumTip);
        settlement.setPumpingAmount(sumPlatform);
        settlement.setTotalAmount(total);
        settlement.setStatus((byte) 0);
        settlement.setCreateTime((int) (System.currentTimeMillis() / 1000));

        //校验，收入是否与客户账户相等 代收货款不能比较，用户不定时提现代收货款
        MrcardFinanceCustomer knight2  = customerService.getCustomer(carryoverKnightDto.getMemberId(), carryoverKnightDto.getIdentity(), carryoverKnightDto.getMerchId());
        BigDecimal addReal = knight2.getRealAmount().subtract(oldRealMoney);
        if (total.equals(addReal)) {
            logger.info("结转校验通过,生成结转单", JSON.toJSONString(settlement));
            settlementMapper.insertSelective(settlement);
            carryoverStatus(carryoverKnightDto.getSnList(),true);
            return settlement.getSettlementsn();
        }else{
            logger.error("结转校验出错：",JSON.toJSONString(knight2), JSON.toJSONString(settlement));
            carryoverStatus(carryoverKnightDto.getSnList(),false);
            //结算出错了 ，钱要原路退回
            logger.info("结转出错，钱原路退回:",JSON.toJSONString(carryoverList));
            carryoverList.stream().filter((ck)->ck.getCommission().doubleValue()>0).forEach((ck)->{customerService.addUnrecordMoneyFromRealMoney(ck);});
        }
        return null;
    }

    private void carryoverStatus(List<String> snList,Boolean status){
        //改变流水单的结转状态，等待财务打款
        merchFlowService.updateMerchFlowStatus(snList,status);
    }

    public boolean deleteBySettlement(long id ){
        int num = settlementMapper.deleteByPrimaryKey(id);
        return num >0?true:false;
    }

}
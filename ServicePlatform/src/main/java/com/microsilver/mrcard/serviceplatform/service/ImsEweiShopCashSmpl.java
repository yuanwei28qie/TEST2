package com.microsilver.mrcard.serviceplatform.service;

import com.microsilver.mrcard.cloud.finance.dto.WithdrawDto;
import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopCashMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopCash;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name com.microsilver.mrcard.serviceplatform.service.ImsEweiShopCashSmpl
 * @Description 会员提现单操作
 * @Author Jade
 * @Version 2017/10/24
 * @Copyright Micro Silver
 */
@Service
public class ImsEweiShopCashSmpl {

     @Autowired
    ImsEweiShopCashMapper imsEweiShopCashMapper;


     
    /**
     * time:2018.03.16
     * @param withdraw
     * @return
     */
    public ImsEweiShopCash createCashBill(WithdrawDto withdraw){
        ImsEweiShopCash cash = new ImsEweiShopCash();
        cash.setOrdersn(Utils.createOrderSn("TX"));
        cash.setMemberid(withdraw.getMemberId());
        cash.setMerchid(withdraw.getMerchId());
        cash.setIdentity((int) withdraw.getIdentity());
        cash.setBankname("支付宝");
        cash.setBankcard(withdraw.getAlipay());
        cash.setMoneys(withdraw.getAmount());
        cash.setCreatetime(System.currentTimeMillis()/1000);
        cash.setRemark("会员提现");
        cash.setType(1);
        if(withdraw.getAmount().compareTo(new BigDecimal(Consts.MEMBER_CASH_NO_CHECK_MAX))<=0) {
        	cash.setStatus(0);
		}else {
			cash.setStatus(0);
		}
        cash.setIdentity(0);
        cash.setPayrates(0);
        cash.setCashType(4);
        imsEweiShopCashMapper.insertSelective(cash);
        return cash;
    }

    public Boolean checkCashBill(){
        return false;
    }
    /**
     * 统计用户当天的提现金额（不计算不通过的）
     * @param memberId
     * @return
     */
    public BigDecimal countMemberCashMoenyByTime(Long memberId) {
    	ImsEweiShopCash shopCash = new ImsEweiShopCash();
    	shopCash.setMemberid(memberId);
    	shopCash.setMerchid(0L);
    	shopCash.setIdentity(0);
    	shopCash.setCreatetime(Long.valueOf(Utils.getDayBeginTimestamp()));
    	shopCash.setFinshtime(Long.valueOf(Utils.getCurrentTime()));
    	return imsEweiShopCashMapper.countCashMoenyByTime(shopCash);
    }
}

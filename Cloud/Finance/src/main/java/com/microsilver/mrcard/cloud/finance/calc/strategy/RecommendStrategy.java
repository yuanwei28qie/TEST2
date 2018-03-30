package com.microsilver.mrcard.cloud.finance.calc.strategy;

import com.microsilver.mrcard.cloud.finance.calc.CommissionStrategy;
import com.microsilver.mrcard.cloud.finance.dic.AgentLevelEnum;
import com.microsilver.mrcard.cloud.finance.dto.BounsDto;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.CustomerDto;
import com.microsilver.mrcard.cloud.finance.dto.ProportionDto;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Name com.microsilver.mrcard.cloud.finance.calc.strategy.RecommendStrategy
 * @Description 会员充值 ，推荐人获取分成收益
 * @Author Jade
 * @Version 2017/11/23
 * @Copyright Micro Silver
 */
public class RecommendStrategy extends CalcMerch implements CommissionStrategy {
    @Override
    public List<BounsDto> calculatorBouns(CommissionDto commission, ProportionDto proportion) throws Exception {

        List<BounsDto> list = new ArrayList<BounsDto>();
        //充值订单
        String orderSn = commission.getOrderSn();
        //充值金额
        BigDecimal total = commission.getTotalAmount();
        //推荐人列表
        CustomerDto[] rlist = commission.getParentCustomer();
        //平台
        BigDecimal rMoney = new BigDecimal(0);
        CustomerDto platform = null;
        //推荐人获取推荐金额
        for (CustomerDto dto : rlist){
            if(AgentLevelEnum.getEnumValue(dto.getIdentity()) != AgentLevelEnum.AGENT_PLATFORM && dto.getMemberId() > 0) {
            	BigDecimal prop = new BigDecimal(dto.getProportion());
            	prop = prop.divide(new BigDecimal(100));
            	
                BigDecimal recomendMoney = total.multiply(prop);
                BigDecimal frm = new BigDecimal(decimalFormat.format(recomendMoney));
                rMoney = rMoney.add(frm);
                BounsDto db = new BounsDto(dto, orderSn, frm);
                list.add(db);
            }else{
                platform = dto;
            }
        }
        //平台获取金额
        BounsDto plat = new BounsDto(platform,orderSn,total.subtract(rMoney));
        list.add(plat);
        return list;
    }
}

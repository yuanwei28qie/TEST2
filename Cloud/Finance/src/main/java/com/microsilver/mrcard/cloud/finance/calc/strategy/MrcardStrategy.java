package com.microsilver.mrcard.cloud.finance.calc.strategy;

import com.microsilver.mrcard.cloud.finance.calc.CommissionStrategy;
import com.microsilver.mrcard.cloud.finance.dic.AgentLevelEnum;
import com.microsilver.mrcard.cloud.finance.dto.BounsDto;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.CustomerDto;
import com.microsilver.mrcard.cloud.finance.dto.ProportionDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jade
 * @Description 卡先生结算算法
 * @create 2017-08-02 上午 11:40
 * @Copyright Micro Silver
 **/

public class MrcardStrategy extends CalcMerch implements CommissionStrategy {

    @Override
    public List<BounsDto> calculatorBouns(CommissionDto commission , ProportionDto proportion) throws Exception {
        super.initProportion(proportion);

        List<BounsDto> list = new ArrayList<BounsDto>();

        String orderSn = commission.getOrderSn();
        //商户
        BounsDto mb = calculatorMerchBounds(commission);
        list.add(mb);

        //统计除平台以外的分成
        BigDecimal plat = new BigDecimal(0);

        /**
         *先排序，后计算
         * 1，排序：代理级别由小到大，不能改变
         * 2，计算：先算代理，最后算平台
         */

        CustomerDto[] cus = CustomerReSort(commission.getParentCustomer(), commission.getKeyWord());
        for(CustomerDto c : cus){
            switch (AgentLevelEnum.getEnumValue(c.getIdentity())) {
                case MRCARD_WARRIOR:
                    BounsDto mw = calculatorWarriorBounds(c,orderSn);
                    list.add(mw);

                    plat = plat.add(mw.getBouns());
                    break;
                case MRCARD_COUNTRY:
                    BounsDto mcoun = calculatorCountryBounds(c,orderSn);
                    list.add(mcoun);

                    plat = plat.add(mcoun.getBouns());
                    break;
                case MRCARD_VIP:
                    BounsDto mcity = calculatorVIPBounds(c,orderSn);
                    list.add(mcity);

                    plat = plat.add(mcity.getBouns());
                    break;
                case MRCARD_KNIGHT:
                    BounsDto mpro = calculatorKnightBounds(c,orderSn);
                    list.add(mpro);

                    plat = plat.add(mpro.getBouns());
                    break;
                case MRCARD_PLATFORM:
//            //算法1
//            BounsDto mplat = calculatorPlatformBounds(c,orderSn);
//            list.add(mplat);
                    //算法2 用户支付金额=商户分成+代理分成+平台分成
                    BigDecimal proBounds = sysBounds.subtract(plat);
                    BounsDto mp2 = new BounsDto(c,orderSn,proBounds);
                    list.add(mp2);
                    break;
                default:
                    break;
            }
        }
        return list;
    }
}

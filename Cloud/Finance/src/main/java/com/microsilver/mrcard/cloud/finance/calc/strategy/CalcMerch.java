package com.microsilver.mrcard.cloud.finance.calc.strategy;

import com.microsilver.mrcard.cloud.finance.dto.BounsDto;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.CustomerDto;
import com.microsilver.mrcard.cloud.finance.dto.ProportionDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2017/7/25 0025.
 * 商户所得计算类，通用功能
 */
public class CalcMerch {

    protected DecimalFormat decimalFormat = null;

    protected ProportionDto proportion = null;

    //商户分完后剩下的钱，需要平台，代理多级分成
    public BigDecimal sysBounds;

    public CalcMerch() {
        decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
    }

    /**
     * 计算商户 所得
     * @return 返回商户所得
     */
    protected BounsDto calculatorMerchBounds(CommissionDto commission) throws Exception {
        if(proportion == null)
            throw new IllegalArgumentException("proportion is not null");
        //商户分成
        BigDecimal totalAmount = commission.getTotalAmount();
        BigDecimal merchBounds = totalAmount.multiply(proportion.getMERCH_PROPORTION());
        BigDecimal formatDecimal = new BigDecimal(decimalFormat.format(merchBounds));
        BounsDto mb = new BounsDto(commission.getMerchInfo(),commission.getOrderSn(),formatDecimal);

        //计算系统分成，系统分成再次进行分成，分配到平台，省代
//        BigDecimal sysProportion = new BigDecimal(1).subtract(proportion.getMERCH_PROPORTION());
//        sysBounds = totalAmount.multiply(sysProportion);
        //total - merchbound = sysbound 防小数据精度丢失
        BigDecimal formatSys = new BigDecimal(decimalFormat.format(totalAmount.subtract(formatDecimal)));
        sysBounds = formatSys;
        return mb;
    }

    /**
     * 计算勇士 所得
     * @return 返回勇士所得
     */
    protected BounsDto calculatorWarriorBounds(CustomerDto proCustomer , String orderId){
        BigDecimal proBounds = sysBounds.multiply(proportion.getWARRIOR_PROPORTION());
        BigDecimal formatDecimal = new BigDecimal(decimalFormat.format(proBounds));
        BounsDto mw = new BounsDto(proCustomer,orderId,formatDecimal);
        return mw;
    }
    /**
     * 计算县代 所得
     * @return 返回县代所得
     */
    protected BounsDto calculatorCountryBounds(CustomerDto proCustomer , String orderId){
        BigDecimal proBounds = sysBounds.multiply(proportion.getCOUNTRY_PROPORTION());
        BigDecimal formatDecimal = new BigDecimal(decimalFormat.format(proBounds));
        BounsDto mc = new BounsDto(proCustomer,orderId,formatDecimal);
        return mc;
    }
    /**
     * 计算市代 所得
     * @return 返回市代所得
     */
    protected BounsDto calculatorCityBounds(CustomerDto proCustomer , String orderId){
        BigDecimal proBounds = sysBounds.multiply(proportion.getCITY_PROPORTION());
        BigDecimal formatDecimal = new BigDecimal(decimalFormat.format(proBounds));
        BounsDto mc = new BounsDto(proCustomer,orderId,formatDecimal);
        return mc;
    }

    /**
     * 计算营销 所得
     * @return 返回营销所得
     */
    protected BounsDto calculatorProvinceBounds(CustomerDto proCustomer , String orderId){
        BigDecimal proBounds = sysBounds.multiply(proportion.getPROVINCE_PROPORTION());
        BigDecimal formatDecimal = new BigDecimal(decimalFormat.format(proBounds));
        BounsDto mp = new BounsDto(proCustomer,orderId,formatDecimal);
        return mp;
    }
/**
     * 计算骑士 所得
     * @return 返回营销所得
     */
    protected BounsDto calculatorKnightBounds(CustomerDto proCustomer , String orderId){
        BigDecimal proBounds = sysBounds.multiply(proportion.getKNIGHT_PROPORTION());
        BigDecimal formatDecimal = new BigDecimal(decimalFormat.format(proBounds));
        BounsDto mp = new BounsDto(proCustomer,orderId,formatDecimal);
        return mp;
    }
/**
     * 计算VIP 所得
     * @return 返回营销所得
     */
    protected BounsDto calculatorVIPBounds(CustomerDto proCustomer , String orderId){
        BigDecimal proBounds = sysBounds.multiply(proportion.getVIP_PROPORTION());
        BigDecimal formatDecimal = new BigDecimal(decimalFormat.format(proBounds));
        BounsDto mp = new BounsDto(proCustomer,orderId,formatDecimal);
        return mp;
    }

    /**
     * 计算平台 所得
     * @return 返回平台所得
     */
    @Deprecated
    protected BounsDto calculatorPlatformBounds(CustomerDto proCustomer ,String orderId){
        BigDecimal proBounds = sysBounds.multiply(proportion.getPLAT_PROPORTION());
        BigDecimal formatDecimal = new BigDecimal(decimalFormat.format(proBounds));
        BounsDto mp = new BounsDto(proCustomer,orderId,formatDecimal);
        return mp;
    }

    /**
     * 计算用户所得
     * @Jade 2017-10-27 用户返现，返回到钱包
     * @param commission
     * @return
     */
    protected BounsDto calculatorUserBounds(CommissionDto commission){
        BounsDto ub = new BounsDto(commission.getUserInfo(),commission.getOrderSn(),commission.getUserprice());
        return ub;
    }
    /**
     * 计算推荐用户所得
     * @param commission
     * @return
     */
    protected BounsDto calculatorRecommendUserBounds(CommissionDto commission,BigDecimal bouns) {
    	BounsDto ub = new BounsDto(commission.getRecMemberInfo(),commission.getOrderSn(),bouns);
        return ub;
    }

    /**
     * 计算系统分成，系统分成再次进行分成，分配到平台，省代
     * @Jade 2017-10-30  系统分成
     * @param sysprice
     * @return
     */
    protected void initSysPrice(BigDecimal sysprice){
        BigDecimal formatSys = new BigDecimal(decimalFormat.format(sysprice));
        sysBounds = formatSys;
    }

    /**
     * 初始各级化抽成比例
     * @param proportion
     */
    public void initProportion(ProportionDto proportion) {
        this.proportion = proportion;
    }

    /**
     * 根据客户代理信息，按顺序重新排列代理商
     * @param agent
     * @param keyWord
     * @return
     */
    protected  CustomerDto[] CustomerReSort(CustomerDto[] agent, String keyWord) {
        String [] args = keyWord.split("_");
        //按顺key_word序排列客户信息，遇到缺少的客户信息，以null占位
        List<CustomerDto> cusList = new ArrayList<CustomerDto>();
        for(String str : args){
            if(!"0".equals(str)){
                for (CustomerDto cd : agent) {
                    //customer level match proportion key words
                    if(cd !=null && Short.valueOf(str) == cd.getIdentity()){
                        cusList.add(cd);
                        break;
                    }
                }
            }
        }
        Collections.reverse(cusList);
        return cusList.toArray(new CustomerDto[cusList.size()]);
    }
}

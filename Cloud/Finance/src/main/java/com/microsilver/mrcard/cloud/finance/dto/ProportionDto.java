package com.microsilver.mrcard.cloud.finance.dto;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceAgentShareConfig;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/7/26 0026.
 * 折扣率汇总
 */
public class ProportionDto {

    BigDecimal dev = new BigDecimal(100);

    //商家折扣
    public BigDecimal MERCH_PROPORTION ;
    //平台折扣
    public BigDecimal PLAT_PROPORTION  ;
    //省代折扣
    public BigDecimal PROVINCE_PROPORTION  ;
    //市代折扣
    public BigDecimal CITY_PROPORTION  ;
    //县代折扣
    public BigDecimal COUNTRY_PROPORTION  ;
    //勇士折扣
    public BigDecimal WARRIOR_PROPORTION  ;
    //骑士折扣
    public BigDecimal KNIGHT_PROPORTION;
    //VIP折扣
    public BigDecimal VIP_PROPORTION;
    //推荐商户分润比例
    public BigDecimal REM_MERCH_PROPORTION;

    public ProportionDto() {
    }
    public ProportionDto(Short MERCH_PROPORTION) {
        this.MERCH_PROPORTION =  new BigDecimal(MERCH_PROPORTION).divide(dev);
    }
    public ProportionDto(Short merchProportion,Short recMemProportion, MrcardFinanceAgentShareConfig agentConfig) {
        this.MERCH_PROPORTION =  new BigDecimal(merchProportion).divide(dev);
        this.PLAT_PROPORTION =  new BigDecimal(agentConfig.getPlatformProportion()).divide(dev);
        this.PROVINCE_PROPORTION = new BigDecimal(agentConfig.getProvinceProportion()).divide(dev);
        this.CITY_PROPORTION = new BigDecimal(agentConfig.getCityProportion()).divide(dev);
        this.COUNTRY_PROPORTION = new BigDecimal(agentConfig.getCountyProportion()).divide(dev);
        this.WARRIOR_PROPORTION = new BigDecimal(agentConfig.getWarriorProportion()).divide(dev);
        this.KNIGHT_PROPORTION = new BigDecimal(agentConfig.getKnightProportion()).divide(dev);
        this.VIP_PROPORTION = new BigDecimal(recMemProportion).divide(dev);
    }
    public ProportionDto(Short merchProportion,MrcardFinanceAgentShareConfig agentConfig) {
        this.MERCH_PROPORTION =  new BigDecimal(merchProportion).divide(dev);
        this.PLAT_PROPORTION =  new BigDecimal(agentConfig.getPlatformProportion()).divide(dev);
        this.PROVINCE_PROPORTION = new BigDecimal(agentConfig.getProvinceProportion()).divide(dev);
        this.CITY_PROPORTION = new BigDecimal(agentConfig.getCityProportion()).divide(dev);
        this.COUNTRY_PROPORTION = new BigDecimal(agentConfig.getCountyProportion()).divide(dev);
        this.WARRIOR_PROPORTION = new BigDecimal(agentConfig.getWarriorProportion()).divide(dev);
        this.KNIGHT_PROPORTION = new BigDecimal(agentConfig.getKnightProportion()).divide(dev);
        this.VIP_PROPORTION = new BigDecimal(agentConfig.getVipProportion()).divide(dev);
    }
    public ProportionDto(MrcardFinanceAgentShareConfig agentConfig) {
        this.PLAT_PROPORTION =  new BigDecimal(agentConfig.getPlatformProportion()).divide(dev);
        this.PROVINCE_PROPORTION = new BigDecimal(agentConfig.getProvinceProportion()).divide(dev);
        this.CITY_PROPORTION = new BigDecimal(agentConfig.getCityProportion()).divide(dev);
        this.COUNTRY_PROPORTION = new BigDecimal(agentConfig.getCountyProportion()).divide(dev);
        this.WARRIOR_PROPORTION = new BigDecimal(agentConfig.getWarriorProportion()).divide(dev);
        this.KNIGHT_PROPORTION = new BigDecimal(agentConfig.getKnightProportion()).divide(dev);
        this.VIP_PROPORTION = new BigDecimal(agentConfig.getVipProportion()).divide(dev);
    }
    public BigDecimal getMERCH_PROPORTION() {
        return MERCH_PROPORTION;
    }

    public BigDecimal getPLAT_PROPORTION() {
        return PLAT_PROPORTION;
    }

    public BigDecimal getPROVINCE_PROPORTION() {
        return PROVINCE_PROPORTION;
    }

    public BigDecimal getCITY_PROPORTION() {
        return CITY_PROPORTION;
    }

    public BigDecimal getCOUNTRY_PROPORTION() {
        return COUNTRY_PROPORTION;
    }

    public BigDecimal getWARRIOR_PROPORTION() {
        return WARRIOR_PROPORTION;
    }

    public BigDecimal getKNIGHT_PROPORTION() {
        return KNIGHT_PROPORTION;
    }

    public BigDecimal getVIP_PROPORTION() {
        return VIP_PROPORTION;
    }
	public BigDecimal getREM_MERCH_PROPORTION() {
		return REM_MERCH_PROPORTION;
	}
	public void setREM_MERCH_PROPORTION(Short rEM_MERCH_PROPORTION) {
		this.REM_MERCH_PROPORTION = new BigDecimal(rEM_MERCH_PROPORTION).divide(dev);
	}
	public void setVIP_PROPORTION(Short vIP_PROPORTION) {
		this.VIP_PROPORTION = new BigDecimal(vIP_PROPORTION).divide(dev);
	}
    
}

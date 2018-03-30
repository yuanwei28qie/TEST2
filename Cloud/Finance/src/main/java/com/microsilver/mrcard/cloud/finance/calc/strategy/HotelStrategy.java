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
import java.util.Objects;

/**
 * @author Jade
 * @Description 超级定结算算法
 * @create 2017-08-02 下午 2:50
 * @Copyright Micro Silver
 **/

public class HotelStrategy extends CalcMerch implements CommissionStrategy {

	/**
	 * 酒店分得全部的成本价格 平台及其他代理，按比例分得平台抽成
	 * 
	 * @param commission
	 * @return
	 * @throws Exception
	 */
	@Override
	protected BounsDto calculatorMerchBounds(CommissionDto commission) throws Exception {
		BigDecimal formatDecimal = new BigDecimal(decimalFormat.format(commission.getCostprice()));
		BounsDto mb = new BounsDto(commission.getMerchInfo(), commission.getOrderSn(), formatDecimal);
		return mb;
	}

	/**
	 * 会员推荐人按照比例获取总利润,剩余的利润 平台及其他代理，按比例分得
	 */
	protected BounsDto calculatorVIPBounds(CommissionDto commission) {
		BigDecimal pro = new BigDecimal(commission.getRecMemberInfo().getProportion()).divide(new BigDecimal(100));
		BigDecimal formatDecimal = new BigDecimal(decimalFormat.format(commission.getSysprice().multiply(pro)));
		BounsDto vmb = new BounsDto(commission.getRecMemberInfo(), commission.getOrderSn(), formatDecimal);
		sysBounds =sysBounds.subtract(formatDecimal);
		return vmb;
	}
	/**
	 * 酒店推荐人按照比例获取总利润,剩余的利润 平台及其他代理，按比例分得
	 * @param commission
	 * @return
	 */
	protected BounsDto calculatorRemMerchBounds(CommissionDto commission) {
		
		BigDecimal pro = new BigDecimal(commission.getRecMerchInfo().getProportion()).divide(new BigDecimal(100));
		BigDecimal formatDecimal = new BigDecimal(decimalFormat.format(commission.getSysprice().multiply(pro)));
		BounsDto vmb = new BounsDto(commission.getRecMerchInfo(), commission.getOrderSn(), formatDecimal);
		sysBounds =sysBounds.subtract(formatDecimal);
		return vmb;
	}

	@Override
	public List<BounsDto> calculatorBouns(CommissionDto commission, ProportionDto proportion) throws Exception {
		super.initProportion(proportion);
		// 初始化系统分润的总额
		initSysPrice(commission.getSysprice());
		List<BounsDto> list = new ArrayList<BounsDto>();
		String orderSn = commission.getOrderSn();
		/*
		 * 判断下单会员是否有VIP推荐用户
		 */
		if (Objects.nonNull(commission.getRecMemberInfo())) {
			BounsDto vmb = calculatorVIPBounds(commission);
			list.add(vmb);
		}
		/**
		 * 酒店是否有推荐人
		 */
		if(Objects.nonNull(commission.getRecMerchInfo())){
			BounsDto vmb = calculatorRemMerchBounds(commission);
			list.add(vmb);
		}
		// 商户
		if (Objects.nonNull(commission.getMerchInfo()) && Objects.nonNull(commission.getCostprice())
				&& commission.getCostprice().doubleValue() > 0) {
			BounsDto mb = calculatorMerchBounds(commission);
			list.add(mb);
		}

		/*
		 * @Jade 2017-10-27 检查用户是否有返现 要为用户添加返现记录 rows 4
		 */
		if (Objects.nonNull(commission.getUserInfo()) && Objects.nonNull(commission.getUserprice())
				&& commission.getUserprice().doubleValue() > 0) {
			BounsDto ub = calculatorUserBounds(commission);
			list.add(ub);
		}

		// 统计除平台以外的分成
		BigDecimal plat = new BigDecimal(0);

		/**
		 * 先排序，后计算 1，排序：代理级别由小到大，不能改变 2，计算：先算代理，最后算平台
		 */

		CustomerDto[] cus = CustomerReSort(commission.getParentCustomer(), commission.getKeyWord());
		for (CustomerDto c : cus) {
			switch (AgentLevelEnum.getEnumValue(c.getIdentity())) {
			case AGENT_WARRIOR:
				BounsDto mw = calculatorWarriorBounds(c, orderSn);
				list.add(mw);

				plat = plat.add(mw.getBouns());
				break;
			case AGENT_COUNTRY:
				BounsDto mcoun = calculatorCountryBounds(c, orderSn);
				list.add(mcoun);

				plat = plat.add(mcoun.getBouns());
				break;
			case AGENT_CITY:
				BounsDto mcity = calculatorCityBounds(c, orderSn);
				list.add(mcity);

				plat = plat.add(mcity.getBouns());
				break;
			case AGENT_PROVINCE:
				BounsDto mpro = calculatorProvinceBounds(c, orderSn);
				list.add(mpro);

				plat = plat.add(mpro.getBouns());
				break;
			case AGENT_PLATFORM:
				// //算法1
				// BounsDto mplat = calculatorPlatformBounds(c,orderSn);
				// list.add(mplat);
				// 算法2 用户支付金额=商户分成+代理分成+平台分成
				BigDecimal proBounds = sysBounds.subtract(plat);
				BounsDto mp2 = new BounsDto(c, orderSn, proBounds);
				list.add(mp2);
				break;
			default:
				break;
			}
		}
		return list;
	}
}

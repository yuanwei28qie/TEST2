package com.microsilver.mrcard.cloud.finance.calc;

import com.microsilver.mrcard.cloud.finance.dto.BounsDto;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.ProportionDto;

import java.util.List;

/**
 * Created by Administrator on 2017/7/25 0025.
 * 分闰策略接口，
 * 客户向商家购买服务后，根据商户类型，确定其客服（发展商家的人）、平台、商家的分成
 */
public interface CommissionStrategy {

    /**
     * 根据商户信息，计算其客服对应的分闰值
     *      不同级别的客服，不同的客服数量，分闰比例不同
     *
     *
     平台	100.00%
     营销	40.00%	60.00%
     市代	40.00%	10.00%	50.00%
     市代	50.00%		50.00%
     县代	40.00%	10.00%	6.00%	44.00%
     县代	50.00%		6.00%	44.00%
     县代	40.00%	16.00%		44.00%
     县代	56.00%			44.00%
     勇士	40.00%	10.00%	6.00%	4.00%	40.00%
     勇士	50.00%		6.00%	4.00%	40.00%
     勇士	46.00%	10.00%		4.00%	40.00%
     勇士	44.00%	10.00%	6.00%		40.00%
     勇士	56.00%			4.00%	40.00%
     勇士	54.00%		6.00%		40.00%
     勇士	40.00%	20.00%			40.00%
     勇士	60.00%				40.00%
            平台	营销	市代	县代	勇士

     *
     * @param commission 分成数据
     * @param proportion 分成比例
     * @return 分成结果、
     * @TODO 分成结果是否要包含商家？
     */
    public List<BounsDto> calculatorBouns(CommissionDto commission, ProportionDto proportion) throws Exception;
}

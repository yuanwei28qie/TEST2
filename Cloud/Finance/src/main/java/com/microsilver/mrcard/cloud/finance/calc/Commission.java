package com.microsilver.mrcard.cloud.finance.calc;

import com.microsilver.mrcard.cloud.finance.dto.BounsDto;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.cloud.finance.dto.ProportionDto;

import java.util.List;

/**
 *
 * Created by Administrator on 2017/7/25 0025.
 *
 * 分闰（商家、抽成--平台、代理商（省、市、县、勇士））
 *
 */
public class Commission {

    private CommissionStrategy commissionStrategy;

    public Commission(CommissionStrategy comm) {
        this.commissionStrategy = comm;
    }
    /**
     * 测试专用
     * 根据折扣和折扣率，计算每个人的所得
     * @param commission 需要算分成的每个人数据及商家数据
     * @param proportion 比率
     * @return 返回每个人所得，商家，平台，代理等
     */
    public List<BounsDto> getBounds(CommissionDto commission, ProportionDto proportion) throws Exception {
        return commissionStrategy.calculatorBouns(commission,proportion);
    }
}

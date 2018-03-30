package com.microsilver.mrcard.cloud.finance.dao;

import com.microsilver.mrcard.cloud.finance.dto.FinanceMerchFlowResultDto;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchFlow;
import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceMerchFlowExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MrcardFinanceMerchFlowMapper {
    int countByExample(MrcardFinanceMerchFlowExample example);

    int deleteByExample(MrcardFinanceMerchFlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MrcardFinanceMerchFlow record);

    int insertSelective(MrcardFinanceMerchFlow record);

    List<MrcardFinanceMerchFlow> selectByExample(MrcardFinanceMerchFlowExample example);

    List<FinanceMerchFlowResultDto> selectByMerchs(MrcardFinanceMerchFlowExample example);

    MrcardFinanceMerchFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MrcardFinanceMerchFlow record, @Param("example") MrcardFinanceMerchFlowExample example);

    int updateByExample(@Param("record") MrcardFinanceMerchFlow record, @Param("example") MrcardFinanceMerchFlowExample example);

    int updateByPrimaryKeySelective(MrcardFinanceMerchFlow record);

    int updateByPrimaryKey(MrcardFinanceMerchFlow record);

    int updateByOrderSn(@Param("orderSn") List<String> orderSn,@Param("status") Boolean status);
}
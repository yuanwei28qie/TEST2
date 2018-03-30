package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopRecharge;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopRechargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopRechargeMapper {
    int countByExample(ImsEweiShopRechargeExample example);

    int deleteByExample(ImsEweiShopRechargeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsEweiShopRecharge record);

    int insertSelective(ImsEweiShopRecharge record);

    List<ImsEweiShopRecharge> selectByExample(ImsEweiShopRechargeExample example);

    ImsEweiShopRecharge selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsEweiShopRecharge record, @Param("example") ImsEweiShopRechargeExample example);

    int updateByExample(@Param("record") ImsEweiShopRecharge record, @Param("example") ImsEweiShopRechargeExample example);

    int updateByPrimaryKeySelective(ImsEweiShopRecharge record);

    int updateByPrimaryKey(ImsEweiShopRecharge record);
}
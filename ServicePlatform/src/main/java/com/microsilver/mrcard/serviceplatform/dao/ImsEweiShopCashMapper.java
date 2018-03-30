package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopCash;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopCashExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopCashMapper {
    int countByExample(ImsEweiShopCashExample example);

    int deleteByExample(ImsEweiShopCashExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsEweiShopCash record);

    int insertSelective(ImsEweiShopCash record);

    List<ImsEweiShopCash> selectByExample(ImsEweiShopCashExample example);

    ImsEweiShopCash selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsEweiShopCash record, @Param("example") ImsEweiShopCashExample example);

    int updateByExample(@Param("record") ImsEweiShopCash record, @Param("example") ImsEweiShopCashExample example);

    int updateByPrimaryKeySelective(ImsEweiShopCash record);

    int updateByPrimaryKey(ImsEweiShopCash record);
    
    BigDecimal countCashMoenyByTime(ImsEweiShopCash record);
}
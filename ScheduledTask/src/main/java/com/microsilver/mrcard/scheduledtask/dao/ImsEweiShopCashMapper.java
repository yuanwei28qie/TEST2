package com.microsilver.mrcard.scheduledtask.dao;


import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopCash;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopCashExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
}
package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopAdv;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopAdvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopAdvMapper {
    int countByExample(ImsEweiShopAdvExample example);

    int deleteByExample(ImsEweiShopAdvExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsEweiShopAdv record);

    int insertSelective(ImsEweiShopAdv record);

    List<ImsEweiShopAdv> selectByExample(ImsEweiShopAdvExample example);

    ImsEweiShopAdv selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImsEweiShopAdv record, @Param("example") ImsEweiShopAdvExample example);

    int updateByExample(@Param("record") ImsEweiShopAdv record, @Param("example") ImsEweiShopAdvExample example);

    int updateByPrimaryKeySelective(ImsEweiShopAdv record);

    int updateByPrimaryKey(ImsEweiShopAdv record);
}
package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchConfig;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopMerchConfigMapper {
    int countByExample(ImsEweiShopMerchConfigExample example);

    int deleteByExample(ImsEweiShopMerchConfigExample example);

    int deleteByPrimaryKey(Long merchId);

    int insert(ImsEweiShopMerchConfig record);

    int insertSelective(ImsEweiShopMerchConfig record);

    List<ImsEweiShopMerchConfig> selectByExample(ImsEweiShopMerchConfigExample example);

    ImsEweiShopMerchConfig selectByPrimaryKey(Long merchId);

    int updateByExampleSelective(@Param("record") ImsEweiShopMerchConfig record, @Param("example") ImsEweiShopMerchConfigExample example);

    int updateByExample(@Param("record") ImsEweiShopMerchConfig record, @Param("example") ImsEweiShopMerchConfigExample example);

    int updateByPrimaryKeySelective(ImsEweiShopMerchConfig record);

    int updateByPrimaryKey(ImsEweiShopMerchConfig record);
}
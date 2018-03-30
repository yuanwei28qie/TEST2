package com.microsilver.mrcard.serviceplatform.dao;

import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUser;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsEweiShopMerchUserMapper {
    int countByExample(ImsEweiShopMerchUserExample example);

    int deleteByExample(ImsEweiShopMerchUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImsEweiShopMerchUser record);

    int insertSelective(ImsEweiShopMerchUser record);

    List<ImsEweiShopMerchUser> selectByExample(ImsEweiShopMerchUserExample example);

    ImsEweiShopMerchUser selectByPrimaryKey(Long id);
    ImsEweiShopMerchUser selectByPrimaryKey1(Long id);
    ImsEweiShopMerchUser selectByPrimaryKeyForComment(Long id);
    

    int updateByExampleSelective(@Param("record") ImsEweiShopMerchUser record, @Param("example") ImsEweiShopMerchUserExample example);

    int updateByExample(@Param("record") ImsEweiShopMerchUser record, @Param("example") ImsEweiShopMerchUserExample example);

    int updateByPrimaryKeySelective(ImsEweiShopMerchUser record);

    int updateByPrimaryKey(ImsEweiShopMerchUser record);

    List<ImsEweiShopMerchUser> selectByExampleWithActivity(ImsEweiShopMerchUserExample example);

    List<ImsEweiShopMerchUser> selectByExampleWithActivityAndLocation(ImsEweiShopMerchUserExample example);

	ImsEweiShopMerchUser selectByPrimaryKeyWithComment(Integer id);

	ImsEweiShopMerchUser selectByPrimaryKeyWithPrice(Long id);
}
package com.microsilver.mrcard.scheduledtask.dao;

import java.util.List;

import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMerchUser;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMerchUserExample;

public interface ImsEweiShopMerchUserMapper {
	
    List<ImsEweiShopMerchUser> selectByExample(ImsEweiShopMerchUserExample example);

    ImsEweiShopMerchUser selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(ImsEweiShopMerchUser merchUser);
}
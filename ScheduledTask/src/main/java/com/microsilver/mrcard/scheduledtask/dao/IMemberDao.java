package com.microsilver.mrcard.scheduledtask.dao;

import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMember;

public interface IMemberDao {
	
	ImsEweiShopMember selectByPrimaryKey(Long id);

	ImsEweiShopMember selectByMobile(String mobile);

	ImsEweiShopMember selectByOpenId(String openid);
}
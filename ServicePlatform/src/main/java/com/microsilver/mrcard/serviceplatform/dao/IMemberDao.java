package com.microsilver.mrcard.serviceplatform.dao;

import java.util.List;

import com.microsilver.mrcard.serviceplatform.dto.MemberDto;
import com.microsilver.mrcard.serviceplatform.dto.StaffInformation;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMember;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchAccount;

public interface IMemberDao {
    int deleteByPrimaryKey(Long id);

    int insert(ImsEweiShopMember record);

    int insertSelective(ImsEweiShopMember record);

    ImsEweiShopMember selectByPrimaryKey(Long id);
    
    ImsEweiShopMember selectByMobile(String mobile);

    List<StaffInformation> selectByMerchId(Long merchId);

    int updateByPrimaryKeySelective(ImsEweiShopMember record);

    int updateByPrimaryKeyWithBLOBs(ImsEweiShopMember record);

    int updateByPrimaryKey(ImsEweiShopMember record);

	int updatePassword(ImsEweiShopMember record);

	ImsEweiShopMerchAccount selectShopMerchByMemberId(Long memberId);
	
	MemberDto selectDtoByMobile(String mobile);

	void updateUserInfo(ImsEweiShopMember member);

	int updateMobile(ImsEweiShopMember member);
	
}
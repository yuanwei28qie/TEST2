package com.microsilver.mrcard.serviceplatform.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopMemberAdditionalMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAdditional;

@Service
public class ImsEweiShopMemberAdditionalService {

	@Resource
	ImsEweiShopMemberAdditionalMapper mapper;
	
    public ImsEweiShopMemberAdditional getImsEweiShopMemberAdditionalById(Long memberId){
    	ImsEweiShopMemberAdditional memberAdditional = mapper.selectByPrimaryKey(memberId);
    	return memberAdditional;
    }

	public int addShopMemberAdditional(ImsEweiShopMemberAdditional memberAdditional) {
		
		return mapper.insertSelective(memberAdditional);
	}

	public int updateShopMemberAdditional(ImsEweiShopMemberAdditional memberAdditional) {
		return mapper.updateByPrimaryKeySelective(memberAdditional);
	}
}

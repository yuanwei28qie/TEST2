/**
 * 
 */
package com.microsilver.mrcard.basicservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsilver.mrcard.basicservice.dao.FxSdUserMemberMapper;
import com.microsilver.mrcard.basicservice.model.FxSdUserMember;
import com.microsilver.mrcard.basicservice.model.FxSdUserMemberExample;
import com.microsilver.mrcard.basicservice.model.FxSdUserMemberExample.Criteria;
import com.microsilver.mrcard.basicservice.service.UserService;

@Service
public class UserService  {
		
	
	@Autowired
	private FxSdUserMemberMapper fxSdUserMemberMapper;

	
	public FxSdUserMember selectUserByMobile(String mobile) {
		
		FxSdUserMemberExample fxSdUserMemberExample = new FxSdUserMemberExample();
		Criteria createCriteria = fxSdUserMemberExample.createCriteria();
		createCriteria.andMobileLike(mobile);
		List<FxSdUserMember> selectByExample = fxSdUserMemberMapper.selectByExample(fxSdUserMemberExample);
		if(selectByExample.size()>0) {
			return selectByExample.get(0);
		}
		return null;
		
	}
	
	public void insertUser(FxSdUserMember info) {
		fxSdUserMemberMapper.insert(info);
	}

	/**
	 * @param selectUserByMobile
	 */
	public void updatePwd(FxSdUserMember selectUserByMobile) {
		fxSdUserMemberMapper.updateByPrimaryKey(selectUserByMobile);
	}
	
	
}

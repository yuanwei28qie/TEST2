package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopMemberIdentityAdditionalMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentityAdditional;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberIdentityAdditionalExample;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;

@Service
public class ImsEweiShopMemberIdentityAdditionalService {
	@Resource
	ImsEweiShopMemberIdentityAdditionalMapper additionalMapper;
	
    public ImsEweiShopMemberIdentityAdditional selectByPrimaryKey(Long memberId){
    	return additionalMapper.selectByPrimaryKey(memberId);
    }
    
    /**
     * 根据骑士id获取相关信息
     * @param memberId
     * @param identity
     * @return
     */
    List<ImsEweiShopMemberIdentityAdditional> getShopMemberIdentityAdditional(Long memberId){
		ImsEweiShopMemberIdentityAdditionalExample example = new ImsEweiShopMemberIdentityAdditionalExample();
		example.createCriteria().andMemberIdEqualTo(memberId).andIdentityEqualTo((byte)13);
		List<ImsEweiShopMemberIdentityAdditional> additional = additionalMapper.selectByExample(example);
		return additional;
    }
    
    /**
     * 根据memberId更改骑士状态
     * @param memberId
     * @param isWork
     * @return
     */
	public int isWork(Long memberId,Boolean isWork){
		if(memberId == null || isWork == null){
			throw new BusinessException(EWarning.ErrorParams);
		}
		ImsEweiShopMemberIdentityAdditionalExample example = new ImsEweiShopMemberIdentityAdditionalExample();
		example.createCriteria().andMemberIdEqualTo(memberId);
		ImsEweiShopMemberIdentityAdditional additional =  new ImsEweiShopMemberIdentityAdditional();
		additional.setIsWork(isWork);
		int result = additionalMapper.updateByExampleSelective(additional, example);
		return result;
	}

	/**
	 * 更新骑士经纬度
	 * @param memberId
	 * @param lat
	 * @param lng
	 * @return
	 */
	public int updateLocation(Long memberId, Byte identity, String lat, String lng) {
		ImsEweiShopMemberIdentityAdditionalExample example = new ImsEweiShopMemberIdentityAdditionalExample();
		example.createCriteria().andMemberIdEqualTo(memberId).andIdentityEqualTo(identity);
		ImsEweiShopMemberIdentityAdditional additional = new ImsEweiShopMemberIdentityAdditional();
		additional.setLat(lat);
		additional.setLng(lng);	
		return additionalMapper.updateByExampleSelective(additional, example);
	}

	public int addIdentityAdditional(ImsEweiShopMemberIdentityAdditional identityAdditional) {

		return additionalMapper.insertSelective(identityAdditional);
	}
}

package com.microsilver.mrcard.scheduledtask.service;


import com.microsilver.mrcard.mq.OrderMQ;
import com.microsilver.mrcard.mq.coordinateMQ;
import com.microsilver.mrcard.scheduledtask.dao.ImsEweiShopMemberIdentityAdditionalMapper;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberIdentityAdditional;
import com.microsilver.mrcard.scheduledtask.model.ImsEweiShopMemberIdentityAdditionalExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
	 * 更新骑士经纬度
	 * @param coordinate
	 * @return
	 */
	public int updateLocation(coordinateMQ coordinate) {
		ImsEweiShopMemberIdentityAdditionalExample example = new ImsEweiShopMemberIdentityAdditionalExample();
		example.createCriteria().andMemberIdEqualTo(coordinate.getMemberId()).andIdentityEqualTo(coordinate.getIdentity());
		ImsEweiShopMemberIdentityAdditional additional = new ImsEweiShopMemberIdentityAdditional();
		additional.setLat(coordinate.getLat());
		additional.setLng(coordinate.getLng());
		return additionalMapper.updateByExampleSelective(additional, example);
	}

	public int addIdentityAdditional(ImsEweiShopMemberIdentityAdditional identityAdditional) {

		return additionalMapper.insertSelective(identityAdditional);
	}

	public List<OrderMQ> selectByConditionExample(OrderMQ order) {

		return additionalMapper.selectByConditionExample(order);
	}
}

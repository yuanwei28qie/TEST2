package com.microsilver.mrcard.basicservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microsilver.mrcard.basicservice.dao.FxSdUserDeliverinfoMapper;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfo;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfoExample;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfoExample.Criteria;
import com.microsilver.mrcard.basicservice.service.SuperDeliveryService;

@Service
public class SuperDeliveryService  {

	@Autowired
	private FxSdUserDeliverinfoMapper fxSdUserDeliverinfoMapper;

	@Transactional
	public void insertDelivery(FxSdUserDeliverinfo fxSdUserDeliverinfo) {
		fxSdUserDeliverinfoMapper.insert(fxSdUserDeliverinfo);
	}

	@Transactional
	public FxSdUserDeliverinfo selectDeliveryBymobile(String mobile) {
		FxSdUserDeliverinfoExample fxSdUserDeliverinfoExample = new FxSdUserDeliverinfoExample();
		Criteria createCriteria = fxSdUserDeliverinfoExample.createCriteria();
		createCriteria.andMobileLike(mobile);
		List<FxSdUserDeliverinfo> selectByExample = fxSdUserDeliverinfoMapper
				.selectByExample(fxSdUserDeliverinfoExample);
		if (selectByExample.size() > 0) {
			FxSdUserDeliverinfo fxSdUserDeliverinfo = selectByExample.get(0);
			return fxSdUserDeliverinfo;
		}
		return null;
	}

	public FxSdUserDeliverinfo selectDeliveryByRefereeMobile(String refereeMobile) {
		FxSdUserDeliverinfoExample fxSdUserDeliverinfoExample = new FxSdUserDeliverinfoExample();
		Criteria createCriteria = fxSdUserDeliverinfoExample.createCriteria();
		createCriteria.andMobileLike(refereeMobile);
		List<FxSdUserDeliverinfo> selectByExample = fxSdUserDeliverinfoMapper
				.selectByExample(fxSdUserDeliverinfoExample);
		if (selectByExample.size() > 0) {
			FxSdUserDeliverinfo fxSdUserDeliverinfo = selectByExample.get(0);
			return fxSdUserDeliverinfo;
		}

		return null;
	}

	public void updatePwd(FxSdUserDeliverinfo info) {

		fxSdUserDeliverinfoMapper.updateByPrimaryKeySelective(info);
	}

	// 更新骑手完善资料
	public void updateSuperDelivery(FxSdUserDeliverinfo info) {

		fxSdUserDeliverinfoMapper.updateEntity(info);
	}

}

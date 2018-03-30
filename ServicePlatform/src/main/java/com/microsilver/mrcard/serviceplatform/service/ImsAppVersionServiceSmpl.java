package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.dao.ImsAppVersionMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsAppVersion;
import com.microsilver.mrcard.serviceplatform.model.ImsAppVersionExample;
import com.microsilver.mrcard.serviceplatform.model.ImsAppVersionExample.Criteria;

@Service
public class ImsAppVersionServiceSmpl {
	@Resource
	private ImsAppVersionMapper appVersionMapper;
	
	/**
	 * APP获取最新版本
	 * @param appType APP类型1:卡先生消费者版本2:卡先生商家版3:卡先生雇员版
	 * @param clientType 终端类型(1:android,2:ios)
	 * @return
	 */
	public ImsAppVersion getRecentlyVersion(Integer appType,Byte clientType){
		ImsAppVersionExample example = new ImsAppVersionExample();
		Criteria criteria = example.createCriteria();
		criteria.andAppTypeEqualTo(appType);
		criteria.andClientTypeEqualTo(clientType);
		example.setOrderByClause(" version desc ");
		List<ImsAppVersion> list = appVersionMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
}

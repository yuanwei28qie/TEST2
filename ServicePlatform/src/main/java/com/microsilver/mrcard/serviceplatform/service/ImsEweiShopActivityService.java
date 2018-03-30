package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopActivityMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivity;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopActivityExample;

@Service
public class ImsEweiShopActivityService {

	@Resource
	private ImsEweiShopActivityMapper mapper;
	public List<ImsEweiShopActivity> listShopActivity(){
		List<ImsEweiShopActivity> list = mapper.selectByExample(new ImsEweiShopActivityExample());
		return list;
	}
}

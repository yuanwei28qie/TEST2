package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopAdvMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopAdv;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopAdvExample;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopAdvExample.Criteria;

@Service
public class ImsEweiShopAdvSmpl {
	@Resource
	private ImsEweiShopAdvMapper advMapper;
	
	public List<ImsEweiShopAdv> getAdvByUnicId(Integer uniacId){
		ImsEweiShopAdvExample example = new ImsEweiShopAdvExample();
		Criteria criteria = example.createCriteria();
		criteria.andUniacidEqualTo(uniacId);
		criteria.andEnabledEqualTo(1);
		List<ImsEweiShopAdv> imsEweiShopAdvs = advMapper.selectByExample(example);
		return imsEweiShopAdvs;
	}
}

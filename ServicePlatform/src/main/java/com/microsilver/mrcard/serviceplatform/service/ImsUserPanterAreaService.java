package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.dao.ImsUserPanterAreaMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsUserPanterArea;
import com.microsilver.mrcard.serviceplatform.model.ImsUserPanterAreaExample;

@Service
public class ImsUserPanterAreaService {
	@Resource
	private ImsUserPanterAreaMapper mapper;
	
	public List<ImsUserPanterArea> selectByAreaCode(Long areaCode){
		ImsUserPanterAreaExample example = new ImsUserPanterAreaExample();
		example.createCriteria().andAreaCodeEqualTo(areaCode);
		return mapper.selectByExample(example);
	}
}

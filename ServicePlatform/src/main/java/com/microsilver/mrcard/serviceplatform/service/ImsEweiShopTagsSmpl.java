package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopTagsMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopTags;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopTagsExample;

@Service
public class ImsEweiShopTagsSmpl {
	@Resource
	ImsEweiShopTagsMapper eweiShopTagsMapper;

	public List<ImsEweiShopTags> getAllShopTags() {
		ImsEweiShopTagsExample example = new ImsEweiShopTagsExample();
		return eweiShopTagsMapper.selectByExample(example);
	}
}

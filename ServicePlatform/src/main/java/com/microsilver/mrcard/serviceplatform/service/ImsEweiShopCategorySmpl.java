package com.microsilver.mrcard.serviceplatform.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopCategoryMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopCategory;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopCategoryExample;

@Service
public class ImsEweiShopCategorySmpl {

	@Resource
	private ImsEweiShopCategoryMapper categoryMapper;

	public Map<String, List<ImsEweiShopCategory>> getAllCategory() {
		Map<String, List<ImsEweiShopCategory>> map = new HashMap<>();
		ImsEweiShopCategoryExample example = new ImsEweiShopCategoryExample();
		example.createCriteria().andEnabledEqualTo((byte) 1);
		List<ImsEweiShopCategory> categoryList = categoryMapper.selectByExample(example);
		List<ImsEweiShopCategory> firstLevel = new ArrayList<>();
		List<ImsEweiShopCategory> secondLevel = new ArrayList<>();
		for (ImsEweiShopCategory cate : categoryList) {
			if (cate.getLevel() == 1) {
				firstLevel.add(cate);
			}
			if (cate.getLevel() == 2) {
				secondLevel.add(cate);
			}
		}
		map.put("firstLevel", firstLevel);
		map.put("secondLevel", secondLevel);
		return map;
	}
}

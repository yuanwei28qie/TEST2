package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.dao.ImsSysDictionaryMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionary;
import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionaryExample;

@Service
public class ImsSysDictionarySmpl {

	@Resource
	ImsSysDictionaryMapper mapper;
	public List<ImsSysDictionary> selectByExample(ImsSysDictionaryExample example){
    	return mapper.selectByExample(example);
    }
}

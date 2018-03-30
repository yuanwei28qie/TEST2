package com.microsilver.mrcard.serviceplatform.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.dao.ImsSysRemindMapper;
import com.microsilver.mrcard.serviceplatform.model.ImsSysRemind;
import com.microsilver.mrcard.serviceplatform.model.ImsSysRemindExample;

@Service
public class ImsSysRemindService {
	@Resource
	ImsSysRemindMapper mapper;
	
    public int newRemind(ImsSysRemind record){
    	return mapper.insertSelective(record);
    }
    
    public List<ImsSysRemind> checkIfRemind(Long goodsId,Long memberId){
    	ImsSysRemindExample example = new ImsSysRemindExample();
    	example.createCriteria().andObjectIdEqualTo(goodsId).andMemberIdEqualTo(memberId);    	
    	return mapper.selectByExample(example);
    }
}

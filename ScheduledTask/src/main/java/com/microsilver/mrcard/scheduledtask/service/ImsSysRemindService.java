package com.microsilver.mrcard.scheduledtask.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microsilver.mrcard.scheduledtask.dao.ImsSysRemindMapper;
import com.microsilver.mrcard.scheduledtask.model.ImsSysRemind;
import com.microsilver.mrcard.scheduledtask.model.ImsSysRemindExample;
import com.microsilver.mrcard.scheduledtask.utils.DateUtil;



@Service
public class ImsSysRemindService {
	@Resource
	ImsSysRemindMapper mapper;
	
    public int newRemind(ImsSysRemind record){
    	return mapper.insertSelective(record);
    }
    
    public List<ImsSysRemind> checkIfRemind(Long goodsId){
    	ImsSysRemindExample example = new ImsSysRemindExample();
    	example.createCriteria().andObjectIdEqualTo(goodsId);    	
    	return mapper.selectByExample(example);
    }
    
    public List<ImsSysRemind> listNextTimeRemind(){
    	ImsSysRemindExample example = new ImsSysRemindExample();
    	long nowDate = DateUtil.getNowDate();
		example.createCriteria().andRemindTimeBetween((int)nowDate, (int)(DateUtil.addMinutes(new Date(),10).getTime()/1000));		
    	return mapper.selectByExample(example);
    }
    public int deleteByPrimaryKey(Long id){
    	return mapper.deleteByPrimaryKey(id);
    }
}

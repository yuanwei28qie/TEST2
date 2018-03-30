package com.microsilver.mrcard.serviceplatform.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dao.ICheckCodeDao;
import com.microsilver.mrcard.serviceplatform.model.ImsCheckCode;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.service.CheckCodeSmpl
 * @Description 验证码服务类
 * 
 * @Author bruce
 * @Version 2017年6月30日 下午6:16:20
 * @Copyright Micro Silver
 *
 */
@Service
public class CheckCodeSmpl {
	@Autowired
	ICheckCodeDao iCheckCodeDao;
	
	public String getCheckCode(String mobile,int type){
		//6位随机数
		int radomInt = new Random().nextInt(999999);
		String shi = String.valueOf(System.currentTimeMillis());
		ImsCheckCode checkCode = new ImsCheckCode();
		checkCode.setCode(String.valueOf(radomInt));
		checkCode.setLastTime(Long.valueOf(shi.substring(0, 10)));
		checkCode.setPhone(mobile);
		checkCode.setType(type);
		if(iCheckCodeDao.countByModel(checkCode)==0){ 
			iCheckCodeDao.insert(checkCode);
		}else{
			iCheckCodeDao.updateByPhone(checkCode);
		}
		return String.valueOf(radomInt);
	}
	public ImsCheckCode selectByCheckCode(String mobile,int type) throws BusinessException{
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("phone", mobile);
		map.put("type", type);
		ImsCheckCode checkCode = iCheckCodeDao.selectByCheckCode(map);
		
		if(checkCode==null){
			throw new BusinessException(EWarning.CheckCodeNonExistent);
		}
		long interval = Utils.getCurrentTime()-checkCode.getLastTime();
		if(interval>Consts.CHECK_CODE_EFFECTIVE_MINUTE * 60){
			throw new BusinessException(EWarning.CheckCode_Overdue);
		}
		return checkCode;
	}
}

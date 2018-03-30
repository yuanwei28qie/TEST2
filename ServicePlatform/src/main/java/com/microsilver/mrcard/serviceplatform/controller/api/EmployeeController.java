package com.microsilver.mrcard.serviceplatform.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microsilver.mrcard.common.CryptoTools;
import com.microsilver.mrcard.serviceplatform.controller.BaseController;
import com.microsilver.mrcard.serviceplatform.dto.BusinessDto;
import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMember;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.service.MemberSmpl;
import com.microsilver.mrcard.serviceplatform.service.ShopMerchSmpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.controller.api.EmployeeController
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年7月8日 下午1:53:16
 * @Copyright Micro Silver
 *
 */
@Api(value = "/api/employee", description = "雇员相关API")
@Controller
@RequestMapping("/api/employee")
public class EmployeeController extends BaseController{
	@Autowired
	MemberSmpl memberSmpl;
	@Autowired
	ShopMerchSmpl merchSmpl;
	@ApiOperation(value = "雇员登录接口", httpMethod = "POST")
	@RequestMapping(value = "/employeeLogin",method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<BusinessDto> login(String mobile,String password){
		RespBaseDto<BusinessDto> result = new RespBaseDto<BusinessDto>();
		ImsEweiShopMember member = memberSmpl.selectByMobile(mobile);
		//检查手机号
		if(member==null){
			result.setState(EWarning.NonExistent.getValue());
			result.setMessage(EWarning.NonExistent.getName());
		}else{
			//检查密码
			String pwd = CryptoTools.EncoderByMd5(password+member.getSalt());
			if(!member.getPwd().equals(pwd)){
				result.setState(EWarning.PasswordError.getValue());
				result.setMessage(EWarning.PasswordError.getName());
			}else{
				//检查雇员账号
				result = merchSmpl.checkEmployeeAccount(member);
			}
		}
		return result;
	}
}

package com.microsilver.mrcard.basicservice.controller;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microsilver.mrcard.basicservice.dto.RespBaseDto;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfo;
import com.microsilver.mrcard.basicservice.model.FxSdUserMember;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.microsilver.mrcard.basicservice.service.UserService;

/**
 * 
 * @Name com.microsilver.mrcard.basicservice.controller.UserController
 * @Description 
 * 
 * @Author huwei
 * @Version 2018年3月28日 上午10:16:02
 * @Copyright  Micro Silver-SuperDelivery
 *
 */
@Api(value = "/api/user", description= "用户基础API")
@Controller
@RequestMapping(value = "/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@ApiOperation(value = "用户注册(手机号快速注册)", httpMethod = "POST")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "body"),
		@ApiImplicitParam(name = "checkCode", value = "验证码", required = true, paramType = "body")})
	@RequestMapping(value = "/quickRegister")
	@ResponseBody
	public RespBaseDto<Object> UserQuickRegister(
			String mobile,
			String checkCode){
		 RespBaseDto<Object> result = new RespBaseDto<Object>();
		 if(mobile==null||mobile.trim().equals("")) {
			 result.setMessage("您的手机号为空,请重新输入");
			 result.setState(1);
			 return result;
		 }
		 if(checkCode==null||checkCode.trim().equals("")) {
			 result.setMessage("您的验证码为空,请重新输入");
			 result.setState(2);
			 return result;
		 }
		 FxSdUserMember selectUserByMobile = userService.selectUserByMobile(mobile);
		 if(selectUserByMobile!=null) {
			 result.setMessage("您的手机号已注册,请重新选择");
			 result.setState(3);
			 return result;
		 }
		String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile);
		System.out.println(redisCheckCode);
		if (redisCheckCode == null || redisCheckCode.trim().equals("")) {
			result.setMessage("验证码未获取,请联系管理员");
			result.setState(4);
			return result;
		}
		int valueOf = Integer.valueOf(redisCheckCode);
		int valueOf2 = Integer.valueOf(checkCode);
		if (valueOf != valueOf2) {
			result.setMessage("验证码有误,请联系管理员");
			result.setState(5);
			return result;
		}
		 
		 //创建一个用户对象
		 FxSdUserMember fxSdUserMember = new FxSdUserMember();
		 fxSdUserMember.setMobile(mobile);
		 fxSdUserMember.setCreatetime((int) new Date().getTime());
		 //默认信用等级分80
		 fxSdUserMember.setServicescor(80);
		 //添加到数据库
		 userService.insertUser(fxSdUserMember);
		 result.setMessage("用户添加成功");
		 result.setState(6);
		 return result;
	}
	
	@ApiOperation(value = "用户注册(手机号密码注册)", httpMethod = "POST")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "body"),
		@ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "body")})
	@RequestMapping(value = "/UserRegister")
	@ResponseBody
	public RespBaseDto<Object> UserRegister(
			String mobile,
			String password){
		 RespBaseDto<Object> result = new RespBaseDto<Object>();
		 if(mobile.trim().equals("")||mobile==null) {
			 	result.setMessage("手机号为空,请重新输入");
				result.setState(1);
				return result;
		 }
		 if(password==null||password.trim().trim().equals("")) {
			 	result.setMessage("密码不能为空,请重新输入");
				result.setState(2);
				return result;
		 }
		 FxSdUserMember selectUserByMobile = userService.selectUserByMobile(mobile);
		 if(selectUserByMobile!=null) {
			 result.setMessage("您的手机号已注册,请重新选择");
			 result.setState(3);
			 return result;
		 }
		//创建一个用户对象
		 FxSdUserMember fxSdUserMember = new FxSdUserMember();
		 fxSdUserMember.setMobile(mobile);
		 fxSdUserMember.setPwd(DigestUtils.md5Hex(password));
		 fxSdUserMember.setCreatetime((int) new Date().getTime());
		 //默认信用等级分80
		 fxSdUserMember.setServicescor(80);
		 //添加到数据库
		 userService.insertUser(fxSdUserMember);
		
		 result.setMessage("用户添加成功");
		 result.setState(4);
	
		 return result;
			
	}
	
	/**
	 * 
	 * 忘记密码,更新数据库中密码
	 */
	@ApiOperation(value = "忘记密码", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "form"),
			@ApiImplicitParam(name = "checkCode", value = "短信验证码", required = true, paramType = "form"),
			@ApiImplicitParam(name = "newPwd", value = "新密码", required = true, paramType = "form"),
			@ApiImplicitParam(name = "newConfirmPwd", value = "确认新密码", required = true, paramType = "form") })
	@RequestMapping(value = "/UserForgetPwd")
	@ResponseBody
	public RespBaseDto<Object> UserForgetPwd(
			String mobile, 
			String checkCode, 
			String newPwd, 
			String newConfirmPwd) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		if (mobile == null || mobile.trim().equals("")) {
			result.setState(1);
			result.setMessage("手机号不能为空,请重新输入");
			return result;
		}

		if (checkCode == null || checkCode.trim().equals("")) {
			result.setState(2);
			result.setMessage("验证码不能为空,请重新输入");
			return result;
		}
		if (newPwd == null || newPwd.trim().equals("")) {
			result.setState(3);
			result.setMessage("密码不能为空,请重新输入");
			return result;
		}
		if (newConfirmPwd == null || newConfirmPwd.trim().equals("")) {
			result.setState(4);
			result.setMessage("密码不能为空,请重新输入");
			return result;
		}
		FxSdUserMember selectUserByMobile = userService.selectUserByMobile(mobile);
		if (selectUserByMobile == null) {
			result.setState(5);
			result.setMessage("手机号未注册,请注册后登陆");
			return result;
		}
		String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile);
		if (!redisCheckCode.equals(checkCode)) {
			result.setState(6);
			result.setMessage("验证码有误,请重新输入");
			return result;
		}
		if (!newPwd.equals(newConfirmPwd)) {
			System.out.println(newPwd);
			System.out.println(newConfirmPwd);
			result.setState(7);
			result.setMessage("两次密码输入不一致,请重新输入");
			return result;
		}
		// 更新密码
		selectUserByMobile.setPwd(DigestUtils.md5Hex(newPwd));
		userService.updatePwd(selectUserByMobile);
		result.setState(8);
		result.setMessage("密码更新成功,请重新登陆");

		return result;

	}
	
	
	/**
	 * 
	 * 用户手机号,验证码登陆
	 */
	@ApiOperation(value = "用户登陆(手机号,验证码登陆)", httpMethod = "POST")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "form"),
			@ApiImplicitParam(name = "checkCode", value = "短信验证码", required = true, paramType = "form") })
	@RequestMapping(value = "/UserQuickLogin")
	@ResponseBody
	public RespBaseDto<Object> UserQuickLogin(String mobile, String checkCode) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		if (mobile == null || mobile.trim().equals("")) {
			result.setState(1);
			result.setMessage("手机号不能为空,请重新输入");
			return result;
		}
		if (checkCode == null || checkCode.trim().equals("")) {
			result.setState(5);
			result.setMessage("验证码不能为空,请重新输入");
			return result;
		}
		FxSdUserMember selectUserByMobile = userService.selectUserByMobile(mobile);
		if (selectUserByMobile == null) {
			result.setState(2);
			result.setMessage("手机号未注册,请注册后登陆");
			return result;
		}
		String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile);
		if (!redisCheckCode.equals(checkCode)) {
			result.setState(3);
			result.setMessage("验证码有误,请重新输入");
			return result;
		}
		result.setState(4);
		result.setMessage("恭喜你,登陆成功");
		return result;
	}
	/**
	 * 用户登陆(用户和密码登陆)
	 */
	@ApiOperation(value = "用户登陆(手机号,密码登陆)", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "form"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form") })
	@RequestMapping(value = "/UserLogin")
	@ResponseBody
	public RespBaseDto<Object> UserLogin(String mobile, String password) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		if (mobile == null || mobile.trim().equals("")) {
			result.setState(1);
			result.setMessage("你输入的电话号码为空,请重新输入");
			return result;
		}
		if (password == null || password.trim().equals("")) {
			result.setState(2);
			result.setMessage("你输入的密码不能为空,请重新输入");
			return result;
		}
		// 验证手机号是否存在
		FxSdUserMember selectUserByMobile = userService.selectUserByMobile(mobile);
		if (selectUserByMobile == null) {
			result.setState(3);
			result.setMessage("您输入的电话未注册,请先注册");
			return result;
		}
		// 验证密码是否正确
		String md5password = DigestUtils.md5Hex(password);
		if (!selectUserByMobile.getPwd().equals(md5password)) {
			result.setState(4);
			result.setMessage("您输入的密码有误,请重新输出");
			return result;
		}
		result.setState(5);
		result.setMessage("恭喜你,登陆成功");

		return result;
	}
}

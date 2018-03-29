package com.microsilver.mrcard.basicservice.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.microsilver.mrcard.basicservice.dto.RespBaseDto;
import com.microsilver.mrcard.basicservice.model.FxSdUserDeliverinfo;
import com.microsilver.mrcard.basicservice.service.SuperDeliveryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
@Api(value = "/api/superDelivery", description = "骑手功能API")
@Controller
@RequestMapping(value = "/api/superDelivery")
public class SuperDeliveryController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private SuperDeliveryService superDeliveryService;

	/**
	 * 骑手注册
	 * 
	 */
	@ApiOperation(value = "跑腿注册(手机号注册)", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "body"),
			@ApiImplicitParam(name = "checkCode", value = "验证码", required = true, paramType = "body"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "body"),
			@ApiImplicitParam(name = "refereeMobile", value = "推荐手机号", required = false, paramType = "body") })
	@RequestMapping(value = "/quickRegister")
	@ResponseBody
	public RespBaseDto<FxSdUserDeliverinfo> SuperDeliveryregister(String mobile, String checkCode, String password,
			@RequestParam(defaultValue = "") String refereeMobile) {
		RespBaseDto<FxSdUserDeliverinfo> result = new RespBaseDto<FxSdUserDeliverinfo>();
		if (mobile == null || mobile.equals("")) {
			result.setMessage("您的电话为空,请重新输入");
			result.setState(1);
			return result;
		}
		FxSdUserDeliverinfo delivery = superDeliveryService.selectDeliveryBymobile(mobile);
		if (delivery != null) {
			result.setMessage("手机号已注册,请您直接登陆");
			result.setState(2);
			return result;
		}
		if (checkCode == null || checkCode.equals("")) {
			result.setMessage("您的验证码不能为空,请重新输入");
			result.setState(3);
			return result;
		}
		String redisCheckCode = stringRedisTemplate.opsForValue().get(mobile);
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
		// 判断推荐人手机号是否存在
		FxSdUserDeliverinfo RefereeMobileDeliver = superDeliveryService.selectDeliveryByRefereeMobile(refereeMobile);
		if (RefereeMobileDeliver == null) {
			result.setMessage("推荐人不存在,请你重新输入");
			result.setState(6);
			return result;
		}
		// 加密密码
		String pwd = DigestUtils.md5Hex(password);
		FxSdUserDeliverinfo info = new FxSdUserDeliverinfo();
		info.setMobile(mobile);
		info.setPwd(pwd);
		if (refereeMobile == null || refereeMobile.trim().equals("")) {
			info.setReferee(null);
		} else {
			long parseLong = Long.parseLong(refereeMobile);
			info.setReferee(parseLong);
		}
		superDeliveryService.insertDelivery(info);
		result.setData(info);
		result.setMessage("您好:手机用户:" + mobile + "恭喜您,注册成功.");
		result.setState(7);
		return result;
	}

	/**
	 * 骑手登陆(用户和密码登陆)
	 */
	@ApiOperation(value = "骑手登陆(手机号,密码登陆)", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "form"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form") })
	@RequestMapping(value = "/superliveryLogin")
	@ResponseBody
	public RespBaseDto<Object> SuperliveryLogin(String mobile, String password) {
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
		FxSdUserDeliverinfo selectDeliveryBymobile = superDeliveryService.selectDeliveryBymobile(mobile);
		if (selectDeliveryBymobile == null) {
			result.setState(3);
			result.setMessage("您输入的电话未注册,请先注册");
			return result;
		}
		// 验证密码是否正确
		String md5password = DigestUtils.md5Hex(password);
		if (!selectDeliveryBymobile.getPwd().equals(md5password)) {
			result.setState(4);
			result.setMessage("您输入的密码有误,请重新输出");
			return result;
		}
		result.setState(5);
		result.setMessage("恭喜你,登陆成功");

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
	@RequestMapping(value = "/ForgetPwd")
	@ResponseBody
	public RespBaseDto<Object> ForgetPwd(String mobile, String checkCode, String newPwd, String newConfirmPwd) {
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
		FxSdUserDeliverinfo selectDeliveryBymobile = superDeliveryService.selectDeliveryBymobile(mobile);
		if (selectDeliveryBymobile == null) {
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
		selectDeliveryBymobile.setPwd(DigestUtils.md5Hex(newPwd));
		superDeliveryService.updatePwd(selectDeliveryBymobile);
		result.setState(8);
		result.setMessage("密码更新成功,请重新登陆");

		return result;

	}

	/**
	 * 完善飞人资料
	 * 
	 */
	@ApiOperation(value = "完善飞人资料", httpMethod = "POST")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "loginName", value = "登陆名", required = true, paramType = "form"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form"),
			@ApiImplicitParam(name = "city", value = "所在城市", required = true, paramType = "form"),
			@ApiImplicitParam(name = "name", value = "姓名", required = true, paramType = "form"),
			@ApiImplicitParam(name = "sex", value = "性别", required = true, paramType = "form"),
			@ApiImplicitParam(name = "identityNumber", value = "身份证号码", required = true, paramType = "form"),
			@ApiImplicitParam(name = "address", value = "所在地址", required = true, paramType = "form"),
			@ApiImplicitParam(name = "emergentMobile", value = "紧急人联系电话", required = true, paramType = "form"),
			@ApiImplicitParam(name = "occupation", value = "工作职位", required = true, paramType = "form") })
	@RequestMapping(value = "/PerfectSuperDelivery")
	@ResponseBody
	public RespBaseDto<Object> PerfectSuperDelivery(
			String loginName, 
			String password, 
			String city, 
			String name,
			String sex, 
			String identityCardNo, 
			String address, 
			String emergentMobile, 
			String occupation,
			HttpServletRequest request) {
		// 存放基础类
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		// 登录名,查询数据库中是否存在
		FxSdUserDeliverinfo selectDeliveryBymobile = superDeliveryService.selectDeliveryBymobile(loginName);
		if (selectDeliveryBymobile == null) {
			result.setMessage("您的用户名不存在,请你输入正确的用户名");
			result.setState(1);
			return result;
		}
		if(selectDeliveryBymobile.getPwd().equals("")||selectDeliveryBymobile.getPwd()==null) {
			result.setMessage("您的账号没有密码,请重新设置");
			result.setState(8);
			return result;
		}
		// 验证密码是否正确
		if (!selectDeliveryBymobile.getPwd().equals(DigestUtils.md5Hex(password))) {
			result.setMessage("您的密码不准确,请你重新输入");
			result.setState(2);
			return result;
		}
		// 验证身份证是否符合规范
		// 校验身份证验证码
		// 十八位：^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$
		// 十五位：^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}[0-9Xx]$
		if (!identityCardNo.matches(
				"^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$")) {
			result.setMessage("您的身份证不符合规格,请你重新输入");
			result.setState(3);
			return result;
		}
		// 校验身份证是否符合规范
		if (!emergentMobile.matches("[1][35789]\\d{9}")) {
			result.setMessage("您的紧急联系人电话不符合规格,请你重新输入");
			result.setState(4);
			return result;
		}
		// 存入数据库
		//FxSdUserDeliverinfo fxSdUserDeliverinfo = new FxSdUserDeliverinfo();
		selectDeliveryBymobile.setAddress(address);
		selectDeliveryBymobile.setCheckStatus((byte)2);
		selectDeliveryBymobile.setCreateTime((int) new Date().getTime());
		selectDeliveryBymobile.setMobile(loginName);
		selectDeliveryBymobile.setRealname(name);
		selectDeliveryBymobile.setSex((byte)2);
		selectDeliveryBymobile.setCity(1L);
		selectDeliveryBymobile.setIdentityCardNo(identityCardNo);
		selectDeliveryBymobile.setOtherphoneno(emergentMobile);
		selectDeliveryBymobile.setOccupation(occupation);
		//selectDeliveryBymobile.setId(null);
		// 解析上传图片
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		String filePath = "D://aim//";
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			System.out.println("文件的名称" + file.getOriginalFilename());
			// 按照上传的顺序来判断是合照,正面,背面;
			System.out.println("文件的名字" + file.getName());
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					stream = new BufferedOutputStream(
							new FileOutputStream(new File(filePath + file.getOriginalFilename())));// 设置文件路径及名字
					stream.write(bytes);// 写入
					stream.close();
				} catch (Exception e) {
					stream = null;
					result.setMessage("第 " + i + " 个文件上传失败  ==> " + e.getMessage());
					result.setState(5);
					return result;
				}
			} else {
				result.setMessage("第 " + i + " 个文件上传失败因为文件为空");
				result.setState(6);
				return result;

			}
		}
		// 0是合照,1是正面,2是背面
		selectDeliveryBymobile.setIdentityCardGroup(filePath + files.get(0).getOriginalFilename());
		selectDeliveryBymobile.setIdentityCardFront(filePath + files.get(1).getOriginalFilename());
		selectDeliveryBymobile.setIdentityCardBack(filePath + files.get(2).getOriginalFilename());
		superDeliveryService.updateSuperDelivery(selectDeliveryBymobile);
		result.setMessage("完善资料成功,请耐心等待审核通过");
		result.setState(5);
		return result;
	}
	/**
	 * 飞人资料完善成功(是否培训成功)
	 */
	@ApiOperation(value = "骑手培训成功", httpMethod = "POST")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "mobile", value = "手机号(骑手登陆账号)", required = true, paramType = "form")})
	@RequestMapping("/UpdateSuperDeliveryCheckStauts")
	@ResponseBody
	public RespBaseDto<Object> UpdateSuperDeliveryCheckStauts(String mobile){
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		FxSdUserDeliverinfo selectDeliveryBymobile = superDeliveryService.selectDeliveryBymobile(mobile);
		if(selectDeliveryBymobile==null) {
			result.setMessage("该用户不存在,请你重新输入");
			result.setState(1);
			return result;
		}
		selectDeliveryBymobile.setCheckStatus((byte)2);
		superDeliveryService.updateSuperDelivery(selectDeliveryBymobile);
		result.setMessage("用户培训已成功,恭喜你正式成为骑手");
		result.setState(2);
		return result;
	}
	
}

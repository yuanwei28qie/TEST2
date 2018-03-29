package com.microsilver.mrcard.basicservice.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.basicservice.dto.RespBaseDto;
import com.microsilver.mrcard.basicservice.model.enums.EWarning;
import com.microsilver.mrcard.basicservice.mq.MQSendMsgHelper;
import com.microsilver.mrcard.basicservice.service.IFinanceRemoteSmpl;
import com.microsilver.mrcard.mq.PushMsg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/api/Common", description = "通用方法API")
@Controller
@RequestMapping("/api/Common")
public class CommonController extends BaseController {
	@Autowired
	private MQSendMsgHelper mqsendMsgHelper;
	/**
	 * 获取短信验证码
	 */
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@ApiOperation(value = "获取短信验证码", httpMethod = "POST")
	@RequestMapping(value = { "/getCheckCode" }, method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<Object> getCheckCode(String mobile) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		if (mobile != null && !mobile.equals("")) {
			String checkCode = stringRedisTemplate.opsForValue().get(mobile);
			if (checkCode != null) {
				result.setData(checkCode);
				result.setMessage("短信验证码");
				result.setState(1);
				return result;
			}
		}
		result.setMessage("验证码不能为空");
		result.setState(2);
		return result;
	}

	/**
	 * 发送验证码
	 */
	@Autowired
	IFinanceRemoteSmpl financeRemoteSmpl;

	@Autowired
	private MQSendMsgHelper mqSendMsgHelper;

	@ApiOperation(value = "发送短信验证码并保存", httpMethod = "POST")
	@RequestMapping(value = { "/sendAndSaveCheckCode" }, method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<Object> sendAndSaveCheckCode(String mobile) {
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		if (mobile != null && !mobile.equals("")) {
			mobile = mobile.trim();
			// 生成验证码
			int radomInt = new Random().nextInt(999999);
			String checkCode = String.valueOf(radomInt);
			// 存入redis中
			stringRedisTemplate.opsForValue().set(mobile, checkCode);
			//发送消息给MQ
			mqSendMsgHelper.sendJSONMsg(mobile+"-"+checkCode+"-"+"您的验证码是:"+checkCode+",如非本人操作,请忽略本短信");
			result.setData(null);
			result.setMessage("发送成功");
			result.setState(1);
			return result;
		}

		return result;
	}
	@ApiOperation(value = "MQ接收处理，短信消息，推送消息", httpMethod = "POST")
	@RequestMapping(value = "/pushMessageToMQ", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<Object> pushMessageToMQ(PushMsg msg){
		logger.info("PushMsg :"+JSON.toJSONString(msg));

		RespBaseDto<Object> res = new RespBaseDto<Object>();
		try{
			mqsendMsgHelper.sendJSONMsg(msg);
			res.setMessage("OK");
		}catch (Exception ex){
			res.setState(EWarning.Unknown.getValue());
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}
		return res;
	}
	
}

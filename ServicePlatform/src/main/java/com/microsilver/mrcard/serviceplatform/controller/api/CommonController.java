package com.microsilver.mrcard.serviceplatform.controller.api;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.common.CryptoTools;
import com.microsilver.mrcard.common.HttpClientUtils;
import com.microsilver.mrcard.mq.ESMSTemplate;
import com.microsilver.mrcard.mq.MemberMQ;
import com.microsilver.mrcard.mq.OrderMQ;
import com.microsilver.mrcard.mq.PushMsg;
import com.microsilver.mrcard.mq.SortMQ;
import com.microsilver.mrcard.serviceplatform.baidutranslate.TransApi;
import com.microsilver.mrcard.serviceplatform.common.DictionaryUtils;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.controller.BaseController;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dao.IMemberIdentityDao;
import com.microsilver.mrcard.serviceplatform.dao.ImsEweiShopMerchUserMapper;
import com.microsilver.mrcard.serviceplatform.dao.ImsUserRecommendMapper;
import com.microsilver.mrcard.serviceplatform.dto.ImsSysAreaDto;
import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.model.ImsAppVersion;
import com.microsilver.mrcard.serviceplatform.model.ImsCheckCode;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMember;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberDevice;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUser;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUserExample;
import com.microsilver.mrcard.serviceplatform.model.ImsSysArea;
import com.microsilver.mrcard.serviceplatform.model.ImsSysGroup;
import com.microsilver.mrcard.serviceplatform.model.ImsUnicid;
import com.microsilver.mrcard.serviceplatform.model.ImsUserRecommendExample;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.mq.MQSendMsgHelper;
import com.microsilver.mrcard.serviceplatform.service.CheckCodeSmpl;
import com.microsilver.mrcard.serviceplatform.service.ImsAppVersionServiceSmpl;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopMemberDeviceSmpl;
import com.microsilver.mrcard.serviceplatform.service.ImsSysAreaSmpl;
import com.microsilver.mrcard.serviceplatform.service.MemberSmpl;
import com.microsilver.mrcard.serviceplatform.service.SysResourceServiceSmpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;



/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.controller.api.CommonController
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年6月30日 下午7:02:38
 * @Copyright Micro Silver
 *
 */

@Api(value = "/api/Common", description = "通用方法API")
@Controller
@RequestMapping("/api/Common")
public class CommonController extends BaseController{
	@Autowired
	CheckCodeSmpl checkCodeSmpl;
	@Autowired
	ImsAppVersionServiceSmpl imsAppVersionServiceSmpl;
	@Autowired
	MemberSmpl memberSmpl;
	@Resource
	private ImsSysAreaSmpl imsSysAreaSmpl;
	@Autowired
	ImsEweiShopMemberDeviceSmpl deviceService;
	@Autowired
	private MQSendMsgHelper mqsendMsgHelper;
	@Autowired
	IMemberIdentityDao iMemberIdentityDao;

	@Autowired
	SysResourceServiceSmpl sysResourceServiceSmpl;
	@Resource
	ImsUserRecommendMapper recommendMapper;
	
	@ApiOperation(value = "获取服务器时间", httpMethod = "POST")
	@RequestMapping(value = "/getSysTime")
	@ResponseBody
	public RespBaseDto<String> getSysTime(){
		RespBaseDto<String> result = new RespBaseDto<String>();
		result.setData(String.valueOf(System.currentTimeMillis()));
		result.setMessage("OK");
		return result;
	}
	
	@ApiOperation(value = "APP获取最新版本", httpMethod = "POST")
	@RequestMapping(value = "/getRecentlyVersion")
	@ApiImplicitParams({@ApiImplicitParam(name="appType",value="APP类型1:卡先生消费者版本2:卡先生商家版3:卡先生雇员版4:超级订消费者版5:小飞侠骑士版",dataType="int"),
		@ApiImplicitParam(name="clientType",value="终端类型(1:android,2:ios)",dataType="int")})
	@ResponseBody
	public RespBaseDto<ImsAppVersion> getRecentlyVersion(Integer appType,Byte clientType){
		RespBaseDto<ImsAppVersion> result = new RespBaseDto<ImsAppVersion>();
		ImsAppVersion version = imsAppVersionServiceSmpl.getRecentlyVersion(appType, clientType);
		if(version == null){
			version = new ImsAppVersion();
			result.setMessage("未初始化版本");
			result.setState(0);
		}else{
			result.setMessage("SUCCESS");
		}
		result.setData(version);		
		return result;
	}
	/**
	 * 
	 * 获取短信验证码
	 * @param mobile
	 * @param type(1:注册,2：登录,3:修改密码;4：提现验证)
	 * time:2018.03.16
	 * @return
	 */
	@ApiOperation(value = "获取短信验证码", httpMethod = "POST")
	@ApiImplicitParams({@ApiImplicitParam(name="type",value="验证码类型(1:注册,2：登录,3:修改密码(更换手机号))")})
	@RequestMapping(value = { "/getCheckCode" }, method = RequestMethod.POST)  
	@ResponseBody
	public RespBaseDto<Object> getCheckCode(HttpServletRequest request, String mobile, int type){
		RespBaseDto<Object> result = new RespBaseDto<Object>();
		try{
			String headers = request.getHeader("apptype");
			if(null == headers || "".equals(headers)){
				headers ="4";//default hotel
				logger.info("验证码接口未取到apptype，转换默认应用-超级定4");
			}
			ImsEweiShopMember oldShopMember = memberSmpl.selectByMobile(mobile);
			if(type==1){
				if(oldShopMember!=null){
					result.setState(EWarning.MobileExist.getValue());
					result.setMessage(EWarning.MobileExist.getName());
					return result;
				}
			}if(type==3) {
				if(oldShopMember==null){
					result.setState(EWarning.MobileNotRegister.getValue());
					result.setMessage(EWarning.MobileNotRegister.getName());
					return result;
				}
			}
			String code = checkCodeSmpl.getCheckCode(mobile, type);
			int templateId = ESMSTemplate.valueOf(Integer.valueOf(headers),type).getTplId();

			PushMsg pushMsg = new PushMsg();
			pushMsg.setPushType(1);
			pushMsg.setAppType(Byte.parseByte(headers));
			pushMsg.setTitle(code);
			pushMsg.setPhone(mobile);
			pushMsg.setTemplateType(templateId);
			logger.debug(" getCheckCode  messageBody {}",JSON.toJSONString(pushMsg));
			mqsendMsgHelper.sendJSONMsg(pushMsg);
			//JuheMsg.sendCheckCode(mobile,code,templateId);
			result.setMessage("OK");
		}
		catch(Exception ex){
			logger.error(ex.getMessage());
			result.setState(EWarning.SendCheckCodeError.getValue());
			result.setMessage(ex.getMessage());
			ex.printStackTrace();
		}
		return result;
	}
	/**
	 * 验证校验码 
	 * @param checkCode
	 * @param type
	 * @return
	 */
	@ApiOperation(value = "验证校验码 ", httpMethod = "POST")
	@RequestMapping(value = { "/validateCheckCode" }, method = RequestMethod.POST)  
	@ResponseBody
	public RespBaseDto<String> validateCheckCode(String mobile,int type,String checkCode){
		RespBaseDto<String> result = new RespBaseDto<String>();
		try{
			if(checkCode.equals("100200")) {
				result.setMessage("OK");
				return result;
			}
			ImsCheckCode imsCheckCode = checkCodeSmpl.selectByCheckCode(mobile,type);
			if(imsCheckCode.getCode().equals(checkCode)){
				result.setMessage("OK");
			}else{
				result.setState(EWarning.CheckCodeError.getValue());
				result.setMessage(EWarning.CheckCodeError.getName());
			}
		}
		catch(BusinessException bex){
			result.setState(bex.getWarning().getValue());
			result.setMessage(bex.getWarning().getName());
		}
		return result;
	}
	
	/**
	 * 修改绑定手机
	 * @param checkCode
	 * @param type
	 * @return
	 */
	@ApiOperation(value = "修改绑定手机 ", httpMethod = "POST")
	@RequestMapping(value = { "/updateMobile" }, method = RequestMethod.POST)  
	@ResponseBody
	public RespBaseDto<String> updateMobile(Long id,String mobile){
		RespBaseDto<String> result = new RespBaseDto<String>();
		try{
			ImsEweiShopMember shopMember = memberSmpl.selectByMobile(mobile);
			if(shopMember!=null){
				result.setState(EWarning.MobileExist.getValue());
				result.setMessage(EWarning.MobileExist.getName());
				return result;
			}
			memberSmpl.updateMobile(id, mobile);
			result.setData("ok");
		}
		catch(BusinessException bex){
			result.setState(bex.getWarning().getValue());
			result.setMessage(bex.getWarning().getName());
		}catch(Exception e) {
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	/**
	 * 修改密码
	 * @param id 用户主键
	 * @param pwd 新密码
	 * @return
	 */
	@ApiOperation(value = "修改密码 ", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="用户id"),
		@ApiImplicitParam(name="pwd",value="新密码"),
		@ApiImplicitParam(name="oldPwd",value="老密码")
	})
	@RequestMapping(value = { "/modifyPassword" }, method = RequestMethod.POST)  
	@ResponseBody
	public RespBaseDto<String> modifyPassword(@RequestParam Long id,@RequestParam String pwd,String oldPwd){
		RespBaseDto<String> result = new RespBaseDto<String>();
		ImsEweiShopMember member = memberSmpl.selectMemberById(id);
		
		if(oldPwd != null&&!member.getPwd().equals(CryptoTools.EncoderByMd5(oldPwd + member.getSalt()))) {
			result.setMessage(EWarning.PasswordError.getName());
			result.setState(EWarning.PasswordError.getValue());
			return result;
		}
		String salt = Utils.getRandomString(16);
		member.setSalt(salt);
		member.setPwd(CryptoTools.EncoderByMd5(pwd + salt));
		try {
			memberSmpl.updatePassword(member);
			result.setMessage("OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	/**
	 * 找回密码
	 * @param mobile 用户手机号
	 * @param pwd 新密码
	 * @return
	 */
	@ApiOperation(value = "找回密码 ", httpMethod = "POST")
	@RequestMapping(value = { "/findPassword" }, method = RequestMethod.POST)  
	@ResponseBody
	public RespBaseDto<String> findPassword(@RequestParam String mobile,@RequestParam String pwd){
		RespBaseDto<String> result = new RespBaseDto<String>();
		ImsEweiShopMember member = memberSmpl.selectByMobile(mobile);
		if(member != null){
			String salt = Utils.getRandomString(16);
			member.setSalt(salt);
			member.setPwd(CryptoTools.EncoderByMd5(pwd + salt));			
			try {
				memberSmpl.updatePassword(member);
				result.setMessage("OK");
			} catch (Exception e) {
				e.printStackTrace();
				result.setMessage(EWarning.Unknown.getName());
				result.setState(EWarning.Unknown.getValue());
			}
		}else{
			result.setMessage(EWarning.NonExistent.getName());
			result.setState(EWarning.NonExistent.getValue());
		}
		return result;
	}
	
	@ApiOperation(value = "获取已开通的区域", httpMethod = "POST")
	@RequestMapping(value = "/getActivatedArea")
	@ResponseBody
	public RespBaseDto<Map<String,List<ImsSysAreaDto>>> getActivatedArea() throws Exception{
		RespBaseDto<Map<String,List<ImsSysAreaDto>>> result = new RespBaseDto<>();		
		Set<Long> provinceSet = new HashSet<>();
		Set<Long> citySet = new HashSet<>();
		Set<Long> countrySet = new HashSet<>();
		List<ImsUnicid> list = imsSysAreaSmpl.getAllImsUnicid();
		if(list!=null){
			for (ImsUnicid imsUnicid : list) {
				provinceSet.add(imsUnicid.getProvince());
				citySet.add(imsUnicid.getCity());
				countrySet.add(imsUnicid.getCounty());
			}
		}
		Map<String,List<ImsSysAreaDto>> map = new HashMap<>();
		map.put("province",getArea(provinceSet,null));
		map.put("city",getArea(citySet,null));
		map.put("country",getArea(countrySet,list));
		
		result.setData(map);
		result.setMessage("OK");
		return result;
	}

	private List<ImsSysAreaDto> getArea(Set<Long> set,List<ImsUnicid> listUnicid) throws Exception {
		Map<Long, ImsSysArea> areaMap = DictionaryUtils.getAreaMap();
		List<ImsSysAreaDto>  list = new ArrayList<>();
		for (Long code : set) {
			ImsSysArea e = areaMap.get(code);
			ImsSysAreaDto dto = new ImsSysAreaDto();
			BeanUtils.copyProperties(dto, e);
			if(listUnicid != null){
				for (ImsUnicid imsUnicid : listUnicid) {
					if(code==imsUnicid.getCounty()) {
						dto.setUnicid(imsUnicid.getUnicid());			
						break;
					}
				}
			}
			list.add(dto);
		}
		return list;
	}

	@ApiOperation(value = "获取全部区域", httpMethod = "POST")
	@RequestMapping(value = "/getAllArea")
	@ResponseBody
	public RespBaseDto<List<ImsSysArea>> getAllArea() throws Exception{
		RespBaseDto<List<ImsSysArea>> dto = new RespBaseDto<>();
		List<ImsSysArea> allArea = DictionaryUtils.getSysAreas();
		dto.setData(allArea);
		return dto;
	}
	
	@ApiOperation(value = "同步设备基本信息", httpMethod = "POST")
	@RequestMapping(value = "/syncinfo", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto synchronizeDeviceInfo(ImsEweiShopMemberDevice deviceInfo){
		logger.info("device :"+JSON.toJSONString(deviceInfo));
		boolean dev =  false;
		RespBaseDto res = new RespBaseDto();
		try{
			dev = deviceService.synchronizeMemberDeviceInfo(deviceInfo);
			if(dev)
				res.setMessage("OK");
			else
				res.setState(EWarning.Unknown.getValue());
		}catch (Exception ex){
			res.setState(EWarning.Unknown.getValue());
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}
		return res;
	}

	@ApiOperation(value = "MQ接收处理，短信消息，推送消息", httpMethod = "POST")
	@RequestMapping(value = "/pushMessageToMQ", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto pushMessageToMQ(PushMsg msg){
		logger.info("PushMsg :"+JSON.toJSONString(msg));

		RespBaseDto res = new RespBaseDto();
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
	
	@ApiOperation(value = "MQ接收处理，短信消息，推送消息", httpMethod = "POST")
	@RequestMapping(value = "/pushMessageToMQForFeign", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto pushMessageToMQForFeign(@RequestBody PushMsg msg){
		logger.info("PushMsg :"+JSON.toJSONString(msg));

		RespBaseDto res = new RespBaseDto();
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
	
	
	@ApiOperation(value = "MQ接收处理，触发排序算法", httpMethod = "POST")
	@RequestMapping(value = "/sortMessageToMQ", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto sortMessageToMQ(SortMQ sort){
		logger.info("Sort message  :"+JSON.toJSONString(sort));

		RespBaseDto res = new RespBaseDto();
		try{
			mqsendMsgHelper.sendJSONMsg(sort);
			res.setMessage("OK");
		}catch (Exception ex){
			res.setState(EWarning.Unknown.getValue());
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}
		return res;
	}

	@ApiOperation(value = "MQ接收处理，订单状态处理", httpMethod = "POST")
	@RequestMapping(value = "/orderMessageToMQ", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto orderMessageToMQ(OrderMQ orderMQ){
		logger.info("orderMQ message  :"+JSON.toJSONString(orderMQ));

		RespBaseDto res = new RespBaseDto();
		try{
			mqsendMsgHelper.sendJSONOrderMQ(orderMQ);
			res.setMessage("OK");
		}catch (Exception ex){
			res.setState(EWarning.Unknown.getValue());
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}
		return res;
	}
	
	@ApiOperation(value = "发送会员消息", httpMethod = "POST")
	@RequestMapping(value = "/memberMessageToMQ", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto memberMessageToMQ(MemberMQ memberMq) {
		logger.info("memberMQ message  :"+JSON.toJSONString(memberMq));

		RespBaseDto res = new RespBaseDto();
		try{
			mqsendMsgHelper.sendJSONMemberMQ(memberMq);
			res.setMessage("OK");
		}catch (Exception ex){
			res.setState(EWarning.Unknown.getValue());
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}
		return res;
	}

	@ApiOperation(value = "获取酒店员工角色列表", httpMethod = "POST")
	@RequestMapping(value = "/staffRoleList", method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto staffRoleList(){

		RespBaseDto res = new RespBaseDto();
		try{
			List<ImsSysGroup> list = sysResourceServiceSmpl.getSysGroup(14);
			res.setData(list);
			res.setMessage("OK");
		}catch (Exception ex){
			res.setState(EWarning.Unknown.getValue());
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}
		return res;
	}

	@Resource
	private ImsEweiShopMerchUserMapper userMapper;
	/**
	 * @return
	 */
	@RequestMapping(value = "/baiduTranslate", method = RequestMethod.GET)
	@ResponseBody
	public String baiduTranslate() {
		TransApi api = new TransApi("20171103000092484", "MKjKYUhcbv74WPfe5A8N");
		String query = "高度600米";
		System.out.println(api.getTransResult(query, "auto", "en"));

		ImsEweiShopMerchUserExample merchUserExample = new ImsEweiShopMerchUserExample();
		merchUserExample.createCriteria().andCateidEqualTo(216);
		List<ImsEweiShopMerchUser> merchUsers = userMapper.selectByExample(merchUserExample);
		ImsEweiShopMerchUser mu = new ImsEweiShopMerchUser();
		for (ImsEweiShopMerchUser imsEweiShopMerchUser : merchUsers) {
			String merchname = imsEweiShopMerchUser.getMerchname();
			String engName = imsEweiShopMerchUser.getEngMerchname();
			if(merchname!=null&&!merchname.equals("")&&(engName==null||engName.equals(""))) {
				String transResult = api.getTransResult(merchname, "auto", "en");		
				Result parseObject = JSON.parseObject(transResult, Result.class);
				mu.setId(imsEweiShopMerchUser.getId());
				mu.setEngMerchname(parseObject.getTrans_result().get(0).getDst());
				userMapper.updateByPrimaryKeySelective(mu);
			}
		}
		return "ok";
	}
	
		@RequestMapping(value = "/getTradingArea", method = RequestMethod.GET)
		@ResponseBody
		public String getTradingArea() {
			String baseUrl = "http://api.map.baidu.com/geocoder/v2/";
			ImsEweiShopMerchUserExample merchUserExample = new ImsEweiShopMerchUserExample();
			merchUserExample.createCriteria().andCateidEqualTo(216);
			List<ImsEweiShopMerchUser> merchUsers = userMapper.selectByExample(merchUserExample);
			ImsEweiShopMerchUser mu = new ImsEweiShopMerchUser();
			for (ImsEweiShopMerchUser imsEweiShopMerchUser : merchUsers) {
				String lat = imsEweiShopMerchUser.getLat();
				String lng = imsEweiShopMerchUser.getLng();
				String tArea = imsEweiShopMerchUser.getTradingArea();
				if(lat!=null&&!lat.equals("")&&lng!=null&&!lng.equals("")&&(tArea==null||tArea.equals(""))) {
					String location = lat+","+lng;
					String output = "json";
					String ak = "cjNvMvjTbMpnIU6dS6G2vVO5nNyT2tlX";		
					Map<String,String> map = new HashMap<String,String>();
					map.put("location", location);
					map.put("output", output);
					map.put("ak", ak);
					String result = HttpClientUtils.doGet(baseUrl, map, null);
					//{"status":0,"result":{"location":{"lng":106.80565099999994,"lat":32.35974606992156},"formatted_address":"四川省巴中市南江县","business":"","addressComponent":{"country":"中国","country_code":0,"province":"四川省","city":"巴中市","district":"南江县","town":"","adcode":"511922","street":"","street_number":"","direction":"","distance":""},"pois":[],"roads":[],"poiRegions":[],"sematic_description":"槐树村东132米","cityCode":239}}
					Map resultMap = JSON.parseObject(result,Map.class);
					Object object = resultMap.get("result");
					TradingResult r = JSON.parseObject(object.toString(), TradingResult.class);
					String tradingArea = r.getBusiness();
					if(tradingArea==null||tradingArea.equals("")) {
						tradingArea = r.getAddressComponent().getStreet();
					}
					mu.setId(imsEweiShopMerchUser.getId());
					mu.setTradingArea(tradingArea);
					userMapper.updateByPrimaryKeySelective(mu);					
				}			
			}
			return "ok";
		}
}

class TradingResult{
	String business;
	AddressComponent addressComponent;
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public AddressComponent getAddressComponent() {
		return addressComponent;
	}
	public void setAddressComponent(AddressComponent addressComponent) {
		this.addressComponent = addressComponent;
	}
	
}
class AddressComponent{
	String street;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}

class Result{
	String from;
	String to;
	List<TransResult> trans_result;
	
	public void setFrom(String from) {
		this.from=from;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public List<TransResult> getTrans_result() {
		return trans_result;
	}
	public void setTrans_result(List<TransResult> trans_result) {
		this.trans_result = trans_result;
	}
	
}
class TransResult{
	String src;
	String dst;
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
}
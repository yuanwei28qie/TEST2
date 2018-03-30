package com.microsilver.mrcard.serviceplatform.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microsilver.mrcard.common.CryptoTools;
import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.DictionaryUtils;
import com.microsilver.mrcard.serviceplatform.common.RongCloud;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.controller.BaseController;
import com.microsilver.mrcard.serviceplatform.core.ApiResourcesAnnotion;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dto.MemberDto;
import com.microsilver.mrcard.serviceplatform.dto.MemberPanterDto;
import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.dto.StaffInformation;
import com.microsilver.mrcard.serviceplatform.dto.VipType;
import com.microsilver.mrcard.serviceplatform.model.ImsCheckCode;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMember;
import com.microsilver.mrcard.serviceplatform.model.ImsSysArea;
import com.microsilver.mrcard.serviceplatform.model.ImsUserRecommend;
import com.microsilver.mrcard.serviceplatform.model.enums.EEmployeeRole;
import com.microsilver.mrcard.serviceplatform.model.enums.EVIPType;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.service.CheckCodeSmpl;
import com.microsilver.mrcard.serviceplatform.service.ImsUserRecommendService;
import com.microsilver.mrcard.serviceplatform.service.MemberSmpl;
import com.microsilver.mrcard.serviceplatform.service.StaffInformationSmpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "/api/shopMember", description = "会员相关API")
@Controller
@RequestMapping(value = "api/shopMember")
public class ShopMemberController extends BaseController {
	
	@Autowired
	private MemberSmpl memberSmpl;
	@Autowired
	private CheckCodeSmpl checkCodeSmpl;
	@Autowired
	private StaffInformationSmpl staffInformationSmpl;

	@Autowired
	ImsUserRecommendService recommendService;
	
	/**
	 * 会员注册
	 * 
	 * @param mobile
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "会员注册", httpMethod = "POST")
	@RequestMapping(value = "/register")
	@ResponseBody
	public RespBaseDto<MemberDto> register(@RequestParam String mobile, 
			@RequestParam String password,
			@RequestParam(defaultValue="",required = false) String refereeMobile,
			@RequestParam Integer uniacId,
			@RequestParam Long province,
			@RequestParam Long city,
			@RequestParam Long country) {
		RespBaseDto<MemberDto> result = new RespBaseDto<MemberDto>();
		Map<Long, ImsSysArea> areaMap = DictionaryUtils.getAreaMap();
		try {
			ImsEweiShopMember member = memberSmpl.selectByMobile(mobile);
			if (member != null) {
				throw new Exception(mobile+" 手机号已经存在");
			}
			ImsEweiShopMember newMember = new ImsEweiShopMember();
			String openId = Utils.getOpenId(uniacId, mobile);
			newMember.setOpenid(openId);
			String nickname= mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
			newMember.setNickname(nickname);
			newMember.setCreatetime(Utils.getCurrentTime());
			newMember.setMobile(mobile);
			newMember.setPwd(password);
			newMember.setUniacid(uniacId);
			newMember.setProvince(areaMap.get(province).getName());
			newMember.setCity(areaMap.get(city).getName());
			newMember.setArea(areaMap.get(country).getName());
			Long level2ParentId = 0L;
			if(refereeMobile != null&&!refereeMobile.trim().equals("")){
				ImsEweiShopMember refMember = memberSmpl.getRecommendMember(refereeMobile);
				if(refMember.getReferee()!=null) {
					level2ParentId = refMember.getReferee();
				}
				newMember.setReferee(refMember.getId());
			}
			
			String rongcloudToken = RongCloud.getToken(newMember.getId()+"0", newMember.getNickname(), "");
			newMember.setRongcloudToken(rongcloudToken);
			memberSmpl.register(newMember,level2ParentId);
			MemberDto memDto = new MemberDto();
			memDto.setId(newMember.getId());
			memDto.setNickname(newMember.getNickname());
			memDto.setRongcloudToken(rongcloudToken);
			memDto.setCheckStatus((byte)-1);
			memDto.setIsblack(0);
			memDto.setPwd(newMember.getPwd());
			result.setData(memDto);
		} catch (Exception ex) {
			logger.error("register error:{}",ex.getMessage());
			result.setMessage(ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	
	/**
	 * 快速注册(仅手机号)
	 * @param mobile
	 * @return
	 */
	@ApiOperation(value = "会员快速注册(仅手机号注册)", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "mobile",value = "手机号",required=true,paramType="form"),
		@ApiImplicitParam(name = "password",value = "密码",required=true,paramType="form"),
		@ApiImplicitParam(name = "checkCode",value = "验证码",required=true,paramType="form"),
		@ApiImplicitParam(name = "refereeMobile", value = "推荐手机号",required=false,paramType="form"),
		@ApiImplicitParam(name = "wxmemberId", value = "微信注册时生成的会员编号",required=false,paramType="form")
	})
	@RequestMapping(value = "/quickRegister")
	@ResponseBody
	public RespBaseDto<MemberDto> quickRegister(String mobile,String checkCode,@RequestParam(defaultValue="") String password,
			@RequestParam(defaultValue="") String refereeMobile,
			@RequestParam(defaultValue="0",required = false)Long wxmemberId){
		RespBaseDto<MemberDto> result = new RespBaseDto<MemberDto>();
		try{
			ImsEweiShopMember member = memberSmpl.selectByMobile(mobile);
			if (member != null) {
				throw new Exception(mobile+" 手机号已经存在");
			}
			if(!checkCode.equals("100200")) {
				ImsCheckCode imsCheckCode = checkCodeSmpl.selectByCheckCode(mobile,1);
				if(!imsCheckCode.getCode().equals(checkCode)){
					result.setState(EWarning.CheckCodeError.getValue());
					result.setMessage(EWarning.CheckCodeError.getName());
					return result;
				}
			}
			boolean isExist = false;
			ImsEweiShopMember newMember = null;
			if(wxmemberId!=null&&wxmemberId>0) {
				//微信来源客户
				newMember = memberSmpl.selectMemberById(wxmemberId);
				if(newMember!=null) {
					if(newMember.getMobile()!=null&&!newMember.getMobile().equals("")) {
						//用户已注册，帮别人注册
						isExist = false;
					}else {
						isExist = true;
					}
				}
			}
			if(!isExist) {
				newMember = new ImsEweiShopMember();
				String openId = Utils.getOpenId(0, mobile);
				newMember.setOpenid(openId);
				String nickname= mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
				newMember.setNickname(nickname);
				newMember.setCreatetime(Utils.getCurrentTime());
				newMember.setUniacid(0);
			}
			newMember.setMobile(mobile);
			if(password!=null&&!password.equals("")) {
				newMember.setPwd(password);
			}
			
			Long level2ParentId = 0L;
			if(refereeMobile != null&&!refereeMobile.trim().equals("")){
				ImsEweiShopMember refMember = memberSmpl.getRecommendMember(refereeMobile);
				if(refMember.getReferee()!=null) {
					level2ParentId = refMember.getReferee();
				}
				newMember.setReferee(refMember.getId());
			}
			
			if(isExist) {
				memberSmpl.wxMemberRegister(newMember,level2ParentId,null);
			}else {
				memberSmpl.register(newMember,level2ParentId);
			}
			MemberDto memDto = new MemberDto();
			memDto.setId(newMember.getId());
			memDto.setCheckStatus((byte)-1);
			memDto.setIsblack(0);
			memDto.setNickname(newMember.getNickname());
			result.setData(memDto);
			result.setMessage("OK");
		}catch (Exception ex) {
			logger.error("quickRegister error:{}",ex.getMessage());
			result.setMessage(ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	@ApiOperation(value = "微信账号绑定手机", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "mobile",value = "手机号",required=true,paramType="form"),
		@ApiImplicitParam(name = "checkCode",value = "验证码",required=true,paramType="form"),
		@ApiImplicitParam(name = "refereeMobile", value = "推荐手机号",required=false,paramType="form"),
		@ApiImplicitParam(name = "wxmemberId", value = "微信注册时生成的会员编号",required=false,paramType="form")
	})
	@RequestMapping(value = "/wxbindPhone")
	@ResponseBody
	public RespBaseDto<MemberDto> wxbindPhone(String mobile,String checkCode,@RequestParam(defaultValue="") String refereeMobile,
			@RequestParam(defaultValue="0",required = false)Long wxmemberId){
		RespBaseDto<MemberDto> result = new RespBaseDto<MemberDto>();
		try{
			if(!checkCode.equals("100200")) {
				ImsCheckCode imsCheckCode = checkCodeSmpl.selectByCheckCode(mobile,2);
				if(!imsCheckCode.getCode().equals(checkCode)){
					result.setState(EWarning.CheckCodeError.getValue());
					result.setMessage(EWarning.CheckCodeError.getName());
					return result;
				}
			}
			
			ImsEweiShopMember wxMember = memberSmpl.selectMemberById(wxmemberId);
			if(wxMember==null) {
				result.setMessage("微信用户不存在");
				result.setState(EWarning.Unknown.getValue());
				logger.info("微信用户:{}不存在",wxmemberId);
				return result;
			}
			ImsEweiShopMember member = memberSmpl.selectByMobile(mobile);
			if(member!=null) {
				if(wxMember.getOpenid()==null||wxMember.getOpenid().equals("")) {
					result.setMessage("不是微信用户，不能使用该功能!");
					result.setState(EWarning.Unknown.getValue());
					return result;
				}else {
					if(wxMember.getOpenid().equals(member.getOpenid()))
					{
						result.setMessage("用户微信已绑定手机,不能再次绑定");
						result.setState(EWarning.Unknown.getValue());
						logger.info("用户:{}微信已绑定手机,不能再次绑定",wxmemberId);
						return result;
					}
				}
			}
			Long level2ParentId = 0L;
			if(refereeMobile != null&&!refereeMobile.trim().equals("")){
				ImsEweiShopMember refMember = memberSmpl.getRecommendMember(refereeMobile);
				if(refMember.getReferee()!=null) {
					level2ParentId = refMember.getReferee();
				}
				if(wxMember.getReferee()==null||wxMember.getReferee().longValue()==0)
					wxMember.setReferee(refMember.getId());
				if(member != null)
					if(member.getReferee()==null||member.getReferee().longValue()==0)
						member.setReferee(refMember.getId());
			}
			
			if (member != null) {
				//手机号已注册,保留有手机号的账号
				member.setOpenid(wxMember.getOpenid());
				member.setPwd(null);
				member.setSalt(null);
				memberSmpl.wxMemberRegister(member,level2ParentId,wxMember);
			}else {
				//手机号没有注册,使用微信注册账号
				member = wxMember;
				member.setMobile(mobile);
				member.setPwd(null);
				member.setSalt(null);
				memberSmpl.wxMemberRegister(member,level2ParentId,null);
			}
			MemberDto memDto = new MemberDto();
			
			memDto.setId(member.getId());
			memDto.setCheckStatus((byte)-1);
			memDto.setIsblack(0);
			memDto.setNickname(member.getNickname());
			result.setData(memDto);
			result.setMessage("OK");
			result.setState(0);
		}
		catch (Exception ex) {
			logger.error("wxbindPhone error:{}",ex.getMessage());
			result.setMessage(EWarning.Unknown.getName()+ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		
		return result;
		
	}
	/**
	 *会员登录接口
	 * @param phone
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "会员登录接口", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "mobile",value = "手机号",required=true,paramType="form"),
		@ApiImplicitParam(name = "password",value = "密码",required=true,paramType="form"),
		@ApiImplicitParam(name = "identity", value = "当前登录身份(如果不填，系统会自动查询所有身份)",required=false,paramType="form")
	})
	@RequestMapping(value = "/businessLogin",method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<MemberDto> login(String mobile,String password,@RequestParam(value="identity",required = false)Integer identity){
		RespBaseDto<MemberDto> result = new RespBaseDto<MemberDto>();
		MemberDto member = memberSmpl.selectDtoByMobile(mobile,identity);
		//检查手机号
		if(member==null){
			result.setState(EWarning.NonExistent.getValue());
			result.setMessage(EWarning.NonExistent.getName());
		}else{
			//检查密码
			if(member.getPwd()==null||member.getPwd().equals("")){
				result.setState(EWarning.PasswordError.getValue());
				result.setMessage("注册时使用的是快捷注册，请使用快捷登录!");
				return result;
			}
			String pwd = CryptoTools.EncoderByMd5(password+member.getSalt());
			if(!member.getPwd().equals(pwd)){
				result.setState(EWarning.PasswordError.getValue());
				result.setMessage(EWarning.PasswordError.getName());
				return result;
			}
			//检查会员是否被禁用
			if(member.getIsblack()==1){
				result.setState(EWarning.DisableAccount.getValue());
				result.setMessage(EWarning.DisableAccount.getName());
				return result;
			}
			//member.setPwd(null);
			member.setSalt(null);
			result.setData(member);
		}
		return result;
	}
	/**
	 * 会员无密码登录
	 * @param mobile
	 * @param checkCode
	 * @return
	 */
	@ApiOperation(value = "会员无密码登录", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "mobile",value = "手机号",required=true,paramType="form"),
		@ApiImplicitParam(name = "checkCode",value = "验证码",required=true,paramType="form"),
		@ApiImplicitParam(name = "identity", value = "当前登录身份(如果不填，系统会自动查询所有身份)",required=false,paramType="form")
	})
	@RequestMapping(value = "/forNopassLogin")
	@ResponseBody
	public RespBaseDto<MemberDto> loginForNopass(String mobile,String checkCode,@RequestParam(value="identity",required = false)Integer identity){
		RespBaseDto<MemberDto> result = new RespBaseDto<MemberDto>();
		boolean ischeckCodePass=false;
		try{
			ImsCheckCode imsCheckCode = checkCodeSmpl.selectByCheckCode(mobile,2);
			if(!imsCheckCode.getCode().equals(checkCode)){
				result.setState(EWarning.CheckCodeError.getValue());
				result.setMessage(EWarning.CheckCodeError.getName());
			}else{
				ischeckCodePass = true;
			}
			if(ischeckCodePass){
				MemberDto memberDto = memberSmpl.selectDtoByMobile(mobile,identity);
				if(memberDto == null){
					result.setState(EWarning.NonExistent.getValue());
					result.setMessage(EWarning.NonExistent.getName());
					return result;
				}
				//检查会员是否被禁用
				if(memberDto.getIsblack()==1){
					result.setState(EWarning.DisableAccount.getValue());
					result.setMessage(EWarning.DisableAccount.getName());
					return result;
				}
				//memberDto.setPwd(null);
				memberDto.setSalt(null);
				if(identity!=null&&identity==13){
					memberDto.setRongcloudToken(null);
				}
				result.setData(memberDto);
			}
		}
		catch(BusinessException bex){
			logger.error("loginForNopass error:{}",bex.getMessage());
			result.setState(bex.getWarning().getValue());
			result.setMessage(bex.getWarning().getName());
		}
		return result;
	}	
	
	/**
	 * 修改会员信息
	 * @param mobile
	 * @param checkCode
	 * @return
	 */
	@ApiOperation(value = "修改会员信息", httpMethod = "POST")
	@ApiImplicitParams({@ApiImplicitParam(name="id",value="用户ID"),@ApiImplicitParam(name="nickname",value="昵称"),@ApiImplicitParam(name="avatar",value="头像")})
	@RequestMapping(value = "/updateUserInfo")
	@ResponseBody
	public RespBaseDto<ImsEweiShopMember> updateUserInfo(ImsEweiShopMember member){
		RespBaseDto<ImsEweiShopMember> result = new RespBaseDto<ImsEweiShopMember>();
		try {
			if(member.getNickname()==null&&member.getAvatar()==null) {
				result.setMessage(EWarning.ErrorParams.getName());
				result.setState(EWarning.ErrorParams.getValue());
			}else {
				memberSmpl.updateUserInfo(member);
				result.setMessage("OK");			
			}
		} catch (Exception e) {
			logger.error("updateUserInfo:{}",e.getMessage());
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}

	/**
	 * 企业员工信息录入
	 * 		1，检查是否是会员shop_member，非会员需要向会员表进行注册
	 * 	    2，添加员工身份shop_member_identiy
	 * 	    3，为员工授权 ims_sys_group_resource
	 * @param staffInfo
	 * @return
	 */
	@ApiResourcesAnnotion(uri="/api/shopMember/staffInformationAdd",role= EEmployeeRole.Manager,name="酒店员工管理-新增员工")
	@ApiOperation(value = "酒店员工管理-新增员工", httpMethod = "POST")
	@RequestMapping(value = "/staffInformationAdd")
	@ResponseBody
	public RespBaseDto<MemberDto> staffInformationAdd(StaffInformation staffInfo){
		RespBaseDto<MemberDto> result = new RespBaseDto<>();
		MemberDto memDto = new MemberDto();
		try {
			memDto = staffInformationSmpl.staffInformationAdd(staffInfo);
		}catch (Exception ex){
			result.setMessage(ex.getMessage());
			result.setState(EWarning.ErrorStatus.getValue());
			return result;
		}
		result.setData(memDto);
		return result;
	}

	@ApiResourcesAnnotion(uri="/api/shopMember/staffInformationList",role= EEmployeeRole.Manager,name="员工列表")
	@ApiOperation(value = "酒店员工管理-员工列表", httpMethod = "POST")
	@RequestMapping(value = "/staffInformationList")
	@ResponseBody
	public RespBaseDto<List<StaffInformation>> staffInformationList(Long merchInfo){
		RespBaseDto<List<StaffInformation>> result = new RespBaseDto<>();
		List<StaffInformation> merchList = staffInformationSmpl.staffInformationList(merchInfo);
		result.setData(merchList);
		return result;
	}
	
	@ApiResourcesAnnotion(uri="/api/shopMember/staffInformation",role= EEmployeeRole.Manager,name="员工详情")
	@ApiOperation(value = "酒店员工管理-员工详情", httpMethod = "POST")
	@RequestMapping(value = "/staffInformation")
	@ResponseBody
	public RespBaseDto<MemberDto> staffInformation(Long memberId){
		RespBaseDto<MemberDto> result = new RespBaseDto<>();
		MemberDto shopMember = staffInformationSmpl.staffInformation(memberId);
		result.setData(shopMember);
		return result;
	}
	
	@ApiResourcesAnnotion(uri="/api/shopMember/staffInformationDelete",role= EEmployeeRole.Manager,name="禁用员工")
	@ApiOperation(value = "酒店员工管理-禁用员工", httpMethod = "POST")
	@RequestMapping(value = "/staffInformationDelete")
	@ResponseBody
	public RespBaseDto<Long> staffInformationDelete(Long merchId,Long memberId){
		RespBaseDto<Long> result = new RespBaseDto<>();
		ImsEweiShopMember shopMember = staffInformationSmpl.staffInformationDelete(merchId, memberId);
		result.setData(shopMember.getId());
		result.setMessage("禁用员工");
		return result;
	}

	@ApiOperation(value = "我的首页", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id") })
	@RequestMapping(value = "/personal")
	@ResponseBody
	public RespBaseDto<Boolean> personal(Long memberId){
		RespBaseDto<Boolean> result = new RespBaseDto<>();
		try {
			ImsUserRecommend recommend = recommendService.selectByPrimaryKey(memberId);
			result.setData(false);
			if(recommend!=null) {
				byte vipType = recommend.getVipType();
				if(vipType>0)
					result.setData(true);
			}			
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setMessage(EWarning.Unknown. getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	@ApiOperation(value = "获取合伙人信息(已过期)", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id") })
	@RequestMapping(value = "/getPanter")
	@ResponseBody
	public RespBaseDto<MemberPanterDto> getPanter(Long memberId){
		RespBaseDto<MemberPanterDto> result = new RespBaseDto<>();
		MemberPanterDto mpDto = new MemberPanterDto();
		try {
			ImsUserRecommend recommend = recommendService.selectByPrimaryKey(memberId);
			if(recommend!=null) {
				mpDto.setVipType(recommend.getVipType());
			}else {
				mpDto.setVipType((byte)0);
			}
			if(mpDto.getVipType()==0) {
				List<VipType> vipTypeList = new ArrayList<VipType>();
				for(EVIPType evType:EVIPType.values()) {
					VipType vipType = new VipType();
					vipType.setId(evType.getValue());
					switch(evType.getValue()) {
						case 1:vipType.setCostPrice(Consts.PARTNER_COST);break;
						case 2:vipType.setCostPrice(Consts.SENIOR_PANTER_COST);break;
						case 3:vipType.setCostPrice(Consts.SUPER_PANTER_COST);break;
						case 10:vipType.setCostPrice(Consts.VIP_MEMBER_COST);break;
					}
					vipType.setName(evType.getName());
					vipTypeList.add(vipType);
				}
				mpDto.setVipTypeList(vipTypeList);
			}
			mpDto.setMemberId(memberId);
			result.setData(mpDto);
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setMessage(EWarning.Unknown. getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
}

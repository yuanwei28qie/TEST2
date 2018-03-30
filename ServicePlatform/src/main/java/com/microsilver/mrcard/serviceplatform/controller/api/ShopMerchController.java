package com.microsilver.mrcard.serviceplatform.controller.api;
/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.controller.ShopMerchController
 * @Description �̻�������
 * 
 * @Author bruce
 * @Version 2017��6��28�� ����1:39:10
 * @Copyright Micro Silver
 *
 */

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsilver.mrcard.common.CryptoTools;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.controller.BaseController;
import com.microsilver.mrcard.serviceplatform.core.ApiResourcesAnnotion;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dto.BusinessDto;
import com.microsilver.mrcard.serviceplatform.dto.MerchInfoDto;
import com.microsilver.mrcard.serviceplatform.dto.MerchOrderDto;
import com.microsilver.mrcard.serviceplatform.dto.MerchUserIndexDto;
import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.dto.ShopMerchReg;
import com.microsilver.mrcard.serviceplatform.model.ImsCheckCode;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiMemberCard;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMember;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchRegWithBLOBs;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUser;
import com.microsilver.mrcard.serviceplatform.model.enums.EEmployeeRole;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.service.CheckCodeSmpl;
import com.microsilver.mrcard.serviceplatform.service.IFinanceRemoteSmpl;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopMerchRegSmpl;
import com.microsilver.mrcard.serviceplatform.service.MemberSmpl;
import com.microsilver.mrcard.serviceplatform.service.ShopMerchSmpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "/api/ShopMerch", description = "商家相关API")
@Controller
@RequestMapping("/api/ShopMerch")
public class ShopMerchController extends BaseController{
	
	@Autowired
	ShopMerchSmpl merchSmpl;
	@Autowired
	CheckCodeSmpl checkCodeSmpl;
	@Autowired
	MemberSmpl memberSmpl;
	@Autowired
	IFinanceRemoteSmpl iFinanceRemoteSmpl;

	@Autowired
	ImsEweiShopMerchRegSmpl shopMerchRegSmpl;

	@ApiOperation(value = "获取商家信息", httpMethod = "POST")
	@RequestMapping(value = "/getMerchInfo",method = RequestMethod.POST)
	@ResponseBody
	public RespBaseDto<MerchInfoDto> getMerchInfo(Long memberId,Long merchId,Long identity){
		RespBaseDto<MerchInfoDto> result = new RespBaseDto<MerchInfoDto>();
		MerchInfoDto dto = (MerchInfoDto) merchSmpl.getShopMerch(merchId);
		if(dto==null){
			result.setState(EWarning.NotExistMerch.getValue());
			result.setMessage(EWarning.NotExistMerch.getName());
			return result;
		}
		MrcardFinanceCustomer customer = iFinanceRemoteSmpl.searchFinanceCustomer(memberId,merchId,identity);
		dto.setTotalAmount(customer.getTotalAmount());
		dto.setRealAmount(customer.getRealAmount());
		dto.setUnrecordedAmount(customer.getUnrecordedAmount());
		dto.setAdvanceAmount(customer.getAdvanceAmount());
		result.setData(dto);
		result.setMessage("OK");
		return result;
	}
	/**
	 * 商家登录接口
	 * @param phone
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "商家登录接口", httpMethod = "POST",response = BusinessDto.class)
	@RequestMapping(value = "/businessLogin")
	@ResponseBody
	public RespBaseDto<BusinessDto> login(String mobile,String password,@RequestParam(defaultValue="-1")int identity){
		RespBaseDto<BusinessDto> result = new RespBaseDto<BusinessDto>();
		try{
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
					//检查商户账号
					result = merchSmpl.checkBusinessAccount(member.getId(),member,identity);
				}
			}
		}
		catch(Exception ex){
			logger.error("businessLogin:{}", ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(ex.getMessage());
		}
		return result;
	}
	/**
	 * 无密码登录
	 * @param mobile
	 * @param checkCode
	 * @return
	 */
	@ApiOperation(value = "无密码登录", httpMethod = "POST")
	@RequestMapping(value = "/forNopassLogin")
	@ResponseBody
	public RespBaseDto<BusinessDto> loginForNopass(String mobile,String checkCode,@RequestParam(defaultValue="-1")int identity){
		RespBaseDto<BusinessDto> result = new RespBaseDto<BusinessDto>();
		try{
			ImsCheckCode imsCheckCode = checkCodeSmpl.selectByCheckCode(mobile,2);
			if(!imsCheckCode.getCode().equals(checkCode)){
				result.setState(EWarning.CheckCodeError.getValue());
				result.setMessage(EWarning.CheckCodeError.getName());
			}else{
				ImsEweiShopMember member = memberSmpl.selectByMobile(mobile);
				//检查商户账号
				result = merchSmpl.checkBusinessAccount(member.getId(),member,identity);
			}
		}
		catch(BusinessException bex){
			logger.error("loginForNopass:{}", bex.getMessage());
			result.setState(bex.getWarning().getValue());
			result.setMessage(bex.getWarning().getName());
		}
		return result;
	}
	/**
	 * 商家注册
	 * @param mobile
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "商家注册", httpMethod = "POST")
	@ApiResponse(code = 200, message = "success")
	@ApiResponses({ @ApiResponse(code = 400, message = "Invalid Order") })
	@RequestMapping(value = "/register")
	@ResponseBody
	public RespBaseDto<BusinessDto> register(String mobile,String password){
		RespBaseDto<BusinessDto> result = new RespBaseDto<BusinessDto>();
		int uniacId=2;
		try{
			
			String openId=Utils.getOpenId(uniacId, mobile);
			ImsEweiShopMember newMember = new ImsEweiShopMember();
			newMember.setMobile(mobile);
			newMember.setPwd(password);
			newMember.setUniacid(uniacId);
			newMember.setOpenid(openId);
			newMember.setCreatetime(Utils.getCurrentTime());
			Long memberId = memberSmpl.register(newMember);
			BusinessDto bnDto = new BusinessDto();
			bnDto.setMemberId(memberId);
			bnDto.setUniacId(uniacId);
			bnDto.setRegStatus(-2);
			bnDto.setOpenId(openId);
			result.setMessage("OK");
			
			result.setData(bnDto);
		}
		catch(Exception ex){
			ex.printStackTrace();
			result.setMessage(ex.getMessage());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	/**
	 * 查看商家基本信息
	 * 
	 */
	@ApiOperation(value = "查看商家基本信息", httpMethod = "POST")
	@RequestMapping(value = "/getMerchUser")
	@ResponseBody
	public RespBaseDto<ImsEweiShopMerchUser> getMerchUser(Integer id){
		RespBaseDto<ImsEweiShopMerchUser> dto = new RespBaseDto<>();
		ImsEweiShopMerchUser merchUser = merchSmpl.selectMerchUserByPrimaryKey(id);
		dto.setData(merchUser);
		return dto;
	}
	
	/**
	 * 更新商家信息
	 * 
	 */
	@ApiOperation(value = "更新商家信息", httpMethod = "POST")
	@RequestMapping(value = "/saveMerchUser")
	@ResponseBody
	public RespBaseDto<String> saveMerchUser(Integer id,@ApiParam("是否支持镖师配送") Integer supportBiaoshi,@ApiParam("是否支持自提")Integer supportPickUp){
		RespBaseDto<String> dto = new RespBaseDto<>();
		
		try {
			ImsEweiShopMerchUser merchUser = new ImsEweiShopMerchUser();
			merchUser.setId(id);
			merchUser.setSupportBiaoshi(supportBiaoshi==1);
			merchUser.setSupportPickUp(supportPickUp==1);
			merchSmpl.updateMerchUserByPrimaryKey(merchUser);
			dto.setData("OK");			
		} catch (Exception e) {
			e.printStackTrace();
			dto.setMessage(EWarning.Unknown.getName());
			dto.setState(EWarning.Unknown.getValue());
		}
		return dto;
	}

	/**
	 * 商家入住申请
	 *
	 */
	@ApiOperation(value = "商家入住申请", httpMethod = "POST")
	@RequestMapping(value = "/saveMerchInfo")
	@ResponseBody
	public RespBaseDto<String> saveMerchInfo(ShopMerchReg reg){
		RespBaseDto<String> dto = new RespBaseDto<>();
		try {
			ImsEweiShopMerchRegWithBLOBs regInfo = new ImsEweiShopMerchRegWithBLOBs();
			if(!Objects.nonNull(reg.getMemberid())){
				dto.setState(EWarning.MerchInfoException.getValue());
				dto.setMessage("申请用户不存在");
				return dto;
			}
			regInfo.setMemberid(reg.getMemberid());
			regInfo.setRealname(reg.getRealname());
			regInfo.setMobile(reg.getMobile());
			regInfo.setTel(reg.getTel());
			regInfo.setLat(reg.getLat());
			regInfo.setLng(reg.getLng());
			regInfo.setAddress(reg.getAddress());
			regInfo.setMerchname(reg.getMerchname());
			regInfo.setShopType(reg.getShopType());
			regInfo.setBrandId(reg.getBrandId());
			regInfo.setProvince(reg.getProvince());
			regInfo.setCity(reg.getCity());
			regInfo.setCounty(reg.getCounty());
			regInfo.setIdentity(reg.getIdentity());
			regInfo.setIdNo(reg.getIdNo());
			regInfo.setPic(reg.getPic());
			regInfo.setPic2(reg.getPic2());
			regInfo.setPublicitypic(reg.getPublicitypic());

			boolean merchUser = merchSmpl.merchInfoInput(regInfo);
			if(merchUser)
				dto.setData("OK");
			else {
				dto.setState(EWarning.MerchInfoException.getValue());
				dto.setMessage("商家入住申请失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			dto.setMessage(e.getMessage());
			dto.setState(EWarning.MerchInfoException.getValue());
		}
		return dto;
	}

	@ApiResourcesAnnotion(uri="/api/ShopMerch/saveMerchBalanceInfo",role= EEmployeeRole.Finance,name="商家绑定银行卡信息")
	@ApiOperation(value = "商家绑定银行卡信息", httpMethod = "POST")
	@RequestMapping(value = "/saveMerchBalanceInfo")
	@ResponseBody
	public RespBaseDto<String> saveMerchBalanceInfo(ImsEweiMemberCard card) {
		RespBaseDto<String> dto = new RespBaseDto<>();
		try {
			Integer recordid = merchSmpl.menberCardInput(card);
			if(recordid >0)
				dto.setData("OK");
			else {
				dto.setState(EWarning.MerchCardException.getValue());
				dto.setMessage("银行卡录入失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			dto.setState(EWarning.MerchCardException.getValue());
			dto.setMessage(e.getMessage());
		}
		return dto;
	}

	@ApiResourcesAnnotion(uri="/api/ShopMerch/setDefaultBalanceInfo",role= EEmployeeRole.Finance,name="商家设置默认卡")
	@ApiOperation(value = "商家设置默认卡", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cardId",value = "银行卡记录编号"),
			@ApiImplicitParam(name = "memberId",value = "会员编号"),
			@ApiImplicitParam(name = "identity",value = "会员身份")
	})
	@RequestMapping(value = "/setDefaultBalanceInfo")
	@ResponseBody
	public RespBaseDto<String> setDefaultBalanceInfo(Long cardId,Long memberId,Integer identity) {
		RespBaseDto<String> dto = new RespBaseDto<>();
		merchSmpl.changeDefaultBalanceCard(cardId,memberId,identity);
		dto.setMessage("OK");
		return dto;
	}

	@ApiResourcesAnnotion(uri="/api/ShopMerch/listMerchBalanceInfo",role= EEmployeeRole.Finance,name="商家银行卡列表信息")
	@ApiOperation(value = "商家银行卡列表信息", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "memberId",value = "会员编号"),
			@ApiImplicitParam(name = "identity",value = "会员身份")
	})
	@RequestMapping(value = "/listMerchBalanceInfo")
	@ResponseBody
	public RespBaseDto<List<ImsEweiMemberCard>> listMerchBalanceInfo(Long memberId,Integer identity) {
		RespBaseDto<List<ImsEweiMemberCard>> dto = new RespBaseDto<>();
		List<ImsEweiMemberCard> list = merchSmpl.getImsEweiMemberCardList(memberId,identity);
		if(list.isEmpty()){
			dto.setData(Lists.emptyList());
		}else {
			dto.setData(list);
		}
		return dto;
	}
	
	@ApiOperation(value = "商家收银台首页", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "merchId",value = "商家ID")
	})
	@RequestMapping(value = "/merchUserIndex")
	@ResponseBody
	public RespBaseDto<MerchUserIndexDto> merchUserIndex(Integer merchId) {
		RespBaseDto<MerchUserIndexDto> resp = new RespBaseDto<>();
		try {
			MerchUserIndexDto dto = merchSmpl.getMerchUserIndex(merchId);
			resp.setData(dto);
		} catch (BusinessException be) {
			be.printStackTrace();
			resp.setMessage(be.getWarning().getName());
			resp.setState(be.getWarning().getValue());
		}catch(Exception e) {
			e.printStackTrace();
			resp.setMessage(EWarning.Unknown.getName());
			resp.setState(EWarning.Unknown.getValue());
		}
		return resp;
	}
	
	@ApiOperation(value = "分页获取各种状态的订单", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "merchId",value = "商家ID"),
		@ApiImplicitParam(name = "pageNum",value = "当前页码"),
		@ApiImplicitParam(name = "status",value = "订单状态(-2.全部 1.待入住 3.已入住 4.已退款 6.已完成)")
	})
	@RequestMapping(value = "/getMerchOrderDtoByStatus")
	@ResponseBody
	public RespBaseDto<List<MerchOrderDto>> getMerchOrderDtoByStatus(Integer merchId,Integer pageNum,Byte status) {
		RespBaseDto<List<MerchOrderDto>> resp = new RespBaseDto<>();
		try {
			List<MerchOrderDto> dto = merchSmpl.getMerchOrderDtoByStatus(merchId,pageNum,status);
			resp.setData(dto);
		} catch (BusinessException be) {
			be.printStackTrace();
			resp.setMessage(be.getWarning().getName());
			resp.setState(be.getWarning().getValue());
		}catch(Exception e) {
			e.printStackTrace();
			resp.setMessage(EWarning.Unknown.getName());
			resp.setState(EWarning.Unknown.getValue());
		}
		return resp;
	}
	
	@ApiOperation(value = "确认入住", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "订单id")
	})
	@RequestMapping(value = "/customerIn")
	@ResponseBody
	public RespBaseDto<String> customerIn(Long id) {
		RespBaseDto<String> resp = new RespBaseDto<>();
		try {
			merchSmpl.customerIn(id);
			resp.setData("OK");
		} catch (BusinessException be) {
			be.printStackTrace();
			resp.setMessage(be.getWarning().getName());
			resp.setState(be.getWarning().getValue());
		}catch(Exception e) {
			e.printStackTrace();
			resp.setMessage(EWarning.Unknown.getName());
			resp.setState(EWarning.Unknown.getValue());
		}
		return resp;
	}	
	
	@ApiOperation(value = "订单详情", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "订单id")
	})
	@RequestMapping(value = "/getOrderDetails")
	@ResponseBody
	public RespBaseDto<MerchOrderDto> getOrderDetails(Long id) {
		RespBaseDto<MerchOrderDto> resp = new RespBaseDto<>();
		try {
			MerchOrderDto orderDto=merchSmpl.selectOrdersDetailsByPrimaryKey(id);
			resp.setData(orderDto);
		} catch (BusinessException be) {
			be.printStackTrace();
			resp.setMessage(be.getWarning().getName());
			resp.setState(be.getWarning().getValue());
		}catch(Exception e) {
			e.printStackTrace();
			resp.setMessage(EWarning.Unknown.getName());
			resp.setState(EWarning.Unknown.getValue());
		}
		return resp;
	}	
	@ApiResourcesAnnotion(uri="/api/ShopMerch/getMerchAccount",role= {EEmployeeRole.Finance,EEmployeeRole.Manager},name="我的提现")
	@ApiOperation(value = "我的提现首页", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "merchId",value = "商家编号"),@ApiImplicitParam(name = "memberId",value = "会员编号"),@ApiImplicitParam(name = "identity",value = "身份")
		})
	@RequestMapping(value = "/getMerchAccount")
	@ResponseBody
	public RespBaseDto<Map<String,String>> getMerchAccount(Long memberId,Long merchId,Long identity) {
		RespBaseDto<Map<String,String>> resp = new RespBaseDto<>();
		try {
			Map<String,String> merchAccount=merchSmpl.constituteIndex(memberId,merchId,identity);
			resp.setData(merchAccount);
		} catch (BusinessException be) {
			be.printStackTrace();
			resp.setMessage(be.getWarning().getName());
			resp.setState(be.getWarning().getValue());
		}catch(Exception e) {
			e.printStackTrace();
			resp.setMessage(EWarning.Unknown.getName());
			resp.setState(EWarning.Unknown.getValue());
		}
		return resp;
	}
	
	@ApiResourcesAnnotion(uri="/api/ShopMerch/withdraw",role= EEmployeeRole.Finance,name="商户提现")
	@ApiOperation(value = "确认提现", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "merchId",value = "商家编号"),@ApiImplicitParam(name = "memberId",value = "会员编号"),
		@ApiImplicitParam(name = "identity",value = "身份"),@ApiImplicitParam(name = "moneys",value = "提现金额")
		})
	@RequestMapping(value = "/withdraw")
	@ResponseBody
	public RespBaseDto<String> withdraw(Long memberId,Long merchId,Long identity,BigDecimal moneys) {
		RespBaseDto<String> resp = new RespBaseDto<String>();
		try {
			Long flowId=merchSmpl.withdraw(memberId,merchId,identity,moneys);
			if(flowId != null){
				resp.setData("OK");
				logger.info("提现申请成功：{}",flowId);
			}else{
				resp.setState(EWarning.FINANCE_EXCEPTION.getValue());
				resp.setMessage(EWarning.FINANCE_EXCEPTION.getName());
			}
		} catch (BusinessException be) {
			be.printStackTrace();
			resp.setMessage(be.getWarning().getName());
			resp.setState(be.getWarning().getValue());
		}catch(Exception e) {
			e.printStackTrace();
			resp.setMessage(EWarning.Unknown.getName());
			resp.setState(EWarning.Unknown.getValue());
		}
		return resp;
	}	
}

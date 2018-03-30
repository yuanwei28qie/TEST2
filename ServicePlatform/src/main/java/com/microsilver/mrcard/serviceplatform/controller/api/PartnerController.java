package com.microsilver.mrcard.serviceplatform.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microsilver.mrcard.serviceplatform.common.Consts;
import com.microsilver.mrcard.serviceplatform.common.DictionaryUtils;
import com.microsilver.mrcard.serviceplatform.controller.BaseController;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dto.ImsUserRecommendDto;
import com.microsilver.mrcard.serviceplatform.dto.MemberPanterDto;
import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.dto.VipType;
import com.microsilver.mrcard.serviceplatform.model.ImsSysArea;
import com.microsilver.mrcard.serviceplatform.model.ImsUserPanterArea;
import com.microsilver.mrcard.serviceplatform.model.ImsUserPanterOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsUserRecommend;
import com.microsilver.mrcard.serviceplatform.model.enums.EVIPType;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.service.ImsUserPanterAreaService;
import com.microsilver.mrcard.serviceplatform.service.ImsUserPanterOrderService;
import com.microsilver.mrcard.serviceplatform.service.ImsUserRecommendService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "/api/partner", description = "合伙人相关API")
@Controller
@RequestMapping(value = "api/partner")
public class PartnerController extends BaseController{
	@Resource
	ImsUserPanterOrderService orderService;
	
	@Resource
	ImsUserRecommendService recommendService;
	@Resource
	ImsUserPanterAreaService panterAreaService;
	
	@ApiOperation(value = "成为合伙人(下单)", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id"),
		@ApiImplicitParam(name = "vipType", value = "VIP类型(1:合伙人,2:超站,3:秘书长,10:vip会员)")})
	
	@RequestMapping(value = "/toBePartner")
	@ResponseBody
	public RespBaseDto<String> toBePartner(Long memberId,byte vipType){
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			ImsUserPanterOrder panterOrder = new ImsUserPanterOrder();
			panterOrder.setMemberId(memberId);
			panterOrder.setVipType(vipType);
			String orderSn = orderService.addPartner(panterOrder);
			result.setData(orderSn);			
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		}catch (Exception e) {
			logger.info(e.getMessage());
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	@ApiOperation(value = "我推荐的合伙人与会员统计", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id") })
	@RequestMapping(value = "/countMyPartner")
	@ResponseBody
	public RespBaseDto<Map<String,Object>> countMyPartner(Long memberId){
		RespBaseDto<Map<String,Object>> result = new RespBaseDto<Map<String,Object>>();
		try {
			Map<String,Object> partnerGroup = recommendService.getMyPartner(memberId);
			result.setData(partnerGroup);			
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		}catch (Exception e) {
			logger.info(e.getMessage());
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	@ApiOperation(value = "我推荐的合伙人与会员", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id"),
		@ApiImplicitParam(name = "type", value = "类型 1.一级合伙人 2.二级合伙人 3.一级会员 4.二级会员"),
		@ApiImplicitParam(name = "vipType", value = "vip类型(1:创业合伙人,2:高级合伙人,3:超级合伙人,10:vip会员)"),
		@ApiImplicitParam(name = "keyWords", value = "关键字搜索 匹配手机号或昵称"),
		@ApiImplicitParam(name = "pageNum", value = "当前页")})
	@RequestMapping(value = "/myPartner")
	@ResponseBody
	public RespBaseDto<List<ImsUserRecommendDto>> myPartner(Long memberId,Byte type,Byte vipType,String keyWords,@RequestParam(defaultValue="1")Integer pageNum){
		RespBaseDto<List<ImsUserRecommendDto>> result = new RespBaseDto<List<ImsUserRecommendDto>>();
		try {
			List<ImsUserRecommendDto> partnerGroup = recommendService.getMyPartnerByType(memberId,type,vipType,keyWords,pageNum);
			result.setData(partnerGroup);			
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		}catch (Exception e) {
			logger.info(e.getMessage());
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	
	@ApiOperation(value = "合伙人修改所属区域", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "memberId", value = "用户id"),
		@ApiImplicitParam(name = "areaCode", value = "区域code")})
	@RequestMapping(value = "/changeArea")
	@ResponseBody
	public RespBaseDto<String> changeArea(Long memberId,Long areaCode){
		RespBaseDto<String> result = new RespBaseDto<String>();
		try {
			String errorMsg="";
			ImsUserRecommend recommend = recommendService.selectByPrimaryKey(memberId);
			ImsSysArea area = DictionaryUtils.getAreaMap().get(areaCode);
			boolean isArea = false;
			switch(recommend.getVipType()) {
				case 1:if(area.getLevel()==3) isArea = true;else errorMsg="您是创业合伙人，只能选择区县";break;
				case 2:if(area.getLevel()==2) isArea = true;else errorMsg="您是高级合伙人，只能选择市级区域";break;
				case 3:if(area.getLevel()==1) isArea = true;else errorMsg="您是超级合伙人，只能选择省级区域";break;
			}
			if(!isArea) {
				result.setMessage(errorMsg);
				result.setState(EWarning.Unknown.getValue());
				return result;
			}
			int areaCount = recommendService.countByArea(areaCode, recommend.getVipType());
			int maxCount = -1;
			
			/*查询所选区域是否有单独设置合伙人上限
			 * author zhengtao
			 * begin
			 */
			List<ImsUserPanterArea> panterAreas = panterAreaService.selectByAreaCode(areaCode);
			if(panterAreas.size()>0&&panterAreas.get(0).getMaxCount()!=null) {
				maxCount=panterAreas.get(0).getMaxCount();
			}
			if(maxCount==-1) {
				switch(recommend.getVipType()) {
				case 1:maxCount = Consts.VP_AREA_COUNT;break;
				case 2:maxCount = Consts.SP_AREA_COUNT;break;
				case 3:maxCount = Consts.SVP_area_count;break;
				default:throw new BusinessException("未知的合伙人类型");
				}				
			}
			/*
			 * end
			 */
			
			if(areaCount<maxCount) {
				recommendService.changeArea(recommend,areaCode);
				result.setData("OK");			
			}else {
				result.setMessage("您选择的区域合伙人已满，请选择其他区域");
				result.setState(EWarning.Unknown.getValue());
			}
		} catch (BusinessException be) {
			result.setMessage(be.getMessage());
			result.setState(be.getWarning().getValue());
		}catch (Exception e) {
			logger.info(e.getMessage());
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
	@ApiOperation(value = "获取合伙人信息", httpMethod = "POST")
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
					vipType.setName(evType.getCname());
					vipTypeList.add(vipType);
				}
				mpDto.setVipTypeList(vipTypeList);
			}
			mpDto.setMemberId(memberId);
			result.setData(mpDto);
			/*
			//测试传输数据是否正确    结果正确
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
				vipType.setName(evType.getCname());
				vipTypeList.add(vipType);
			}
			mpDto.setVipTypeList(vipTypeList);
			mpDto.setMemberId(memberId);
			result.setData(mpDto);
			*/
			
			
			
			
			
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
	
	@PostMapping("/getCustomer")
	public ImsUserRecommend selectUserRecommendByOrder(long orderId) {
		return orderService.selectUserRecommendByOrder(orderId);
		
	}
	
	@PostMapping("/getImsUserPanterOrderByOrdersn")
	public ImsUserPanterOrder selectImsUserPanterOrderByOrdersn(String ordersn) {
		return orderService.selectImsUserPanterOrderByOrdersn(ordersn);
		
	} 
}

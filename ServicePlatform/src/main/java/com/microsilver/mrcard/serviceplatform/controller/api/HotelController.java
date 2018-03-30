package com.microsilver.mrcard.serviceplatform.controller.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microsilver.mrcard.serviceplatform.common.DictionaryUtils;
import com.microsilver.mrcard.serviceplatform.common.Utils;
import com.microsilver.mrcard.serviceplatform.controller.BaseController;
import com.microsilver.mrcard.serviceplatform.core.exception.BusinessException;
import com.microsilver.mrcard.serviceplatform.dao.IShopMemberAddressDao;
import com.microsilver.mrcard.serviceplatform.dto.ActivityGoodsDto;
import com.microsilver.mrcard.serviceplatform.dto.HotelDto;
import com.microsilver.mrcard.serviceplatform.dto.HotelIndexDto;
import com.microsilver.mrcard.serviceplatform.dto.HotelOrderDto;
import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberAddress;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMemberCollection;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchImages;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUser;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrder;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopOrderComment;
import com.microsilver.mrcard.serviceplatform.model.ImsSysDictionary;
import com.microsilver.mrcard.serviceplatform.model.ImsSysRemind;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopMemberCollectionSmpl;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopMerchImagesService;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopMerchUserSmpl;
import com.microsilver.mrcard.serviceplatform.service.ImsSysRemindService;
import com.microsilver.mrcard.serviceplatform.service.ShopOrderSmpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/api/quding", description = "去订接口")
@RestController
@RequestMapping("/api/quding")
public class HotelController extends BaseController {
	@Resource
	private ImsEweiShopMerchUserSmpl eweiShopMerchUserSmpl;
	@Resource
	ImsEweiShopMemberCollectionSmpl collectionSmpl;
	@Resource
	ShopOrderSmpl orderSmpl;
	@Resource
	ImsEweiShopMerchImagesService shopMerchImagesService;
	@Resource
	ImsSysRemindService remindService;
	@Resource
	IShopMemberAddressDao addressDao;
	
	@ApiOperation(value = "获取首页内容", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="appType",value="投放应用类型(超级订:hotel_adv,总后台:mgmt_adv)",paramType="query"),
		@ApiImplicitParam(name="advBits",value="广告位编号",paramType="query"),
		@ApiImplicitParam(name="lat",value="经度",paramType="query"),
		@ApiImplicitParam(name="lng",value="纬度",paramType="query"),
		@ApiImplicitParam(name="code",value="区域code字段",paramType="query"),
		@ApiImplicitParam(name="areaType",value="区域类型1.省 2.市 3.区县",paramType="query")		
	})
	@RequestMapping(value = "/getIndex")
	public RespBaseDto<HotelIndexDto> getIndex(@ApiParam(hidden=true) HotelDto hotelDto,@RequestParam(defaultValue="hotel_adv") String appType,@RequestParam(defaultValue="1") Short advBits){
		RespBaseDto<HotelIndexDto> dto = new RespBaseDto<>();
		try {
			HotelIndexDto hotelIntexDto = eweiShopMerchUserSmpl.constituteIndex(hotelDto,appType,advBits);
			dto.setData(hotelIntexDto);
		} catch (Exception e) {
			e.printStackTrace();
			dto.setMessage(EWarning.Unknown.getName());
			dto.setState(EWarning.Unknown.getValue());
		}
		return dto;
	}
	
	@ApiOperation(value = "组合条件查询酒店", httpMethod = "POST")
	@ApiImplicitParams({@ApiImplicitParam(name="page",value="页码",paramType="query"),
		@ApiImplicitParam(name="keyWords",value="关键字",paramType="query"),
		@ApiImplicitParam(name="startPrice",value="最低价",paramType="query"),
		@ApiImplicitParam(name="endPrice",value="最高价",paramType="query"),
		@ApiImplicitParam(name="starLevel",value="星级",paramType="query"),
		@ApiImplicitParam(name="merchType",value="商户类型(不同类型以英文状态的逗号)",paramType="query"),
		@ApiImplicitParam(name="brandId",value="酒店品牌(不同品牌以英文状态的逗号)",paramType="query"),
		@ApiImplicitParam(name="servicestag",value="服务标签(不同服务以英文状态的逗号)",paramType="query"),
		@ApiImplicitParam(name="sortType",value="排序方式1.评分优先 2.折扣最多 3.销量最多4.价格最低 5.距离最近",paramType="query"),
		@ApiImplicitParam(name="lat",value="经度",paramType="query"),
		@ApiImplicitParam(name="lng",value="纬度",paramType="query"),
		@ApiImplicitParam(name="code",value="区域code字段",paramType="query"),
		@ApiImplicitParam(name="areaType",value="区域类型1.省 2.市 3.区县",paramType="query"),
		@ApiImplicitParam(name="activity",value="活动类型 1.零点半价 2.超级特价",paramType="query"),
		@ApiImplicitParam(name="cashbackMax",value="平台返现 0.未选 1.已选",paramType="query")
		})
	@RequestMapping(value = "/searchHotels")
	public RespBaseDto<List<HotelDto>> searchHotels(@ApiParam(hidden=true) HotelDto hotelDto){
		
		System.out.println("==============================");
		RespBaseDto<List<HotelDto>> dto = new RespBaseDto<>();
		try {
			if(hotelDto.getAreaType()==null&&hotelDto.getCode()!=null){
//				hotelDto.setAreaType((byte)2);
			}
			List<HotelDto> hotels = eweiShopMerchUserSmpl.searchHotels(hotelDto);
			dto.setData(hotels);
		} catch (Exception e) {
			e.printStackTrace();
			dto.setMessage(EWarning.Unknown.getName());
			dto.setState(EWarning.Unknown.getValue());
		}
		return dto;
	}
	
	@ApiOperation(value = "获取服务标签", httpMethod = "POST")
	@ApiImplicitParam(name="tagName",
	value="标签名称(star_level=星级标签,hotel_tags=酒店服务标签,hotel_goods_tags=房间服务标签,hotel_type=酒店类型,hotel_brand=酒店品牌)")
	@RequestMapping(value = "/getTags")
	public RespBaseDto<Map<String,List<ImsSysDictionary>>> getTags(String tagName){
		RespBaseDto<Map<String,List<ImsSysDictionary>>> dto = new RespBaseDto<>();
		try {
			if(tagName!=null){
				String[] tagArray = tagName.split(",");
				Map<String,List<ImsSysDictionary>> map = new HashMap<>();
				for (String string : tagArray) {
					map.put(string, DictionaryUtils.getDictionaryListByType(string));		
				}
				dto.setData(map);
			}			
		} catch (Exception e) {
			dto.setMessage(EWarning.Unknown.getName());
			dto.setState(EWarning.Unknown.getValue());
		}
		return dto;
	}
	
	
	/*
	@ApiOperation(value = "进入酒店首页", httpMethod = "POST")
	@RequestMapping(value = "/getHotelById")
	public RespBaseDto<HotelDto> getHotelById(Long memberId, Integer merchId) {
		RespBaseDto<HotelDto> result = new RespBaseDto<>();
		try {
			HotelDto hotelDetails = eweiShopMerchUserSmpl.getHotelDetails(memberId, merchId);
			result.setData(hotelDetails);
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(EWarning.Unknown.getName());
		}
		return result;
	}
*/
	
	@ApiOperation(value = "进入酒店首页", httpMethod = "POST")
	@RequestMapping(value = "/getHotelById")
	public RespBaseDto<HotelDto> getHotelById(Long memberId, Integer merchId, Integer activityId) {
		RespBaseDto<HotelDto> result = new RespBaseDto<>();
		if("".equals(activityId)||activityId==null) {
			
			try {
				HotelDto hotelDetails = eweiShopMerchUserSmpl.getHotelDetails(memberId, merchId,activityId);
				result.setData(hotelDetails);
			} catch (BusinessException be) {
				result.setMessage(be.getWarning().getName());
				result.setState(be.getWarning().getValue());
			} catch (Exception e) {
				e.printStackTrace();
				result.setState(EWarning.Unknown.getValue());
				result.setMessage(EWarning.Unknown.getName());
			}
			
		}else {
			
			try {
				HotelDto hotelDetails = eweiShopMerchUserSmpl.getHotelDetails(memberId, merchId, activityId);
				result.setData(hotelDetails);
			} catch (BusinessException be) {
				result.setMessage(be.getWarning().getName());
				result.setState(be.getWarning().getValue());
			} catch (Exception e) {
				e.printStackTrace();
				result.setState(EWarning.Unknown.getValue());
				result.setMessage(EWarning.Unknown.getName());
			}
			
			
		}
		
		
		
		return result;
	}
	
	@ApiOperation(value = "获取酒店图片", httpMethod = "POST")
	@RequestMapping(value = "/getHotelImages")
	public RespBaseDto<List<ImsEweiShopMerchImages>> getHotelImages(Integer merchId){
		RespBaseDto<List<ImsEweiShopMerchImages>> result = new RespBaseDto<>();
		try {
			List<ImsEweiShopMerchImages> imageList = shopMerchImagesService.getImsEweiShopMerchImagesByMerchId(merchId);
			result.setData(imageList);
		}catch (Exception e) {
			e.printStackTrace();
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(EWarning.Unknown.getName());
		}
		return result;
	}
	
	@ApiOperation(value = "订房提醒", httpMethod = "POST")
	@ApiImplicitParams({@ApiImplicitParam(name="memberId",value="用户id"),@ApiImplicitParam(name="merchId",value="传0"),@ApiImplicitParam(name="identity",value="用户身份id"),
		@ApiImplicitParam(name="objectId",value="商品id"),@ApiImplicitParam(name="remindTime",value="活动开始时间")})
	@RequestMapping(value = "/remindMe")
	public RespBaseDto<String> remindMe(ImsSysRemind remind){
		RespBaseDto<String> result = new RespBaseDto<>();
		try {
			remind.setObjectType((byte)1); //1.表示房间
			remind.setRemindWay((byte)1);//提醒方式(0:push,1:短信,2:push+短信)
			remind.setCreateTime(Utils.getCurrentTime());
			int r = remindService.newRemind(remind);
			if(r==1)
				result.setData("OK");			
		} catch (Exception e) {
			e.printStackTrace();
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(EWarning.Unknown.getName());		}
		return result;
	}
	
	@ApiOperation(value = "进入房间主页", httpMethod = "POST")
	@RequestMapping(value = "/getRoomIndex")
	public RespBaseDto<ActivityGoodsDto> getRoomIndex(Long goodsId,Long memberId){
		RespBaseDto<ActivityGoodsDto> result = new RespBaseDto<>();
		try {
			ActivityGoodsDto roomIndex = eweiShopMerchUserSmpl.getRoomIndex(goodsId,memberId);
			result.setData(roomIndex);			
		} catch (BusinessException be) {
			be.printStackTrace();
			result.setState(be.getWarning().getValue());
			result.setMessage(be.getWarning().getName());	
		} catch (Exception e) {
			e.printStackTrace();
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(EWarning.Unknown.getName());		
		}
		return result;
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name="orderId",value="订单ID，该参数不填",required=false),
		@ApiImplicitParam(name="ordersn",value="订单编号，该参数不填",required=false),
		@ApiImplicitParam(name="goodsId",value="商品ID",required=true,dataType="int",paramType="form"),
		@ApiImplicitParam(name="goodsNumber",value="商品数量",required=true,dataType="int"),
		@ApiImplicitParam(name="days",value="入住天数",required=true,dataType="int"),
		@ApiImplicitParam(name="fetchTime",value="入住时间",required=true,dataType="int"),
		@ApiImplicitParam(name="sendTime",value="离店时间",required=true,dataType="int"),
		@ApiImplicitParam(name="price",value="商品总价",required=true,dataType="int"),
		@ApiImplicitParam(name="memberId",value="用户ID",required=true,dataType="int"),
		@ApiImplicitParam(name="customers",value="用户信息组(json格式)",required=true,dataType="json"),
		@ApiImplicitParam(name="sourceType",value="订单来源(1:android,2:ios,3:微信)")})
	@ApiOperation(value = "创建订单", httpMethod = "POST")
	@RequestMapping(value = "/createOrder")
	public RespBaseDto<HotelOrderDto> createOrder(HotelOrderDto orderDto){
		RespBaseDto<HotelOrderDto> result = new RespBaseDto<>();
		try {
			if(orderDto.getSourceType()==null||orderDto.getSourceType().equals("")) {
				orderDto.setSourceType((byte)2);
			}
			HotelOrderDto dto= eweiShopMerchUserSmpl.createOrder(orderDto);			
			result.setData(dto);
		} catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch(Exception e) {
			e.printStackTrace();
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(EWarning.Unknown.getName());
		}
		return result;
	}
	
	@ApiOperation(value = "获取已收藏", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberId",value="用户id"),
		@ApiImplicitParam(name="collecType",value="收藏类型1.房间 2.地址")})	
	@RequestMapping(value = "/getCollections")
	public RespBaseDto<List<Object>> getCollections(Long memberId,@RequestParam(defaultValue="1")Byte collecType){
		RespBaseDto<List<Object>>  result = new RespBaseDto<>();
		List<Object> object = new ArrayList<>();
		try {
			List<ImsEweiShopMemberCollection> collections = collectionSmpl.selectByMemberId(memberId,collecType);
				for (ImsEweiShopMemberCollection imsEweiShopMemberCollection : collections) {
					long objectId = imsEweiShopMemberCollection.getCollecObjectId();
					if(collecType==1){
						ImsEweiShopMerchUser merch= eweiShopMerchUserSmpl.selectByPrimaryKeyWithPrice(objectId);
						if(merch!=null){
							Integer shopType = merch.getShopType();
							merch.setMerchType(translateShopType(shopType));
							object.add(merch);							
						}
					}else if(collecType == 2){
						ImsEweiShopMemberAddress address = addressDao.selectByPrimaryKey((int)objectId);
						object.add(address);
					}
				}			
		} catch (Exception e) {
			e.printStackTrace();
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(EWarning.Unknown.getName());
		}
		result.setData(object);
		return result;
	}
	
	public String translateShopType(Integer shopType){
		if(shopType!=null) {
			List<ImsSysDictionary> dictionaryListByType = DictionaryUtils.getDictionaryListByType("hotel_type");
			for (ImsSysDictionary imsSysDictionary : dictionaryListByType) {
				if(imsSysDictionary.getValue().equals(shopType)) {
					return imsSysDictionary.getName();
				}
			}			
		}
		return null;
	}
	
	@ApiOperation(value = "(取消)收藏", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="memberId",value="用户id"),
		@ApiImplicitParam(name="merchId",value="收藏的对象id"),
		@ApiImplicitParam(name="status",value="状态 1.收藏 0.取消收藏"),
		@ApiImplicitParam(name="collecType",value="收藏类型1.酒店 2.地址")})
	@RequestMapping(value = "/isCollection")
	public RespBaseDto<String> isCollection(Long memberId,Integer merchId,Byte status,@RequestParam(defaultValue="1")Byte collecType){
		RespBaseDto<String>  result = new RespBaseDto<>();
		try {
			int code = collectionSmpl.changeStatus(memberId,merchId, status,collecType);
			if(code==1){
				result.setMessage("OK");
			}else{
				result.setState(EWarning.Unknown.getValue());
				result.setMessage(EWarning.Unknown.getName());
			}			
		} catch (Exception e) {
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(EWarning.Unknown.getName());
		}
		return result;
	}
	
	@ApiOperation(value = "住过的酒店", httpMethod = "POST")
	@RequestMapping(value = "/getHotelsOnceIn")
	public RespBaseDto<List<ImsEweiShopMerchUser>> getHotelsOnceIn(Long memberId){
		RespBaseDto<List<ImsEweiShopMerchUser>>  result = new RespBaseDto<>();
		try {
			List<ImsEweiShopOrder> orders = orderSmpl.getOrderByMemberId(memberId);
			Set<Long> merchIds = new HashSet<>();		
			for (ImsEweiShopOrder imsEweiShopOrder : orders) {
				merchIds.add(imsEweiShopOrder.getMerchid());
			}
			List<ImsEweiShopMerchUser> merchs = new ArrayList<>();
			for (long merchId : merchIds) {
				ImsEweiShopMerchUser merch= eweiShopMerchUserSmpl.selectByPrimaryKeyWithPrice(merchId);	
				if(merch!=null){
					Integer shopType = merch.getShopType();
					merch.setMerchType(translateShopType(shopType));
					String tags = merch.getServicestag();
					List<String> listTags = new ArrayList<>();
					if (tags != null&&!tags.equals("")) {
						String[] tag = tags.split(",");
						List<ImsSysDictionary> dics = DictionaryUtils.getDictionaryListByType("hotel_tags");
						for (String str : tag) {
							for (ImsSysDictionary imsSysDictionary : dics) {
								if(imsSysDictionary.getValue().equals(Integer.valueOf(str))){
									listTags.add(imsSysDictionary.getName());		
									break;
								}
							}
						}
					}
					merch.setListTags(listTags);
					merchs.add(merch);
				}
			}			
			result.setData(merchs);
		} catch (Exception e) {
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(EWarning.Unknown.getName());		
		}
		return result;
	}
	
	@ApiOperation(value = "进入评论界面", httpMethod = "POST")
	@ApiImplicitParam(name="orderId",value="订单id")
	@RequestMapping(value = "/toAppraise")
	public RespBaseDto<ImsEweiShopMerchUser> toAppraise(Long orderId){
		RespBaseDto<ImsEweiShopMerchUser>  result = new RespBaseDto<>();
		try {
			ImsEweiShopMerchUser shopMerch = eweiShopMerchUserSmpl.getShopMerchUser(orderId);
			result.setData(shopMerch);
		}catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(EWarning.Unknown.getName());
		}
		return result;
	}
	
	@ApiOperation(value = "提交评论", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="orderid",value="订单id"),
		@ApiImplicitParam(name="level",value="几星"),
		@ApiImplicitParam(name="content",value="评论内容"),
		@ApiImplicitParam(name="images",value="评论图片(多张用逗号分隔)"),
		@ApiImplicitParam(name="isAnonymous",value="是否匿名评价"),
	})
	@RequestMapping(value = "/submitComment")
	public RespBaseDto<String> submitComment(ImsEweiShopOrderComment comment,@RequestParam(defaultValue="false") Boolean isAnonymous){
		RespBaseDto<String>  result = new RespBaseDto<>();
		try {
			eweiShopMerchUserSmpl.submitComment(comment,isAnonymous);
			result.setData("ok");
		}catch (BusinessException be) {
			result.setMessage(be.getWarning().getName());
			result.setState(be.getWarning().getValue());
		} catch (Exception e) {
			result.setState(EWarning.Unknown.getValue());
			result.setMessage(EWarning.Unknown.getName());
		}
		return result;
	}
}
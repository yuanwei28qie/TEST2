package com.microsilver.mrcard.serviceplatform.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microsilver.mrcard.serviceplatform.dto.RespBaseDto;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopAdv;
import com.microsilver.mrcard.serviceplatform.model.ImsEweiShopMerchUser;
import com.microsilver.mrcard.serviceplatform.model.enums.EWarning;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopAdvSmpl;
import com.microsilver.mrcard.serviceplatform.service.ImsEweiShopMerchUserSmpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/api/index", description = "首页请求")
@Controller
@RequestMapping(value = "api/index")
public class IndexController {
	@Resource
	private ImsEweiShopAdvSmpl imsEweiShopAdvSmpl;

	@Resource
	private ImsEweiShopMerchUserSmpl eweiShopMerchUser ;
	
	@ApiOperation(value = "获取首页内容", httpMethod = "POST")
	@RequestMapping(value = "/getIndexContent")
	@ResponseBody
	public RespBaseDto<Map<String,List<?>>> getIndexContent(@RequestParam Integer uniacId,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10")Integer pageSize){
		RespBaseDto<Map<String,List<?>>> result = new RespBaseDto<>();
		Map<String,List<?>> map = new HashMap<>();
		
		List<ImsEweiShopAdv> imsEweiShopAdvs = imsEweiShopAdvSmpl.getAdvByUnicId(uniacId);
		map.put("advs", imsEweiShopAdvs);
		List<ImsEweiShopMerchUser> latestPreferentials = eweiShopMerchUser.getLatestPreferentialShopsByUniacId(uniacId);
		map.put("latestPreferential", latestPreferentials);
		List<ImsEweiShopMerchUser> recommendShops = eweiShopMerchUser.getRecommendShopByUniacId(uniacId,page,pageSize);
		map.put("recommendShops", recommendShops);
		
		result.setData(map);
		return result;
	}
	
	@ApiOperation(value = "分页获取推荐商家", httpMethod = "POST")
	@RequestMapping(value = "/loadRecommendShops")
	@ResponseBody
	public RespBaseDto<List<ImsEweiShopMerchUser>> loadRecommendShops(@RequestParam Integer uniacId,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10")Integer pageSize){
		RespBaseDto<List<ImsEweiShopMerchUser>> result = new RespBaseDto<>();
		try{
			List<ImsEweiShopMerchUser> recommendShops = eweiShopMerchUser.getRecommendShopByUniacId(uniacId,page,pageSize);
			result.setMessage("OK");
			result.setData(recommendShops);			
		}catch(Exception e){
			result.setMessage(EWarning.Unknown.getName());
			result.setState(EWarning.Unknown.getValue());
		}
		return result;
	}
}

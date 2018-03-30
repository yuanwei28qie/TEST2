package com.microsilver.mrcard.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.microsilver.mrcard.cloud.finance.model.MrcardFinanceCustomer;
import com.microsliver.model.dao.ImsUserPanterOrder;
import com.microsliver.model.dao.ImsUserRecommend;


@FeignClient(value = "api-service")
public interface IServiceRemoteSmpl {
	@RequestMapping(value = "/api/partner/getCustomer", method = RequestMethod.POST)
	public ImsUserRecommend selectUserRecommend(@RequestParam(value ="orderId")Long orderId);
	@RequestMapping(value = "/api/partner/getImsUserPanterOrderByOrdersn", method = RequestMethod.POST)
	public ImsUserPanterOrder selectImsUserPanterOrderByOrdersn(@RequestParam(value ="ordersn")String ordersn);
	

}

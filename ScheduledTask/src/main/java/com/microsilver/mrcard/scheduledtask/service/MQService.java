package com.microsilver.mrcard.scheduledtask.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microsilver.mrcard.mq.PushMsg;
import com.microsilver.mrcard.scheduledtask.model.RespBaseDto;


@FeignClient(value = "API-SERVICE")
public interface MQService {

	@RequestMapping(value = "/ServicePlatform/api/Common/pushMessageToMQForFeign", method = RequestMethod.POST)
	public RespBaseDto pushMessageToMQForFeign(@RequestBody PushMsg msg);
}

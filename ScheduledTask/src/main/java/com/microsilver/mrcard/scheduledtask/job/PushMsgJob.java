package com.microsilver.mrcard.scheduledtask.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.mq.PushMsg;
import com.microsilver.mrcard.scheduledtask.service.MQHandlerService;
import com.microsilver.mrcard.scheduledtask.utils.MQUtil;
import com.rabbitmq.client.Channel;

@Component
public class PushMsgJob implements ChannelAwareMessageListener {

	// 统一处理消息
	@Autowired
	private MQHandlerService handlerService;
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		try {
			// 解析消息为自己的消息实体
			PushMsg msg = MQUtil.fromMessage(message, PushMsg.class);
			logger.info("收到MQ：{}",JSON.toJSONString(msg));
			this.handlerService.pushMsg(msg);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
}

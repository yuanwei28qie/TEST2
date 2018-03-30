package com.microsilver.mrcard.scheduledtask.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.mq.MemberMQ;
import com.microsilver.mrcard.scheduledtask.model.ImsUserRecommend;
import com.microsilver.mrcard.scheduledtask.service.PanterOrderService;
import com.microsilver.mrcard.scheduledtask.utils.MQUtil;
import com.rabbitmq.client.Channel;

@Component
public class MemberHandler implements ChannelAwareMessageListener{
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	PanterOrderService panterOrderService;
	
	@Override
    public void onMessage(Message message, Channel channel) throws Exception {
		MemberMQ memberMq = MQUtil.fromMessage(message,MemberMQ.class);

        logger.info("收到会员通知信息："+JSON.toJSONString(memberMq));
        if(memberMq != null){
        	switch (memberMq.getType()){
        		//推荐用户
        		case 1:
        			recommendPreSettlement(memberMq);
        			break;
        		//会员充值
        		case 2:
        			break;
        		default:
                	logger.info("收到未定义的会员消息类型：{}",memberMq.getType());
                	break;
        	}
        }
	}
	/**
	 * 推荐会员预结算
	 * @param memberMq
	 */
	private void recommendPreSettlement(MemberMQ memberMq) {
		try {
			panterOrderService.updateUserRecommend(memberMq.getRegMemberId(), (byte)1);
			Long orderId=panterOrderService.addUserRecommendOrder(memberMq.getRegMemberId());
			ImsUserRecommend recommend = panterOrderService.selectUserRecommendByOrder(orderId);
			//testMember(orderId);
			if(panterOrderService.PreSettlementByRecommendMember(orderId, recommend))
				logger.info("{}推荐会员{},预结算成功",memberMq.getRefereeMemberId(),memberMq.getRegMemberId());
		}
		catch(Exception ex) {
			panterOrderService.updateUserRecommend(memberMq.getRegMemberId(), (byte)-1);
			ex.printStackTrace();
			logger.error("推荐会员预结算失败:{}",ex.getMessage());
		}
	}
	
	/*private void testMember(long orderId) {
		ImsUserRecommend recommend = panterOrderService.selectUserRecommendByOrder(orderId);
		panterOrderService.PreSettlementByRecommendMember(orderId,recommend);
	}*/
	/**
	 * 推荐会员结算
	 * @param memberMq
	 */
	private void recommendSettlement(MemberMQ memberMq) {
		
	}
	
}

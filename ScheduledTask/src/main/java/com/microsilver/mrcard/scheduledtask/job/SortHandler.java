package com.microsilver.mrcard.scheduledtask.job;

import com.microsilver.mrcard.mq.SortMQ;
import com.microsilver.mrcard.scheduledtask.service.ShopActivityGoodsService;
import com.microsilver.mrcard.scheduledtask.utils.MQUtil;
import com.rabbitmq.client.Channel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Jade on 2017/8/22.
 */
@Component
public class SortHandler  implements ChannelAwareMessageListener {
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    ShopActivityGoodsService goodsService;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            // 解析消息为自己的消息实体
            SortMQ sort = MQUtil.fromMessage(message, SortMQ.class);
            if(null != sort) {
            	int sortWeight = goodsService.calSortWeight(sort.getMerchId());
            	logger.info("商户["+sort.getMerchId()+"]刷新排序,权重分值："+sortWeight);
            }else {
            	logger.info("权重消息队列取到空消息");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

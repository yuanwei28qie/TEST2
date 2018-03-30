package com.microsilver.mrcard.scheduledtask.job;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.mq.coordinateMQ;
import com.microsilver.mrcard.scheduledtask.service.ImsEweiShopMemberIdentityAdditionalService;
import com.microsilver.mrcard.scheduledtask.utils.MQUtil;
import com.rabbitmq.client.Channel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Name com.microsilver.mrcard.scheduledtask.job.coordinateHandler
 * @Description 用户坐标实时更新
 * @Author Jade
 * @Version 2017/9/18
 * @Copyright Micro Silver
 */
@Component
public class coordinateHandler  implements ChannelAwareMessageListener {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ImsEweiShopMemberIdentityAdditionalService additionalService;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            // 解析消息为自己的消息实体
            coordinateMQ ordinate = MQUtil.fromMessage(message, coordinateMQ.class);
            logger.info("实时用户坐标："+ JSON.toJSONString(ordinate));
            if(ordinate != null) {
                int num = additionalService.updateLocation(ordinate);
                logger.debug("用户坐标更新成功"+JSON.toJSONString(ordinate));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

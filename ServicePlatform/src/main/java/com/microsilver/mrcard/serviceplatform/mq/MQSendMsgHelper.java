package com.microsilver.mrcard.serviceplatform.mq;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.mq.MemberMQ;
import com.microsilver.mrcard.mq.OrderMQ;
import com.microsilver.mrcard.mq.PushMsg;
import com.microsilver.mrcard.mq.SortMQ;
import com.microsilver.mrcard.mq.coordinateMQ;
import com.microsilver.mrcard.serviceplatform.mq.AmqpConfig.RouteConfig;

@Component
@Lazy(false)
public class MQSendMsgHelper {

    @Autowired
    private AmqpConfig amqpConfig;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入
     */
    @Autowired
    public MQSendMsgHelper(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJSONMsg(PushMsg msg) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        RouteConfig route = this.amqpConfig.getRouteConfig("msgHandle");
        this.rabbitTemplate.convertAndSend(route.exchange, route.routingkey, JSON.toJSONString(msg), correlationId);
    }
    public void sendJSONOrderMQ(OrderMQ order) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        RouteConfig route = this.amqpConfig.getRouteConfig("orderHandle");
        this.rabbitTemplate.convertAndSend(route.exchange, route.routingkey, JSON.toJSONString(order), correlationId);
    }
    public void sendJSONMemberMQ(MemberMQ member) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        RouteConfig route = this.amqpConfig.getRouteConfig("memberHandle");
        this.rabbitTemplate.convertAndSend(route.exchange, route.routingkey, JSON.toJSONString(member), correlationId);
    }

    public void sendJSONMsg(SortMQ msg) {
//    	Connection connection = rabbitTemplate.getConnectionFactory().createConnection();
//    	Channel channel = connection.createChannel(false);
//		try {
//			RouteConfig route = this.amqpConfig.getRouteConfig("sortHandle");
//			channel.exchangeDeclare(route.exchange, ExchangeTypes.FANOUT);
//			channel.basicPublish(route.exchange,route.routingkey,MessageProperties.PERSISTENT_TEXT_PLAIN,SerializationUtils.serialize(msg));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				channel.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        RouteConfig route = this.amqpConfig.getRouteConfig("sortHandle");
        this.rabbitTemplate.convertAndSend(route.exchange, route.routingkey, JSON.toJSONString(msg), correlationId);
    }

    public void sendByteMsg(PushMsg msg) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        // 这里未实现，可以采用protobuf序列化
        RouteConfig route = this.amqpConfig.getRouteConfig("msgHandle");
        this.rabbitTemplate.convertAndSend(route.exchange, route.routingkey,  JSON.toJSONString(msg), correlationId);
    }

    public void coordinateMSG(coordinateMQ msg) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        // 这里未实现，可以采用protobuf序列化
        RouteConfig route = this.amqpConfig.getRouteConfig("coordinateHandle");
        this.rabbitTemplate.convertAndSend(route.exchange, route.routingkey,  JSON.toJSONString(msg), correlationId);
    }
}

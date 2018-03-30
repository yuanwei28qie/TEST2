package com.microsilver.mrcard.scheduledtask.delay;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * Created by Jade on 2017/8/22.
 */
@Service
public class DelayQueueService  implements ApplicationContextAware {

    final static Log logger = LogFactory.getLog(DelayQueueService.class);

    private static ApplicationContext applicationContext = null;

    final static BlockingQueue<DelayCommission> queue = new DelayQueue<DelayCommission>();
    final static BlockingQueue<DelayCommission> queueList = new DelayQueue<DelayCommission>();

    final static int MAX_COUNT = 3;

    static DelayQueueConsumer consumer = null;

    /**
     * 生产 第一次使用
     * @param orderId
     * @param commission
     */
    public static void putCommissionToQueue(int orderId,CommissionDto commission){
        logger.info("job 结算对象生产:"+JSON.toJSONString(commission));
        DelayCommission delayCommission = new DelayCommission(0,orderId,commission,1000);
        putCommissionToQueue(delayCommission);

        if(consumer == null){
            consumer = applicationContext.getBean(DelayQueueConsumer.class);
            consumer.setBlockingQueue(queue);
            new Thread(consumer).start();
        }
    }

    public static void putCommissionToQueue(int orderId,String orderSn,List<CommissionDto> commission){
        logger.info("job 结算对象生产:"+JSON.toJSONString(commission));
        DelayCommission delayCommission = new DelayCommission(0,orderId,orderSn,commission,1000);
        putCommissionToQueue(delayCommission);

        if(consumer == null){
            consumer = applicationContext.getBean(DelayQueueConsumer.class);
            consumer.setBlockingQueue(queue);
            new Thread(consumer).start();
        }
    }

    /**
     * 重试
     *      次数+1
     *      时间延迟
     * @param delay
     */
    public static void putCommissionToQueue(DelayCommission delay){
        delay.setCount(delay.getCount()+1);
        switch (delay.getCount()){
            case 1:
                delay.setExpiryTime(3000);
                break;
            case 2:
                delay.setExpiryTime(3000*10);
                break;
            case MAX_COUNT:
                delay.setExpiryTime(1000*60);
                break;
            default:
                logger.info("结算重试次数过多，不再进行结算:"+delay.getOrderId());
                return;
        }
        new DelayQueueProducer(queue).putElement(delay);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}

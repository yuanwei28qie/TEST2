package com.microsilver.mrcard.scheduledtask.delay;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Jade on 2017/8/22.
 * 生产 结算对象
 *    向阻塞队列中添加要延迟处理的结算对象
 */
public class DelayQueueProducer{
    final static Log logger = LogFactory.getLog(DelayQueueProducer.class);

    protected BlockingQueue<DelayCommission> blockingQueue;

    public DelayQueueProducer(BlockingQueue<DelayCommission> queue) {
        this.blockingQueue = queue;
    }

    public void putElement(DelayCommission delayElement){
        try {
            logger.info("producer :"+JSON.toJSONString(delayElement));
            blockingQueue.put(delayElement);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

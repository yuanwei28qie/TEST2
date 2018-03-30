package com.microsilver.mrcard.scheduledtask.delay;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;
import com.microsilver.mrcard.scheduledtask.service.IFinanceRemoteService;
import com.microsilver.mrcard.scheduledtask.service.ShopOrderJobService;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jade on 2017/8/22.
 * 阻塞式队列，处理结算
 */
@Component
public class DelayQueueConsumer implements Runnable{
    final static Log logger = LogFactory.getLog(DelayQueueConsumer.class);
    // 分成结算
    @Autowired
    private IFinanceRemoteService financeRemoteService;
    @Autowired
    private ShopOrderJobService orderJobService;


    protected BlockingQueue<DelayCommission> blockingQueue;

//    public DelayQueueConsumer(BlockingQueue<DelayCommission> queue) {
//        this.blockingQueue = queue;
//    }

    @Override
    public void run() {
        while (true) {
            boolean flag = false;
            DelayCommission delayCommission = null;
            try {//阻塞队列，未取到值会一直等待
                delayCommission = blockingQueue.take();
                if(delayCommission != null){
                    if(null == delayCommission.getOrderSn())
                        flag = commitCommission(delayCommission);
                    else
                        flag = commitCommissionByKnight(delayCommission);
                }
            } catch (InterruptedException e) {
                flag = true;
                logger.error("结算失败",e);
            }catch (Exception e){
                flag = true;
                logger.error("结算失败",e);
            }finally {
                if(delayCommission.getCount() >= DelayQueueService.MAX_COUNT && null == delayCommission.getOrderSn()) {//到达最大重试次数，则更新订单状态为结算失败，手工结算
                    orderJobService.changeOrderStatus(delayCommission.getOrderId(), (byte) -1);
                }else if(delayCommission.getCount() >= DelayQueueService.MAX_COUNT && null != delayCommission.getOrderSn()){
                    orderJobService.changeOrderStatusByKnight((long) delayCommission.getOrderId(), (byte) -1);
                }else if(flag) {
                    logger.info("结算失败，执行重试 :"+delayCommission.getOrderId());
                    DelayQueueService.putCommissionToQueue(delayCommission);
                }
            }
        }
    }

    private boolean commitCommission(DelayCommission delayCommission) {
        boolean flag = false;
        logger.info("getDelay : "+delayCommission.getDelay(TimeUnit.MICROSECONDS));
        logger.info("结算数据:"+ JSON.toJSONString(delayCommission));
        CommissionDto element = delayCommission.getElement();
        boolean issuccess = financeRemoteService.Commisstion(element);
        if(issuccess){//执行成功则修改订单状态
            orderJobService.changeOrderStatus(delayCommission.getOrderId(),(byte)1);
            logger.info("结算结果："+issuccess);
        }else{//执行失败，则重试
            flag = true;
        }
        return flag;
    }

    private boolean commitCommissionByKnight(DelayCommission delayCommission) {
        boolean flag = false;
        logger.info("getDelay : "+delayCommission.getDelay(TimeUnit.MICROSECONDS));
        logger.info("结算数据:"+ JSON.toJSONString(delayCommission));
        List<CommissionDto> element = delayCommission.getListElement();
        boolean issuccess = financeRemoteService.CommissionKnight(delayCommission.getOrderSn(),element);
        if(issuccess){//执行成功则修改订单状态
            orderJobService.changeOrderStatusByKnight((long) delayCommission.getOrderId(),(byte)1);
            logger.info("结算结果："+issuccess);
            //2017-09-22/结算完成后生成结算流水，客户金额在结转的时候再进行扣除
            orderJobService.KnightBound(delayCommission.getOrderSn());
        }else{//执行失败，则重试
            flag = true;
        }
        return flag;
    }

    public BlockingQueue<DelayCommission> getBlockingQueue() {
        return blockingQueue;
    }

    public void setBlockingQueue(BlockingQueue<DelayCommission> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
}

package com.microsilver.im.client.netty;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Name ImExculator
 * @Description
 * @Author Jade
 * @Version 2017/9/26
 * @Copyright Micro Silver
 */
@Component
public class ImExculator {
    private static Logger logger = Logger.getLogger(ImExculator.class.getName());
    @Value("${tcp.port}")
    public int tcpPort;
    @Value("${tcp.host}")
    public String tcpHost;
    @Value("${im.number}")
    public Integer number;


    @Autowired
    @Qualifier("imclient")
    IMclient client;

    @Autowired
    @Qualifier("imRepository")
    ImRepository imRepository;

    public void start() {
        final int[] count = {0};
        final ScheduledExecutorService executorCount = Executors.newScheduledThreadPool(1);
        executorCount.execute(new Runnable() { //接受一个Runnable实例
            public void run() {
                try {
                    for (;;) {
                        logger.info("online client number is : " + imRepository.size());
                        logger.info("server reply messages is : " + imRepository.sizeByReply());
                        System.out.println(new Date().toString()+" online client number is : " + imRepository.size());
                        System.out.println(new Date().toString()+" server reply messages is : " + imRepository.sizeByReply());
                        Thread.sleep(2000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(number);
        for (int i = 1; i <= number; i ++) {
            final  int taskId = i;   //10个任务
            //TimeUnit.SECONDS.sleep(1);
            //接受一个Runnable实例
            executor.execute(() -> {
//                    System.out.println("ImExculator.........."+taskId+"...............");
                try {
                    for (int j = 1; j <= number; j ++) {
                        client.connect("imclient" + taskId, tcpHost, tcpPort, imRepository);
                    }
//                        if(client.imClientIntHandler.getCtx().channel().isOpen())
                } catch (Exception e) {
                    count[0]++;
                    try {
                        Thread.sleep(count[0]*100);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            });
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

package  com.microsilver.im.server.netty;

import com.google.gson.Gson;

import com.microsilver.im.server.packet.Content;
import com.microsilver.im.server.packet.MessageBean;
import io.netty.channel.Channel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Name server.netty.ReplyListener
 * @Description
 * @Author Jade
 * @Version 2017/10/10
 * @Copyright Micro Silver
 */

@Component
public class ReplyListener {


    Gson g = new Gson();

    private Logger logger = Logger.getLogger(ReplyListener.class.getName());

    @Autowired
    @Qualifier("channelRepository")
    private ChannelRepository channelRepository;

    @Value("${base.result.time}")
    private Integer baseTime;
    @Value("${base.result.count}")
    private Integer baseCount;


    public void start() throws Exception {
        ScheduledExecutorService executorCount = Executors.newScheduledThreadPool(1);
        executorCount.scheduleWithFixedDelay(new Runnable() { //接受一个Runnable实例
            private Logger taskLog = Logger.getLogger(super.getClass());
            public void run() {
                try {
                    int count = channelRepository.getMessageCacheAll();
                    int channle = channelRepository.getChannelCache().size();
                    if (count > 0 && channle > 0){
                          MessageBean reply = new MessageBean();
                        reply.setFormId("/192.168.4.233:1086/replay");
                        Long nowTime = System.currentTimeMillis();
                        Long begincount = channelRepository.getCountTime();
                        Integer[] minMessage = {9999};
                        String [] minClient = {""};

                        channelRepository.setCountTime(nowTime);
                        channelRepository.getMessageCache().forEach((k, v) -> {
                            if(v < minMessage[0]) {
                                minMessage[0] = v;
                                minClient[0] = k;
                            }
                            if(nowTime - begincount > (baseCount*1000) && logger.isDebugEnabled()) {
                                taskLog.debug("用户【" + k + "】消息总数:【" + v + "】");
                            }
                        });
                        taskLog.info("当前在线用户数【"+channelRepository.getChannelCache().size()+"】 消息总数【"+channelRepository.getMessageCacheAll()+"】");

                        Long beginTime = channelRepository.getCurrentTime();
                        if(nowTime - beginTime > (baseTime*1000)) {
                            channelRepository.setCurrentTime(nowTime);
                            reply.setCommand("shakeResult");
                            Content cc = new Content();
                            cc.setStatus(0);
                            cc.setData(minClient[0] + " shake count is " +minMessage[0]+"");
                            cc.setMessage("OK");
                            reply.setContent(cc);

                            Map<String, Channel> all = channelRepository.getChannelCache();
                            logger.debug(g.toJson(reply) + "###");
                            all.forEach((k, v) -> {
                                logger.debug("muc packet =>" + v);
                                reply.setToId(v.remoteAddress().toString());
                                v.writeAndFlush(g.toJson(reply) + "###");
                            });
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },0,5000, TimeUnit.MILLISECONDS);
    }
}

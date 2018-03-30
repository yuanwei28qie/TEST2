package com.microsilver.im.client.netty;

import com.google.gson.Gson;

import com.microsilver.im.client.packet.Content;
import com.microsilver.im.client.packet.MessageBean;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Name com.microsilver.netty.client.im.client.im.ImSimpleHandler
 * @Description
 * @Author Jade
 * @Version 2017/10/9
 * @Copyright Micro Silver
 */

@Component
@ChannelHandler.Sharable
public class ImSimpleHandler  extends SimpleChannelInboundHandler {

    private static Logger logger = Logger.getLogger(ImSimpleHandler.class.getName());
    private String imClientName;

    Gson g = new Gson();
    @Autowired
    @Qualifier("imRepository")
    ImRepository imRepository;

    public String getImClientName() {
        return imClientName;
    }

    public void setImClientName(String imClientName) {
        this.imClientName = imClientName;
    }

    private MessageBean login(){
        return packate("login","请求登录");
    }
    private MessageBean chat(Integer ids){
        return packate("shake","聊天消息"+ids);
    }
    private MessageBean start(){
        return packate("start","开始摇");
    }

    private MessageBean packate(String command,String data){
        MessageBean message = new MessageBean();
        message.setFormId(this.imClientName);
        message.setMsgId(UUID.randomUUID().toString().substring(0,10));
        message.setToId("MRCARD-IMSERVER");
        message.setCommand(command);
        Content ct = new Content();
        ct.setData(data);
        ct.setMessage("OK");
        ct.setStatus(0);
        message.setContent(ct);
        return message;
    }

    public void sendChatMessage(ChannelHandlerContext ctx) throws Exception {
        for (;;){
            if(ctx.isRemoved()){

                logger.error("服务器断开了,关闭聊天任务");
                throw new Exception("ctx isRemoved");
            }
            int rand = new Random().nextInt(5000);
            MessageBean chatMsg = chat(rand);
            ctx.writeAndFlush(g.toJson(chatMsg) + "###");
            logger.debug("send chat packet " + g.toJson(chatMsg));
            Thread.sleep(rand);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
        String stringMessage = (String) o;
        imRepository.putReply();
        logger.debug("Server reply:"+o.toString());
        MessageBean reply = g.fromJson(stringMessage,MessageBean.class);
        if("shakeResult".equals(reply.getCommand())){
            System.out.println(imClientName + " shake Result reply : " + stringMessage);
        }
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        logger.debug("ImClientIntHandler.channelActive");
        ctx.writeAndFlush(g.toJson(login()) + "###");
        Thread.sleep(2000);
//        ctx.writeAndFlush(g.toJson(start()) + "###");
        final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    sendChatMessage(ctx);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    executor.shutdown();
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        logger.error(cause.getMessage(), cause);
        String key = ctx.channel().remoteAddress().toString();
        logger.info("IM client close :"+key);
        ctx.close();
    }
}

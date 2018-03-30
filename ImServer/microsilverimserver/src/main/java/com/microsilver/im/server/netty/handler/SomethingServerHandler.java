/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsilver.im.server.netty.handler;

import com.google.gson.Gson;
import com.microsilver.im.server.netty.ChannelRepository;
import com.microsilver.im.server.packet.Content;
import com.microsilver.im.server.packet.MessageBean;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * event handler to process receiving messages
 *
 * @author Jade
 */
@Component
@Qualifier("somethingServerHandler")
@ChannelHandler.Sharable
public class SomethingServerHandler extends ChannelInboundHandlerAdapter {

    @Autowired
    @Qualifier("channelRepository")
    private ChannelRepository channelRepository;

    private Integer onLine = 0;

    @Value("${base.result.time}")
    private Integer baseTime;
    @Value("${base.result.count}")
    private Integer baseCount;

    Gson g = new Gson();

    private static Logger logger = Logger.getLogger(SomethingServerHandler.class.getName());

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Assert.notNull(this.channelRepository, "[Assertion failed] - ChannelRepository is required; it must not be null");

        ctx.fireChannelActive();
        logger.debug(ctx.channel().remoteAddress());
        String channelKey = ctx.channel().remoteAddress().toString();
        channelRepository.put(channelKey, ctx.channel());
        logger.debug("Binded Channel Count is " + this.channelRepository.size());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String stringMessage = (String) msg;
        onLine = 0 ;
        String channelKey = ctx.channel().remoteAddress().toString();
//        logger.debug(channelKey +" => "+stringMessage);

        MessageBean receive = g.fromJson(stringMessage,MessageBean.class);
        //answer to client
        MessageBean reply  = receive.createCopy();

        Boolean flag = false;
        Boolean muc = false;
        switch (receive.getCommand()){
            case "login":
                reply.setCommand("loginResult");
                Content ct = new Content();
                ct.setStatus(0);
                ct.setData(channelKey);
                ct.setMessage("OK");
                reply.setContent(ct);
                flag = true;
                break;
            case "start":
                reply.setCommand("startResult");
                muc = true;
                break;
            case "shake":
                int count = this.channelRepository.messageCacheAdd(channelKey);
                break;
            case "grabOrder":
                reply.setCommand("grabOrderResult");
                flag = true;
                break;
            case "hearbeat":
                break;
            default :
        }
        if(flag) {
            reply.setFormId(receive.getToId());
            reply.setToId(receive.getFormId());
            ctx.writeAndFlush(g.toJson(reply) + "###");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error(cause.getMessage(), cause);
        clearCount(ctx);
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx){
        Assert.notNull(this.channelRepository, "[Assertion failed] - ChannelRepository is required; it must not be null");
        Assert.notNull(ctx);
        clearCount(ctx);
        logger.debug("Binded Channel Count is " + this.channelRepository.size());
    }

    public void setChannelRepository(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    private void clearCount(ChannelHandlerContext ctx){
        String channelKey = ctx.channel().remoteAddress().toString();
        this.channelRepository.remove(channelKey);
        this.channelRepository.clearMessageCache(channelKey);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            System.out.println(event.state());
            if (event.state() == IdleState.READER_IDLE) {
                String channelKey = ctx.channel().remoteAddress().toString();
                onLine++;
                if(onLine >= 6){
                    logger.error("已经60秒没收到客户端["+channelKey+"]消息了，用户被迫下线");
                    clearCount(ctx);
                    ctx.channel().close();
                    ctx.close();
                }
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}

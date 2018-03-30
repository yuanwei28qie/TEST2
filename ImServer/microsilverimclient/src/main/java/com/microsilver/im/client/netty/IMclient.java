package com.microsilver.im.client.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Name com.mrcard.netty.client.IMclient
 * @Description
 * @Author Jade
 * @Version 2017/9/26
 * @Copyright Micro Silver
 */
@Component
@Qualifier("imclient")
public class IMclient {
    private static final StringDecoder DECODER = new StringDecoder();
    private static final StringEncoder ENCODER = new StringEncoder();

    @Autowired
    @Qualifier("imSimpleHandler")
    ImSimpleHandler imSimpleHandler;


    public void connect(final String name, String host, int port,ImRepository imRepository) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        imSimpleHandler.setImClientName(name);
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    // Add the text line codec combination first,
//                    pipeline.addLast(new DelimiterBasedFrameDecoder(1024*1024, Delimiters.lineDelimiter()));
                    pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Unpooled.copiedBuffer("###".getBytes())));
                    // the encoder and decoder are static as these are sharable
                    pipeline.addLast(DECODER);
                    pipeline.addLast(ENCODER);
                    pipeline.addLast(imSimpleHandler);
//                    pipeline.addLast(new IdleStateHandler(2, 2, 0, TimeUnit.SECONDS));
                }
            });

            //Wait for client startup to complete.
            ChannelFuture f = b.connect(host, port).sync();
            //count onLine client
            if(f.isSuccess() && f.channel().isActive()){
                imRepository.put(name,this);
            }
            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            //Close EventLoopGroup to free all resources.
            workerGroup.shutdownGracefully().sync();
            System.out.println("close imClient is : " + name);
            imRepository.remove(name);
        }

    }

}

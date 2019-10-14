package cn.com.im.server;

import cn.com.im.decode.PacketDecode;
import cn.com.im.decode.PacketEncode;
import cn.com.im.handler.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-11
 * Time: 20:31
 */
public class IMServer {

    private static final int PORT = 8080;

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .attr(AttributeKey.newInstance("serverName"), "IMSERVER")
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                // 已完成三次握手的请求的队列的最大长度，如果连接建立频繁，服务器处理创建新连接较慢，可以适当调大这个参数
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        // ch.pipeline().addLast(new StringDecoder());
                        // ch.pipeline().addLast(new FirstServerHandler());
                        // ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                        //     @Override
                        //     protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
                        //         System.out.println(msg);
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(new PacketDecode());
                        ch.pipeline().addLast(new LoginRequestHandler());
                        ch.pipeline().addLast(new AuthChannelHandler());
                        ch.pipeline().addLast(new MessageRequestHandler());
                        ch.pipeline().addLast(new CaughtExceptionHandler());
                        ch.pipeline().addLast(new ExceptionHandler());
                        ch.pipeline().addLast(new PacketEncode());
                        // }
                        // });
                    }
                });

        bind(serverBootstrap, PORT);
    }

    /**
     * 绑定方法
     */
    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future ->  {
            if (future.isSuccess()) {
                System.out.println("端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
                bind(serverBootstrap, port + 1);
            }
        });
    }
}

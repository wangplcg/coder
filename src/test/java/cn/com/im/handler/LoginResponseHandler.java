package cn.com.im.handler;

import cn.com.im.common.Session;
import cn.com.im.entity.LoginResponsePacket;
import cn.com.im.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-11
 * Time: 22:55
 */
@ChannelHandler.Sharable
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) {
        System.out.println(new Date() + "接收到服务端登录结果信息 :" + msg.getMsg() + "用户ID [" + msg.getUserId() + "]");
        if (msg.isSuccess()) {
            SessionUtil.bindSession(ctx.channel(), new Session(msg.getUserId(), msg.getUserName()));
        }
    }
}
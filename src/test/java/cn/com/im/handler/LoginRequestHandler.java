package cn.com.im.handler;

import cn.com.im.common.Session;
import cn.com.im.entity.LoginRequestPacket;
import cn.com.im.entity.LoginResponsePacket;
import cn.com.im.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-11
 * Time: 22:55
 */

public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) {
        String username = msg.getUsername();
        String password = msg.getPassword();
        System.out.println(new Date() + "收到登录请求: 用户名 [" + username + "] 密码：["+  password + "]");

        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        if (validate(username, password)) {
            Session session = generateSession(msg);
            SessionUtil.bindSession(ctx.channel(), session);
            loginResponsePacket.setSuccess(true);
            loginResponsePacket.setUserId(session.getUserId());
            loginResponsePacket.setUserName(session.getUserName());
            loginResponsePacket.setMsg("[" + msg.getUsername() + "]登录成功");
            System.out.println("[" + msg.getUsername() + "]登录成功");
        } else {
            loginResponsePacket.setSuccess(false);
            loginResponsePacket.setMsg("登录失败");
        }
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private boolean validate(String username, String password) {
        return true;
    }

    private Session generateSession(LoginRequestPacket msg) {
        return new Session(UUID.randomUUID().toString().substring(0 ,5), msg.getUsername());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        SessionUtil.unBindSession(ctx.channel());
    }
}

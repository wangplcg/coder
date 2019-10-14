package cn.com.im.handler;

import cn.com.im.common.Session;
import cn.com.im.entity.MessageRequestPacket;
import cn.com.im.entity.MessageResponsePacket;
import cn.com.im.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-11
 * Time: 21:56
 */
@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {
        Session session = SessionUtil.getSession(ctx.channel());

        // 构造发送消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMessage(msg.getMessage());
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());

        // 获取目标channel
        Channel toUserChannel = SessionUtil.getChannel(msg.getToUserId());
        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageResponsePacket);
        } else {
            System.out.println(" 用户 [" + msg.getToUserId() + "] 不在线, 请稍后再试");
        }
    }
}
package cn.com.im.handler;

import cn.com.im.entity.CreateGroupRequestPacket;
import cn.com.im.entity.CreateGroupResponsePacket;
import cn.com.im.util.IDUtil;
import cn.com.im.util.SessionUtil;
import com.google.common.collect.Lists;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.DefaultChannelGroup;

import java.util.List;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-13
 * Time: 19:04
 */

public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket msg) {
        // 获取组成员Id
        List<String> userIds = msg.getUserIds();
        List<String> names = Lists.newArrayList();
        // 创建组对象
        DefaultChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());
        for (String userId : userIds) {
            Channel channel = SessionUtil.getChannel(userId);
            if (channel != null) {
                channelGroup.add(channel);
                names.add(SessionUtil.getSession(SessionUtil.getChannel(userId)).getUserName());
            }
        }
        CreateGroupResponsePacket responsePacket = new CreateGroupResponsePacket();
        if (names.isEmpty()) {
            responsePacket.setSuccess(false);
            responsePacket.setMsg("当前无群聊成员在线，创建群组失败");
        } else {
            String id = IDUtil.generateId();
            responsePacket.setGroupId(id);
            responsePacket.setUserNames(names);
            responsePacket.setSuccess(true);
            responsePacket.setCreateUserId(msg.getCreateUserId());
            if (!SessionUtil.addGroup(id, channelGroup)) {
                responsePacket.setSuccess(false);
                responsePacket.setMsg("创建群聊失败, 已存在此群ID, 请重新创建群");
            }
        }
        ctx.writeAndFlush(responsePacket);
    }
}
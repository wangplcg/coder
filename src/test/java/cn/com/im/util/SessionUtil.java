package cn.com.im.util;

import cn.com.im.common.Attributes;
import cn.com.im.common.Session;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.util.Attribute;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-12
 * Time: 21:40
 */

public class SessionUtil {

    private static Map<String, Channel> loginMap = new ConcurrentHashMap<>();

    private static Map<String, ChannelGroup> groupIdChannelGroupMap = new ConcurrentHashMap<>();

    public static void bindSession(Channel channel, Session session) {
        channel.attr(Attributes.SESSION).set(session);
        loginMap.put(session.getUserId(), channel);
    }

    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            loginMap.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }

    }

    public static Session getSession(Channel channel) {
            return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId) {
        return loginMap.get(userId);
    }

    public static boolean hasLogin(Channel channel) {
        return channel.hasAttr(Attributes.SESSION);
    }

    public static boolean addGroup(String groupId, ChannelGroup channel) {
        return groupIdChannelGroupMap.putIfAbsent(groupId, channel) != null;
    }

    public static ChannelGroup getGroup(String groupId) {
        return groupIdChannelGroupMap.get(groupId);
    }
}
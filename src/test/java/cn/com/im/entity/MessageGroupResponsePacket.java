package cn.com.im.entity;

import cn.com.im.common.CommandEnum;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-13
 * Time: 18:59
 */

public class MessageGroupResponsePacket extends Packet {
    /**
     * 指令
     */
    @Override
    public Byte getCommand() {
        return CommandEnum.MESSAGE_GROUP_RESPONSE.getCommandId();
    }
}

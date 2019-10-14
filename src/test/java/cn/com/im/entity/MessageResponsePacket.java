package cn.com.im.entity;

import cn.com.im.common.CommandEnum;
import lombok.Data;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-12
 * Time: 16:04
 */
@Data
public class MessageResponsePacket extends Packet {

    private String fromUserId;

    private String fromUserName;

    private String message;
    /**
     * 指令
     */
    @Override
    public Byte getCommand() {
        return CommandEnum.MESSAGE_RESPONSE.getCommandId();
    }
}

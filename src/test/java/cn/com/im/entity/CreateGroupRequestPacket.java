package cn.com.im.entity;

import cn.com.im.common.CommandEnum;
import lombok.Data;

import java.util.List;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-13
 * Time: 18:59
 */
@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIds;

    private String createUserId;

    /**
     * 指令
     */
    @Override
    public Byte getCommand() {
        return CommandEnum.CREATE_GROUP_REQUEST.getCommandId();
    }
}

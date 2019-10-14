package cn.com.im.entity;

import cn.com.im.common.CommandEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-13
 * Time: 18:59
 */
@Data
@NoArgsConstructor
public class CreateGroupResponsePacket extends Packet {

    private String groupId;
    private String createUserId;
    private List<String> userNames;
    private boolean success;
    private String  msg;
    /**
     * 指令
     */
    @Override
    public Byte getCommand() {
        return CommandEnum.CREATE_GROUP_RESPONSE.getCommandId();
    }
}

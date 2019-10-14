package cn.com.im.entity;
import cn.com.im.common.CommandEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-12
 * Time: 16:04
 */
@Data
@AllArgsConstructor
public class MessageRequestPacket extends Packet {

    private String toUserId;

    private String message;

    /**
     * 指令
     */
    @Override
    public Byte getCommand() {
        return CommandEnum.MESSAGE_REQUEST.getCommandId();
    }
}

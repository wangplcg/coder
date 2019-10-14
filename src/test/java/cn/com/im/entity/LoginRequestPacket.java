package cn.com.im.entity;

import cn.com.im.common.CommandEnum;
import lombok.Data;

@Data
public class LoginRequestPacket extends Packet {

    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return CommandEnum.LOGIN_REQUEST.getCommandId();
    }
}
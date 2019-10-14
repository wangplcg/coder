package cn.com.im.entity;

import cn.com.im.common.CommandEnum;
import lombok.Data;

@Data
public class LoginResponsePacket extends Packet {

    private boolean success;

    private String userId;
    private String userName;


    private String msg;

    @Override
    public Byte getCommand() {
        return CommandEnum.LOGIN_RESPONSE.getCommandId();
    }
}
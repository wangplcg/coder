package cn.com.im.entity;

import cn.com.im.common.CommandEnum;
import lombok.Data;

@Data
public class ExceptionPacket extends Packet {

    private int type;

    private String msg;

    private int msgCode;

    @Override
    public Byte getCommand() {
        return CommandEnum.EXCEPTION.getCommandId();
    }
}
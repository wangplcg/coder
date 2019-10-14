package cn.com.im.common;

import cn.com.im.entity.*;

public enum CommandEnum {

    EXCEPTION((byte)0, ExceptionPacket.class),

    LOGIN_REQUEST((byte)1, LoginRequestPacket.class),

    LOGIN_RESPONSE((byte)2, LoginResponsePacket.class),

    MESSAGE_REQUEST((byte)3, MessageRequestPacket.class),

    MESSAGE_RESPONSE((byte)4, MessageResponsePacket.class),

    CREATE_GROUP_REQUEST((byte)5, MessageResponsePacket.class),

    CREATE_GROUP_RESPONSE((byte)6, MessageResponsePacket.class),

    JOIN_GROUP_REQUEST((byte)7, MessageResponsePacket.class),

    JOIN_GROUP_RESPONSE((byte)8, MessageResponsePacket.class),

    EXIST_GROUP_REQUEST((byte)9, MessageResponsePacket.class),

    EXIST_GROUP_RESPONSE((byte)10, MessageResponsePacket.class),

    MESSAGE_GROUP_REQUEST((byte)11, MessageResponsePacket.class),

    MESSAGE_GROUP_RESPONSE((byte)12, MessageResponsePacket.class);

    private byte commandId;

    private Class<? extends Packet> clazz;

    CommandEnum(byte commandId, Class<? extends Packet> clazz) {
        this.commandId = commandId;
        this.clazz = clazz;
    }

    public byte getCommandId() {
        return commandId;
    }

    public Class<? extends Packet> getClazz() {
        return clazz;
    }

    public static CommandEnum getByCommandId(byte id) {
        CommandEnum[] values = CommandEnum.values();
        for (CommandEnum value : values) {
            if (value.commandId == id) {
                return value;
            }
        }
        return null;
    }

}
package cn.com.im.protocol;

import cn.com.im.common.CommandEnum;
import cn.com.im.entity.Packet;
import cn.com.im.execption.IMSysException;
import io.netty.buffer.ByteBuf;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-11
 * Time: 22:25
 */

public class ProtocolParserUtil {

    private static final int MAGIC_NUMBER = 0x12345678;

    public static void encode(ByteBuf byteBuf, Packet packet) {
        // 1. 创建 ByteBuf 对象
        // 2. 序列化 Java 对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        // 3. 实际编码过程
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }

    public static Packet decode(ByteBuf byteBuf) {
        // 跳过 magic number
        byteBuf.skipBytes(4);
        // 跳过版本号
        byteBuf.skipBytes(1);
        // 序列化算法标识
        byte serializeAlgorithm = byteBuf.readByte();
        // 指令
        byte command = byteBuf.readByte();
        Class<? extends Packet> aClass = getPacket(command);
        // 数据包长度
        int length = byteBuf.readInt();
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        Serializer serializer = getSerializer(serializeAlgorithm);
        if (aClass != null && serializer != null) {
            return serializer.deserialize(aClass, bytes);
        }
        return null;
    }

    private static Serializer getSerializer(byte command) {
        try {
            SerializerEnum serializerEnum = SerializerEnum.getById((int) command);
            Class serializerType = serializerEnum.getSerializerType();
            if (serializerType != null) {
                return (Serializer)serializerType.newInstance();
            }
            throw new IMSysException("未获取到有效的请求指令", 9999);
        } catch (Exception e) {
            throw new IMSysException("解析报文出现错误", 9999);
        }
    }

    private static Class<? extends Packet> getPacket(byte command) {
        try {
            CommandEnum commandEnum = CommandEnum.getByCommandId(command);
            Class clazz = commandEnum.getClazz();
            if (clazz != null) {
                return clazz;
            }
            throw new IMSysException("未获取到有效的请求指令", 9999);
        } catch (Exception e) {
            throw new IMSysException("解析报文出现错误", 9999);
        }
    }
}
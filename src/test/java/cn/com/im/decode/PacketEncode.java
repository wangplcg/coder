package cn.com.im.decode;

import cn.com.im.entity.Packet;
import cn.com.im.protocol.ProtocolParserUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-12
 * Time: 16:41
 */

public class PacketEncode extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) throws Exception {
        ProtocolParserUtil.encode(out, msg);
    }
}
package cn.com.im.decode;

import cn.com.im.protocol.ProtocolParserUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-12
 * Time: 16:41
 */

public class PacketDecode extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(ProtocolParserUtil.decode(in));
    }
}
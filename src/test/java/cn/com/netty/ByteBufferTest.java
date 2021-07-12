package cn.com.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;

/**
 * @Classname ByteBufferTest
 * @Description TODO
 * @Date 2021/7/9 14:42
 * @Created by think
 */
public class ByteBufferTest {

    public void test() {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();

        CompositeByteBuf byteBufs = ByteBufAllocator.DEFAULT.compositeBuffer();

    }

}

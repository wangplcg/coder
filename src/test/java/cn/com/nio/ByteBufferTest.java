package cn.com.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @Classname ByteBufferTest
 * @Description TODO
 * @Date 2021/4/24 15:11
 * @Created by think
 */
public class ByteBufferTest {

    @Test
    public void test() {
        // 堆内存 利用byte[] 实现
        ByteBuffer allocate = ByteBuffer.allocate(10);
        // 堆外内存 内部借用 unsafe 工具类实现，封装 unsfae
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);

        // position
        // limit
        // capacity
        // filp 方法 将 position设置为 0
        // address + position
        // 处理int 处理4字节处理
        // 使用 PathomReference 使用 gc 回收堆外内存   ByteBuffer

        


    }
}
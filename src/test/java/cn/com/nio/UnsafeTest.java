package cn.com.nio;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Classname UnsafeTest
 * @Description TODO
 * @Date 2021/4/24 14:54
 * @Created by think
 */
public class UnsafeTest {

    @Test
    public void unsafeTest() {
        Unsafe unsafe = getUnsafe();
        // 分配10 字节内存  返回为内存基础地址, 对外内存
        long address = unsafe.allocateMemory(10);

        unsafe.setMemory(address, 10, (byte)0);

        unsafe.putByte(address,  (byte)1);
        unsafe.putByte(address + 1,  (byte)2);
        unsafe.putByte(address + 2,  (byte)3);


        System.out.println(unsafe.getByte(address));
        System.out.println(unsafe.getByte(address + 1));
        System.out.println(unsafe.getByte(address + 2));
        unsafe.freeMemory(address);
    }


    public Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe)field.get(null);
        } catch (Exception e) {
            return null;
        }
    }
}

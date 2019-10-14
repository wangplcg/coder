package cn.com.algorithm.bitmap;

import org.junit.Test;

import java.util.BitSet;

/**
 * Description:
 * User: wangpl
 * Date: 2019-07-21
 * Time: 22:44
 */

public class BloomFilterTest {

    @Test
    public void testBloomFilter() {
        // 布隆过滤器  底层由位图实现 对同一个数据运用多个hash函数求得hash值 1 ... k
        // 利用 多个hash值来确定值是否 为 true
    }

    @Test
    public void testBitSet() {
        BitSet bitSet = new BitSet();
        bitSet.set(0, 50);
        System.out.println("80:" + bitSet.get(50) + "50:" + bitSet.get(49));
    }
}

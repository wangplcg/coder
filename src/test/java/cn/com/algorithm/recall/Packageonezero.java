package cn.com.algorithm.recall;

import org.junit.Test;

/**
 * Description:
 * User: wangpl
 * Date: 2019-07-14
 * Time: 12:47
 */

public class Packageonezero {

    public int maxW = Integer.MIN_VALUE;

    /**
     * i 表示当前扫描到第几个
     * cw 当前物品的总质量
     * items 每个物品的总质量
     * w 背包重量
     * n 物品个数
     *
     */
    public void f (int i, int cw, int[] items, int w, int n) {
        if (i == n || cw == w) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        f (i + 1, cw, items, w, n);
        if (cw + items[i] <= w) {
            f (i + 1, cw + items[i], items, w, n);
        }
    }

    /**
     * 0 1 背包问题
     */
    @Test
    public void testPack() {
        int[] items = {11,23,21,1,3,4,5,7,3,99,97,5};
        f(0, 0, items, 200, items.length);
        System.out.println(maxW);
    }


}

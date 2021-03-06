package cn.com.algorithm.sort;

import org.junit.Test;

/**
 * Description: 最大子串
 * 思想： 首先初始化一相同大小数组 数组初始化为 1， 记录每个子数组的最大子串长度
 *        从 index 1 开始，每次从 0 匹配小于 index 值的个数， 同时与当前为 最大长度比较， 如果 +1 > 当前最大长度  则更新
 * User: wangpl
 * Date: 2019-07-17
 * Time: 22:13
 */

public class MaxSubSeq {

    public int maxSub(int[] a, int j) {
        int[] lis = new int[j];
        for (int i = 0; i < j; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < j; i++) {
            for (int k = 0; k < i; k++) {
                if (a[i] > a[k] && lis[k] + 1 > lis[i]) {
                    lis[i] = lis[k] + 1;
                }
            }
        }

        int max = lis[0];
        for (int i = 1; i < lis.length; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }
        return max;
    }

    @Test
    public void testMaxSubSeq() {
        int[] arr = {12,21,1,23,4,3,12,32,1,4,12};
        int i = maxSub(arr, arr.length);
        System.out.println(i);
    }
}
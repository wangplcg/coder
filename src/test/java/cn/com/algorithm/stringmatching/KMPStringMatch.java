package cn.com.algorithm.stringmatching;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:
 * User: wangpl
 * Date: 2019-07-13
 * Time: 20:30
 */

public class KMPStringMatch {

    /**
     * @param a 待查找字符串
     * @param n 待查找字符串大小
     * @param b 模式串
     * @param m 模式串长度
     */
    public int kmp(char[] a, int n, char[] b, int m) {
        int[] next = new int[m];
        getNexts(b, m, next);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while(j > 0 && a[i] != b[j]) {
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * 求模式串最长匹配前缀长度
     *
     * if (b[k + 1] == b[i]) next[i] = next[k] + 1
     * next 数组求解策略， 根据 如果 b[k + 1] = b[i] 则 next[i] = k + 1;
     * @param b 模式串
     * @param m 模式串长度
     * @param next next数组 下标为：模式串前缀好前缀候选，前缀结尾下标
     *             值为： 最长可匹配前缀字符结尾字符下标
     */
    public void getNexts(char[] b, int m, int[] next) {
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
    }

    @Test
    public void testKMP() {
        String a = "asdewqewqsadsadacweqwewqfssssawwangpeilinsadadxxx";
        String b = "xxx";
        int bm = kmp(a.toCharArray(), a.length(), b.toCharArray(), b.length());
        System.out.println(bm);
    }

    @Test
    public void testNexts() {
        String b = "xxx";
        int[] next = new int[b.length()];
        getNexts(b.toCharArray(), b.length(), next);
        System.out.println(Arrays.toString(next));
    }



}

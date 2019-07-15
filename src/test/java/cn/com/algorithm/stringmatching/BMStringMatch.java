package cn.com.algorithm.stringmatching;

import oracle.sql.CHAR;
import org.junit.Test;

/**
 * Description:
 * User: wangpl
 * Date: 2019-07-12
 * Time: 22:46
 */

public class BMStringMatch {

    private static final int CHAR_SIZE = 256;

    /**
     * 实现BM算法 坏字符规则,
     * @param bc 记录字符出现在模式串的具体位置数组
     * @param b 模式串数组
     * @param m 模式串大小
     */
    public void generatorBc(char[] b, int m, int[] bc) {
        for (int i = 0; i < CHAR_SIZE; i ++ ) {
            bc[i] = -1;
        }
        // 遍历模式串 填充bc 数组 定位模式串每个字符位置
        for (int j = 0; j < m; j++) {
            int ascii = b[j];
            bc[ascii] = j;
        }
    }

    /**
     * 后缀匹配算法
     */
    public void generatorGs(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        for (int i = 0; i < m - 1; i++) { // b[0,i]
            int j = i;
            int k = 0;

            while (j >= 0 && b[m - 1 - k] == b[j]) {
                k++;
                j--;
                suffix[k] = j + 1;
            }

            if (j < 0) prefix[k] = true;

        }
    }


    /**
     *
     * @param a 字符串
     * @param n 字符串长度
     * @param b 模式串
     * @param m 模式串长度
     */
    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[CHAR_SIZE];
        // 最坏规则, 生成散列表 定位出现字符位置
        generatorBc(b, m, bc);

        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        // 最优后缀
        generatorGs(b, m, suffix, prefix);

        int i = 0;
        while (i <= n - m) { // < ? <=
            int j;
            for (j = m - 1; j >= 0; --j) {
                if (b[j] != a[i + j]) break;
            }
            if (j < 0) {
                return i;
            }
            int x = j - (bc[a[i + j]]);
            int y = 0;
            if (j < m -1) {
                y = moveByGs(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    /**
     * @param j 表示坏字符在模式串中的位置
     * @param m 表示模式串长度
     */
    private int moveByGs(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j;
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }

        for (int r = j + 2; r <= m -1; ++r) {
            if (prefix[m - r]) {
                return r;
            }
        }
        return m;
    }


    @Test
    public void testBm() {
        String a = "asdewqewqsadsadacweqwewqfssssawwangpeilinsadadxxx";
        String b = "xxx";
        int bm = bm(a.toCharArray(), a.length(), b.toCharArray(), b.length());
        System.out.println(bm);
    }
    
}

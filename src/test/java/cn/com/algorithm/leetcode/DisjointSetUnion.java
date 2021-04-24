package cn.com.algorithm.leetcode;

import java.util.Arrays;

/**
 * Description: 并查集算法，处理并查集逻辑
 *              包含 查找， 以及短路径优化，将长路径 优化为短路径
 * User: wangpl
 * Date: 2020-07-14
 * Time: 20:51
 */
public class DisjointSetUnion {

    private int[] pre = new int[20];
    {
        Arrays.fill(pre, 5);
    }

    public int search(int i) {
        int root = i;
        while (root != pre[root]) {
            root = pre[root];
        }

        // 并查集路径压缩
        int son = i;
        while (son != root) {
            int tmp = pre[son];
            pre[son] = root;
            son = tmp;
        }
        return root;
    }


}

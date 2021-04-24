package cn.com.algorithm.leetcode.middle;

/**
 * Description:  给个n序列 1......n  计算能生成二叉搜索树的个数
 * User: wangpl
 * Date: 2020-07-15
 * Time: 0:53
 */

public class numTrees96 {

    /**
     * 使用动态规划进行题解：
     * 递归方程 = dp[i] = sum(dp[i - j] * dp[j])   j 为 0 ..... i
     * 分析过程：
     *   求解二×搜索树 个数问题
     *
     * @param n
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }




}
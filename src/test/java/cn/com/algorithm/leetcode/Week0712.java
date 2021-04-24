package cn.com.algorithm.leetcode;

/**
 * Description:
 * User: wangpl
 * Date: 2020-07-12
 * Time: 11:33
 */

public class Week0712 {

    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
    //
    // 返回所有字符都为 1 的子字符串的数目。
    //
    // 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
    public int numSub(String s) {
        int mod = 1000000007;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '1') {
                continue;
            }
            for (int j = i; j < s.length(); j++) {
                if ('1' == s.charAt(j)) {
                    ans++;
                    if (ans > mod) {
                        ans -= mod;
                    }
                } else {
                    break;
                }
            }
        }
        return ans ;
    }

    // 寻找 1 的最长子序列
    public int numSub2(String s) {
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) == '1') {
               ans++;
           } else {
                sum += sum(ans);
                ans = 0;
           }
        }
        sum += sum(ans);
        return sum;
    }

    private int sum(int i) {
        int ssum = 0;
        int mod = 1000000007;
        for (int j = 1; j <= i; j++) {
            ssum += j;
            if (ssum > mod) {
                ssum -= mod;
            }
        }
        return ssum;
    }
    //
    // 5211. 概率最大的路径 显示英文描述
    // 给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
    // 指定两个节点分别作为起点 star 路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
    public boolean winnerSquareGame(int n) {
        return false;
    }
}

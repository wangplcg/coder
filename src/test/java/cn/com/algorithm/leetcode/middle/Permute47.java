package cn.com.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 * User: wangpl
 * Date: 2020-07-16
 * Time: 21:57
 */

public class Permute47 {

    /**
     * 47. 全排列 II
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * 示例:
     * 输入: [1,1,2]
     * 重复数字的序列 ？？？  需要判断序列重复
     *
     *
     * 输出:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0, new boolean[nums.length], new Stack<>());
        return res;
    }

    public void dfs(int[] nums, int depth, boolean[] used, Stack<Integer> stack) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            stack.add(nums[j]);
            dfs(nums, depth + 1, used, stack);
            stack.pop();
        }
    }
}
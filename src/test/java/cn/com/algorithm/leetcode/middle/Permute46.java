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

public class Permute46 {

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
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
            if (!used[j]) {
                used[j] = true;
                stack.add(nums[j]);
                dfs(nums, depth + 1, used, stack);
                used[j] = false;
                stack.pop();
            }
        }
    }
}
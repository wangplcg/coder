package cn.com.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 极客时间期中评测
 * User: wangpl
 * Date: 2020-07-26
 * Time: 10:57
 */

public class MiddleTest {
    // nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) {
            return ans;
        }
        // 返回四元组 拆解为三元组 求和问题
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> lists = threeSum(nums, i, target - nums[i]);
            if (!lists.isEmpty()) {
                ans.addAll(lists);
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = start + 1; i < nums.length - 2; i++) {
            if (i > start + 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int total = nums[left] + nums[right];
                if (total == sum) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[start]);
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    ans.add(res);
                    while (right > 0 && nums[right] == nums[--right]);
                    while (left < nums.length - 1 && nums[left] == nums[++left]);
                }
                if (total > sum) {
                    while (right > 0 && nums[right] == nums[--right]);
                }
                if (total < sum) {
                    while (left < nums.length - 1 && nums[left] == nums[++left]);
                }
            }
        }
        return ans;
    }

    @Test
    public void testJump() {
        int jump = jump(new int[]{2, 3, 1, 1, 4});
    }

    /**
     * 最少跳跃次数
     * @param nums 步数
     * @return
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        int minPos = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < i; k++) {
                if (k + nums[k] >= i) {
                    min = Math.min(dp[k] + 1, min);
                }
            }
            dp[i] = min;
        }
        return dp[nums.length - 1];
    }
}

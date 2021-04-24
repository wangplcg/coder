package cn.com.algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description:
 * User: wangpl
 * Date: 2020-07-11
 * Time: 22:32
 */

public class Week0711 {
    public String reformatDate(String date) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        String[] dateArray = date.split(" ");
        String day = dateArray[0];
        String month = dateArray[1];
        int i = 0;
        for (String smonth : months) {
            if (Objects.equals(smonth, month)) {
                break;
            }
            i++;
        }
        String year = dateArray[2];
        String pday = day.substring(day.length() - 2, day.length());
        if (Integer.parseInt(pday) < 10) {
            pday = "0" + pday;
        }
        return year + "-" + (i < 10 ? "0" + i : i) + pday;
    }

    /**
     * 子数组和排序后的区间和 显示英文描述
     * 给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数字的数组。
     * 请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
     * 计算非空连续子数组
     */
    public static void main(String[] args) {
        // [1,2,3,4]
        // 4
        // 1
        // 5
        rangeSum(new int[]{9,3,2,2,6,9,6,6}, 8, 4, 8);
    }

    // [9,3,2,2,6,9,6,6]
    //         8
    //         4
    //         8

    public static int rangeSum(int[] nums, int n, int left, int right) {
        // 非空连续子数组
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        List<Integer> list1 = list.subList(left - 1, right);
        return list1.stream().mapToInt(x -> x).sum();
    }

    // 输入：
    //         [7,5,8,5,6,4,3,3]
    //         8
    //         2
    //         6
    // 输出：
    //         19
    // 预期：
    //         23
    // 标准输出：
    //         [3, 3, 4, 4, 5]

    /**
     * 5446. 三次操作后最大值与最小值的最小差 显示英文描述
     * 题目难度Medium
     * 给你一个数组 nums ，每次操作你可以选择 nums 中的任意一个数字并将它改成任意值。
     * 请你返回三次操作后， nums 中最大值与最小值的差的最小值。
     */
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        if (nums.length < 4) {
            return 0;
        }
        return Math.min(Math.min(Math.min(nums[n] - nums[3], nums[n - 1] - nums[2]), nums[n - 2] - nums[1]), nums[n - 3] - nums[0]);
    }

    /**
     * 石子游戏
     * @param n
     * @return
     */
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j > 0; j++) {
                dp[i] = dp[i - j * j];
                if (dp[i]) break;
            }
        }
        return dp[n];
    }

}
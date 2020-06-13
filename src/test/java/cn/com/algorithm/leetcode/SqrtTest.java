package cn.com.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Description:
 * User: wangpl
 * Date: 2020-06-10
 * Time: 18:31
 */

public class SqrtTest {
    @Test
    public void testSqurt() {
        // Xn-1 =  Xn - f(xn)/f(xn)'
        // f(xn) = x ^ 2;
        // Xn = Xn-1 + f(xn)/f(xn)'
        // Xn = Xn-1 + Xn/2
        String a = "a" + "b";
        String b = "ab";
        String c = new String("ab").intern();
        System.out.println(a == b);
        System.out.println(c == b);
    }



    public List<List<Integer>> threeSum(int[] nums) {
        // 排序 插入排序， 规模小采用计数排序
        Arrays.sort(nums);

        List<List<Integer>> rtnList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

            }
        }
        return rtnList;
    }

    /**
     * 计算日期为一年中的第几天
     * @param date
     * @return
     */
    public int dayOfYear(String date) {
        int[] dayIndex = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dateArr = date.split("-");
        int year = Integer.parseInt(dateArr[0]);
        boolean leap = false;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            leap = true;
        }
        int month = Integer.parseInt(dateArr[1]) - 1;
        int day = Integer.parseInt(dateArr[2]);

        int days = 0;
        while(month > 0) {
            days += dayIndex[month];
            if (month == 2 && leap) {
                days += 1;
            }
            month--;
        }
        days += day;
        return days;
    }

    /**
     * 给定数组 返回三角形最大长度
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i > 0; i--) {
            int len = A[i];
            for (int j = i - 1; j > 0; j = j - 2) {
                if (A[j] + A[j - 1] > len) {
                    return len + A[j] + A[j - 1];
                }
            }
        }
        return 0;
    }

    /**
     * 两个单词之间最近距离，利用哨兵结点处理
     * @param word1
     * @param word2
     */
    public int minDistance(String word1, String word2) {
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        int n = a.length;
        int m = b.length;
        int[][] min = new int[n][m];
        // 行初试化
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j<=m; j++) {
                if (i == 0 || j == 0) {
                    min[i][j] = i + j;
                    continue;
                }
                if (a[i] == b[j]) {
                    min[i][j] = min[i - 1][j - 1];
                } else {
                    min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + 1;
                }
            }
        }
        return min[n][m];
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // 暴力破解
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }

        // 一遍hash
        // 可以考虑 使用一遍hash  存储之前位置的数据即可
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int i2 = target - nums[i];
            if (map.containsKey(i2)) {
                Integer j = map.get(i2);
                return new int[]{i, j};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * 可以考虑递归实现   同时需要注意 特殊条件处理
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        add(l1, l2, 0);
        return l1;
    }

    public static void add(ListNode l1, ListNode l2, int carry) {
        int count = l1.val + l2.val + carry;
        l1.val = count % 10;
        carry = count / 10;
        if (l1.next == null && l2.next == null && carry == 0) {
            return;
        }
        if (l2.next == null) {
            l2.next = new ListNode(0);
        }
        if (l1.next == null) {
            l1.next = new ListNode(0);
        }
        add(l1.next, l2.next, carry);
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public int lengthOfLongestSubstring(String s) {
        // 最长子串 求 不含重复 子串长度
        char[] chars = s.toCharArray();
        while () {

        }
    }
}
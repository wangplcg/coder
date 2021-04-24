package cn.com.algorithm.leetcode;

import com.google.common.base.Enums;

import java.util.*;

/**
 * Description:
 * User: wangpl
 * Date: 2020-06-14
 * Time: 18:09
 */

public class SimpleTest {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 需要考虑溢出情况
     * 判断整型超出
     * 1、可以将原数  * 10 / 10 然后再判断是否与原数据相等
     * 2.
     * @param x
     * @return
     * 123
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if ((result * 10) / 10 != result) {
                return 0;
            }
            int digit = x % 10;
            result = result * 10 + digit;
            x = x / 10;
        }
        return result;
    }

    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }
    public String commonPrefix(String prefix, String str2) {
        int length = Math.min(prefix.length(), str2.length());
        int index = 0;
        while (index < length && prefix.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str2.substring(0, index);
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 示例 1:
     * 输入: 121
     * 输出: true
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x / 10 == 0 && x > 10)) {
            return false;
        }
        int i = x;
        int ans = 0;
        while (i != 0) {
            ans = ans * 10 + (i % 10);
            i = i / 10;
        }
        return ans == x;
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * 示例 1:
     *      输入: "A man, a plan, a canal: Panama"
     *      输出: true
     * @return
     */
    public boolean isPalindrome(String s) {
        int i = 0;
        int length = s.length() - 1;
        int j = s.length() - 1;
        while(i < j) {
            while (i < length && !('0' <= s.charAt(i) && s.charAt(i) <= '9')
                    && !('a' <= s.charAt(i) && s.charAt(i) <= 'z')
                    && !('A' <= s.charAt(i) && s.charAt(i) <= 'Z')) {
                i++;
            }
            while (j > 0 && !('0' <= s.charAt(j) && s.charAt(j) <= '9')
                    && !('a' <= s.charAt(j) && s.charAt(j) <= 'z')
                    && !('A' <= s.charAt(j) && s.charAt(j) <= 'Z')) {
                j--;
            }
            int abs = Math.abs(s.charAt(i) - s.charAt(j));
            if ((i < j && abs != 0 && abs != 32) || ((s.charAt(i) < 'A' || s.charAt(j) < 'A') && abs == 32))  {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 给你两个整数，n 和 start 。
     * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
     * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
     */
    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans =  ans ^ (start + 2 * i);
        }
        return ans;
    }

    /**
     *
     给你两个二进制字符串，返回它们的和（用二进制表示）。

     输入为 非空 字符串且只包含数字 1 和 0。
     示例 1:
     输入: a = "11", b = "1"
     输出: "100"
     */
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int ai = i > -1 ? a.charAt(i) - '0' : 0;
            int bj = j > -1 ? b.charAt(j) - '0' : 0;
            ans.append((ai + bj + carry) % 2);
            carry = ai + bj + carry > 1 ? 1 : 0;
        }
        if (carry > 0) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 示例 1:
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 示例 1:
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:          1 2 3 4 5 6 7
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * 解决方案 1: 暴力法 数组位移
     * 解决方案 2： 数组copy， 按照index起始，依次输出元素到指定数组
     * 解决方案 3： 翻转三次， 首先将整个nums 翻转，然后根据位移k，得到分界点，然后再继续翻转得到结果
     */
    public void rotate(int[] nums, int k) {
        // 先将 整个数组进行翻转
        int i = 0;
        int j = nums.length - 1;
        int temp;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

        // 利用k 将数据分为两部分 进行翻转
        int i1 = 0;
        int j1 = k % nums.length - 1;
        while (i1 < j1) {
            temp = nums[i1];
            nums[i1] = nums[j1];
            nums[j1] = temp;
            i1++;
            j1--;
        }

        int i2 = k % nums.length;
        int j2 = nums.length - 1;
        while (i2 < j2) {
            temp = nums[i2];
            nums[i2] = nums[j2];
            nums[j2] = temp;
            i2++;
            j2--;
        }
    }


    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 示例 1:
     *      输入: s = "anagram", t = "nagaram"
     *      输出: true
     */
    public boolean isAnagram(String s, String t) {
        int[] ints = new int[128];
        Arrays.fill(ints, 0);
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            ints[t.charAt(i)]--;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     * @return
     * 1. 暴力法   排序
     * 2. 计数
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String caculator = caculator(strs[i]);
            if (!map.containsKey(caculator)) {
                map.put(caculator, new ArrayList<String>());
            }
            map.get(caculator).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    // 计数
    public String caculator(String s) {
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
        }
        return Arrays.toString(ints);
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        return sunNum(root, 0, sum);
    }

    public boolean sunNum(TreeNode root, int total, int sum) {
        if (root == null) {
            return false;
        }
        int val = root.val + total;
        if (root.left == null && root.right == null) {
            return val == sum;
        }
        return sunNum(root.left, val, sum) || sunNum(root.right, val, sum);
    }

    /**
     *给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    public int[] twoSum(int[] nums, int target) {
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
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     */
    public int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = ((right - left) >> 1) + left;
            if (nums[middle] >= target) {
                ans = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return ans;
    }

    /**
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
     * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     * 注意，一开始你手头没有任何零钱。
     * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     *  5  10  20
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }
            if (bill == 10) {
                if (--five < 0) {
                    return false;
                }
                ten++;
            }
            if (bill == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    // 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    // 输入一个递增排序的数组的一个旋转，
    // 输出旋转数组的最小元素。例如，数组 [2,3,4,5,1] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
    // 示例 1：
    // 输入：[3,4,5,1,2]
    // 输出：1
    // 判断数组为某一数组的旋转 只需要判断第一个反序的数字即可
    //  二分查找算法
    // public int minArray(int[] numbers) {
    //     // for (int i = 1; i < numbers.length; i++) {
    //     //     if (numbers[i - 1] > numbers[i]) {
    //     //         return numbers[i];
    //     //     }
    //     // }
    //     // return numbers[0];
    //
    //
    // }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        while (i < s.length()) {
            int currentIndex = t.indexOf(s.charAt(i));
            if (currentIndex == -1) {
                return false;
            }
            t = t.substring(currentIndex + 1);
            i++;
        }
        return true;
    }
}
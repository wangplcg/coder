package cn.com.algorithm.leetcode;

import cn.com.algorithm.leetcode.common.TreeNode;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description:
 * User: wangpl
 * Date: 2020-06-10
 * Time: 18:31
 */

public class Middle {
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
     *
     * pwwkew
     */
    @Test
    public void test() {
        lengthOfLongestSubstring("abba");
    }

    public int lengthOfLongestSubstring(String s) {
        // 最长子串 求 不含重复 子串长度
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int validate = 0;
        if (arr.length == 1) {
            return 1;
        }
        // abba
        while (j < arr.length - 1) {
            int c = j;
            j++;
            map.put(arr[c], c);
            Integer index = map.get(arr[j]);
            if (index != null) {
                if (index >= validate) {
                    validate = index;
                    i = index + 1;
                }
                map.remove(arr[j]);
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }

    /**
     * 最长回文子串 动态规划
     * 动态规划法  ~~~
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 输入: "babad"   abcdba     abdcba
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     */
    public String longestPalindrome(String s) {
        // 最长回文子串
        int length = s.length();
        boolean arr[][] = new boolean[length][length];
        // 动态规划
        String ans = "";
        for (int l = 0; l < length; l++) {
            for (int i = 0; i < length; i++) {
                int j = i + l;
                if (j >= length) {
                    break;
                }
                if (l ==0) {
                    arr[i][j] = true;
                } else if (l == 1) {
                    arr[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    arr[i][j] = ((s.charAt(i) == s.charAt(j) && arr[i + 1][j - 1]));
                }

                if (arr[i][j] && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }


    /**
     * 最长回文子串 中心扩散算法
     * 动态规划法  ~~~
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 输入: "babad"   abcdba     abdcba
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     */
    public String longestPalindrome2(String s) {
        // 最长回文子串
        if (s == null || s.length() == 1) return "";
        char[] chars = s.toCharArray();
        int length = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < length; i ++) {
            int i1 = expandAroundCenter(chars, i, i);
            int i2 = expandAroundCenter(chars, i, i + 1);
            int max = Math.max(i1, i2);
            if (max > end - start + 1) {
                start = i - (max - 1) / 2;
                end = i + max/2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(char[] chars, int start, int end) {
        int L = start;
        int R = end;
        while (L >= 0 && R < chars.length && chars[R] == chars[L]) {
            L--;
            R++;
        }
        return R - L + 1;
    }

    /**
     * 暴力法
     * 转变数组后最接近目标值的数组和
     * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
     * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
     * 请注意，答案不一定是 arr 中的数字。
     * @return
     */
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int v = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            int abs = Math.abs(target - arr[i] * (arr.length - i) - sum);
            if (abs <= min) {
                j = i;
                v = arr[i];
                min = abs;
            } else {
                break;
            }
            sum += arr[i];
        }

        int caculatorSum = sum - arr[j];
        int len = arr.length - j;
        // 二分查找
        while (true) {
            int abs = Math.abs(target - (v - 1) * len - caculatorSum);
            if (abs > min) {
                break;
            } else {
                min = abs;
                v--;
            }
        }
        while (true) {
            int abs = Math.abs(target - (v + 1) * (len - 1) - sum);
            if (abs >= min) {
                break;
            } else {
                min = abs;
                v++;
            }
        }
        return v;
    }

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     * 示例 1:
     */
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        if (numRows == 1) {
            return s;
        }

        int index = 0;
        boolean grow = true;
        for (int i = 0; i < s.length(); i++) {
            list.get(index).append(s.charAt(i));
            if (index == 0) {
                grow = true;
            }
            if (index == numRows - 1) {
                grow = false;
            }
            index = grow ? index + 1 : index - 1;
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            StringBuilder stringBuilder1 = list.get(i);
            resultBuilder.append(stringBuilder1.toString());
        }
        return resultBuilder.toString();
    }

    /**
     * 最佳观光组合
     * 注意看题  题目可变化为   A[i] + i + A[j] - j
     * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
     * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
     * 返回一对观光景点能取得的最高分。
     */
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0;
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            int a = max + A[i] -i;
            max = Math.max(max, A[i] + i);
            ans = Math.max(ans, a);
        }
        return ans;
    }

    /**
     * 最长子串
     */
    public int maxLongestSubString(String str) {
        char[] chars = str.toCharArray();
        int s = 0, e = 0;
        int ans = 0;
        for (int i = 1; i < chars.length; i++) {
            int p = s;
            boolean exists = false;
            while(p <= e) {
                if (chars[i] == chars[p]) {
                    exists = true;
                    break;
                }
                p++;
            }
            e = i;
            if (exists) {
                s = i;
            }
            if (e - s + 1 > ans) {
                ans = e - s + 1;
            }
        }
        return ans;
    }

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     */
    public int maxArea1(int[] height) {
        int rtn = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                rtn = Math.max((j - i) * Math.min(height[i], height[j]), rtn);
            }
        }
        return rtn;
    }

    /**
     * 是否可以利用左右指针法， 选取左右 指针  计算ij 距离 进行移位处理
     * */
    public int maxArea2(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            int res = Math.min(height[j], height[i]) * (j - i);
            max = Math.max(res, max);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
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
     */
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     // 求解每个单词的 26个数组
    //
    //
    //
    // }

    /**
     * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
     * 像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。
     * 在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。
     * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
     */
    // public int respace(String[] dictionary, String sentence) {
    //
    // }


    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] ans = new int[obstacleGrid.length][obstacleGrid[0].length];



        return 0;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        level(root, 0, ans);
        return ans;
    }

    public void level(Node node, int level,  List<List<Integer>> ans) {
        if (node == null) {
            return;
        }

        if (ans.size() < level + 1) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        for (Node child : node.children) {
            level(child, level + 1, ans);
        }
    }

    /**
     * 347. 前 K 个高频元素
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     */
    // public int[] topKFrequent(int[] nums, int k) {
    //     Map<Integer, Integer> countMap = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         Integer count = countMap.get(nums[i]);
    //         countMap.put(nums[i], count != null ? count++ : 1);
    //     }
    //     return int[]{1};
    //     // PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Comparator.comparingInt(countMap::get));
    //     // priorityQueue.addAll(Stream.of(nums).mapToInt(Integer::new).collect(Collectors.toList()));
    //     // int[] ans = new int[k];
    //     // for (int i = 0; i < k; i++) {
    //     //     ans[i] = freqMap.get(priorityQueue.poll());
    //     // }
    //     // return ans;
    // }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {
        dfs(0, n);
        return res;
    }

    public List<TreeNode> dfs(int start, int end) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (start == end) {
            treeNodes.add(null);
            return treeNodes;
        }
        for (int j = start; j <= end; j++) {
            List<TreeNode> left = dfs(start, j);
            List<TreeNode> right = dfs(j, end);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode node = new TreeNode(j);
                    node.left = leftNode;
                    node.right = rightNode;
                    treeNodes.add(node);
                }
            }
        }
        return treeNodes;
    }


    // 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //
    // 说明：每次只能向下或者向右移动一步。
    //
    // 示例:
    //
    // 输入:
    //     [
    //         [1,3,1],
    //         [1,5,1],
    //         [4,2,1]
    //     ]
    // 输出: 7
    // 解释: 因为路径 1→3→1→1→1 的总和最小。
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            ans += grid[i][0];
            dp[i][0] = ans;
        }

        ans = 0;
        for (int j = 0; j < grid[0].length; j++) {
            ans += grid[0][j];
            dp[0][j] = ans;
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 最长公共子串
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
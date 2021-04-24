package cn.com.algorithm.leetcode;

import cn.com.zookeeper.MasterMatcher;
import com.rabbitmq.tools.json.JSONUtil;
import org.junit.Test;
import sun.font.EAttribute;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Description:
 * User: wangpl
 * Date: 2020-06-14
 * Time: 19:10
 */

public class Hard {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode deserialize = codec.deserialize("123**45");
        String serialize = codec.serialize(deserialize);
        System.out.println(serialize);
    }

    public static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }

            Queue<TreeNode> queue = new LinkedList();
            StringBuilder stringBuilder = new StringBuilder();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                stringBuilder.append(poll == null ? "*" : poll.val).append(",");
                if (poll != null) {
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }
            return stringBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            String[] chars = data.split(",");
            TreeNode rootNode = new TreeNode(Integer.parseInt(chars[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(rootNode);
            int i = 1;
            while (!queue.isEmpty() && i < chars.length) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                TreeNode left = null;
                if (!chars[i].equals("*")) {
                    left = new TreeNode(Integer.parseInt(chars[i]));
                }
                TreeNode right = null;
                if (i + 1 < chars.length) {
                    if (!chars[i + 1].equals("*")) {
                        right = new TreeNode(Integer.parseInt(chars[i + 1]));
                    }
                }
                poll.left = left;
                poll.right = right;
                queue.add(left);
                queue.add(right);
                i += 2;
            }
            return rootNode;
        }
    }

    /**
     * 10 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * 说明:
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 示例 1:
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        char[] strArray = s.toCharArray();
        char[] patternArray = p.toCharArray();
        boolean[][] f = new boolean[strArray.length + 1][patternArray.length + 1];
        f[0][0] = true;
        for (int i = 0; i <= strArray.length; i++) {
            for (int j = 1; j <= patternArray.length; j++) {
                if (patternArray[j - 1] != '*') {
                    if (matches(strArray, patternArray, i, j - 1)) {
                        f[i][j] = f[i - 1][j - 1];
                    } else {
                        f[i][j] = false;
                    }
                } else {
                    if (matches(strArray, patternArray, i, j - 2)) {
                        f[i][j] = (f[i - 1][j] || f[i][j - 2]);
                    } else {
                        f[i][j] = f[i][j - 2];
                    }
                }
            }
        }
        return f[strArray.length][patternArray.length];
    }

    public boolean matches(char[] s, char[] p, int si, int pi) {
        if (si == 0) {
            return false;
        }
        if (p[pi - 1] == '.' || s[si] == p[pi - 1]) {
            return true;
        }
        return false;
    }

    /**
     * 42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 暴力法：
     * 根据题目意思理解，从结点向两边遍历，寻找两边最大值的最小值 进行求解
     */
    public int trap1(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int l = i, r = i;
            int maxLeft = height[i];
            while (l >= 0) {
                maxLeft = Math.max(maxLeft, height[l--]);
            }
            int maxRight = height[i];
            while (r < height.length) {
                maxRight = Math.max(maxRight, height[r++]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    @Test
    public void testTrap2() {
        int i = trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(i);
    }


    /**
     * 42.1 接雨水
     * 压栈法
     * 如果碰到比 栈顶元素 >= 的元素时，则进行处理
     */
    public int trap2(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            // 栈为空入栈 或者当前元素值小于栈顶元素值， 则将元素值压栈
            while (!stack.empty() && h >= height[stack.peek()]) {
                // 当前元素值 大于等于栈顶元素
                Integer top = stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                    break;
                }
                int distanct = i - stack.peek() - 1;
                ans += (Math.min(height[stack.peek()], h) - height[top]) * distanct;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 接雨水 解法3
     * 双指针解法
     * 如果left_max<right_max成立，那么它就知道自己能存多少水了。无论右边将来会不会出现更大的right_max，都不影响这个结果
     * 按照左右进行计算，同时求出  leftMax  and  rightMax
     *
     *
     * max_left 左边
     * max_right 右边
     */
    public int trap3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                ans += leftMax - height[left++];
            } else {
                rightMax = Math.max(height[right], rightMax);
                ans += rightMax - height[right--];
            }
        }
        return ans;
    }

    /**
     * 315. 计算右侧小于当前元素的个数
     * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts
     * 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
     *
     *
     *
     */
    // public List<Integer> countSmaller(int[] nums) {
    // }

    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     *
     * 示例:
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     */
    public int nthUglyNumber(int n) {
        // 30 为既能2  也能被 3  也能被 5 整除的数
        // 丑数 * 2 / 丑数 * 3 / 丑数 * 5 依旧为丑数
        int a = 1, b = 1, c = 1;
        int[] dp = new int[1690];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
            dp[i] = min;
            if (dp[a] * 2 == min) a += 1;
            if (dp[b] * 3 == min) b += 1;
            if (dp[c] * 5 == min) c += 1;
        }
        return dp[n];
    }

    /**
     * 174. 地下城游戏
     * 采用回溯来做
     * @param dungeon
     */
    public int calculateMinimumHP(int[][] dungeon) {
        return find(dungeon, 0, 0, 0, 0);
    }

    public int find(int[][] dungeon, int i, int j, int heart, int minHeart) {
        // 当前房间的血量
        int currentheart = heart + dungeon[i][j];
        if (currentheart < 1) {
            minHeart += 1 - currentheart;
        }
        int min = minHeart;
        if (i + 1 < dungeon.length) {
            min = minHeart + find(dungeon, i + 1, j, Math.max(currentheart, 1), minHeart);
        }
        if (j + 1 < dungeon[0].length) {
            min = minHeart + find(dungeon, i, j + 1, Math.max(currentheart, 1), minHeart);
        }
        return min;
    }
}
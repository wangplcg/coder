package cn.com.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generator(n, 0, 0, new StringBuilder());
        return ans;
    }

    public void generator(int n, int left, int right, StringBuilder stringBuilder) {
        if (left + right == n) {
            if (left == right) {
                ans.add(stringBuilder.toString());
            }
            return;
        }
        if (right > left) {
            return;
        }
        if (left > right) {
            stringBuilder.append(")");
            generator(n, left, right++, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        stringBuilder.append("(");
        generator(n, left++, right, stringBuilder);
    }
}
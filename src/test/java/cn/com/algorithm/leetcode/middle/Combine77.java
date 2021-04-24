package cn.com.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 * User: wangpl
 * Date: 2020-07-15
 * Time: 23:10
 */

public class Combine77 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // [1， 2， 3， 4， 5， 6， 7， 8， 9]
        dfs(0, 0, k, n, new Stack<>());
        return ans;
    }

    public void dfs(int num, int i, int k, int n, Stack<Integer> pre) {
        if (pre.size() == k) {
            ans.add(new ArrayList<>(pre));
            return;
        }
        if (n - i < k - num) {
            return;
        }

        pre.push(i + 1);
        dfs(num + 1, i + 1, k, n, pre);
        pre.pop();
        dfs(num, i + 1, k, n, pre);
    }
}
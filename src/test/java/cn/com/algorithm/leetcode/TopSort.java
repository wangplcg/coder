package cn.com.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class TopSort {
    /**
     * 拓扑排序 运用kahn 算法
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] seriable = new int[numCourses];
        int[] deep = new int[numCourses];

        // 构建入度表
        for (int j = 0; j < prerequisites.length; j++) {
            deep[prerequisites[j][0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int j = 0; j < numCourses; j++) {
            if (deep[j] == 0) {
                queue.add(j);
            }
        }

        int k = 0;
        while (!queue.isEmpty()) {
            Integer index = queue.remove();
            seriable[k++] = index;
            for (int j = 0; j < prerequisites.length; j++) {
                if (prerequisites[j][1] == index) {
                    deep[prerequisites[j][0]]--;
                    if (deep[prerequisites[j][0]] == 0) {
                        queue.add(prerequisites[j][0]);
                    }
                }
            }
        }

        if (k != numCourses) {
            return new int[0];
        }
        return seriable;
    }


    @Test
    public void testTopSort() {
        int[][] a = {{1, 0}};
        int[] order = findOrderByDfs(2, a);
        System.out.println(Arrays.toString(order));
    }

    int k = 0;
    boolean circle = false;

    /**
     * 拓扑排序 运用kahn 算法
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrderByDfs(int numCourses, int[][] prerequisites) {
        int[] serial = new int[numCourses];
        int[] visiting = new int[numCourses];

        for (int j = 0; j < numCourses; j++) {
            if (visiting[j] == 0) {
                visiting[j] = 1;
                boolean dfs = dfs(j, prerequisites, visiting, serial);
                if (!dfs) {
                    return new int[0];
                }
            }
        }
        return serial;
    }

    /**
     * dfs
     */
    public boolean dfs(int i, int[][] prerequisites,int[] visiting, int[] serial) {
        for (int j = 0; j < prerequisites.length; j++) {
            // 判断是否有环
            if (prerequisites[j][0] == i) {
                if (visiting[prerequisites[j][1]] == 1) {
                    circle = true;
                    return false;
                }
                if (visiting[prerequisites[j][1]] == 0) {
                    visiting[prerequisites[j][1]] = 1;
                    boolean dfs = dfs(prerequisites[j][1], prerequisites, visiting, serial);
                    if (!dfs) {
                        return false;
                    }
                }
            }
        }
        visiting[i] = 2;
        serial[k++] = i;
        return true;
    }
}
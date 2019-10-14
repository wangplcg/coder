package cn.com.algorithm.dp;

/**
 * Description:
 * User: wangpl
 * Date: 2019-07-15
 * Time: 22:22
 */

public class MinDistDp {

    /**
     * 状态转移表法
     * 最短距离计算 从 （0,0） --- （n, n）
     * @param matrix 距离矩阵，存储距离值
     * @param n 矩阵宽度
     * @return
     */
    public int minDistDp(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += states[0][i];
            states[0][i] = sum;
        }
        sum = 0;
        for (int j = 0; j < n; j++) {
            sum += states[j][0];
            states[j][0] = sum;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = states[i][j] + Math.min(states[i - 1][j], states[i][j - 1]);
            }
        }
        return states[n - 1][n - 1];
    }



    /**
     * 状态转移方程法
     * mem[i][j] = matrix[i][j] + min(mem[i-1][j], mem[i][j - 1])
     * @return
     */

    int[][] matrix = {{1,4,987,67}, {2,3,4,65}, {76,1,2,12}, {12,3,2,3}};
    int n = 4;
    int mem[][] = new int[4][4];

    public int minDistDp2(int i, int j) {
        if (i == 0 && j == 0) {
            return matrix[0][0];
        }
        if (mem[i][j] > 0) {
            return mem[i][j];
        }

        int minLeft = Integer.MAX_VALUE;
        if (i - 1 > 0) {
            minLeft = minDistDp2(i - 1, j);
        }
        int minUp = Integer.MAX_VALUE;
        if (j - 1 > 0) {
            minUp = minDistDp2(i, j - 1);
        }

        int current = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = current;
        return current;
    }
}

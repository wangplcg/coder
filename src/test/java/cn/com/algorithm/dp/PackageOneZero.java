package cn.com.algorithm.dp;

/**
 * Description:
 * User: wangpl
 * Date: 2019-07-14
 * Time: 18:56
 */

public class PackageOneZero {

    /**
     * @param weight 物品重量数组
     * @param n 物品个数
     * @param w 背包可承载重量
     */
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true;
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            // 不把i物品放入背包
            for (int j = 0; j <= w; j++) {
                if (states[i -1][j]) {
                    states[i][j] = true;
                }
            }
            // i 物品放入背包
            for (int j = 0; j < w - weight[i];j++) {
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) {
            if (states[n - 1][i]) return i;
        }
        return 0;
    }


    /**
     * @param weight 物品重量数组
     * @param n 物品个数
     * @param w 背包可承载重量
     */
    public int knapsack2(int[] weight, int n, int w) {
        boolean[] states = new boolean[w + 1];
        states[0] = true;
        if (weight[0] <= w) {
            states[weight[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = w - weight[i]; j >= 0; j--) {
                if (states[j]) {
                    states[j + weight[i]] = true;
                }
            }
        }

        for (int i = w; i >= 0; --i) {
            if (states[i]) return i;
        }
        return 0;
    }

    /**
     * @param weight 物品重量数组, 并且背包价值最大
     * @param value 价值数组
     * @param n 物品个数
     * @param w 背包可承载重量
     */
    public int knapsack3(int[] weight, int[] value, int n, int w) {
//        states 二维数组 值存储价值，初始化为 -1
        int[][] states = new int[n][w + 1];
        for (int i = 0;i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;

        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }

        for (int i = 1; i < n; i++) {
//            不选择第i个物品
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] > -1) {
                    states[i][j] = states[i-1][j];
                }
            }
//           选择第 i个物品
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j] > -1) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }

        }

        int maxvalue = -1;
        for (int j = 0; j <=w; j++) {
            if (states[n - 1][j] > maxvalue) {
                maxvalue = states[n - 1][j];
            }
        }
        return maxvalue;
    }
}
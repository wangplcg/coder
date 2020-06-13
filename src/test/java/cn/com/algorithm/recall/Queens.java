package cn.com.algorithm.recall;

import org.junit.Test;

/**
 * Description: 八皇后问题
 * User: wangpl
 * Date: 2019-07-14
 * Time: 11:58
 */

public class Queens {

    // 八皇后问题 下标存储 row 值存储 皇后放置的位置 column
    public int[] result = new int[8];

    @Test
    public void testQueen() {
        call8Queens(0);
    }


    public void call8Queens(int row) {
        if (row == 8) {
            printQueens();
            return;
        }

        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                call8Queens(row + 1);
            }
        }
    }

    /**
     * 判断是否满足 8 皇后 规则
     */
    public boolean isOk(int row, int column) {
        int leftup = column - 1,  rightup = column + 1;
        for (int i = row - 1; i >= 0; i--) {

            // 结果在同一列中 校验不通过 返回false
            if (result[i] == column) {
                return false;
            }
            // 对角线校验
            if (leftup >= 0 ) {
                if (result[i] == leftup) {
                    return false;
                }
            }
            if (rightup < 8 ) {
                if (result[i] == rightup) {
                    return false;
                }
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    public void printQueens() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (result[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}

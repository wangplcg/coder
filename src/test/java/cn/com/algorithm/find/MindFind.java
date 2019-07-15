package cn.com.algorithm.find;

import java.util.Arrays;

/**
 * Description:
 * User: wangpl
 * Date: 2019-07-01
 * Time: 22:09
 */

public class MindFind {

    /**
     * 二分查找原始写法
     */
    public static int findBuMiddle(int[] a, int low, int high, int targe) {
        if (low > high) {
            return -1;
        }

        int middle = low + ((high - low) >> 1);
        if (a[middle] == targe) {
            return middle;
        }

        if (a[middle] > targe) {
            return findBuMiddle(a, low, middle - 1, targe);
        }
        return findBuMiddle(a, middle + 1, high, targe);
    }

    /**
     * 二分查找 查询第一个匹配的值
     */
    public static int findFirstBuMiddle(int[] a, int low, int high, int target) {

        while(low <= high) {
            int middle = low + ((high - low) >> 1);
            if (a[middle] < target) {
                low = middle + 1;
            } else if (a[middle] > target) {
                high = middle - 1;
            } else {
                if (middle == 0 || a[middle - 1] != target) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找 查询第一个大于等于给定值的元素
     */
    public static int findFirstUpperMiddle(int[] a, int low, int high, int target) {

        while(low <= high) {
            int middle = low + ((high - low) >> 1);
            if (a[middle] >= target) {
                if (middle == 0 || a[middle - 1] < target) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int buMiddle = findFirstBuMiddle(a, 0, a.length - 1, 15);
//        int buMiddle = findBuMiddle(a, 0, a.length - 1, 999);
        System.out.println(buMiddle);
    }
}

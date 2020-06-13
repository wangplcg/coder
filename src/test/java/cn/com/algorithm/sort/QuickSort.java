package cn.com.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description: 快速排序 按照二分的思想进行排序, 每组选择 最后一元素 作为分组元素
 * 时间复杂度
 *      最坏时间复杂度（集合本身有序）： n2
 *      最好时间复杂度 （集合本身有序 反序）： O(n * logn)
 * User: wangpl
 * Date: 2019-07-01
 * Time: 16:02
 */
public class QuickSort {

    public static void quickSortProvit(int[] a, int q, int r) {
        if (q >= r) return;
        int i = partition(a, q, r);
        quickSortProvit(a, q, i -1);
        quickSortProvit(a, i + 1, r);
    }

    public static int partition(int[] a, int q, int r) {
        if (q == r) return q;

        int p = a[r];
        int j = q;

        for (int i = q; i < r; i++) {
            if (a[i] < p) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
        }
        int temp = a[j];
        a[j] = p;
        a[r] = temp;
        return j;
    }

    @Test
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] a = {1,123,123,1243,546,33,213,45,6,7,3123,12321,321,323,213,21,12,2,123,1,324,123,22,11,45,67,21,8,645,9,9,9,0,
                213,45,6,7,3123,12321,321,323,213,21,12,2,123,1,324,123,22,11,45,67,21,8,645,9,9,9,0,
                213,45,6,7,3123,12321,321,323,213,21,12,2,123,1,324,123,22,11,45,67,21,8,645,9,9,9,0,
                213,45,6,7,3123,12321,321,323,213,21,12,2,123,1,324,123,22,11,45,67,21,8,645,9,9,9,0,
                213,45,6,7,3123,12321,321,323,213,21,12,2,123,1,324,123,22,11,45,67,21,8,645,9,9,9,0,
                213,45,6,7,3123,12321,321,323,213,21,12,2,123,1,324,123,22,11,45,67,21,8,645,9,9,9,0};
        quickSortProvit(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println(System.currentTimeMillis() - start);
    }
}
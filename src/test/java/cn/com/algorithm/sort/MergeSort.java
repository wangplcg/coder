package cn.com.algorithm.sort;

import java.util.Arrays;

/**
 * Description:
 * User: wangpl
 * Date: 2019-07-01
 * Time: 16:35
 */

public class MergeSort {

    public static void mergeSort(int[] a, int q, int r) {
        if (q >= r) return;
        mergeSort(a, q, (q + r)/ 2);
        mergeSort(a,(q + r)/ 2 + 1, r);
        merge(a, q, (q + r)/ 2, r);
    }


    public static void merge(int[] a, int q, int s, int r) {
        int[] temp = new int[r - q + 1];
        int s1 = q;
        int s2 = s + 1;
        int ii = 0;
        for (int i = s1, j = s2; i <= s && j <= r; ii++) {
            if (a[i] < a[j]) {
                temp[ii] = a[i++];
                s1++;
            } else {
                temp[ii] = a[j++];
                s2++;
            }
        }

        while (s1 <= s) {
            temp[ii++] = a[s1++];
        }

        while (s2 <= r) {
            temp[ii++] = a[s2++];
        }
        System.arraycopy(temp, 0, a, q, r - q + 1);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] a = {1,123,123,1243,546,33,213,45,6,7,3123,12321,321,323,213,21,12,2,123,1,324,123,22,11,45,67,21,8,645,9,9,9,0
                ,213,45,6,7,3123,12321,321,323,213,21,12,2,123,1,324,123,22,11,45,67,21,8,645,9,9,9,0
                ,213,45,6,7,3123,12321,321,323,213,21,12,2,123,1,324,123,22,11,45,67,21,8,645,9,9,9,0
                ,213,45,6,7,3123,12321,321,323,213,21,12,2,123,1,324,123,22,11,45,67,21,8,645,9,9,9,0
                ,213,45,6,7,3123,12321,321,323,213,21,12,2,123,1,324,123,22,11,45,67,21,8,645,9,9,9,0
                ,213,45,6,7,3123,12321,321,323,213,21,12,2,123,1,324,123,22,11,45,67,21,8,645,9,9,9,0};
        mergeSort(a, 0, a.length -1 );
        System.out.println(Arrays.toString(a));
        System.out.println(System.currentTimeMillis() - start);
    }
}

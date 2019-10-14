package cn.com.algorithm.heap;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Description: 建堆 堆排序
 * User: wangpl
 * Date: 2019-07-09
 * Time: 14:39
 */

public class HeapTest {

    public static int[] a = new int[21];

    @Before
    public void heapData() {
        for (int i = 1; i <= 20; i++) {
            a[i] = (int)(1 + Math.random() * 100);
        }
    }

    /**
     * 堆化建堆 （自上向下堆化）
     */
    @Test
    public void heapify1() {
        int index = (20 - 1) / 2;
        while (index > 0) {
            heapHead(index--, 20);
        }
        sortByHeap(20);
        System.out.println(Arrays.toString(a));
    }


    public void heapHead(int headIndex, int n) {
        if (headIndex < 1 || headIndex > (n - 1)/2) {
            return;
        }
        while (headIndex < (a.length - 1)/2) {
            int point = headIndex;

            if (a[point] < a[headIndex * 2]) {
                point = headIndex * 2;
            }

            if (a[point] < a[headIndex * 2 + 1]) {
                point = headIndex * 2 + 1;
            }

            if (point == headIndex) {
                break;
            }

            int temp = a[point];
            a[point] = a[headIndex];
            a[headIndex] = temp;
            headIndex = point;
        }
    }

    // 堆排序
    public void sortByHeap(int n) {
        if (n == 1) return;
        int temp = a[1];
        a[1] = a[n];
        a[n] = temp;

        int i = 1;
        while (i < (n / 2)) {
            int point = i;
            if (a[point] < a[2 * i]) point = 2 * i;
            if (a[point] < a[2 * i + 1]) point = 2 * i + 1;
            if (i == point) break;
            int tep = a[point];
            a[point] = a[i];
            a[i] = tep;
            i = point;
        }
        sortByHeap(--n);
    }

    /**
     * 堆中插入元素
     * 向堆中最后一个元素插入元素，然后自下向上堆化即可
     */
    public void insertHeap(int nodeData) {

    }
}

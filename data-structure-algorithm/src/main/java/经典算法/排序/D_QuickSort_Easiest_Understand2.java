package 经典算法.排序;

import leetcode.base.definition.Point;
import org.junit.Test;
import util.UtilArray;

/**
 * 冒泡排序的升级版
 */
public class D_QuickSort_Easiest_Understand2 {


    public void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(arr, start, end);
        sort(arr, 0, partition - 1);
        sort(arr, partition + 1, end);
    }

    public int partition(int[] arr, int start, int end) {
        int pivot = start;
        while (start < end) {
            while (start < end && arr[end] >= arr[pivot]) end--;
            swap(arr, pivot, end);
            pivot = end;
            while (start < end && arr[start] <= arr[pivot]) start++;
            swap(arr, pivot, start);
            pivot = start;
        }
        return pivot;
    }

    public void swap(int[] arr, int loc1, int loc2) {
        int tmp = arr[loc1];
        arr[loc1] = arr[loc2];
        arr[loc2] = tmp;
    }

    @Test
    public void testSort2() {
        int[] array = {3, 1, 2, 3, 4, 2, 3, 5};
        System.out.println(partition(array, 0, array.length - 1));
//        sort(array, 0, array.length - 1);
        UtilArray.display(array);

        sort(array, 0, array.length - 1);
        UtilArray.display(array);

    }
}

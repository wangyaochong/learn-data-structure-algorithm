package 经典算法.搜索.practice;

import org.junit.Test;

public class p1 {
    public static void main(String[] args) {
    }

    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    @Test
    public void test() {
//        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 1));
//        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 2));
//        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 3));
//        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 4));
        System.out.println(search(new int[]{1, 2, 3, 4}, 5));
    }
}

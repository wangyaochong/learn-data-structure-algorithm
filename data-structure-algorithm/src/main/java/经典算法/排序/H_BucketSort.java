package 经典算法.排序;

import org.junit.Test;
import util.UtilArray;

public class H_BucketSort {
    public int[] sort(int[] arr) {
        boolean flag = true;
        int round = 1;
        int bucketNum = 10;
        while (flag) {
            flag = false;
            int[] bucketLoc = new int[bucketNum];
            int[][] bucket = new int[bucketNum][arr.length];
            for (int i = 0; i < arr.length; i++) {
                //只要有arr[i]>round*bucketNum，才需要进行下一轮，
                // 否则等下一轮操作时肯定都排在0号位置了
                if (arr[i] > round * bucketNum) {
                    flag = true;
                }
                int toBucketLoc = (arr[i] / round) % bucketNum;
                System.out.println("数字=" + arr[i] + "，bucketLoc=" + toBucketLoc + "，round=" + round);
                bucket[toBucketLoc][bucketLoc[toBucketLoc]] = arr[i];
                bucketLoc[toBucketLoc]++;
            }
            int arrLoc = 0;
            for (int i = 0; i < bucketNum; i++) {
                for (int j = 0; j < bucketLoc[i]; j++) {
                    arr[arrLoc] = bucket[i][j];
                    arrLoc++;
                }
            }
            round *= bucketNum;
        }
        return arr;
    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 23, 4, 27, 9, 101, 1001, 5, 6, 7, 8, 19};
        UtilArray.display(sort(arr));
        System.out.println(10 % 10);
        System.out.println((100 / 10) % 10);
        System.out.println((123 / 100) % 10);
    }
}

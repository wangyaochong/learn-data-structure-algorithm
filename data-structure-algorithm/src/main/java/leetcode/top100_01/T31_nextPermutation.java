package leetcode.top100_01;

import java.util.Arrays;

public class T31_nextPermutation {

    //    	测试用例:[4,2,0,2,3,2,0]
//	测试结果:[4,2,2,0,0,2,3]
//	期望结果:[4,2,0,3,0,2,2]
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 2, 3, 2, 0};
//        int[] arr = {1, 3, 2};
        new T31_nextPermutation().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 1;
        int j = 0;
        boolean flag = false;
        for (; i >= 0; i--) {
            for (j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        if (flag) {
            swap(nums, i, j);
            Arrays.sort(nums, i + 1, nums.length);
        } else {
            Arrays.sort(nums);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

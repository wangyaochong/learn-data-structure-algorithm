package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p2460_applyOperations {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }

        int unzeroLoc = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                unzeroLoc = Math.max(i, unzeroLoc);
                while (unzeroLoc < nums.length && nums[unzeroLoc] == 0) unzeroLoc++;
                if (unzeroLoc < nums.length) {
                    nums[i] = nums[unzeroLoc];
                    nums[unzeroLoc] = 0;
                } else {
                    break;
                }
            }
        }


        return nums;
    }

    @Test
    public void test() {
//        System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(applyOperations(new int[]{847, 847, 0, 0, 0, 399, 416, 416, 879, 879, 206, 206, 206, 272})));
    }

}

package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p922_sortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int oddLoc = 1;
        int evenLoc = 0;
        int length = nums.length;
        int[] result = new int[nums.length];

        for (int i = 0; i < length; i++) {
            if ((nums[i] & 1) == 0) {
                result[evenLoc] = nums[i];
                evenLoc += 2;
            } else {
                result[oddLoc] = nums[i];
                oddLoc += 2;
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] ints = sortArrayByParityII(new int[]{1, 2, 3, 4});
        int[] ints2 = sortArrayByParityII(new int[]{4, 2, 5, 7});
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
    }
}

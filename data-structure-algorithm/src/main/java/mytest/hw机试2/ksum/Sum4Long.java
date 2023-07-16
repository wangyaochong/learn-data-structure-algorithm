package mytest.hw机试2.ksum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4Long {

    @Test
    public void test() {
        System.out.println(fourSum(new int[]{-1, 0, 1, 2, -1, -4}, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int targetInput) {
           long[] numsLong = new long[nums.length];
        for(int i=0;i<nums.length;i++){
            numsLong[i] = nums[i];
        }
        Arrays.sort(numsLong);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numsLong.length; i++) {
            if (i - 1 >= 0 && numsLong[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < numsLong.length; j++) {
                if (j > i + 1 && numsLong[j - 1] == numsLong[j]) continue;
                long target = targetInput - (numsLong[i] + numsLong[j]);
                int left = j + 1;
                int right = numsLong.length - 1;
                while (left < right) {
                    if (numsLong[left] + numsLong[right] < target) left++;
                    else if (numsLong[left] + numsLong[right] > target) right--;
                    else {
                        result.add(Arrays.asList((int)numsLong[i], (int)numsLong[j], (int)numsLong[left], (int)numsLong[right]));
                        while (left + 1 < numsLong.length && numsLong[left] == numsLong[left + 1]) left++;
                        while (right - 1 >= 0 && numsLong[right] == numsLong[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }

        }
        return result;
    }


}

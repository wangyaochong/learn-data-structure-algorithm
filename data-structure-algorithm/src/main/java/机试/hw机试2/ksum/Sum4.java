package 机试.hw机试2.ksum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {

    @Test
    public void test() {
        System.out.println(fourSum(new int[]{-1, 0, 1, 2, -1, -4},0));
    }

     public List<List<Integer>> fourSum(int[] nums, int targetInput) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;
                long target = targetInput - (nums[i] + nums[j]);
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] < target) left++;
                    else if (nums[left] + nums[right] > target) right--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left + 1 < nums.length && nums[left] == nums[left + 1]) left++;
                        while (right - 1 >= 0 && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }

        }
        return result;
    }
}

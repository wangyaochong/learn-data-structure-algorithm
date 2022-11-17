package leetcode.top100_01;

import java.util.HashMap;
import java.util.Map;

public class T1_twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueLoc = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = valueLoc.get(target - nums[i]);
            if (integer != null) {
                return new int[]{i, integer};
            }
            valueLoc.put(nums[i], i);
        }
        return null;
    }


}

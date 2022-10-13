package leetcode.top100_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T015_threeSum_2pointer_better {
    public static void main(String[] args) {
//        List<List<Integer>> lists = new T015_threeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        int[] arr = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List<List<Integer>> lists = new T015_threeSum_2pointer_better().threeSum(arr);
        System.out.println(lists);
//        int[] twoSum = new T015_threeSum().twoSum(arr, -4, 4);
//        System.out.println(twoSum);
    }

    //[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int loc = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (loc < nums.length) {
            int start = loc + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] < -nums[loc]) {
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    start++;
                } else if (nums[start] + nums[end] > -nums[loc]) {
                    while (end > start && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    end--;
                } else {
                    result.add(Arrays.asList(nums[loc], nums[start], nums[end]));
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    start++;
                }
            }

            while (loc + 1 < nums.length && nums[loc] == nums[loc + 1]) {
                loc++;
            }
            loc++;
        }
        return result;
    }

}

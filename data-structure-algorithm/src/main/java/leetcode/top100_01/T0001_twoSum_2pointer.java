package leetcode.top100_01;

import java.util.*;

public class T0001_twoSum_2pointer {
    public List<int[]> twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int start=0;
        int end=nums.length-1;
        List<int[]> result = new ArrayList<>();
        while (start < end) {
            if(nums[start]+nums[end]<target){
                start++;
            }else if(nums[start]+nums[end]>target){
                end--;
            }else{
                result.add(new int[]{nums[start], nums[end]});
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> ints = new T0001_twoSum_2pointer().twoSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 8);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));

        }
    }

}

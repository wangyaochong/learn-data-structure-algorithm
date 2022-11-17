package leetcode.top100_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15_threeSum_2pointer {
    public static void main(String[] args) {
//        List<List<Integer>> lists = new T015_threeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        int[] arr = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List<List<Integer>> lists = new T15_threeSum_2pointer().threeSum(arr);
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
            List<List<Integer>> ints = twoSum(nums,loc ,-nums[loc], nums[loc]);
            for (List<Integer> twoSumResult : ints) {
                if (twoSumResult != null) {
                    List<Integer> one = new ArrayList<>();
                    one.add(nums[loc]);
                    one.addAll(twoSumResult);
                    result.add(one);
                }
            }
            while (loc + 1 < nums.length && nums[loc] == nums[loc + 1]) {
                loc++;
            }
            loc++;
        }
        return result;
    }

     public List<List<Integer>> twoSum(int[] nums, int start,int target,int skip) {
        int end=nums.length-1;
        List<List<Integer>> result = new ArrayList<>();
        while (start < end) {
            if(nums[start]==skip){
                start++;
                skip=Integer.MAX_VALUE;
                continue;
            }
            if(nums[start]+nums[end]<target){
                while(start<end&&nums[start]==nums[start+1]){
                    start++;
                }
                start++;
            }else if(nums[start]+nums[end]>target){
                while(end>start&&nums[end]==nums[end-1]){
                    end--;
                }
                end--;
            }else{
                result.add(Arrays.asList(nums[start], nums[end]));
                while(start<end&&nums[start]==nums[start+1]){
                    start++;
                }
                start++;
            }
        }
        return result;
    }
}

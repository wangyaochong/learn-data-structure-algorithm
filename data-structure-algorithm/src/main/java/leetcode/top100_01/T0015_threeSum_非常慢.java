package leetcode.top100_01;

import java.util.*;
import java.util.stream.Collectors;

public class T0015_threeSum_非常慢 {
    public static void main(String[] args) {
//        List<List<Integer>> lists = new T015_threeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        int[] arr = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List<List<Integer>> lists = new T0015_threeSum_非常慢().threeSum(arr);
        System.out.println(lists);
//        int[] twoSum = new T015_threeSum().twoSum(arr, -4, 4);
//        System.out.println(twoSum);
    }

    //[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int loc = 0;
        Set<String> result = new HashSet<>();
        while (loc < nums.length) {
            List<int[]> ints = twoSum(nums, -nums[loc], nums[loc]);
            for (int[] twoSumResult : ints) {
                if (twoSumResult != null) {
                    List<Integer> one = new ArrayList<>();
                    one.add(nums[loc]);
                    for (int i : twoSumResult) {
                        one.add(i);
                    }
                    one.sort(Integer::compareTo);
                    String str = one.stream().sorted().map(Object::toString).reduce((a, b) -> a + "," + b).get();
                    result.add(str);
                }
            }
            while (loc + 1 < nums.length && nums[loc] == nums[loc + 1]) {
                loc++;
            }
            loc++;
        }
        return result.stream().map(e -> {
            String[] split = e.split(",");
            List<Integer> one = new ArrayList<>();
            for (String s : split) {
                if (s != null && !s.equals("")) {
                    one.add(Integer.parseInt(s));
                }
            }
            return one;
        }).collect(Collectors.toList());
    }

    public List<int[]> twoSum(int[] nums, int target, int skip) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> valueLoc = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (skip == nums[i]) {
                skip = Integer.MAX_VALUE;
                continue;
            }
            Integer integer = valueLoc.get(target - nums[i]);
            if (integer != null) {
                result.add(new int[]{nums[i], nums[integer]});
            }
            valueLoc.put(nums[i], i);
        }
        return result;
    }
}

package mytest.hw机试2.ksum;

import java.util.HashMap;
import java.util.Map;

public class Sum2 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueLoc = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer integer = valueLoc.get(target - nums[i]);
            if(integer==null){
                valueLoc.put(nums[i], i);
            }else{
                return new int[]{integer, i};
            }
        }
        return new int[]{-1, -1};
    }
}

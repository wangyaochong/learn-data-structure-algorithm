package leetcode.top100_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T39_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;

    }

    public void helper(int[] candidates, int target, int startLoc, int currentSum, List<Integer> nums, List<List<Integer>> result) {
        if (currentSum == target) {
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = startLoc; i < candidates.length; i++) {
            if (currentSum + candidates[i] <= target) {
                nums.add(candidates[i]);
                helper(candidates, target, i, currentSum + candidates[i], nums, result);
                nums.remove(nums.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new T39_combinationSum().combinationSum(new int[]{1, 2, 3, 4, 5}, 5);
        System.out.println(lists);
    }
}

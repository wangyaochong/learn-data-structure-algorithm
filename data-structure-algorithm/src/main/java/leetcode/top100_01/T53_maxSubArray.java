package leetcode.top100_01;

public class T53_maxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + dp[i - 1] < nums[i]) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i - 1];
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int i = new T53_maxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}

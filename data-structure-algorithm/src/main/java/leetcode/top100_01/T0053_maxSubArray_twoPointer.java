package leetcode.top100_01;

public class T0053_maxSubArray_twoPointer {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int current = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + pre < nums[i]) {
                pre = nums[i];
                current = nums[i];
            } else {
                current = nums[i] + pre;
                pre = pre + nums[i];
            }
            if (max < current) {
                max = current;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int i = new T0053_maxSubArray_twoPointer().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}

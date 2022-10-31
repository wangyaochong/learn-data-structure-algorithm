package leetcode.top100_01;

public class T0055_canJump {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int max = nums[0];
        int i = 1;
        for (; i < nums.length && max >= i; i++) {
            if (max < i + nums[i]) {
                max = i + nums[i];
            }
        }
        return i == nums.length;
    }

    public static void main(String[] args) {
        boolean b = new T0055_canJump().canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(b);
        boolean b1 = new T0055_canJump().canJump(new int[]{3,2,1,0,4});
        System.out.println(b1);
    }

}

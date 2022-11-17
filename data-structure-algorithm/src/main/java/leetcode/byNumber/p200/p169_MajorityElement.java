package leetcode.byNumber.p200;

public class p169_MajorityElement {
    public int majorityElement(int[] nums) {

        int count = 1;
        int major = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                major = nums[i];
            }
        }
        return major;
    }
}

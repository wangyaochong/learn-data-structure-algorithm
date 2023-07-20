package leetcode.byNumber.p100;

import org.junit.Test;

public class p42_TrappingRainWater_2pointer {
    public int trap(int[] height) {//总体思路，雨水等于总高度减去陆地高度

        int left = 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int right = height.length - 1;
        int totalLand = 0;
        int totalArea = 0;
        while (left < right) {
            while (left < right && height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                totalArea += leftMax;
                totalLand += height[left];
                left++;
            }
            while (left < right && height[left] >= height[right]) {
                rightMax = Math.max(rightMax, height[right]);
                totalArea += rightMax;
                totalLand += height[right];
                right--;
            }
        }
        return totalArea - totalLand;
    }

    @Test
    public void test() {
        System.out.println(trap(new int[]{5, 0, 1, 3, 4, 0, 1}));
    }
//    @Test
//    public void test() {
//        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//    }
}

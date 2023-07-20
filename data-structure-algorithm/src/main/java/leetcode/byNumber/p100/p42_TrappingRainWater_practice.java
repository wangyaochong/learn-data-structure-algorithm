package leetcode.byNumber.p100;

import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Level;

import static java.util.Arrays.copyOf;

public class p42_TrappingRainWater_practice {
    public int trap(int[] height) {
        int[] leftMax = Arrays.copyOf(height, height.length);
        int[] rightMax = Arrays.copyOf(height, height.length);

        for (int i = leftMax.length - 1; i >= 1; i--) {
            leftMax[i - 1] = Math.max(leftMax[i - 1], leftMax[i]);
        }
        for (int i = 0; i < rightMax.length - 1; i++) {
            rightMax[i + 1] = Math.max(rightMax[i + 1], rightMax[i]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
//        System.out.println(Arrays.toString(leftMax));
//        System.out.println(Arrays.toString(rightMax));
        return res;
    }

    @Test
    public void test() {
        System.out.println(trap(new int[]{5,0,1,3,4,0,1}));
    }
}

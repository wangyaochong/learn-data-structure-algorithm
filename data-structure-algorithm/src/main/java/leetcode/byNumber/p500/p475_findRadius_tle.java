package leetcode.byNumber.p500;

import org.junit.Test;

import java.util.Arrays;

public class p475_findRadius_tle {
    public static void main(String[] args) {

    }


    public int findRadius(int[] houses, int[] heaters) {
        int[] leftToRight = new int[houses.length];
        for(int i=0;i<houses.length;i++){
            leftToRight[i] = Integer.MAX_VALUE;
            for (int heater : heaters) {
                leftToRight[i] = Math.min(leftToRight[i], Math.abs(heater - houses[i]));
            }
        }
        return Arrays.stream(leftToRight).max().getAsInt();
    }



    @Test
    public void test() {
        System.out.println(findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(findRadius(new int[]{1, 5}, new int[]{2}));

    }
}

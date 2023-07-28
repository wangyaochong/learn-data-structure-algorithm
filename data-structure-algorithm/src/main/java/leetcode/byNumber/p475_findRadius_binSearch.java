package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p475_findRadius_binSearch {
    public static void main(String[] args) {

    }


    public int findRadius(int[] houses, int[] heaters) {
        int max=0;
          Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            int heater = findHeater(heaters, houses[i]);
            max = Math.max(Math.abs(houses[i] - heaters[heater]), max);
        }
        return max;
    }


    public int findHeater(int[] heaters, int target) {
        int left = 0;
        int right = heaters.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (target == heaters[mid]) {
                return mid;
            } else if (target > heaters[mid]) {
                left = mid ;
            } else {
                right = mid ;
            }
        }
        if(Math.abs(target-heaters[left])>Math.abs(target-heaters[right])){
            return right;
        }else{
            return left;
        }
    }


    @Test
    public void test() {
        System.out.println(findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(findRadius(new int[]{1, 5}, new int[]{2}));
//
//        System.out.println(findHeater(new int[]{1, 2, 5}, 3));

    }
}

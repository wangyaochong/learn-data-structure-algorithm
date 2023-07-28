package leetcode.byNumber.p200;

import org.junit.Test;

import java.util.Arrays;

public class p1013_canThreePartsEqualSum {
    public static void main(String[] args) {

    }

    public boolean canThreePartsEqualSum(int[] arr) {
        int[] sumArr = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < arr.length; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        if (sumArr[sumArr.length - 1] % 3 != 0) return false;

        int avg = sumArr[sumArr.length - 1] / 3;


        int ok1 = -1;
        int ok2 = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (avg == sumArr[i] && ok1 == -1) {
                ok1 = i;
                continue;
            }
            if (avg * 2 == sumArr[i] && ok1 != -1) {
                ok2 = i;
                break;
            }
        }
        return ok1 != -1 && ok1 < ok2;
    }

    @Test
    public void test() {
        System.out.println(canThreePartsEqualSum(new int[]{0, -6, 7, 8, -10, 7, 10, -7, 10, 1, -4, -4, 1, 6, -9, 1, -5, 0, -8, -6, -8, -5, -1, -5, 0, 6, -4, 2, -2, -1, -3, 5, 10, 3, -4, -6, 3, 7, 8, 9, 8, 1}));
        System.out.println(canThreePartsEqualSum(new int[]{6, 1, 1, 13, -1, 0, -10, 20}));
        System.out.println(canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
    }
}

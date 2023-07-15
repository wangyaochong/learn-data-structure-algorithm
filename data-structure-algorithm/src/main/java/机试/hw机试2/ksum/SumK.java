package 机试.hw机试2.ksum;

import org.junit.Test;

import java.util.Arrays;

public class SumK {
    @Test
    public void test() {
        int i = kSum(new int[]{1, 2, 3, 4}, 2, 5);
        System.out.println(i);
    }

    public int kSum(int[] a, int k, int target) {
        Arrays.sort(a);
        solve(a, 0, k, target);
        return count;
    }

    int count = 0;

    public void solve(int[] arr, int startLoc, int k, int target) {
        if (k == 2) {
            int left = startLoc;
            int right = arr.length - 1;
            while (left < right) {
                if (arr[left] + arr[right] < target) left++;
                else if (arr[left] + arr[right] > target) right--;
                else {
                    count++;
                    while (left + 1 < arr.length && arr[left] == arr[left + 1]) left++;
                    while (right - 1 >= 0 && arr[right] == arr[right - 1]) right--;
                    left++;
                    right--;
                }
            }
            return;
        }
        for (int i = startLoc; i < arr.length; i++) {
            if (i > startLoc && arr[i - 1] == arr[i]) continue;
            if (arr[i] > target) break;
            solve(arr, i + 1, k - 1, target - arr[i]);
        }

    }
}

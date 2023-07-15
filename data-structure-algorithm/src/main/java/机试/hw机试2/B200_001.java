package 机试.hw机试2;

import org.junit.Test;

import java.util.Arrays;

public class B200_001 {
    public static void main(String[] args) {
    }

    @Test
    public void test() {
        System.out.println(maxDistance(new int[]{5,4,3,2,1,1000000000}, 2));
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1];
        int result = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(position, mid, m)) {
                result = mid;
                left = mid+1;
            } else {
                right = mid - 1;
            }

        }
        return result;

    }

    public boolean check(int[] position, int distance, int m) {
        int leftCount = m - 1;
        int preLoc = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - preLoc >= distance) {
                leftCount--;
                preLoc = position[i];
                if (leftCount == 0) return true;
            }
        }
        return false;
    }
}

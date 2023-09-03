package leetcode.byNumber.p400;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class p313_nthSuperUglyNumber {
    public static void main(String[] args) {

    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        long[] result = new long[n];
        result[0] = 1;
        for (int prime : primes) {
            queue.add(new long[]{prime, prime, 0});
        }

        int k = 1;
        while (k < n) {
            long[] poll = queue.poll();
            if (result[k - 1] != poll[0]) {
                result[k] = poll[0];
                k++;
            }
            queue.add(new long[]{poll[1] * result[(int) (poll[2] + 1)], poll[1], poll[2] + 1});
        }
        return (int) result[k - 1];
    }

    @Test
    public void test() {
//        int i1 = nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
//        int i2 = nthSuperUglyNumber(1, new int[]{2,3,5});
        int i2 = nthSuperUglyNumber(5911, new int[]{2,3,5,7});
        System.out.println(i2);
    }
}

package 机考准备;

import org.junit.Test;

import java.util.Scanner;

public class P2 {
    static short[][] cache = new short[10001][10001];

    public static boolean checkPrim(int min, int max) {
        if (cache[min][max] != -1) {
            return cache[min][max] == 1;
        }
        for (int i = 2; i < min; i++) {
            if (min % i == 0 && max % i == 0) {
                cache[min][max] = 0;
                return false;
            }
        }
        cache[min][max] = 1;
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }

        Scanner in = new Scanner(System.in);
        Integer start = Integer.parseInt(in.nextLine());
        Integer end = Integer.parseInt(in.nextLine());
        boolean has = false;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (!checkPrim(i, j)) {
                    break;
                }
                if (i * i + j * j > 10000 * 10000) {
                    break;
                }
                for (int k = j + 1; k <= end && i * i + j * j >= k * k; k++) {
                    if (checkPrim(j, k) && i * i + j * j == k * k) {
                        has = true;
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
        if (!has) {
            System.out.println("NA");
        }
    }

    @Test
    public void test() {
//        boolean b = checkPrim(2, 6);
        System.out.println(Short.MAX_VALUE);
    }


}

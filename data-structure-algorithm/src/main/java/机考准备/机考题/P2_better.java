package 机考准备.机考题;

import org.junit.Test;

import java.util.Scanner;

public class P2_better {

    @Test
    public void test() {
        int gcd = gcd(2, 8);
        System.out.println(gcd);
        System.out.println(checkPrime(13, 15));
        System.out.println(checkPrime(3, 15));
    }

    public static int gcd(int a, int b) {
        int tmp = 0;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static boolean checkPrime(int a, int b) {
        int tmp = 0;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a == 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer start = Integer.parseInt(in.nextLine());
        Integer end = Integer.parseInt(in.nextLine());
        boolean has = false;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (i * i + j * j > end*end) {
                    break;
                } else {
                    int sqrt = (int) Math.sqrt(i * i + j * j + 1);
                    if (checkPrime(i, j) && checkPrime(j, sqrt) && i * i + j * j == sqrt * sqrt) {
                        System.out.println(i + " " + j + " " + sqrt);
                    }
                }
            }
        }
        if (!has) {
            System.out.println("NA");
        }
    }

//    @Test
//    public void test() {
////        boolean b = checkPrim(2, 6);
//        System.out.println(Short.MAX_VALUE);
//    }


}

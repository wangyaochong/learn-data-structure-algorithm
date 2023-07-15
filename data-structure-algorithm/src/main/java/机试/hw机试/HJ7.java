package 机试.hw机试;

import java.util.Scanner;

public class HJ7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double v = in.nextDouble();
        if (v - (long) v >= 0.5) System.out.println((long) v + 1);
        else System.out.println((long)v);
    }
}

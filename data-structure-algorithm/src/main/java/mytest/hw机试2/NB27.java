package mytest.hw机试2;

import java.util.Scanner;

public class NB27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Long value = Long.parseLong(s);
        value = Math.abs(value);
        long count = 0;
        if (value == 1) {
            count = 2L;
        } else if (value == 2) {
            count = 1L;
        } else if (value == 3) {
            count = 1L;
        } else {
            if (value % 3 == 0) {
                count = value / 3;
            } else {
                count = value / 3 + 1;
            }
        }
        System.out.println(count);
    }
}

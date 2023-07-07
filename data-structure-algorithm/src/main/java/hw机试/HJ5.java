package hw机试;

import java.util.Scanner;

public class HJ5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String substring = s.substring(2);
        long sum = 0;
        int index = substring.length() - 1;
        long size = 1;
        while (index >= 0) {
            char x = substring.charAt(index);
            long num;
            if (x == 'A' || x == 'B' || x == 'C' || x == 'D' || x == 'E' || x == 'F') {
                num = x - 'A' + 10;
            } else {
                num = x - '0';
            }
            sum += num * size;
            size *= 16;
            index--;
        }
        System.out.println(sum);
    }
}

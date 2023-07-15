package 机试.hw机试;


import com.google.common.base.Strings;

import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toLowerCase();
        String c = in.nextLine().toLowerCase();

        Character one = c.charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (one.equals(str.charAt(i))){
                count++;
            }

        }
        System.out.println(count);
    }
}

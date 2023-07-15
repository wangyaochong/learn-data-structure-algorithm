package 机试.hw机试;

import java.util.Scanner;

public class HJ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        System.out.println(s1[s1.length-1].length());
    }
}

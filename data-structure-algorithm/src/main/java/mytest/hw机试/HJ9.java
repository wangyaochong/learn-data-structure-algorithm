package mytest.hw机试;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        Set<Character> exists = new HashSet<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!exists.contains(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
            exists.add(s.charAt(i));
        }
        System.out.println(sb);
    }
}

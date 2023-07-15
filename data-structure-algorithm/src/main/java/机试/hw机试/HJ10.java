package 机试.hw机试;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ10 {
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        Set<Character> cache = new HashSet<>();
        for (char aChar : chars) {
            cache.add(aChar);
        }
        System.out.println(cache.size());

    }
}

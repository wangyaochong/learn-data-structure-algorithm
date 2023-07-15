package 机试.hw机试;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.putIfAbsent(s.charAt(i), 0);
            countMap.put(s.charAt(i), countMap.get(s.charAt(i)) + 1);
        }

        int minCount = Integer.MAX_VALUE;
        Character minChar = ' ';
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (minCount > entry.getValue()) {
                minCount = entry.getValue();
                minChar = entry.getKey();
            }
        }
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {

            if (entry.getValue().equals(minCount)) {

                s = s.replaceAll("" + entry.getKey(), "");
            }
        }
        System.out.println(s);
    }
}

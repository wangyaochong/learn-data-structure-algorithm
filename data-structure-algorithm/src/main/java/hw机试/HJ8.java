package hw机试;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        TreeMap<Long, Long> result = new TreeMap<>();
        while (count > 0) {
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            Long index = Long.valueOf(s1[0]);
            Long value = Long.valueOf(s1[1]);

            result.merge(index, value, Long::sum);
            count--;
        }
        for (Map.Entry<Long, Long> entry : result.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}

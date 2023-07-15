package 机试.hw机试2;

import java.util.*;

public class NB34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String substring = s.substring(1, s.length() - 1);
        String[] split = substring.split("\\),\\(");
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (String s1 : split) {
            String[] one = s1.split(",");
            Integer value = Integer.parseInt(one[0]);
            Integer weight = Integer.parseInt(one[1]);
            map.putIfAbsent(weight, new ArrayList<>());
            List<Integer> integers = map.get(weight);
            if(!integers.contains(value)){
                integers.add(value);
            }
        }

        ArrayList<Map.Entry<Integer, List<Integer>>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> o2.getKey()-o1.getKey());
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            List<Integer> value = entry.getValue();
            for (Integer valueWeight : value) {
                result.append(valueWeight).append(",");
            }
        }
        if(result.length()!=0){
            System.out.println(result.substring(0, result.length() - 1));
        }
    }
}
//(10,1),(10,1),(30,2),(40,3)
// (10,1),(20,1),(30,2),(40,3)
// (20,1),(10,1),(30,2),(40,3)
// (30,1)(10,1)(10,1),(30,2),(20,1),(40,3)

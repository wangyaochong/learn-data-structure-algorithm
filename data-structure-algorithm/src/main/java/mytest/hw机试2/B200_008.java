package mytest.hw机试2;

import java.util.*;
import java.util.stream.Collectors;

public class B200_008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num1Str = in.nextLine();
        String num2Str = in.nextLine();
        String[] split1 = num1Str.split(",");
        Map<Integer, Integer> numCountMap1 = new HashMap<>();
        Map<Integer, Integer> numCountMap2 = new HashMap<>();
        for (String s : split1) {
            int num = Integer.parseInt(s);
            numCountMap1.putIfAbsent(num, 0);
            numCountMap1.put(num, numCountMap1.get(num) + 1);
        }
        String[] split2 = num2Str.split(",");
        for (String s : split2) {
            int num = Integer.parseInt(s);
            numCountMap2.putIfAbsent(num, 0);
            numCountMap2.put(num, numCountMap2.get(num) + 1);
        }
        Map<Integer, Integer> numCountMapSum = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry1 : numCountMap1.entrySet()) {
            Integer integer = numCountMap2.get(entry1.getKey());
            if(integer!=null){
                numCountMapSum.put(entry1.getKey(), Math.min(entry1.getValue(), integer));
            }
        }
        if(numCountMapSum.size()==0){
            System.out.println("NULL");
            return ;
        }
        Map<Integer, List<Map.Entry<Integer, Integer>>> collect = numCountMapSum.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue));
        ArrayList<Map.Entry<Integer, List<Map.Entry<Integer, Integer>>>> resultEntryList = new ArrayList<>(collect.entrySet());
        resultEntryList.sort(Comparator.comparingInt(Map.Entry::getKey));
        for (Map.Entry<Integer, List<Map.Entry<Integer, Integer>>> integerListEntry : resultEntryList) {
            System.out.print(integerListEntry.getKey()+":");
            List<Map.Entry<Integer, Integer>> value = integerListEntry.getValue();
            value.sort(Comparator.comparingInt(Map.Entry::getKey));
            Optional<String> reduce = value.stream().map(e -> e.getKey().toString()).reduce((a, b) -> a + "," + b);
            System.out.println(reduce.orElse(""));

        }
    }
}
/*
5,8,11
5,8,9

5,8,11,3,6,8,8,-1,11,2,11,11
11,2,11,8,6,8,8,-1,8,15,3,-9,11

 */
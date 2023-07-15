package 机试.hw机试;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HJ101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String number = in.nextLine();
        String type = in.nextLine();
        List<Integer> collect = Arrays.stream(number.split(" ")).map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        if(type.equals("0")){
            collect.sort(Comparator.comparingInt(o -> o));
        }
        if(type.equals("1")){
            collect.sort((o1, o2) -> o2 - o1);
        }
        for (Integer integer : collect) {
            System.out.print(integer+" ");
        }
    }
}

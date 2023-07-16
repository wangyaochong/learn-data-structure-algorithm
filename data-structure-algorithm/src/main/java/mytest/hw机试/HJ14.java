package mytest.hw机试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer count = Integer.parseInt(in.nextLine());
        List<String> list = new ArrayList<>();
        while (count > 0) {
            list.add(in.nextLine());
            count--;
        }
        list.sort(String::compareTo);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

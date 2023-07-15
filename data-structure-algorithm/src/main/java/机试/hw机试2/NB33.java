package 机试.hw机试2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NB33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        Integer k = Integer.parseInt(split[split.length - 1]);
        s = s.substring(1, s.lastIndexOf(",")-1);
        split = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }

        List<Integer> sorted = new ArrayList<>(list);
        sorted.sort(Comparator.comparingInt(o -> o));
        Integer mid = sorted.get(list.size() / 2);
//        System.out.println(mid);


        int window = list.get(0);
        for (int i = 1; i < k; i++) {
            window = window - list.get(i);
        }
        int ans = Math.abs(mid - window);
        int loc = 0;
        for (int i = 1; i <= list.size() - k; i++) {
            window = window - list.get(i - 1)+list.get(i)*2-list.get(i+k-1);
            if(Math.abs(mid-window)<=ans){
                ans = Math.abs(mid - window);
                loc=i;
            }
        }
        System.out.println(loc);
    }
}


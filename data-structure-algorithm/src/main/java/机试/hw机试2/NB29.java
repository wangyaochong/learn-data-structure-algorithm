package 机试.hw机试2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NB29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s2 = s.split(" ");
        String stepStr = in.nextLine();
        Integer targetLevel=Integer.parseInt(s2[0]);
        Integer stepCount=Integer.parseInt(s2[1]);
        List<Integer> collect = Arrays.stream(stepStr.split(" ")).map(Integer::parseInt).collect(Collectors.toList());



    }
//    public static void sovle()

        public static boolean hasResult=false;
//    public static Integer closeLevel=;
    public static List<Integer> result = null;

}

package hw机试;

import java.util.*;
import java.util.stream.Collectors;

public class HJ58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] nums = s.split(" ");
        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);
        String arr = in.nextLine();
        String[] s1 = arr.split(" ");
        List<Integer> collect = Arrays.stream(s1).map(Integer::parseInt).sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());
        List<Integer> integers = collect.subList(0, k);
        for (Integer integer : integers) {
            System.out.print(integer+" ");
        }

    }
}

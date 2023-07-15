package 机试.hw机试2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NB025 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String count = in.nextLine();
        String arrStr = in.nextLine();
        String[] s = arrStr.split(" ");
        List<Integer> collect = Arrays.stream(s).map(Integer::parseInt).collect(Collectors.toList());
        int sum =0;
        for (Integer integer : collect) {
            sum += integer;
        }
        int leftSum=0;
        int rightSum=sum;
        int diff = Integer.MIN_VALUE;
        for(int i=0;i<collect.size();i++){
            leftSum += collect.get(i);
            rightSum -= collect.get(i);
            if (diff < Math.abs(leftSum- rightSum)) {
                diff = Math.abs(leftSum - rightSum);
            }
        }
        System.out.println(diff);
    }
}

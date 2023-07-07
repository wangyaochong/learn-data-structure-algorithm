package hw机试2;

import java.util.Arrays;
import java.util.Scanner;

public class n11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        String number = s1[0];
        int count = Integer.parseInt(s1[1]);
        char[] chars = number.toCharArray();
        Arrays.sort(chars);
        String inputSort = new String(chars);
        for (int i = 1; i <= 1000; i++) {
            StringBuilder one = new StringBuilder();
            for (int j = 0; j < count; j++) {
                one.append(i + j);
            }
            char[] tmp = one.toString().toCharArray();
            Arrays.sort(tmp);
            String tmpSort = new String(tmp);
            if(inputSort.equals(tmpSort)){
                System.out.println(i);
                break;
            }
        }
    }
}

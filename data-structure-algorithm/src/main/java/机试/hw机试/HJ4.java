package 机试.hw机试;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HJ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(s.length()==0){
            return ;
        }

        int current = 0;
        while(s.charAt(current)==' ')current++;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            count++;
            if (count == 8) {
                System.out.println();
                count = 0;
            }
        }
        if (count !=0) {
            while (count < 8) {
                System.out.print("0");
                count++;
            }
            System.out.println();
        }
    }
}

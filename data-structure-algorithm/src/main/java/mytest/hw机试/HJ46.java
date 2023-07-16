package mytest.hw机试;

import java.util.Scanner;

public class HJ46 {
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String num = in.nextLine();
        int count = Integer.parseInt(num);
        if(s.length()<count){
            System.out.println(s);
        }else{
            System.out.println(s.substring(0,count));
        }
    }
}

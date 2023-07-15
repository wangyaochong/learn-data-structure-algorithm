package 机试.hw机试;

import java.util.Scanner;

public class HJ11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for(int i=s.length()-1;i>=0;i--){
            System.out.print(s.charAt(i));
        }
        System.out.println();
    }
}

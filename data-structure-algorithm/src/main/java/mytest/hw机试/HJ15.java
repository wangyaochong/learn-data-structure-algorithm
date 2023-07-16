package mytest.hw机试;

import java.util.Scanner;

public class HJ15 {
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int count=0;
        while(i>0){
            if((i&1)==1){
                count++;
            }
            i=i>>1;
        }
        System.out.println(count);
    }
}

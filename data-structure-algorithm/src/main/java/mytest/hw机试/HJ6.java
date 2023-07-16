package mytest.hw机试;

import java.util.Scanner;

public class HJ6 {
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        long l = in.nextLong();
        int currentPrim=2;
        while(l!=1){
            if(l%currentPrim==0){
                l = l / currentPrim;
                System.out.print(currentPrim+" ");
            }else{
                if(currentPrim>Math.sqrt(l)+1){
                    System.out.println(l);
                    break;
                }
                currentPrim+=1;
            }
        }
    }
}

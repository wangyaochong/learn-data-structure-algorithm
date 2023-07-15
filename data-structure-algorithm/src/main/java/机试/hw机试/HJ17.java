package 机试.hw机试;

import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] split = line.split(";");
        int x = 0;
        int y = 0;
        for (int i = 0; i < split.length; i++) {
            String one = split[i];
            try {
                int num = Integer.parseInt(one.substring(1));
                if (one.charAt(0)=='A') {
                    x-=num;
                }
                if(one.charAt(0)=='S'){
                    y-=num;
                }
                if(one.charAt(0)=='D'){
                    x+=num;
                }
                if(one.charAt(0)=='W'){
                    y+=num;
                }
            }catch (Exception e){

            }
        }
        System.out.println(x + "," + y);
    }

}

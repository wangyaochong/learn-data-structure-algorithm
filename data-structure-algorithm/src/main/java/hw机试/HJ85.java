package hw机试;

import java.util.Scanner;

public class HJ85 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int max=0;
        for(int i=0;i<s.length()/2+2;i++){
            max = Math.max(Math.max(maxCount1(s, i), maxCount2(s, i)),max);
        }
        System.out.println(max);
    }

    public static int maxCount2(String str, int i) {
        int count = 0;
        while (i - count >= 0 && i + 1 + count < str.length() && str.charAt(i - count) == str.charAt(i + 1 + count)) {
            count++;
        }
        return count*2;
    }

    public static int maxCount1(String str, int i) {
        int count = 0;
        while (i - count >= 0 && i + count < str.length() && str.charAt(i - count) == str.charAt(i + count)) {
            count++;
        }
        return (count-1)*2+1;
    }
}

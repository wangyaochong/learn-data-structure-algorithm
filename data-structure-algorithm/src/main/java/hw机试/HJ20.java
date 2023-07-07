package hw机试;

import java.util.Scanner;

public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s == null || s.length() == 0) {
                break;
            }
            if (s.length() < 8) {
                System.out.println("NG");
                continue;
            }
            int hasNum = 0;
            int hasSmallChar = 0;
            int hasBigChar = 0;
            int other = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    hasNum = 1;
                }
                if (Character.isLetter(ch) && Character.isLowerCase(ch)) {
                    hasSmallChar = 1;
                }
                if (Character.isLetter(ch) && Character.isUpperCase(ch)) {
                    hasBigChar = 1;
                }
                if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                    other = 1;
                }
            }
            if(hasNum+hasSmallChar+hasBigChar+other<3){
                System.out.println("NG");
                continue;
            }
            if(calculateLongCommon(s)>2){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");

        }

    }

    static int calculateLongCommon(String s) {
        int max = 0;
        int dp[][] = new int[s.length() + 1][s.length() + 1];
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}

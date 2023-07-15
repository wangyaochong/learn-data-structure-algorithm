package 机试.hw机试2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B200_004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int totalCap = Integer.parseInt(in.nextLine());
        List<Integer> itemSize = Arrays.stream(s.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        int[][] dp = new int[itemSize.size()+1][totalCap + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= itemSize.size(); i++) {
            for (int j = 0; j <= totalCap; j++) {
                if (itemSize.get(i-1) <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - itemSize.get(i-1)];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[itemSize.size()][totalCap]);

    }
}

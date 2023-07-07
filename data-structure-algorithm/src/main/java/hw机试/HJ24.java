package hw机试;

import java.util.*;
import java.util.stream.Collectors;

public class HJ24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s2 = in.nextLine();

        String s = in.nextLine();
        List<Integer> input = Arrays.stream(s.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int[] up = maxUp(input);
        List<Integer> reverse = new ArrayList<>(input);
        Collections.reverse(reverse);
        int[] down = maxUp(reverse);
        int max = 0;
        for (int i = 0; i < input.size(); i++) {
            if (max < up[i] + down[input.size()-i-1]) {
                max = up[i] + down[input.size()-i-1];
            }
        }
        System.out.println(input.size() - max + 1);

    }

    public static int[] maxUp(List<Integer> input) {
        int dp[] = new int[input.size()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < input.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (input.get(i) > input.get(j)) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        return dp;
    }
}
//0 1 0 3 2 38
//186 186 150 200 160 130 197 200
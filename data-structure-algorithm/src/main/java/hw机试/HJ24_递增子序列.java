package hw机试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HJ24_递增子序列 {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(1);
        input.add(0);
        input.add(3);
        input.add(2);
        input.add(3);

        System.out.println(maxUp(input));
    }
    public static int[] maxUp(List<Integer>input){
        int dp[] = new int[input.size()];
        Arrays.fill(dp, 1);
        for(int i=1;i<input.size();i++){
            for(int j=0;j<i;j++){
                if(input.get(i)>input.get(j)){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }else{
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }
        return dp;
    }
}

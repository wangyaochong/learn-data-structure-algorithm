package leetcode.top100_01;

public class T70_climbStairs {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<n+1;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new T70_climbStairs().climbStairs(2));
        System.out.println(new T70_climbStairs().climbStairs(3));
        System.out.println(new T70_climbStairs().climbStairs(4));
    }
}

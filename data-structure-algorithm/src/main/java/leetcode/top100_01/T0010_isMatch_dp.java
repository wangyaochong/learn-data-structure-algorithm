package leetcode.top100_01;

import org.junit.Assert;
import org.junit.Test;

public class T0010_isMatch_dp {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        for(int x=0;x<s.length()+1;x++){
            dp[0][x]=true;
        }
        for(int x=0;x<p.length()+1;x++){
            dp[x][0]=true;
        }

        for (int i = 0; i < p.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
                    continue;
                }
                if (p.charAt(i) == '*') {//如果是*
                    dp[i + 1][j + 1] = dp[i + 1][j + 1] || dp[i - 1][j + 1];//匹配0个字符
                    int x = j;
                    while (x >= 0 && p.charAt(i - 1) == s.charAt(x)) {//匹配1个或多个字符
                        dp[i + 1][j + 1] = dp[i + 1][j + 1] || (dp[i - 1][x + 1] && (p.charAt(i - 1) == s.charAt(x) || p.charAt(i - 1) == '.'));
                        x--;
                    }
                }

            }
        }
        return dp[p.length()][s.length()];
    }

    @Test
    public void test() {
//        Assert.assertFalse(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
//        Assert.assertFalse(isMatch("a", ".*..a*"));
        Assert.assertTrue(isMatch("aa", "a*"));
//        Assert.assertFalse(isMatch("mississippi", "mis*is*p*."));
//        Assert.assertTrue(isMatch("ab", ".*"));
//        Assert.assertTrue(isMatch("aab", "c*a*b"));
//        Assert.assertTrue(isMatch("aa", "a*"));
//        Assert.assertFalse(isMatch("aaaba", "a.a"));
//        Assert.assertFalse(isMatch("aaaba", "a*a"));
//        Assert.assertFalse(isMatch("aa", "a"));
//        Assert.assertTrue(isMatch("aa", "aa"));
    }
}

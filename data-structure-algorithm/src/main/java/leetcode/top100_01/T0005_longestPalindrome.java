package leetcode.top100_01;

import org.junit.Test;

public class T0005_longestPalindrome {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int tmp = 0;
            while (i - tmp >= 0 && i + 1 + tmp < s.length() && s.charAt(i - tmp) == s.charAt(i + 1 + tmp)) {
                if (res.length() < (tmp + 1) * 2) {
                    res = s.substring(i - tmp, i + tmp + 1 + 1);
                }
                tmp++;
            }
            tmp = 0;
            while (i - tmp >= 0 && i + tmp < s.length() && s.charAt(i - tmp) == s.charAt(i + tmp)) {
                if (res.length() < tmp * 2 + 1) {
                    res = s.substring(i - tmp, i + tmp + 1);
                }
                tmp++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("aaaaabb"));
        System.out.println(longestPalindrome("cbbd"));
    }
}

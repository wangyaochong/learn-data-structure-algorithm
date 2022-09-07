package leetcode.top100_01;

public class T003_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int max = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            String substring = s.substring(start, i);
            int indexOf = substring.indexOf(s.charAt(i));
            if (indexOf != -1) {
                start = indexOf +start;
                dp[i] = i - start;
                start++;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

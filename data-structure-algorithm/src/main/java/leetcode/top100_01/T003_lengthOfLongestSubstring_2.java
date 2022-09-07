package leetcode.top100_01;

import org.junit.Test;

public class T003_lengthOfLongestSubstring_2 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1, start = 0;
        for (int i = 1; i < s.length(); i++) {
            String substring = s.substring(start, i);//先找出子串
            int indexOf = substring.indexOf(s.charAt(i));//判断子串是否包含当前字符
            if (indexOf != -1) {
                start = indexOf + start + 1;
            } else {
                if (max < i - start + 1) {
                    max = i - start + 1;//max就是子串的长度+当前字符的长度
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcaa"));
        System.out.println(lengthOfLongestSubstring("bbbb"));
        System.out.println(lengthOfLongestSubstring(" "));
    }
}

package leetcode.top100_01;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class T003_lengthOfLongestSubstring_2pointer {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> cache = new HashSet<>();
        while (right < s.length()) {
            char o = s.charAt(right);
            if (!cache.contains(o)) {
                cache.add(o);
                max = Math.max(max, cache.size());
            } else {
                while (cache.contains(o)&&left<right) {
                    cache.remove(s.charAt(left));
                    left++;
                }
                cache.add(o);
            }
            right++;
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring(" "));
    }
}

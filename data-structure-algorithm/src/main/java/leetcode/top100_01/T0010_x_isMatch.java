package leetcode.top100_01;

import org.junit.Assert;
import org.junit.Test;

public class T0010_x_isMatch {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0, null);
    }

    public boolean isMatch(String s, int sLoc, String p, int pLoc, Character preStar) {
        if (sLoc >= s.length() && pLoc >= p.length()) {//如果比较完毕，则匹配
            return true;
        }

        if (pLoc + 1 < p.length() && p.charAt(pLoc + 1) == '*') {
            if (isMatch(s, sLoc, p, pLoc + 2, p.charAt(pLoc))) {//匹配0个字符
                return true;
            }
            int i = sLoc;//可以匹配1个或多个字符
            while (i < s.length() && (s.charAt(i) == p.charAt(pLoc) || p.charAt(pLoc) == '.')) {
                if (isMatch(s, i, p, pLoc + 2, p.charAt(pLoc))) {//只要有一个匹配，就是真
                    return true;
                }
                i++;
            }
        }
        if (sLoc < s.length() && preStar != null && (s.charAt(sLoc) == preStar || preStar == '.')) {//*号匹配
            if (isMatch(s, sLoc + 1, p, pLoc, preStar)) return true;
        }
        if (sLoc < s.length() && pLoc < p.length() && (s.charAt(sLoc) == p.charAt(pLoc) || p.charAt(pLoc) == '.')) {//单个匹配
            return isMatch(s, sLoc + 1, p, pLoc + 1, preStar);
        }
        return false;
    }

    @Test
    public void test() {
//        Assert.assertFalse(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
//        Assert.assertFalse(isMatch("a", ".*..a*"));
//        Assert.assertTrue(isMatch("aaa", "a*a"));
//        Assert.assertFalse(isMatch("mississippi", "mis*is*p*."));
//        Assert.assertTrue(isMatch("ab", ".*"));
//        Assert.assertTrue(isMatch("aab", "c*a*b"));
        Assert.assertTrue(isMatch("aa", "a*"));
//        Assert.assertFalse(isMatch("aaaba", "a.a"));
//        Assert.assertFalse(isMatch("aaaba", "a*a"));
//        Assert.assertFalse(isMatch("aa", "a"));
//        Assert.assertTrue(isMatch("aa", "aa"));
    }
}

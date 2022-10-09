package leetcode.top100_01;

import org.junit.Assert;
import org.junit.Test;

public class T010_isMatct_rec {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int sLoc, String p, int pLoc) {
        if (s.length() == sLoc && p.length() == pLoc) {
            return true;
        }

        if (pLoc + 1 < p.length() && p.charAt(pLoc + 1) == '*') {//如果后面是*，则可以匹配0个或N个字符
            if (isMatch(s, sLoc, p, pLoc + 2)) {//匹配0个字符
                return true;
            }
            if (sLoc < s.length() && (s.charAt(sLoc) == p.charAt(pLoc) || p.charAt(pLoc) == '.')) {//匹配N个字符

                return isMatch(s, sLoc + 1, p, pLoc);//这里没有使用循环，可以移动一位后，再次调用isMatch
            }
        }
        if ((pLoc < p.length() && p.charAt(pLoc) == '.') || (sLoc < s.length() && pLoc < p.length() && s.charAt(sLoc) == p.charAt(pLoc))) {
            return isMatch(s, sLoc + 1, p, pLoc + 1);
        }
        return false;
    }

    @Test
    public void test() {
//        Assert.assertTrue(isMatch("aa", "a"));
//        Assert.assertTrue(isMatch("aa", "a."));
//        Assert.assertTrue(isMatch("aaa", "a.a"));
//        Assert.assertTrue(isMatch("aa", "aa."));
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

package leetcode.top100_01;

import org.junit.Assert;
import org.junit.Test;

public class T010_isMatct_rec_with_cache {
    public boolean isMatch(String s, String p) {
        cache = new int[100][100];
        return isMatch(s, 0, p, 0);
    }

    int[][] cache;

    public boolean isMatch(String s, int sLoc, String p, int pLoc) {
        if (cache[sLoc][pLoc] != 0) {
            return cache[sLoc][pLoc] == 1;
        }
        if (s.length() == sLoc && p.length() == pLoc) {
            cache[sLoc][pLoc] = 1;
            return true;
        }

        if (pLoc + 1 < p.length() && p.charAt(pLoc + 1) == '*') {//如果后面是*，则可以匹配0个或N个字符
            if (isMatch(s, sLoc, p, pLoc + 2)) {//匹配0个字符
                cache[sLoc][pLoc] = 1;
                return true;
            }
            if (sLoc < s.length() && (s.charAt(sLoc) == p.charAt(pLoc) || p.charAt(pLoc) == '.')) {//匹配N个字符
                boolean match = isMatch(s, sLoc + 1, p, pLoc);
                if(match){
                    cache[sLoc][pLoc] = 1;
                }else{
                    cache[sLoc][pLoc] = -1;
                }
                return match;
            }
        }
        if ((pLoc < p.length() && p.charAt(pLoc) == '.') || (sLoc < s.length() && pLoc < p.length() && s.charAt(sLoc) == p.charAt(pLoc))) {
            boolean match = isMatch(s, sLoc + 1, p, pLoc + 1);
            if(match){
                cache[sLoc][pLoc] = 1;
            }else{
                cache[sLoc][pLoc] = -1;
            }
            return match;
        }
        cache[sLoc][pLoc] = -1;
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

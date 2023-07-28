package leetcode.byNumber.p100;

import org.junit.Test;

public class p97_InterleavingString_practice {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return getResult(s1, 0, s2, 0, s3, 0, new Boolean[s1.length()+1][s2.length()+1]);
    }

    public boolean getResult(String s1, int loc1, String s2, int loc2, String s3, int loc3, Boolean[][] cache) {
        if (cache[loc1][loc2] != null) {
            return cache[loc1][loc2];
        }
        if (s1.length() == loc1 && s2.length() == loc2 && s3.length() == loc3) {
            return true;
        }
        boolean r1 = false;
        if (loc1 < s1.length() && loc3 < s3.length() && s1.charAt(loc1) == s3.charAt(loc3)) {
            r1 = getResult(s1, loc1 + 1, s2, loc2, s3, loc3 + 1, cache);
        }
        if (r1) {
            cache[loc1][loc2] = true;
            return true;
        }
        boolean r2 = false;
        if (loc2 < s2.length() && loc3 < s3.length() && s2.charAt(loc2) == s3.charAt(loc3)) {
            r2 = getResult(s1, loc1, s2, loc2 + 1, s3, loc3 + 1, cache);
        }
        cache[loc1][loc2] = r2;
        return cache[loc1][loc2];
    }


    @Test
    public void test() {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}

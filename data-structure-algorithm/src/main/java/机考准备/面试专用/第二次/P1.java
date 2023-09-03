package 机考准备.面试专用.第二次;

public class P1 {
    public static void main(String[] args) {
        System.out.println(isSub("ahbgdc", "abc"));
        System.out.println(isSub("ahbgdc", "axc"));
        System.out.println(isSub("abc", "abc"));
        System.out.println(isSub("abc", ""));
    }


    public static boolean isSub(String t, String s) {
        int sLoc = 0;
        int tLoc = 0;
        while (sLoc < t.length() && tLoc < s.length()) {
            if (t.charAt(sLoc) == s.charAt(tLoc)) {
                sLoc++;
                tLoc++;
            } else {
                sLoc++;
            }
        }
        return tLoc == s.length();

    }


}

package leetcode.byNumber.p300;

public class p201_BitwiseANDofNumbersRange_会超时 {

    public int rangeBitwiseAnd(int m, int n) {
        int result = m;
        for (int i = m + 1; i <= n; i++) {
            result &= i;
        }
        return result;
    }
}

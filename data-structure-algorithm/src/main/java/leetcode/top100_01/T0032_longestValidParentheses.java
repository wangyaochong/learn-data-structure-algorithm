package leetcode.top100_01;

public class T0032_longestValidParentheses {
    public int longestValidParentheses(String s) {
        int leftMismatch = 0;
        int maxLength = 0;
        int tmpLength = 0;
        int[] cache = new int[s.length()];//记录右边有多少括号，只要右括号比左括号多，则一定能匹配
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                count = 0;
            }
            cache[i] = count;

        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftMismatch++;
                if (i + 1 < s.length() && cache[i + 1] <= 0) {
                    // 如果不能匹配，那tmpLength=0，能否匹配不能leftMismatch不等于0，
                    // 而是下标的右侧没有多余的右括号
                    tmpLength = 0;
                }
            }
            if (s.charAt(i) == ')') {
                if (leftMismatch > 0) {
                    leftMismatch--;
                    tmpLength = tmpLength + 2;
                    if (maxLength < tmpLength) {
                        maxLength = tmpLength;
                    }
                } else {
                    tmpLength = 0;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int i = new T0032_longestValidParentheses().longestValidParentheses(")()(((())))(");
//        int i = new T032_longestValidParentheses().longestValidParentheses("()");
//        int i2 = new T032_longestValidParentheses().longestValidParentheses("()()");
//        int i3 = new T032_longestValidParentheses().longestValidParentheses("(()(()()");
//        int i4 = new T032_longestValidParentheses().longestValidParentheses("(()(()()))");
        System.out.println("");
    }
}

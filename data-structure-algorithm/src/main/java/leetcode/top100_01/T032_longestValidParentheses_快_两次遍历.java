package leetcode.top100_01;

public class T032_longestValidParentheses_快_两次遍历 {
    public int longestValidParentheses(String s) {
        int left=0;
        int right=0;
        int maxCount=0;
        for(int i=0;i<s.length();i++){//从左往右
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                if(maxCount<left*2){
                    maxCount = left*2;
                }
            }
            if(right>left){
                right=left=0;
            }
        }
        left=right=0;
        for(int i=s.length()-1;i>=0;i--){//从右往左
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                if(maxCount<left*2){
                    maxCount = left*2;
                }
            }
            if(right<left){
                right=left=0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int i = new T032_longestValidParentheses_快_两次遍历().longestValidParentheses(")()(((())))(");
//        int i = new T032_longestValidParentheses().longestValidParentheses("()");
//        int i2 = new T032_longestValidParentheses().longestValidParentheses("()()");
//        int i3 = new T032_longestValidParentheses().longestValidParentheses("(()(()()");
//        int i4 = new T032_longestValidParentheses().longestValidParentheses("(()(()()))");
        System.out.println("");
    }
}

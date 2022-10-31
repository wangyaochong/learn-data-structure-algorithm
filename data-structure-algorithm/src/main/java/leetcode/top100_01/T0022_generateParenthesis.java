package leetcode.top100_01;

import java.util.ArrayList;
import java.util.List;

public class T0022_generateParenthesis {
    public static void main(String[] args) {
        List<String> strings = new T0022_generateParenthesis().generateParenthesis(3);
        System.out.println(strings);
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getResult(n, n,0,0, result, "");
        return result;
    }
    public void getResult(int leftCount,int rightCount,int leftPut,int rightPut,List<String> result,String current){
        if(leftCount==0&&rightCount==0){
            if(!current.equals("")){
                result.add(current);
            }
            return ;
        }

        if(leftCount>0){
            getResult(leftCount-1,rightCount,leftPut+1,rightPut,result,current+"(");
        }
        if(rightCount>0&&leftPut>rightPut){
            getResult(leftCount, rightCount - 1, leftPut, rightPut + 1, result, current + ")");
        }
    }
}

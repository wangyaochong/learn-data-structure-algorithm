package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class p739_dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        LinkedList<Integer> st = new LinkedList<>();
        for(int i=0;i<temperatures.length;i++){
            if(st.size()==0){
                st.add(i);
            }else{
                while(!st.isEmpty() &&temperatures[i]>temperatures[st.getLast()]){
                    result[st.getLast()] = i - st.getLast();
                    st.removeLast();
                }
                st.addLast(i);
            }
        }
        return result;
    }
    @Test
    public void test(){
        int[] ints = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }

}

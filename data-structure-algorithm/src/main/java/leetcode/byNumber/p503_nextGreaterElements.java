package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class p503_nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        LinkedList<Integer> st = new LinkedList<>();
        int[] tmp = new int[nums.length];
        Arrays.fill(tmp, -1);
        for (int i = 0; i < nums.length*2; i++) {
            if (st.isEmpty()) {
                st.addLast(i%nums.length);
            } else {
                while (!st.isEmpty() && nums[i%nums.length] > nums[st.getLast()]) {
                    tmp[st.getLast()] = nums[i%nums.length];
                    st.removeLast();
                }
                st.add(i%nums.length);
            }
        }
        return tmp;
    }
    @Test
    public void test(){
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,3,4,3})));
    }
}

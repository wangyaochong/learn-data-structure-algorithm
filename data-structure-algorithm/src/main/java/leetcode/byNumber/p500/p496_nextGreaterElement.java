package leetcode.byNumber.p500;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class p496_nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        LinkedList<Integer> st = new LinkedList<>();
        int[] tmp = new int[nums2.length];
        Arrays.fill(tmp, -1);

        Map<Integer, Integer> valueLocMap = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            valueLocMap.put(nums2[i], i);
            if(st.isEmpty()){
                st.addLast(i);
            }else{
                while(!st.isEmpty()&&nums2[i]>nums2[st.getLast()]){
                    tmp[st.getLast()] = nums2[i];
                    st.removeLast();
                }
                st.add(i);
            }
        }
        int[] r = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            r[i] = tmp[valueLocMap.get(nums1[i])];
        }
        return r;
    }

    @Test
    public void test(){
        int[] nums1 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, nums1)));
    }
}

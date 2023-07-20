package leetcode.byNumber.p100;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class p84_LargestRectangleinHistogram_单调栈解法 {
    public int largestRectangleArea(int[] heights) {

        int[] rightMin = getRightMin(heights);
        int[] leftMin = getLeftMin(heights);

        System.out.println("rightMin=" + Arrays.toString(rightMin));
        System.out.println(" leftMin=" + Arrays.toString(leftMin));
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (rightMin[i] - leftMin[i] + 1) * heights[i]);
        }
        return max;
    }

    public int[] getLeftMin(int[] heights) {//找到左边第一个比当前小的坐标
        LinkedList<Integer> st = new LinkedList<>();
        int[] result = new int[heights.length];
        Arrays.fill(result, 0);
        for (int i = heights.length - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                st.addLast(i);
            } else {
                while (!st.isEmpty() && heights[st.getLast()] > heights[i]) {
                    result[st.getLast()] = i + 1;
                    st.removeLast();
                }
                st.addLast(i);
            }
        }
        return result;
    }

    public int[] getRightMin(int[] heights) {//找到左边第一个比当前小的坐标
        LinkedList<Integer> st = new LinkedList<>();
        int[] result = new int[heights.length];
        Arrays.fill(result, result.length - 1);
        for (int i = 0; i < heights.length; i++) {
            if (st.isEmpty()) {
                st.addLast(i);
            } else {
                while (!st.isEmpty() && heights[st.getLast()] > heights[i]) {
                    result[st.getLast()] = i - 1;
                    st.removeLast();
                }
                st.addLast(i);
            }
        }
        return result;
    }


    @Test
    public void test() {

        int[] heights = {3, 1, 2, 5, 4, 3};
        int i = largestRectangleArea(heights);
        System.out.println(i);
    }


}

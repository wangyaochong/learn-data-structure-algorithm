package leetcode.top100_01;

public class T011_maxArea {
    public int maxArea(int[] height) {
        int max = 0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int tmp = Math.min(height[left], height[right]) * (right - left);
            if(max<tmp){
                max=tmp;
            }
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}

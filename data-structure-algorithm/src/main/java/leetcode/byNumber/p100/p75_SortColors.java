package leetcode.byNumber.p100;

import org.junit.Test;

import java.util.Arrays;

public class p75_SortColors {

    @Test
    public void test(){
        int[] nums = {2, 1,2,0,0, 2, 1, 1, 0};
        sortColors(nums);
//        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int leftLoc=0;
        int rightLoc=nums.length-1;
        while(leftLoc<rightLoc){
            while(leftLoc<rightLoc&&nums[leftLoc]==0){
                leftLoc++;
            }
            while(leftLoc<rightLoc&&nums[rightLoc]!=0){
                rightLoc--;
            }
            swap(nums,leftLoc,rightLoc);
            leftLoc++;
            rightLoc--;
        }
        leftLoc=0;
        rightLoc=nums.length-1;

        while(leftLoc<rightLoc){
            while(leftLoc<rightLoc&&nums[leftLoc]!=2){
                leftLoc++;
            }
            while(leftLoc<rightLoc&&nums[rightLoc]==2){
                rightLoc--;
            }
            swap(nums,leftLoc,rightLoc);
            leftLoc++;
            rightLoc--;
        }


    }
    public void swap(int[]nums,int a,int b){
        int tmp = nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
}

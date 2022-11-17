package leetcode.top100_01;

/**
 * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
 * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
 * 只搜索有序的部分即可。
 */

public class T33_search {

    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start+1)/2;
            if(nums[start]<nums[mid]){
                int i = binSearch(nums, start, mid, target);
                if(i==-1){
                    start=mid+1;
                }else{
                    return i;
                }
            }else{
                int i = binSearch(nums, mid, end, target);
                if(i==-1){
                    end=mid-1;
                }else{
                    return i;
                }
            }
        }
        return -1;
    }
    public int binSearch(int[]nums,int start,int end,int target){
        while(start<=end){
            int mid=start+(end-start+1)/2;
            if(target<nums[mid]){
                end=mid-1;
            }else if(target>nums[mid]){
                start=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {3,1};
//        int i = new T033_search().binSearch(nums, 0, nums.length-1, 5);
        int j = new T33_search().search(nums, 3);
//        System.out.println(i);
        System.out.println(j);
    }
}

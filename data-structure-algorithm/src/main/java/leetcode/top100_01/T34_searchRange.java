package leetcode.top100_01;

import java.util.Arrays;

public class T34_searchRange {
    /**
     * 比如 1、2、3、3、3、4、5，通过二分查找定位到3的下标是4，
     * 则左半部分是1,2,3,3，右半部分是3,3,4,5，
     * 可以通过依次跳一半的方式来去除不是3的数字
     * @param args
     */

    public static void main(String[] args) {
        int[] ints = new T34_searchRange().searchRange(new int[]{1, 2, 2, 2, 3, 4}, 2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int loc = -1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start + 1) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                loc = mid;
                break;
            }
        }
        if (loc == -1) {
            return new int[]{-1, -1};
        }
        int resultStart = 0;
        int resultEnd = 0;
        start = 0;
        int tmp = loc;
        while (start <= tmp) {
            mid = start + (tmp - start + 1) / 2;
            if (nums[tmp] == nums[mid]) {
                tmp = mid - 1;
                if (tmp >= 0 && nums[tmp] != nums[loc]) {
                    break;
                }
            } else {
                start = mid + 1;
            }
        }
        resultStart = mid;
        tmp = loc;
        end = nums.length - 1;
        while (tmp <= end) {
            mid = tmp + (end - tmp + 1) / 2;
            if (nums[tmp] == nums[mid]) {
                tmp = mid + 1;
                if (tmp < nums.length && nums[tmp] != nums[loc]) {
                    break;
                }
            } else {
                end = mid - 1;
            }
        }
        resultEnd = mid;
        return new int[]{resultStart, resultEnd};
    }
}

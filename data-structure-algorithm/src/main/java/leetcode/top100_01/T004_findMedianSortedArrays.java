package leetcode.top100_01;

import org.junit.Test;

public class T004_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 0) {
            int left = find(nums1, 0, nums2, 0, length / 2);
            int right = find(nums1, 0, nums2, 0, length / 2 + 1);
            return (left + right) / 2.0;
        } else {
            return find(nums1, 0, nums2, 0, length / 2 + 1);
        }
    }

    public int find(int[] nums1, int loc1, int[] nums2, int loc2, int k) {
        if (nums1.length - loc1 > nums2.length - loc2) {
            return find(nums2, loc2, nums1, loc1, k);
        }
        if (nums1.length == loc1) {
            return nums2[loc2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[loc1], nums2[loc2]);
        }
        int n1Loc = Math.min(nums1.length, loc1 + k / 2);
        int n2Loc = loc2 + k - k / 2;
        if (nums1[n1Loc - 1] < nums2[n2Loc - 1]) {
            return find(nums1, n1Loc, nums2, loc2, k - (n1Loc - loc1));
        } else {
            return find(nums1, loc1, nums2, n2Loc, k - (n2Loc - loc2));
        }
    }

    @Test
    public void test() {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(medianSortedArrays);
    }
}

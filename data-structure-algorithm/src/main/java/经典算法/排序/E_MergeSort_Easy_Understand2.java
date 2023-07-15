package 经典算法.排序;

import org.junit.Test;
import util.UtilArray;


public class E_MergeSort_Easy_Understand2 {


    public int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int rLoc = 0;
        int aLoc = 0;
        int bLoc = 0;
        while (aLoc < a.length || bLoc < b.length) {
            if (bLoc == b.length || (aLoc < a.length && a[aLoc] < b[bLoc])) {
                result[rLoc] = a[aLoc];
                rLoc++;
                aLoc++;
            } else {
                result[rLoc] = b[bLoc];
                rLoc++;
                bLoc++;
            }
        }
        return result;
    }
    public int[] divide(int[] a){
        if(a.length==1) return a;
        int mid=a.length/2;
        int[] left = new int[mid];
        int[] right = new int[a.length - mid];
        System.arraycopy(a, 0, left, 0, mid);
        System.arraycopy(a, mid, right, 0, a.length - mid);
        return merge(divide(left), divide(right));
    }

    @Test
    public void testMerge() {
//        UtilArray.display(merge(new int[]{1, 3, 5}, new int[]{2, 4, 65}));
        int[] merge = divide(new int[]{1, 2, 5, 3, 6, 2, 11, -1});
        UtilArray.display(merge);
    }


}

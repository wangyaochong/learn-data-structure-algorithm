package leetcode.byNumber.i16;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class _16smallestDifference_2 {
    static class Tmp{
        int num;
        int type;

        public Tmp(int num, int type) {
            this.num = num;
            this.type = type;
        }
    }
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        long min = Long.MAX_VALUE;
        while(i<a.length&&j<b.length){
            if(a[i]==b[j])return 0;
            else if(a[i]>b[j]){
                min = Math.min(min, (long)a[i] - (long)b[j]);
                j++;
            }else{
                min = Math.min(min, (long)b[j] - (long)a[i]);
                i++;
            }
        }
        return (int) min;
    }
    @Test
    public void test(){
        int i = smallestDifference(new int[]{-2147483648, 1}, new int[]{2147483647, 0});
        System.out.println(i);
    }
}

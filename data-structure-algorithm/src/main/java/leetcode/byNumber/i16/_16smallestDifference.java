package leetcode.byNumber.i16;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class _16smallestDifference {
    static class Tmp{
        int num;
        int type;

        public Tmp(int num, int type) {
            this.num = num;
            this.type = type;
        }
    }
    public int smallestDifference(int[] a, int[] b) {
        List<Tmp> one = new ArrayList<>();

        List<Tmp> collect = Arrays.stream(a).mapToObj(e -> new Tmp(e, 1)).collect(Collectors.toList());

        one.addAll(collect);
        one.addAll(Arrays.stream(b).mapToObj(e -> new Tmp(e, 2)).collect(Collectors.toList()));
        one.sort(Comparator.comparingInt(o -> o.num));
        long min = Long.MAX_VALUE;
        for(int i=1;i<one.size();i++){
            long distance = (long)one.get(i).num - (long)one.get(i - 1).num;
            if(one.get(i).type!=one.get(i-1).type&& distance <min){
                min = distance;
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

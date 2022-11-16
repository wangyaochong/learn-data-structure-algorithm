package leetcode.top100_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T0056_merge {


    public static class MergeResult {
        int left;
        int right;
        int nextStartLoc;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int currentLoc = 0;
        List<int[]> result = new ArrayList<>(1024);
        while (currentLoc < intervals.length) {
            MergeResult mergeResult = mergeOne(intervals, currentLoc);
            if (mergeResult == null) {
                result.add(intervals[currentLoc]);
                currentLoc++;
            } else {
                result.add(new int[]{mergeResult.left, mergeResult.right});
                currentLoc = mergeResult.nextStartLoc;
            }
        }
        return result.toArray(new int[result.size()][2]);
//        int[][] resultArr = new int[result.size()][2];
//        for (int i = 0; i < resultArr.length; i++) {
//            resultArr[i] = result.get(i);
//        }
//        return resultArr;
    }

    //如果mergeResult=null，则说明没有合并的
    public MergeResult mergeOne(int[][] intervals, int currentLoc) {
        if (currentLoc >= intervals.length) {
            return null;
        }
        int currentLeft = intervals[currentLoc][0];
        int currentRight = intervals[currentLoc][1];
        boolean hasMerge = false;
        currentLoc++;
        while (currentLoc < intervals.length) {
            int[] b = intervals[currentLoc];
            if (currentRight >= b[0]) {//说明有重合
                currentLeft = Math.min(currentLeft, b[0]);
                currentRight = Math.max(currentRight, b[1]);
                hasMerge = true;
            } else {
                break;
            }
            currentLoc++;
        }
        if (!hasMerge) return null;
        MergeResult mergeResult = new MergeResult();
        mergeResult.left = currentLeft;
        mergeResult.right = currentRight;
        mergeResult.nextStartLoc = currentLoc;
        return mergeResult;
    }

    public static void main(String[] args) {
        int[][] merge = new T0056_merge().merge(new int[][]{{1, 2}, {2, 4}, {5, 6}});
        System.out.println(Arrays.deepToString(merge));
    }
}

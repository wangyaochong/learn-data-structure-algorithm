package 机考准备.面试专用.第一次;

import java.util.HashMap;
import java.util.Map;

public class P1_ {
     public static void main(String[] args) {
         System.out.println("ok");
        System.out.println(solve(new int[]{1, 2, 1, 2, 3, 1}, 3));
//        System.out.println(solve(new int[]{5, 8, 8, 5}, 2));
    }

    public static int solve(int[] task, int space) {
        Map<Integer, Integer> typeDayLeft = new HashMap<>();
        int totalDayCount = 0;
        for (int i = 0; i < task.length; i++) {
            Integer LeftDayCount = typeDayLeft.get(task[i]);
            if (LeftDayCount == null) {
                typeDayLeft.put(task[i], space+1);
                totalDayCount += 1;
                System.out.println("参数为空，不用休息，执行任务" + (i ));
            } else {
                if (LeftDayCount == 0) {
                    totalDayCount += 1;
                    typeDayLeft.put(task[i], space+1);
                    System.out.println("参数为0，不用休息，执行任务" + (i ));

                } else {
                    totalDayCount += LeftDayCount;
                    typeDayLeft.put(task[i], 0);
                    System.out.println("休息" + LeftDayCount + "天" + "执行任务" + (i ));
                }
            }
            for (Map.Entry<Integer, Integer> entry : typeDayLeft.entrySet()) {
                Integer TmpDayLeft = typeDayLeft.get(entry.getKey());
                if (TmpDayLeft != null && TmpDayLeft > 0) {
                    typeDayLeft.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }
        return totalDayCount;
    }
}

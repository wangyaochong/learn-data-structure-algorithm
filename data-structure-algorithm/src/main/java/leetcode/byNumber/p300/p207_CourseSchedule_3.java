package leetcode.byNumber.p300;

import com.sun.security.auth.module.KeyStoreLoginModule;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class p207_CourseSchedule_3 {
    /**
     * 总体思路是使用拓扑排序
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length==0){
            return true;
        }

        Map<Integer, Integer> depCount = new HashMap<>();//入度数量
        Map<Integer, Set<Integer>> depNums = new HashMap<>();//记录依赖的数字集合，比如1-0,2-0,则set是1和2，表示1和2依赖0

        Set<Integer> all = new HashSet<>();
        for(int i=0;i<numCourses;i++){
            all.add(i);
        }
        for (int[] prerequisite : prerequisites) {

            depCount.putIfAbsent(prerequisite[0], 0);
            Integer integer = depCount.get(prerequisite[0]);
            depCount.put(prerequisite[0], integer + 1);


            depNums.putIfAbsent(prerequisite[1], new HashSet<>());
            depNums.get(prerequisite[1]).add(prerequisite[0]);

//            all.add(prerequisite[0]);//记录所有的节点
//            all.add(prerequisite[1]);
        }
        LinkedList<Integer> toRemove = new LinkedList<>();

        for (Integer integer : all) {
            if(depCount.get(integer)==null){
                toRemove.add(integer);
            }
        }



        int count = 0;

        while (toRemove.size() != 0) {
            while (!toRemove.isEmpty()) {
                Integer integer = toRemove.removeFirst();
                Set<Integer> numToDecCount = depNums.get(integer);//需要减掉依赖项数量的候选
                count++;
                if (numToDecCount != null) {
                    for (Integer tmp : numToDecCount) {
                        Integer oneDependent = depCount.get(tmp);
                        if (oneDependent == 0) {
                            depCount.remove(integer);
                        } else {
                            depCount.put(tmp, oneDependent - 1);
                        }
                    }
                }
            }

            Iterator<Map.Entry<Integer, Integer>> iterator = depCount.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() == 0) {
                    toRemove.add(entry.getKey());
                    iterator.remove();
                }
            }
        }
        return count == numCourses;
    }

    @Test
    public void test() {
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(5, new int[][]{{1, 0}}));
    }
}

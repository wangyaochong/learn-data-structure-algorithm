package leetcode.top100_01;

import java.util.ArrayList;
import java.util.List;

public class T0046_permute {
    public static void main(String[] args) {
        List<List<Integer>> permute = new T0046_permute().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> objects = new ArrayList<>();
        for (int num : nums) {
            objects.add(num);
        }
        solve(objects,new ArrayList<>(), result);
        return result;
    }
    public void solve(List<Integer> candidate,List<Integer> current,List<List<Integer>> result){
        if(candidate.size()==0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<candidate.size();i++){
            Integer remove = candidate.remove(i);
            current.add(remove);
            solve(candidate, current, result);
            current.remove(current.size() - 1);
            candidate.add(i, remove);
        }
    }
}

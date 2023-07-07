package hw机试;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        List<Integer> list=new ArrayList<>();
        while(count>0){
            list.add(in.nextInt());
            count--;
        }
        list.sort(Comparator.comparingInt(o -> o));
        List<Integer> result = new ArrayList<>();
        result.add(list.get(0));
        for(int i=1;i<list.size();i++){
            if(result.get(result.size()-1)!=list.get(i)){
                result.add(list.get(i));
            }
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }

    }
}

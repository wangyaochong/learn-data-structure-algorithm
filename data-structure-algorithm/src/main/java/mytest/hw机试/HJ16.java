package mytest.hw机试;

import java.util.*;

public class HJ16 {
    public static class Goods {
        Integer price;
        Integer type;
        Integer majorCategory;
        Integer weight;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s1 = in.nextLine().split(" ");
        Integer amount = Integer.parseInt(s1[0]);
        Integer count = Integer.parseInt(s1[1]);
        int category = 1;
        List<Goods> goods = new ArrayList<>();
        while (count > 0) {
            String s = in.nextLine();
            String[] s2 = s.split(" ");
            Goods e = new Goods();
            e.price = Integer.parseInt(s2[0]);
            e.weight = Integer.parseInt(s2[1]);
            e.type = Integer.parseInt(s2[2]);
            e.majorCategory = category;
            goods.add(e);
            count--;
            category++;
        }
        goods.sort(Comparator.comparingLong(o -> o.type));
        solve(goods,new ArrayList<>(), new HashSet<>(), 0, amount);
        System.out.println(maxValue);
    }

    static Integer maxValue = 0;

    public static void solve(List<Goods> candidate, List<Goods> have, Set<Integer> buyMajor, Integer currentWeight, Integer currentAmount) {
        if (maxValue < currentWeight) {
           // System.out.println(have);
            maxValue = currentWeight;
        }
        for (int i = 0; i < candidate.size(); i++) {
            if (currentAmount >= candidate.get(i).price) {
                if (candidate.get(i).type == 0 || buyMajor.contains(candidate.get(i).type)) {
                    Goods remove = candidate.remove(i);
                    buyMajor.add(remove.majorCategory);
                    have.add(remove);
                    solve(candidate,have, buyMajor, currentWeight + remove.weight*remove.price, currentAmount - remove.price);
                    buyMajor.remove(remove.majorCategory);
                    candidate.add(i, remove);
                    have.remove(remove);
                }
            }
        }
    }
}
/*
50 5
20 3 5
20 3 5
10 3 0
10 2 0
10 1 0


1000 5
800 2 0
400 5 1
300 5 1
400 3 0
500 2 0
 */
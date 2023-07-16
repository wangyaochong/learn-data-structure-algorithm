package mytest.hw机试;

import java.util.*;

public class HJ16dp {
    public static class Goods {
        Integer price;
        Integer type;
        Integer majorCategory;
        Integer weight;
        Goods a1;
        Goods a2;
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
        goods.forEach(e -> e.price /= 10);//先把价格/10
        assGoods(goods);
        goods.removeIf(e -> e.type != 0);//移除附件
//        System.out.println(goods);
        amount/=10;
        int dp[][] = new int[goods.size()+1][amount+1];
        for (int i = 1; i < goods.size() + 1; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];//不选
                Goods g = goods.get(i-1);
                if (j >= g.price)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - g.price] + g.weight * g.price);
                if (g.a1 != null && j >= g.price + g.a1.price)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - g.price - g.a1.price] + g.weight * g.price + g.a1.weight * g.a1.price);
                if (g.a2 != null && j >= g.price + g.a2.price)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - g.price - g.a2.price] + g.weight * g.price + g.a2.weight * g.a2.price);
                if (g.a1 != null && g.a2 != null && j >= g.price + g.a1.price + g.a2.price)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - g.price - g.a1.price - g.a2.price] + g.weight * g.price +
                            g.a1.weight * g.a1.price + g.a2.weight * g.a2.price);
            }
        }
        System.out.println(dp[goods.size()][amount]*10);
    }

    public static void assGoods(List<Goods> goods) {
        goods.sort(Comparator.comparingLong(o -> o.type));
        for (int i = goods.size() - 1; i >= 0; i--) {
            Goods g = goods.get(i);
            if (g.type == 0) {
                break;
            } else {
                for (int j = 0; j < goods.size(); j++) {
                    Goods major = goods.get(j);
                    if (major.majorCategory == g.type) {
                        if (major.a1 == null) {
                            major.a1 = g;
                            break;
                        } else if (major.a2 == null) {
                            major.a2 = g;
                            break;
                        } else {
                            throw new RuntimeException("附件关联错误");
                        }
                    }
                }
            }
        }

    }
}

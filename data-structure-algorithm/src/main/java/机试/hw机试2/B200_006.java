package 机试.hw机试2;

import java.util.*;

public class B200_006 {
    static class Goods {
        int price;
        int relia;

        public Goods(int price, int relia) {
            this.price = price;
            this.relia = relia;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s1 = in.nextLine().split(" ");
        Integer money = Integer.parseInt(s1[0]);
        Integer type = Integer.parseInt(s1[1]);
        Integer totalCount = Integer.parseInt(in.nextLine());
        Map<Integer, List<Goods>> typeGoodsMap = new HashMap<>();
        while (totalCount > 0) {
            String[] typeGoodsPrice = in.nextLine().split(" ");
            int tmpType = Integer.parseInt(typeGoodsPrice[0]);
            int tmpRelia = Integer.parseInt(typeGoodsPrice[1]);
            int tmpPrice = Integer.parseInt(typeGoodsPrice[2]);
            typeGoodsMap.putIfAbsent(tmpType, new LinkedList<>());
            List<Goods> goods = typeGoodsMap.get(tmpType);
            goods.add(new Goods(tmpPrice, tmpRelia));
            totalCount--;
        }
        int dp[][] = new int[type + 1][money + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                List<Goods> goods = typeGoodsMap.get(i - 1);
                for (Goods good : goods) {
                    if (good.price <= j) {
                        dp[i][j] = Math.max(dp[i][j], Math.min(dp[i - 1][j - good.price], good.relia));
                    }
                }
            }
        }
        if(dp[type][money]==0||dp[type][money]==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(dp[type][money]);
        }
    }
}


    /*

0 3
6
0 80 100
0 90 200
1 50 50
1 70 210
2 50 100
2 60 150


500 3
6
0 80 100
0 90 200
1 50 50
1 70 210
2 50 100
2 60 150
     */

    /*

100 1
1
0 90 200

     */
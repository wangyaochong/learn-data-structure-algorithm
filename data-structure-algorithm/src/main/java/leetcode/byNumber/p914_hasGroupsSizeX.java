package leetcode.byNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p914_hasGroupsSizeX {
    @Test
    public void test() {
        System.out.println(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(hasGroupsSizeX(new int[]{1,1,1,1,2,2,2,2,2,2}));
//        System.out.println(hasGroupsSizeX(new int[]{1}));
    }

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        Arrays.sort(deck);
        List<Integer> countList = new ArrayList<>();
        int count = 1;
        int loc = 1;
        while (loc < deck.length && deck[loc] == deck[loc - 1]) { //计算出一组卡牌的长度
            count++;
            loc++;
        }
        countList.add(count);
        if (count == deck.length) {//不是一组，继续
            return true;
        }
        loc++;

        while (loc < deck.length) {
            int tmpCount = 1;
            while (loc < deck.length && deck[loc] == deck[loc - 1]) {
                loc++;
                tmpCount++;
            }
            countList.add(tmpCount);
            loc++;
        }
        loc = 1;
        while (loc < countList.size() && countList.get(loc) % countList.get(loc - 1) == 0) {
            loc++;
        }

        Integer integer = countList.get(0);
        for(int i = 2; i<= integer; i++){
            int j;
            for(j=0;j<countList.size();j++){
                if(countList.get(j)%i!=0){
                    break;
                }
            }
            if(j==countList.size()){
                return true;
            }
        }

        return false;
    }
}

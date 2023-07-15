package 机试.hw机试;

import java.awt.*;
import java.util.*;
import java.util.List;

public class HJ26 {
    public static class ChLoc {
        Character c;
        int loc;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        List<ChLoc> chList = new ArrayList<>();
        List<Character> all = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            all.add(c);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                ChLoc chLoc = new ChLoc();
                chLoc.loc = i;
                chLoc.c = c;
                chList.add(chLoc);
            }
        }
        chList.sort(Comparator.comparing(o -> (""+o.c).toUpperCase()));//先不区分大小写排序

        Map<String, List<ChLoc>> chSortMap = new HashMap<>();//记录每个字符各自的顺序
        for (ChLoc chLoc : chList) {
            chSortMap.putIfAbsent((""+chLoc.c).toUpperCase(), new ArrayList<>());
            chSortMap.get((("" + chLoc.c).toUpperCase())).add(chLoc);
        }
        for (Map.Entry<String, List<ChLoc>> entry :  chSortMap.entrySet()) {
            entry.getValue().sort(Comparator.comparingInt(o -> o.loc));
        }


        int sortLoc=0;
        for(int i=0;i<all.size();i++){//填充，固定非字母
            Character c = all.get(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                ChLoc chLoc = chList.get(sortLoc);
                all.set(i, chLoc.c);
                sortLoc++;
            }
        }


        for (int i = 0; i < all.size(); i++) {//每个字母内部重排序
            Character c = all.get(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                ChLoc chLoc = chSortMap.get(("" + c).toUpperCase()).remove(0);
                all.set(i, chLoc.c);
            }
        }
        for(int i=0;i<all.size();i++){
            System.out.print(all.get(i));
        }
    }
}

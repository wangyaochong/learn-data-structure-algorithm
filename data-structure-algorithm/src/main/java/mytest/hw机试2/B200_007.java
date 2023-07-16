package mytest.hw机试2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B200_007 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> strMap = new ArrayList<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s == null || s.trim().length() == 0) {
                break;
            }
            strMap.add(s);
        }
        int maxLength = 0;
        for (String s : strMap) {
            maxLength = Math.max(maxLength, s.length());
        }
        int[][] visit = new int[strMap.size()][maxLength];
        int max = 0;

        for (int i = 0; i < strMap.size(); i++) {
            for (int j = 0; j < strMap.get(i).length(); j++) {
                if (strMap.get(i).charAt(j) != '0' && visit[i][j] == 0) {
                    max = Math.max(visit(strMap, visit, i, j), max);
                }
            }
        }
        System.out.println(max);
    }

    public static int visit(List<String> map, int[][] visit, int i, int j) {
        if (i < 0 || i >= map.size() || j < 0 || j >= map.get(i).length() || visit[i][j] != 0) {
            return 0;
        }
        char code = map.get(i).charAt(j);
        int value = code - '0';
        if (value != 0) {
            visit[i][j] = 1;
            return value + visit(map, visit, i - 1, j) +
                    visit(map, visit, i + 1, j) +
                    visit(map, visit, i, j + 1) +
                    visit(map, visit, i, j - 1);
        }
        return 0;

    }
}

/*
1111111
1222221
1222221
1222221
1111111
 */

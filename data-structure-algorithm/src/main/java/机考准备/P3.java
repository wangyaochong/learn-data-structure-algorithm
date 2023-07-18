package 机考准备;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<String> grid = new ArrayList<>();
        while (in.hasNextLine()) {
            String row = in.nextLine();
            if (row == null || row.trim().length() == 0) {
                break;
            }
            grid.add(row);
        }
        byte[][] visit = new byte[grid.size()][grid.get(0).length()];
        int value = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).length(); j++) {
                if (grid.get(i).charAt(j) != '0' && visit[i][j] == 0) {
                    int oneGoldMine = enlarge(grid, visit, i, j);
                    if (value < oneGoldMine) {
                        value = oneGoldMine;
                    }
                }
            }
        }
        System.out.println(value);
    }

    public static int enlarge(List<String> grid, byte[][] visit, int i, int j) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid.get(0).length() || grid.get(i).charAt(j) == '0' || visit[i][j] == 1) {
            return 0;
        }
        visit[i][j] = 1;
        return (grid.get(i).charAt(j) - '0')
                + enlarge(grid, visit, i - 1, j)
                + enlarge(grid, visit, i + 1, j)
                + enlarge(grid, visit, i, j - 1)
                + enlarge(grid, visit, i, j + 1);
    }

}

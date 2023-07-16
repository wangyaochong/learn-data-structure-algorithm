package mytest.hw机试2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
YES YES
NO NO
*/
/*
YES YES NO
NO NO NO
YES NO NO

YES NO NO NO
NO NO NO NO
NO NO NO NO
NO NO NO NO

 */


public class B200_003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<List<Integer>> grid = new ArrayList<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s == null || s.length() == 0 || s.trim().length() == 0) {
                break;
            }
            String[] s1 = s.split(" ");
            List<Integer> row = new ArrayList<>();//-1是死亡区，0是可改造，1是宜居
            for (String s2 : s1) {
                if (s2.equals("YES")) {
                    row.add(1);
                } else if (s2.equals("NO")) {
                    row.add(0);
                } else if (s2.equals("NA")) {
                    row.add(-1);
                } else {
                    throw new RuntimeException("wrong type");
                }
            }
            grid.add(row);
        }
        int minRound = Integer.MAX_VALUE;

        List<Point> toSolve = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    toSolve.add(new Point(i, j));
                }
            }
        }
        int solve = solve(grid, toSolve);
        if(solve>0)
            System.out.println(solve-1);
        else{
            System.out.println("-1");
        }

    }

    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public static int solve(List<List<Integer>> param, List<Point> toSolve) {//返回最小开发次数，如果无法开发完成，则返回-1
        List<List<Integer>> grid = new ArrayList<>();
        for (List<Integer> integers : param) {
            grid.add(new ArrayList<>(integers));
        }

        int sizeRow = param.size();
        int sizeCol = param.get(0).size();
        int[][] visit = new int[sizeRow][sizeCol];
        int count = 0;
        while (toSolve.size() != 0) {
            count++;
            for (Point point : toSolve) {
                grid.get(point.row).set(point.col, 1);
            }
            if (checkOk(grid)) {
                return count;
            }
            List<Point> newRound = new ArrayList<>();
            for (Point point : toSolve) {
                if (point.row - 1 >= 0 && grid.get(point.row - 1).get(point.col) != -1 && visit[point.row - 1][point.col] == 0) {
                    visit[point.row - 1][point.col] = 1;
                    newRound.add(new Point(point.row - 1, point.col));
                }
                if (point.row + 1 < sizeRow && grid.get(point.row + 1).get(point.col) != -1 && visit[point.row + 1][point.col] == 0) {
                    visit[point.row + 1][point.col] = 1;
                    newRound.add(new Point(point.row + 1, point.col));
                }
                if (point.col - 1 >= 0 && grid.get(point.row).get(point.col - 1) != -1 && visit[point.row][point.col - 1] == 0) {
                    visit[point.row][point.col - 1] = 1;
                    newRound.add(new Point(point.row, point.col - 1));
                }
                if (point.col + 1 < sizeCol && grid.get(point.row).get(point.col + 1) != -1 && visit[point.row][point.col + 1] == 0) {
                    visit[point.row][point.col + 1] = 0;
                    newRound.add(new Point(point.row, point.col + 1));
                }
            }
            toSolve = newRound;

        }
        if (checkOk(grid)) {
            return count;
        }
        return -1;
    }

    public static boolean checkOk(List<List<Integer>> grid) {
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 0) {//如果不是死亡区，但依然是可改造，那么就是没有改造完成
                    return false;
                }
            }
        }
        return true;
    }

}

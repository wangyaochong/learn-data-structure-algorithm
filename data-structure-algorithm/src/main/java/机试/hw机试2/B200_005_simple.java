package 机试.hw机试2;

import java.util.*;

public class B200_005_simple {
    static class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        int[][] grid = new int[64][64];
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        while (count > 0) {
            String[] s = in.nextLine().split(" ");
            int num = Integer.parseInt(s[0]);
            for (int i = 1; i < s.length; i += 2) {
                grid[Integer.parseInt(s[i])][Integer.parseInt(s[i + 1])] = num;
            }
            map.put(num, 0);
            count--;
        }
        List<Point> offset = new ArrayList<>();
        offset.add(new Point(-1, 0));
        offset.add(new Point(1, 0));
        offset.add(new Point(0, -1));
        offset.add(new Point(0, 1));
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int current = grid[i][j];
                if (current != 0) {
                    for (Point point : offset) {
                        int newX = i + point.x;
                        int newY = j + point.y;
                        if (newX < 0 || newX >= 64 || newY < 0 || newY >= 64) {
                            map.put(current, (map.get(current) + 1));
                        } else {
                            if (grid[newX][newY] != current) {
                                map.put(current, (map.get(current) + 1));
                            }
                        }
                    }
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }
}
/*
2
1 1 3 2 2 2 3 2 4 3 2 3 3 3 4 4 1 4 2 4 3 4 4 5 2 5 3
2 3 7 3 8 4 5 4 6 4 7 4 8 5 4 5 5 5 6 5 7 5 8 6 4 6 5 6 6 6 7 6 8 7 4 7 5 7 6 7 7 7 8

 */
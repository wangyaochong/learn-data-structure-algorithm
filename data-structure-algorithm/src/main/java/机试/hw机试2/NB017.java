package 机试.hw机试2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NB017 {
    static class Dir {
        int x;
        int y;

        public Dir(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        int x = Integer.parseInt(s1[0]);
        int y = Integer.parseInt(s1[1]);
        int t = Integer.parseInt(s1[2]);
        Dir dir = new Dir(1, 1);
        while (t > 0) {
            if (x == 0) dir.x = 1;
            if (x == 750) dir.x = -1;
            if (y == 0) dir.y = 1;
            if (y == 575) dir.y = -1;
            x = x + dir.x;
            y = y + dir.y;
            t--;
        }
        System.out.println(x + " " + y);
    }
}

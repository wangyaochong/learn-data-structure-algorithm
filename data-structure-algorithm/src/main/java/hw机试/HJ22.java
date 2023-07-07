package hw机试;

import java.util.Scanner;

public class HJ22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String s = in.nextLine();
            if (s.equals("0")) {
                break;
            }
            System.out.println(calCount(Integer.parseInt(s)));
        }
    }

    public static int calCount(Integer emptyCount) {
        if (emptyCount < 2) {
            return 0;
        }
        if (emptyCount == 2) {
            return 1;
        }
        return emptyCount / 3 + calCount(emptyCount % 3 + emptyCount / 3);
    }
}

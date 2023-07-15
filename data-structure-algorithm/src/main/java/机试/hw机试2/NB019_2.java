package 机试.hw机试2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NB019_2 {
    static class Player {
        Long id;
        Long score;
        int level;

        public Player(Long id, Long score) {
            this.id = id;
            this.score = score;
            this.level = 0;
        }

    }

    static Comparator<Player> playerComparator = (o1, o2) -> {
        if (o1.level == o2.level) {
            if (o1.score.compareTo(o2.score) == 0) {
                return o1.id.compareTo(o2.id);
            } else {
                return o2.score.compareTo(o1.score);
            }
        } else {
            return o2.level - o1.level;
        }
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        List<Player> list = new ArrayList<>();
        for (int i = 0; i < s1.length; i++) {
            list.add(new Player((long) i, Long.parseLong(s1[i])));
        }

    }


}

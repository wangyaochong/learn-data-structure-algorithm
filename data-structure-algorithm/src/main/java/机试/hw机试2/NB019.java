package 机试.hw机试2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NB019 {
    static class Player {
        Long id;
        Long score;

        public Player(Long id, Long score) {
            this.id = id;
            this.score = score;
        }
    }

    static class PlayerGroup {
        List<Player> win;
        List<Player> loss;

        public PlayerGroup(List<Player> win, List<Player> loss) {
            this.win = win;
            this.loss = loss;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        List<Player> list = new ArrayList<>();
        for (int i = 0; i < s1.length; i++) {
            list.add(new Player((long) i, Long.parseLong(s1[i])));
        }
        PlayerGroup reduce = reduce(list);
        List<List<Player>> resultGroup = new ArrayList<>();
        resultGroup.add(reduce.win);
        resultGroup.add(reduce.loss);
        while (resultGroup.get(0).size() > 1||resultGroup.get(1).size()>1||(resultGroup.size()>=3&&resultGroup.get(2).size()>1)) {
            List<List<Player>> newResultGroup = new ArrayList<>();
            for (List<Player> players : resultGroup) {
                PlayerGroup oneReduce = reduce(players);
                newResultGroup.add(oneReduce.win);
                newResultGroup.add(oneReduce.loss);
            }
            while(newResultGroup.size()>3){
                newResultGroup.remove(newResultGroup.size() - 1);
            }
            resultGroup = newResultGroup;
        }
        System.out.print(resultGroup.get(0).get(0).id+" ");
        System.out.print(resultGroup.get(1).get(0).id+" ");
        System.out.print(resultGroup.get(2).get(0).id+" ");
    }
//2 3 4 5                     3 1 2
//0 1 2 3 4 5 6 7 8           8 7 3
    //2 3 4 6 1 2 35 12 22
    public static PlayerGroup reduce(List<Player> input) {
        List<Player> loss = new ArrayList<>();
        List<Player> win = new ArrayList<>();
        while (input.size() >= 2) {
            Player p1 = input.remove(0);
            Player p2 = input.remove(0);

            if (p1.score.equals(p2.score)) {
                win.add(p1);
                loss.add(p2);
            } else {
                if (p1.score.compareTo(p2.score) > 0) {
                    win.add(p1);
                    loss.add(p2);
                } else {
                    win.add(p2);
                    loss.add(p1);
                }
            }
        }
        win.addAll(input);
        return new PlayerGroup(win, loss);
    }

}

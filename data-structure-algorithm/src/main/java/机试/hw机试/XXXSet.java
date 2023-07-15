package 机试.hw机试;

import java.util.HashSet;

public class XXXSet {
    public static void main(String[] args) {
        HashSet<String> a = new HashSet<>();
        a.add("b");
        a.add("a");
         HashSet<String> b = new HashSet<>();
        b.add("a");
        b.add("b");

        System.out.println(a.equals(b));

    }
}

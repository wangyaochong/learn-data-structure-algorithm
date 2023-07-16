package mytest.hw机试;


import java.util.*;

public class HJ27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        int count = Integer.parseInt(s1[0]);
        String target = s1[s1.length - 2];
        int index = Integer.parseInt(s1[s1.length - 1]);
        List<String> words = new ArrayList<>();
        for (int i = 1; i < s1.length - 2; i++) {
            words.add(s1[i]);
        }
        List<String> brotherWords = new ArrayList<>();
        for (String word : words) {
            char[] a = word.toCharArray();
            Arrays.sort(a);
            String one = new String(a);
            char[] b = target.toCharArray();
            Arrays.sort(b);
            String two = new String(b);

            if (!target.equals(word) && two.equals(one)) {
                brotherWords.add(word);
            }
        }

        List<String> sorted = new ArrayList<>();
        for (String word : words) {
            char[] a = word.toCharArray();
            Arrays.sort(a);
            String one = new String(a);
            if (!sorted.contains(one)) {
                sorted.add(one);
            }
        }
        System.out.println(brotherWords.size());
        Collections.sort(brotherWords);
        if(index<=brotherWords.size()){
            System.out.println(brotherWords.get(index-1));
        }
    }
}

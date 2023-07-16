package mytest.hw机试2.ksum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
     public static void main(String[] args) {
         String input = "(10,1),(20,1),(30,2),(40,3)";
        String regex = "\\(\\d+,\\d+\\)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

//        while (matcher.find()) {
//            result[i][0] = Integer.parseInt(matcher.group(1));
//            result[i][1] = Integer.parseInt(matcher.group(2));
//            i++;
//        }
//
//        for (int[] pair : result) {
//            System.out.println("(" + pair[0] + "," + pair[1] + ")");
//        }
    }
}

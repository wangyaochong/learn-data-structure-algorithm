package mytest.hw机试2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NB31 {
    public static void main(String[] args) {
        String input = "eabcabe";
        String regex="a[bce]";

        Matcher matcher = Pattern.compile(regex).matcher(input);
        if(matcher.find()){
            System.out.println(input.indexOf(matcher.group()));
        }

    }
}

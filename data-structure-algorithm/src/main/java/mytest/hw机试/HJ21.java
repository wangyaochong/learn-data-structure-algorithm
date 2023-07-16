package mytest.hw机试;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ21 {
    static Map<Character, Integer> cache = new HashMap<>();

    static {
        cache.put('a', 2);
        cache.put('b', 2);
        cache.put('c', 2);
        cache.put('d', 3);
        cache.put('e', 3);
        cache.put('f', 3);
        cache.put('g', 4);
        cache.put('h', 4);
        cache.put('i', 4);
        cache.put('j', 5);
        cache.put('k', 5);
        cache.put('l', 5);
        cache.put('m', 6);
        cache.put('n', 6);
        cache.put('o', 6);
        cache.put('p', 7);
        cache.put('q', 7);
        cache.put('r', 7);
        cache.put('s', 7);
        cache.put('t', 8);
        cache.put('u', 8);
        cache.put('v', 8);
        cache.put('w', 9);
        cache.put('x', 9);
        cache.put('y', 9);
        cache.put('z', 9);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder output = new StringBuilder();
        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            if(Character.isDigit(ch)){
                output.append(ch);
            }
            if(Character.isLetter(ch)&&Character.isLowerCase(ch)){
                output.append(cache.get(ch));
            }
            if(Character.isLetter(ch)&&Character.isUpperCase(ch)){
                char c = Character.toLowerCase(ch);
                if(c!='z'){
                    output.append((char)(c + 1));
                }else{
                    output.append('a');
                }
            }
        }
        System.out.println(output);
    }
}

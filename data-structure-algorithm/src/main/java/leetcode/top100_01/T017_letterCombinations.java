package leetcode.top100_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T017_letterCombinations {
    public static void main(String[] args) {
        List<String> strings = new T017_letterCombinations().letterCombinations("23");
        System.out.println(strings);
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> candidate = new HashMap<>();
        candidate.put('2', "abc");
        candidate.put('3', "def");
        candidate.put('4', "ghi");
        candidate.put('5', "jkl");
        candidate.put('6', "mno");
        candidate.put('7', "pqrs");
        candidate.put('8', "tuv");
        candidate.put('9', "wxyz");

        List<String> str = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            str.add(candidate.get(digits.charAt(i)));
        }
        List<String> result = new ArrayList<>();
        getResult(str, 0, result, "");
        return result;
    }

    public void getResult(List<String> candidate, int level, List<String> result, String current) {
        if (level == candidate.size()) {
            if (!current.equals("")) {
                result.add(current);
            }
            return;
        }
        for (int i = 0; i < candidate.get(level).length(); i++) {
            getResult(candidate, level + 1, result, current + candidate.get(level).charAt(i));
        }
    }

}

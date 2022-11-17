package leetcode.top100_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T17_letterCombinations_2 {
    public static void main(String[] args) {
        List<String> strings = new T17_letterCombinations_2().letterCombinations("23");
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
        List<String> result = new ArrayList<>();
        getResult(digits,candidate, 0, result, "");
        return result;
    }

    public void getResult(String digits,Map<Character, String>candidate, int level, List<String> result, String current) {
        if (level == digits.length()) {
            if (!current.equals("")) {
                result.add(current);
            }
            return;
        }

        char key = digits.charAt(level);
        String oneRow = candidate.get(key);
        for (int i = 0; i < oneRow.length(); i++) {
            getResult(digits,candidate,level + 1, result, current + oneRow.charAt(i));
        }
    }

}

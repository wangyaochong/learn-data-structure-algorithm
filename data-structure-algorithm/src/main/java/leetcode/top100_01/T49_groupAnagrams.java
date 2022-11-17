package leetcode.top100_01;

import java.util.*;

public class T49_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> cache = new HashMap<>();
        for (String str : strs) {
            char[] a = str.toCharArray();
            Arrays.sort(a);
            String key = new String(a);
            if (cache.containsKey(key)) {
                cache.get(key).add(str);
            } else {
                cache.put(key, new ArrayList<>());
                cache.get(key).add(str);
            }
        }
        return new ArrayList<>(cache.values());
    }
}

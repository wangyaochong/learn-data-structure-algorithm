package leetcode.byNumber;

import org.junit.Test;

public class p13_RomantoInteger {
    @Test
    public void test() {

    }

    public int romanToInt(String s) {
        int sum = 0;
        if (s.contains("IV") || s.contains("IX")) {//这里的减法，是因为有差值，比如IV=4，但是实际会计算成6
            sum -= 2;
        }
        if (s.contains("XL") || s.contains("XC")) {
            sum -= 20;
        }
        if (s.contains("CD") || s.contains("CM")) {
            sum -= 200;
        }
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }
        return sum;
    }
}

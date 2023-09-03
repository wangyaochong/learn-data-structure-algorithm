package leetcode.byNumber.p300;

import org.junit.Test;

import java.util.UUID;

public class p263_UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }

    @Test
    public void test() {
        System.out.println(isUgly(2));
        System.out.println(isUgly(3));
        System.out.println(isUgly(5));
        System.out.println(isUgly(15));
        System.out.println(isUgly(14));

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid.length());
        System.out.println(uuid);
        System.out.println(Long.MAX_VALUE);
        System.out.println(String.valueOf(Long.MAX_VALUE).length());
        System.out.println(Integer.MAX_VALUE);
    }
}

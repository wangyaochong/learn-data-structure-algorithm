package mytest.hw机试2;

public class NB018 {
    public static void main(String[] args) {
//        System.out.println(b2d("110"));
        System.out.println(d2b("255"));
    }

    static String b2d(String binary) {//二进制转十进制
        int i = binary.length() - 1;
        int curry = 1;
        Long result = 0L;
        while (i >= 0) {
            char c = binary.charAt(i);
            result += (long) Integer.parseInt(c + "") * curry;
            curry *= 2;
            i--;
        }
        return Long.toString(result);

    }

    static String d2b(String decimal) {//十进制转二进制
        Long number = Long.valueOf(decimal);
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            result.append(number % 2);
            number = number / 2;
        }
        return result.reverse().toString();
    }

}

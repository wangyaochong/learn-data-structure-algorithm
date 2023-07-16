package mytest.hw机试;

import java.util.Scanner;

public class HJ29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String toEnc = in.nextLine();
        String toDec = in.nextLine();
        String x = processEnc(toEnc);
        System.out.println(x);
        String y = processDec(toDec);
        System.out.println(y);
    }

    static String processDec(String toEnc) {
        StringBuilder decResult = new StringBuilder();

        for (int i = 0; i < toEnc.length(); i++) {
            char c = toEnc.charAt(i);
            if (Character.isDigit(c)) {
                if (c == '0') {
                    decResult.append('9');
                } else {
                    decResult.append((char) (c - 1));
                }
            }
            if (Character.isLetter(c) && Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
                if (c == 'a') {
                    decResult.append('z');
                } else {
                    decResult.append((char) (c - 1));
                }
            }else if (Character.isLetter(c) && Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
                if (c == 'A') {
                    decResult.append('Z');
                } else {
                    decResult.append((char) (c - 1));
                }
            }
        }
        return decResult.toString();
    }

    static String processEnc(String toEnc) {
        StringBuilder encResult = new StringBuilder();
        for (int i = 0; i < toEnc.length(); i++) {
            char c = toEnc.charAt(i);
            if (Character.isDigit(c)) {
                if (c == '9') {
                    encResult.append('0');
                } else {
                    encResult.append((char) (c + 1));
                }
            }
            if (Character.isLetter(c) && Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
                if (c == 'z') {
                    encResult.append('a');
                } else {
                    encResult.append((char) (c + 1));
                }
            } else if (Character.isLetter(c) && Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
                if (c == 'Z') {
                    encResult.append('A');
                } else {
                    encResult.append((char) (c + 1));
                }
            }
        }
        return encResult.toString();
    }
}

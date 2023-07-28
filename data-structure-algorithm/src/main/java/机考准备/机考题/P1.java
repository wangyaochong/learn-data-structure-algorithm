package 机考准备.机考题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nums = in.nextLine();
        String[] split = nums.split(",");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        list.sort(new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                return -(o1+o2).compareTo(o2+o1);
            }
        });
        for (String s : list) {
            System.out.print(s);
        }
    }


    @Test
    public void test(){
        System.out.println("995".compareTo("9991"));
    }
}

//9999458941425101

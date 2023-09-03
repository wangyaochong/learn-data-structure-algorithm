package leetcode.byNumber;

import org.junit.Test;

import java.util.Arrays;

public class p944_minDeletionSize_colFirst {
    public static void main(String[] args) {

    }

    public int minDeletionSize(String[] strs) {
        if (strs == null) return 0;
        if (strs[0] == null) return 0;
        int col = strs[0].length();
        int row = strs.length;
        int count=0;
        for(int j=0;j<col;j++){
            for(int i=1;i<row;i++){
                if(strs[i].charAt(j) < strs[i - 1].charAt(j)){
                    count++;
                    break;
                }
            }
        }

        return count;

    }

    @Test
    public void test() {
        System.out.println(minDeletionSize(new String[]{"abc", "bce", "cae"}));
        System.out.println(minDeletionSize(new String[]{"a", "b"}));
        System.out.println(minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }


}

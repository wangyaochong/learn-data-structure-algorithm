package mytest.hw机试2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KSUM {

    public static void main(String[] args) {
        System.out.println("abc");
    }

    @Test
    public void test() {
        System.out.println(kSum(new int[]{1, 2, 3, 4}, 2, 5));
    }

    public int kSum(int[] a, int k, int target) {
        // write your code here
        for (int i = 0; i < constStartIndex; i++) {
            for (int j = 0; j < constLeft; j++) {
                for (int x = 0; x < constTarget; x++) {
                    cache[i][j][x] = -1;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }
        return sovle(list, 0, k, target);
    }

    int constStartIndex = 1000;
    int constLeft = 100;
    int constTarget = 1000;

    int[][][] cache = new int[1000][100][1000];

    public int sovle(List<Integer> arr, int startIndex, int left, int target) {
        if (left == 0 && target == 0) {
            //System.out.println(select);
            return 1;
        }
        if (left == 0) {
            return 0;
        }
        int count = 0;
        for (int i = startIndex; i < arr.size(); i++) {
            Integer integer = arr.get(i);
            if (integer > target) {
                break;
            }
            if (cache[i + 1][left - 1][target - integer] != -1) {
                count += cache[i][left - 1][target - integer];
            } else {
                int sovle = sovle(arr, i + 1, left - 1, target - integer);
                count += sovle;
            }
        }
        if (cache[startIndex][left][target] == -1) {
            cache[startIndex][left][target] = count;
        }
        return count;
    }
}

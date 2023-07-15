package 机试.hw机试2;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class NB26 {
    static int binSearch(List<Long> arr, long target) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = (right + left) / 2 ;
            if (arr.get(mid) > target) {
                right = mid - 1;
            } else if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                if (mid + 1 < arr.size() && arr.get(mid + 1).equals(arr.get(mid))) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return left - 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cakePrice = in.nextLine();
        String giftPrice = in.nextLine();
        String priceStr = in.nextLine();
        Integer price = Integer.parseInt(priceStr);
        List<Long> cakeList = Arrays.stream(cakePrice.split(",")).map(Long::parseLong).collect(Collectors.toList());
        List<Long> giftList = Arrays.stream(giftPrice.split(",")).map(Long::parseLong).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        long count = 0;
        for (Long integer : cakeList) {
            if (integer >= price) continue;
            long left = price - integer;
            int i = binSearch(giftList, left);
            if (i >= 0) {
                count += (i + 1);
            }
        }
        System.out.println(count);
    }
/*

10,20,5
5,5,2
15

*/

    @Test
    public void test() {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8, 8, 0, -1));
        arr.sort(Comparator.naturalOrder());
        System.out.println(arr);
//        int i = binSearch(arr, -1);
//        System.out.println(i);
    }


}

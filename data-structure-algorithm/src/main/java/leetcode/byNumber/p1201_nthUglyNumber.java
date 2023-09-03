package leetcode.byNumber;

import org.junit.Test;

public class p1201_nthUglyNumber {
    public static void main(String[] args) {

    }

    @Test
    public void test(){
        System.out.println(nthUglyNumber(3, 2, 3, 5));
        System.out.println(nthUglyNumber(4, 2, 3, 4));
        System.out.println(nthUglyNumber(5, 2, 11, 13));
        System.out.println(nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        long result=-1;
        int loc=0;
        long aMul = 1;
        long bMul = 1;
        long cMul = 1;
        while (loc < n) {
            long tmp = Math.min(Math.min(a * aMul, b *bMul), c * cMul);
            if(tmp==a*aMul){
                aMul++;
            }
            if(tmp==b*bMul){
                bMul++;
            }
            if(tmp==c*cMul){
                cMul++;
            }
            if(result==-1){
                result=tmp;
            }else{
                if(result!=tmp){
                    result=tmp;
                }
            }
            loc++;
        }
        return (int) result;
    }
}

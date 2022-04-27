package leetcode;
//You have n coins and you want to build a staircase with these coins.
// The staircase consists of k rows where the ith row has exactly i coins.
// The last row of the staircase may be incomplete.

public class CountCompleteStairs {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(1));
    }
    public static  int arrangeCoins(int n) {
        int stepcount = 1;
        while( n > 0){
            n = n - stepcount;
            if(n < 0){
                return --stepcount;
            }
            stepcount++;
        }
        if(n == 0 ){
            return --stepcount;
        }else{
            return  stepcount;
        }
    }
}

package easy.math;

public class PowerOfThree326 {

    public boolean isPowerOfThree(int n) {
        if(n<=0)  return false;
        if(n == 1) return true;
        boolean a = helper(n);
        return a;
    }

    public boolean helper(int n){
        if(n == 1) return true;
        if ( n % 3 != 0) return false;
        return helper(n /3);
    }

// tricky solution, if a number is power of 3, then 1162261467 can be divided by this number without remainer.
//    1162261467 is the largest number of 3' power in int range
    public boolean isPowerOfThree2(int n) {
        return ( n>0 &&  1162261467%n==0);
    }


}

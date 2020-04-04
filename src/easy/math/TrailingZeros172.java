package easy.math;

public class TrailingZeros172 {


//    how many 5 in the expressions?   25 = 5*5, count as two five
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

}

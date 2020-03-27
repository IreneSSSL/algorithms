package easy.math;

public class HammerWeight191 {


//    sooooo amazing, in binary system, n & n-1 means changing the smallest 1 into 0
//    so keep anding n and n-1, count how many times it iterates to 0. that's the occurrence of 1
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}

package easy.dp;

public class ClimbingStairs70 {

//    dynamic programming
//    what I was asked when I was interviewed by Baidu
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int[] mem = new int[n + 1];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n];
    }
}

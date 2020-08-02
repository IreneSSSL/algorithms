package medium.dp;

public class IntegerBreak343 {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n+1];
        dp[2] = 2;
        dp[3] = 3;

        for(int i=4;i<=n;i++){
            int max = 0;
            for (int j=2;i-j>1;j++){
                if (dp[i-j]*j > max) max = dp[i-j]*j ;
                else {
                    break;
                }
            }
            dp[i]=max;
        }
        return dp[n];
    }
}

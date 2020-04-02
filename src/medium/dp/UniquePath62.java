package medium.dp;

public class UniquePath62 {
//    from (0,0) to (m-1,n-1), how many distinct ways are there if only 'left' and 'down' movements allowed
//    best solution raised by myself
    public int uniquePaths(int m, int n) {
        if(m==1 || n ==1) return 1;
        int[][] dp = new int[m][n];
        dp[0][0] =1;
        dp[0][1] =1;
        dp[1][0] =1;
        for (int i=0;i<m;i++){
            for(int j= 0;j<n;j++){
                int left = 0;
                int up = 0;
                if (i-1 >=0){
                    up = dp[i-1][j];
                }
                if (j-1 >=0){
                    left = dp[i][j-1];
                }
                dp[i][j] = Math.max(dp[i][j],up+left);
            }
        }
        return dp[m-1][n-1];
    }
}

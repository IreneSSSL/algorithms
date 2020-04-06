package medium.dp;

public class UniquePath2_62 {


//    interesting! if I use 'continue', my solution beats only 13% java submissions
//    when I change it into break, it beats 100% java submissions
    public int uniquePathsWithObstacles(int[][] ob) {
        int[][] dp = new int[ob.length][ob[0].length];
        for (int i = 0;i< ob.length;i++){
            if (ob[i][0] == 1) continue;
            if (i-1>=0 && dp[i-1][0] == 0) continue; //mark
            dp[i][0] = 1;
        }
        for(int j= 0;j<ob[0].length;j++){
            if (ob[0][j] == 1) continue;
            if (j-1>=0 && dp[0][j-1] == 0) continue; // it should be break
            dp[0][j] = 1;
        }
        for(int i = 1;i< ob.length;i++){
            for( int j = 1;j<ob[0].length;j++){
                if (ob[i][j] == 1) continue;
                if (ob[i-1][j] != 1){
                    dp[i][j] += dp[i-1][j];
                }
                if (ob[i][j-1] != 1) {dp[i][j] += dp[i][j-1];}
            }
        }
        return dp[ob.length-1][ob[0].length-1];
    }

}

package medium.dp;

public class MinPathSum64 {

    public static void main(String[] args) {
        System.out.println((int)'3');
    }
//    not so fast
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i=1;i<grid.length;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i=1;i<grid[0].length;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i=1;i< grid.length;i++){
            for(int j=1;j < grid[0].length;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }



//    the same idea written in recursive, reduce runtime from 6ms to 2ms
    public int minPathSum2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        return helper(grid, dp, grid.length-1, grid[0].length-1);
    }

    public int helper(int[][] grid, int[][] dp, int i,int j){
        if (i == 0 && j == 0) return dp[0][0];
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i == 0){
            dp[i][j] = helper(grid, dp, i,j-1)  + grid[i][j];
            return dp[i][j];
        }
        if (j == 0){
            dp[i][j] =helper(grid, dp, i-1,j)  + grid[i][j];
            return dp[i][j];
        }
        dp[i][j] = grid[i][j] + Math.min(helper(grid, dp, i-1,j) , helper(grid, dp, i,j-1));
        return dp[i][j];
    }

}

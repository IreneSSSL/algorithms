package medium.dp;

public class ZerosAndOnes474 {

    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        new ZerosAndOnes474().findMaxForm(strs, 5,3);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] coin = new int[len][2];
        for(int i =0;i< len;i++){
            int one = 0;
            char[] array = strs[i].toCharArray();
            for (char c : array){
                if (c == '1') coin[i][1]++;
                else coin[i][0]++;
            }
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int s=0;s<len;s++) {
            int[] count = coin[s];
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
            System.out.println();
            for (int i =0;i<m+1;i++){
                System.out.println();
                for (int j =0;j<n+1;j++){
                    System.out.print(" "+ dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

}

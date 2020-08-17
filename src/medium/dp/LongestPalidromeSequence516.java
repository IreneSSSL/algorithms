package medium.dp;

public class LongestPalidromeSequence516 {
    public static void main(String[] args) {
        String s = "bbab";
        new LongestPalidromeSequence516().longestPalindromeSubseq(s);
    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int[][] index = new int[len][len];
        for (int i=0;i<len;i++){
            dp[i][i] = 1;
            index[i][i] = i;
        }
        char[] array= s.toCharArray();
        int max = 1;
        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                if(array[i] == array[j]) {
                    dp[i][j]= dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}

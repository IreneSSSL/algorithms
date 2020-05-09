package medium.dp;

public class LongestCommonSequence1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0) return 0;
        int[][] dp = new int[text2.length()][text1.length()];
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();

        for (int i=0;i< text2.length();i++){
            for(int j=0;j< text1.length();j++){
                if (i == 0 && j==0 ){
                    if (ch1[j] == ch2[i]) dp[0][0] = 1;
                }else if (i == 0){
                    if( ch1[j] == ch2[i]) dp[i][j] = 1;
                    else dp[i][j] = dp[i][j-1];
                }else if (j == 0){
                    if( ch1[j] == ch2[i]) dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j];
                }else if (ch1[j] == ch2[i]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[ch2.length-1][ch1.length-1];
    }

}

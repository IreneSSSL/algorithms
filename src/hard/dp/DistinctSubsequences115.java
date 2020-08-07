package hard.dp;

import java.util.*;

public class DistinctSubsequences115 {

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(new DistinctSubsequences115().numDistinct(s, t));
    }

    public int numDistinct(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return 0;

        int[][] dp = new int[t.length()+1][s.length()+1];
        for (int i = 0;i< t.length()+1;i++){
            dp[0][i] = 1;
        }
        for (int i = 1; i < t.length()+1; i++) {
            for (int j = 1; j < s.length()+1; j++) {
                if (t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j - 1] + dp[i ][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }


            }
        }
        return dp[t.length()][s.length()];
    }
}

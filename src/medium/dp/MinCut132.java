package medium.dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MinCut132 {
    public static void main(String[] args) {
        new MinCut132().minCut("cdd");
    }

    public int minCut(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] array = s.toCharArray();
        int[] results = new int[len];
        for (int i =len-1;i>=0;i--){
            results[i]=len-i-1;
            for (int j = i;j<len;j++){
                if (i==j){
                    dp[i][j] = 1;
                }else {
                    if ( array[i] == array[j] && dp[i+1][j-1] != 0){
                        dp[i][j] = dp[i+1][j-1];
                    } else if (j == i+1 && array[i] == array[j] ){
                        dp[i][j] =1;
                    }
                }

                if (dp[i][j] != 0){
                    if (j==len-1){
                        results[i]=0;
                    }else {
                        results[i]=Math.min(results[i],results[j+1]+1);
                    }

                }

            }
        }
        System.out.println(results[0]);
        return results[0];
    }
}

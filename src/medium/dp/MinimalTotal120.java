package medium.dp;

import java.util.List;

public class MinimalTotal120 {


//  for problems like this one, you cannot get the optimal directly.
//  for instance, previous optimal path(n=4) may not part of current optimal path(n=5)
//    so we have to store the optimal path length to each previous node
//    then choose the smallest one after calculating the optimal lengths to each node of current line
    public int minimumTotal(List<List<Integer>> tr) {
        int[] dp =new int[tr.size()];
        dp[0] = tr.get(0).get(0);
        if (tr.size() == 1) return dp[0];
        int re = Integer.MAX_VALUE;
        for(int i = 1;i< tr.size();i++){
            for (int j = tr.get(i).size()-1;j>=0;j--){
                if (j == tr.get(i).size()-1) dp[j] = tr.get(i).get(j) + dp[j-1];
                else if( j == 0 ) {
                    dp[j] = tr.get(i).get(j) + dp[0];
                }
                else dp[j] = tr.get(i).get(j) + (dp[j] <dp[j-1] ? dp[j]: dp[j-1]);

                if(i== tr.size()-1){
                    re =(re <dp[j] ? re : dp[j]);
                }
            }
        }
        return re;
    }

}

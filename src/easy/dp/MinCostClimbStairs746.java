package easy.dp;

public class MinCostClimbStairs746 {
    public static void main(String[] args) {
        int[] a = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] a = {10, 15, 20};
        System.out.println(new MinCostClimbStairs746().minCostClimbingStairs(a));
    }
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if ( len == 0) return 0;
        int[] dp = new int[len];
        dp[0]= cost[0];
        if( len ==1) return cost[0];

        dp[1] = cost[1];
        if (len ==2) return Math.min(cost[0],cost[1]);

        for(int i=2;i<len;i++){
            dp[i] = Math.min( dp[i-1], dp[i-2])+cost[i];
        }
        return Math.min(dp[len-1], dp[len-2]) ;
    }
}

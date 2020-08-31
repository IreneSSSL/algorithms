package hard.dp;

public class BestTimeToSellandBuyStocks188 {

    public static void main(String[] args) {
        int[] a = {1,2};
        new BestTimeToSellandBuyStocks188().maxProfit(2, a);

    }
    public int maxProfit(int k, int[] prices) {
        if (prices.length <=1 ) return 0;
        if(prices.length <= k/2) {
            return fast(prices); // nearly no limit to the number of transactions, you could buy when the price is low and sell it when the price is high.
        }
        int[][] dp= new int[2][prices.length];
        int max = 0;
        for (int i = 1;i<=k;i++){
            int min = prices[0];
            for(int j=1;j<prices.length;j++){
                min = Math.min(min, -dp[0][j] + prices[j]);
                dp[1][j] = Math.max( dp[1][j-1], prices[j]- min);
                max = Math.max(max, dp[1][j]);

                dp[0][j] = dp[1][j];
            }
        }
        return max;
    }

    private int fast(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++) {
            if(prices[i] > min) {
                profit+=(prices[i] - min);
            }
            min = prices[i];
        }
        return profit;
    }
}

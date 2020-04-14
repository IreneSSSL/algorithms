package medium.dp;

public class BestTimeBuyAndSellStock309 {



//    dp

//1 记录昨天的操作：如果昨天是卖，今天必须cooldown
//2 以当前天为最后一天，最大的收益值
//
//
//    b【i】 第i天 买股票（所以要在前天的积蓄上扣钱）
//    什么都不做 积蓄不变
//
//    s[i] 第i天 卖股票（积蓄一定是增加的，而且是在b【i-1】基础上增加积蓄）
//    什么都不做 积蓄不变
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        int s2 = 0;
        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i = 1;i< prices.length;i++){
            buy[i] = Math.max(buy[i-1], s2-prices[i]);
            sell[i] = Math.max(sell[i-1], prices[i] + buy[i-1] );
            s2 = sell[i-1];
        }
        return sell[prices.length-1];
    }

}

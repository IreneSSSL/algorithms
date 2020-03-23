package easy.array;

public class MaxProfit121 {


//    one transaction, find smallest before largest
//    in similar problems, we may find a new smallest, but no largest afterwards.
//    so we need a variables that stores the max profit record
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            if (minPrice > prices[i]){
                minPrice = prices[i];
            } else {
                if (prices[i] - minPrice > maxProfit){
                    maxProfit = prices[i] - minPrice;
                }
            }
        }
        return maxProfit;

    }

}

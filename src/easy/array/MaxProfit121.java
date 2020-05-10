package easy.array;

public class MaxProfit121 {

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        new MaxProfit121().maxProfit2(a);
    }


    // 执行速度慢一点，但是这个方法巩固了之前的一个技巧。
    public int maxProfit2(int[] prices) {
        if (prices.length == 0) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        left[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            left[i] = Math.min(left[i - 1], prices[i]);
        }

        right[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], prices[i]);
        }

        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(right[i] - left[i], max);
        }
        return max;

    }


    //    one transaction, find smallest before largest
//    in similar problems, we may find a new smallest, but no largest afterwards.
//    so we need a variables that stores the max profit record
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                if (prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }
            }
        }
        return maxProfit;

    }

}

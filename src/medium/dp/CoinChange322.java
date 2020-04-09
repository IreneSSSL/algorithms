package medium.dp;

import java.util.*;
import java.util.stream.Collectors;

public class CoinChange322 {

    public int coinChange2(int[] coins, int amount){

        int[] dp = new int[amount+1];
        if (amount == 0) return 0;
        Arrays.fill(dp, -1);
        for (int coin: coins){
            if(coin > amount) continue;
            dp[coin] = 1;
        }

        for(int i=1;i<amount+1;i++){
            if(dp[i] != -1) continue;
            for (int coin: coins){
                if (coin > i) continue;
                if(dp[i-coin] == -1) continue;
                if(dp[i] == -1) dp[i] = dp[i-coin]+1;
                else dp[i] = Math.min( dp[i-coin]+1, dp[i]);
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        int[] coins = {5,2,1};

        new CoinChange322().coinChange(coins, 100);
    }
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        if (amount == 0) return 0;
        Arrays.fill(dp, -1);
        for (int coin: coins){
            if(coin > amount) continue;
            dp[coin] = 1;
        }
        Arrays.sort(coins);
        int re = helper(coins, amount,dp);
        System.out.println(re);
        return re;
    }

    public int helper(int[] coins, int amount, int[] dp){
        if (amount <= 0) return -1;
        for(int i= coins.length-1;i>=0;i--){
            int coin = coins[i];
            if (coin > amount) continue;
            if(amount == coin) return 1;
            int last = helper(coins, amount-coin,dp);
            if (last ==  -1) continue;
//            if(dp[amount] == -1)
                dp[amount] = 1+last;
                break;
//            dp[amount] =Math.min( 1+last, dp[amount] );
        }
        return dp[amount];
    }
}

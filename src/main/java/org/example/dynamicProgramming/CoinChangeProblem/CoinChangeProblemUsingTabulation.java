package org.example.dynamicProgramming.CoinChangeProblem;

import java.util.Arrays;

public class CoinChangeProblemUsingTabulation {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 5;
        System.out.println("Minimum number of ways to get sum: " + coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int sum){
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];

        //Arrays.fill(dp[0], 0);

        for(int i=0; i<=n; i++)
            dp[i][0] = 1; // 0 coins needed to make sum 0

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                dp[i][j] = dp[i-1][j];
                if(coins[i-1]<= j)
                    dp[i][j] += dp[i][j - coins[i-1]];
            }
        }

        return dp[n][sum];
    }

}

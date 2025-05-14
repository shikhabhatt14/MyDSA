package org.example.dynamicProgramming;

import java.util.Arrays;

public class CoinChangeProblem {

    //coin change problem using tabulation(bottom up approach)
    //time complexity = theta(n*m) where n is the number of coins and m is the sum
    //this is much less than a recursive solution where time complexity increases exponentially
    //coin change problem statement:
    //given a set of coins and a sum, find the number of ways to make the sum using the coins
    //for example, given coins = {1, 2, 3} and sum = 5, the output should be 5
    //the 5 ways are:
    //1. 1+1+1+1+1
    //2. 1+1+1+2
    //3. 1+2+2
    //4. 2+3
    //5. 1+1+3
    //the order of coins does not matter, so 1+2+2 is the same as 2+1+2

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;
        int res1 = coinChange(coins, sum);
        int res2 = coinChangeStorageOptimized(coins, sum);

        System.out.println("Minimum number of coins needed(using tabulation): " + res1);
        System.out.println("Minimum number of coins needed(using space optimized): " + res2);
    }

    public static int coinChange(int[] coins, int sum){
        int n = coins.length;
        int[][] dp = new int[n+1][sum+1];

        Arrays.fill(dp[0], 0);

        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(j-coins[i-1] >=0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum];
    }

    public static int coinChangeStorageOptimized(int[] coins, int sum){
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        int n = coins.length;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(j-coins[i-1] >=0){
                    dp[j] += dp[j-coins[i-1]];
                }
            }
        }

    return dp[sum];
    }

}

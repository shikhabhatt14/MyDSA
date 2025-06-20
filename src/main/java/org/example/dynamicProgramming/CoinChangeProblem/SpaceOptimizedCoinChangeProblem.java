package org.example.dynamicProgramming.CoinChangeProblem;

import java.util.Arrays;

public class SpaceOptimizedCoinChangeProblem {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 5;
        System.out.println("Minimum number of ways to get sum: " + coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int sum){

        int n = coins.length;
        int[] prev = new int[sum+1];

        int[] curr = new int[sum+1];
        //Arrays.fill(prev, 0);
        prev[0] = 1; // 0 coins needed to make sum 0
        curr[0] = 1; // 0 coins needed to make sum 0

        for(int i=1; i<=n; i++){
            for(int j=1;j<=sum; j++){
                curr[j] = prev[j];
                if(coins[i-1] <= j) {
                    curr[j] += curr[j - coins[i-1]];
                }
            }
            prev = curr.clone();
        }


    return curr[sum];

    }

}

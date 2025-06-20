package org.example.dynamicProgramming.zeroOneKnapsackProblem;

import java.util.Arrays;

public class KnapsackProblemUsingTabulation {

    public static void main(String[] args) {
        int[] weights = {5, 4, 6, 3};
        int[] values = {10, 40, 30, 50};
        int capacity = 10;
        int n = weights.length;

        int result = knapsack(weights, values, capacity, n);
        System.out.println("Maximum value in Knapsack = " + result);
    }

    public static int knapsack(int[] weights, int[] values, int capacity, int n){
        int[][] dp = new int[n+1][capacity+1];

        Arrays.fill(dp[0], 0);
        for(int i=0; i< capacity; i++)
            dp[0][i] = 0;
        for(int i=1; i<=n; i++){
            for(int j=1;j<=capacity;j++){
                if(weights[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Integer.max(dp[i-1][j], values[i-1]+dp[i-1][j - weights[i-1]]);
            }
        }
        return dp[n][capacity];
    }
}

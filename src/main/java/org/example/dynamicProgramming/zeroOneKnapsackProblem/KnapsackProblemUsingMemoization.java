package org.example.dynamicProgramming.zeroOneKnapsackProblem;

import java.util.Arrays;

public class KnapsackProblemUsingMemoization {

    public static void main(String[] args) {
        int[] weights = {5, 4, 6, 3};
        int[] values = {10, 40, 30, 50};
        int capacity = 10;
        int n = weights.length;

        int result = knapsack(weights, values, capacity, n);
        System.out.println("Maximum value in Knapsack = " + result);
    }

    public static int knapsack(int[] weights, int[] value, int capacity, int n){
        int[][] memo = new int[n+1][capacity+1];
        for (int[] r : memo)
            Arrays.fill(r, -1);
        if(memo[n][capacity] != -1)
            return memo[n][capacity];
        if(n==0 || capacity==0) {
            memo[n][capacity] = 0;
            return memo[n][capacity];
        }
        if(weights[n-1] > capacity) //when weight of nth item is greater than capacity
            memo[n][capacity] = knapsack(weights, value, capacity, n-1);
        else //when weight of nth item is less than or equal to capacity
            memo[n][capacity] = Integer.max(knapsack(weights, value, capacity, n-1),
                    value[n-1] + knapsack(weights, value, capacity - weights[n-1], n-1));

        return memo[n][capacity];
    }

}

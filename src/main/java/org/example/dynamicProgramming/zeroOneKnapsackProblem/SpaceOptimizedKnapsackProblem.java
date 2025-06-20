package org.example.dynamicProgramming.zeroOneKnapsackProblem;

import java.util.Arrays;

public class SpaceOptimizedKnapsackProblem {
    public static void main(String[] args) {
        int[] weights = {5, 4, 6, 3};
        int[] values = {10, 40, 30, 50};
        int capacity = 10;
        int n = weights.length;

        int result = knapsack(weights, values, capacity, n);
        System.out.println("Maximum value in Knapsack = " + result);
    }

    public static int knapsack(int[] weights, int[] values, int capacity, int n){
        int[] prev = new int[capacity+1];
        int[] curr = new int[capacity+1];

        Arrays.fill(prev, 0);
        curr[0] = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=capacity;j++){
                if(weights[i-1] > j)
                    curr[j] = prev[j];
                else
                    curr[j] =Integer.max(prev[j], values[i-1]+prev[j - weights[i-1]]);
            }
            prev = curr.clone();
        }
        return curr[capacity];

    }
}

package org.example.arrays;

public class StockBuyAndSell {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] arr){
        int profit = 0;
        for(int i=1;i<arr.length;i++)
            if(arr[i] > arr[i-1])
                profit += arr[i] -arr[i-1];
        return profit;
    }

}

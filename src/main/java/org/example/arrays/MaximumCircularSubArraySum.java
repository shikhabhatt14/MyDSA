package org.example.arrays;

public class MaximumCircularSubArraySum {

    public static void main(String[] args) {
        int[] arr = {5, -2, 3, 4};
        int maxSum = findMaxCircularSubArraySum(arr);
        System.out.println("Maximum Circular Subarray Sum: " + maxSum);
    }

    public static int findMaxCircularSubArraySum(int[] arr) {
        int n = arr.length;

        // Step 1: Find the maximum subarray sum using Kadane's algorithm
        int maxKadane = kadane(arr);

        // Step 2: Find the total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Step 3: Invert the array elements
        for (int i = 0; i < n; i++) {
            arr[i] = -arr[i];
        }

        // Step 4: Find the maximum subarray sum of the inverted array
        int maxInvertedKadane = kadane(arr);

        // Step 5: Calculate the maximum circular subarray sum
        int maxCircularSum = totalSum + maxInvertedKadane;

        // Step 6: Return the maximum of both results
        return Math.max(maxKadane, maxCircularSum);
    }

    public static int kadane(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        for(int i=1; i<arr.length; i++) {
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

}

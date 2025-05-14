package org.example.hashing;

import java.util.HashMap;

public class LongestSubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int targetSum = 9;
        System.out.println("Length of longest subarray with sum " + targetSum + " is: " + findLongestSubArrayWithGivenSum(arr, targetSum));
    }

    public static int findLongestSubArrayWithGivenSum(int[] arr, int targetSum) {
        int n = arr.length;
        int currentSum = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            if (currentSum == targetSum) {
                maxLength = i + 1;
            }

            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            }

            if (map.containsKey(currentSum - targetSum)) {
                maxLength = Math.max(maxLength, i - map.get(currentSum - targetSum));
            }
        }

        return maxLength;
    }

}

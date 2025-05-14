package org.example.hashing;

import java.util.HashMap;

public class LongestCommonSpanWithSameSum {

    public static void main(String[] args) {

        int[] arr1 = {0, 1, 0, 0, 1, 0, 1};
        int[] arr2 = {1, 0, 0, 1, 0, 1, 0};
        System.out.println("Length of longest common span with same sum: " + findLongestCommonSpan(arr1, arr2));

    }

    public static int findLongestCommonSpan(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int maxLength = 0;

        // Create a map to store the difference between the two arrays
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize with sum 0 at index -1

        int sum = 0;

        for (int i = 0; i < n; i++) {
            // Calculate the difference between the two arrays
            sum += (arr1[i] - arr2[i]);

            // If the sum is already in the map, calculate the length of the span
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                // Store the first occurrence of this sum
                map.put(sum, i);
            }
        }

        return maxLength;
    }

}

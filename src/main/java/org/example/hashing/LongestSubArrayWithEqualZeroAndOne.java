package org.example.hashing;

import java.util.HashMap;

public class LongestSubArrayWithEqualZeroAndOne {

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 1, 1, 0};
        System.out.println("Length of longest subarray with equal number of 0s and 1s: " + findLongestSubArray(arr));
    }

    public static int findLongestSubArray(int[] arr) {
        int n = arr.length;
        int maxLength = 0;
        int sum = 0;

        // HashMap to store the first occurrence of each sum
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // Convert 0s to -1s
            sum += (arr[i] == 0) ? -1 : 1;

            // If sum is zero, update maxLength
            if (sum == 0) {
                maxLength = i + 1;
            }

            // If this sum has been seen before, update maxLength
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

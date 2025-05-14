package org.example.hashing;

import java.util.HashSet;

public class SubArrayWithZeroSum {

    public static void main(String[] args) {

        int[] arr = {4, 2, -3, 1, 6};
        System.out.println("Subarray with zero sum exists: " + hasZeroSumSubarray(arr));

        int[] arr2 = {4, 2, 0, 1, 6};
        System.out.println("Subarray with zero sum exists: " + hasZeroSumSubarray(arr2));

    }

    public static boolean hasZeroSumSubarray(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : arr) {
            sum += num;

            // Check if the current sum is zero or if it has been seen before
            if (sum == 0 || set.contains(sum)) {
                return true;
            }

            set.add(sum);
        }

        return false;
    }

}

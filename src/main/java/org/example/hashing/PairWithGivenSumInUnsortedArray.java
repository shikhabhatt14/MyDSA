package org.example.hashing;

import java.util.HashSet;

public class PairWithGivenSumInUnsortedArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int sum = 9;
        findPairWithSum(arr, sum);

    }

    public static void findPairWithSum(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = sum - num;
            if (set.contains(complement)) {
                System.out.println("Pair with given sum " + sum + " is: (" + num + ", " + complement + ")");
                return;
            }
            set.add(num);
        }

        System.out.println("No pair found with the given sum " + sum);
    }
}

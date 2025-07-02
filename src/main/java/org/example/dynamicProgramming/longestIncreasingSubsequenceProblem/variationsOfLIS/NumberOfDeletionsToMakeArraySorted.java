package org.example.dynamicProgramming.longestIncreasingSubsequenceProblem.variationsOfLIS;

import static org.example.dynamicProgramming.longestIncreasingSubsequenceProblem.LongestIncreasingSubsequence.longestIncreasingSubsequence;

public class NumberOfDeletionsToMakeArraySorted {

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 2, 4};
        int n = arr.length;
        int lisLength = longestIncreasingSubsequence(arr);
        int deletions = n - lisLength;
        System.out.println("Number of deletions to make the array sorted: " + deletions);
    }

}

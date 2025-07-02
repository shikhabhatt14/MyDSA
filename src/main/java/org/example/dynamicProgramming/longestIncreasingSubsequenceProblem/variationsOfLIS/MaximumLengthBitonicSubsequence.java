package org.example.dynamicProgramming.longestIncreasingSubsequenceProblem.variationsOfLIS;

// This class is a placeholder for the Maximum Length Bitonic Subsequence problem.
// It is intended to be implemented with the logic for finding the maximum length bitonic subsequence in an array.
//Bitonic subsequence is a sequence that first increases and then decreases.

public class MaximumLengthBitonicSubsequence {

    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println("Maximum length of bitonic subsequence: " + maximumLengthBitonicSubsequence(arr));
    }

    public static int maximumLengthBitonicSubsequence(int[] arr){
        int[] incFromStart = new int[arr.length];
        int[] incFromEnd = new int[arr.length];
        int n = arr.length;

        for(int i = 0;i<n;i++){
            incFromStart[i] = 1; // Initialize increasing subsequence length
            incFromEnd[n-i-1] = 1; // Initialize decreasing subsequence length
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j])
                    incFromStart[i] = Integer.max(incFromStart[i], incFromStart[j] + 1);
                if(arr[n-i-1] > arr[n-j-1])
                    incFromEnd[n-i-1] = Integer.max(incFromEnd[n-i-1], incFromEnd[n-j-1] + 1);
            }
        }
        int maxLength = 0;
        for(int i=0;i<n;i++){
            maxLength = Integer.max(maxLength, incFromStart[i] + incFromEnd[i] - 1); // -1 to avoid double counting the peak element
        }
        return maxLength;
    }

}

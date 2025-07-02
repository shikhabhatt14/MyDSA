package org.example.dynamicProgramming.longestIncreasingSubsequenceProblem.variationsOfLIS;

public class MaximumSumIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 5, 10};
        System.out.println("Maximum sum of increasing subsequence: " + maximumSumIncreasingSubsequence(arr));
    }

    public static int maximumSumIncreasingSubsequence(int[] arr){
        int[] msis = new int[arr.length];
        for(int i=0; i< arr.length; i++){
            msis[i] = arr[i];
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j])
                    msis[i] = Integer.max(msis[i], arr[i]+msis[j]);
            }
        }

        int result = msis[0];
        for(int i=1; i<msis.length; i++){
            result = Integer.max(result, msis[i]);
        }
        return result;
    }

}

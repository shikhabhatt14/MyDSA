package org.example.dynamicProgramming;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 8, 10, 5, 1};
        int result = longestIncreasingSubsequence(arr);
        System.out.println("Length of longest increasing subsequence is " + result);
    }

    public static int longestIncreasingSubsequence(int[] arr) {
        int[] lis = new int[arr.length];
        lis[0] = 1;
        int maxLength = 1;

        for(int i=1;i<arr.length;i++){
            lis[i] = 1;
            for(int j=0;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    lis[i] = Integer.max(lis[i], lis[j]+1);
                }
            }
        }

        for(int i=0;i<lis.length;i++){
            maxLength = Integer.max(maxLength, lis[i]);
        }
        return maxLength;
    }

}

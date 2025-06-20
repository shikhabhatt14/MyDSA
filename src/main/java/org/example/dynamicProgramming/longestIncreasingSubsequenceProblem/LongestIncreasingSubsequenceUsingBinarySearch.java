package org.example.dynamicProgramming.longestIncreasingSubsequenceProblem;

public class LongestIncreasingSubsequenceUsingBinarySearch {

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 8, 10, 5, 1};
        int result = longestIncreasingSubsequence(arr);
        System.out.println("Length of longest increasing subsequence is " + result);
    }

    public static int longestIncreasingSubsequence(int[] arr){
        if(arr.length == 0) {
            return 0;
        }

        int[] lis = new int[arr.length];
        lis[0]  = arr[0];
        int index = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i] > lis[index-1])
                lis[index++] = arr[i];
            else if(arr[i] < lis[index-1]){
                int ceil = binarySearch(lis, 0, index-1, arr[i]);
                lis[ceil] = arr[i];
            }
        }
        return index; // The length of the longest increasing subsequence
    }

    public static int binarySearch(int[] arr, int left, int right, int key) {
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < key) {
                left = mid + 1;
            }
            else
                right  = mid;
        }
        return right; // Return the position where the key can be inserted
    }

}

package org.example.Tree;

public class LongestIncreasingSubsequenceUsingBinaryTree {

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 8, 10, 5, 1};
        int result = longestIncreasingSubsequence(arr);
        System.out.println("Length of longest increasing subsequence is " + result);
    }

    public static int longestIncreasingSubsequence(int[] arr){
        int[] tailList = new int[arr.length];
        tailList[0] = arr[0];
        int length = 1;

        for(int i=1;i<arr.length;i++){
            if(arr[i] > tailList[length-1]){
                tailList[length] = arr[i];
                length++;
            } else {
                length = ceil(tailList, 0, length-1, arr[i]);
            }

        }

        return length;
    }
    public static int ceil(int[] tailList, int start, int end, int key){
        int mid = 0;
        while(start < end){
           mid = (start + end) / 2;
            if(tailList[mid] >= key){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }

}

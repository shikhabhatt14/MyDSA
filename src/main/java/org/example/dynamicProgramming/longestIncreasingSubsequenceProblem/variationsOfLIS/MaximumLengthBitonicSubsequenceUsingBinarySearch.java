package org.example.dynamicProgramming.longestIncreasingSubsequenceProblem.variationsOfLIS;

public class MaximumLengthBitonicSubsequenceUsingBinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println("Maximum length of bitonic subsequence: " + maximumLengthBitonicSubsequence(arr));
    }

    public static int maximumLengthBitonicSubsequence(int[] arr){
    int[] increasing = new int[arr.length];
    int[] decreasing = new int[arr.length];
    int[] tail1 = new int[arr.length];
    int[] tail2 = new int[arr.length];
    int n = arr.length;
    int result = 0;

    //for increasing subsequence
    int index = 1;
    increasing[0] = arr[0];
    tail1[0] = 0; // The first element is always part of the increasing subsequence

    for(int i=1;i<n;i++){
        if(arr[i] < increasing[0]){
            increasing[0] = arr[i];
            tail1[i]=0;
        } else if(arr[i] > increasing[index-1]) {
            increasing[index++] = arr[i];
            tail1[i] = index-1;
        } else {
            int ceil = binarySearch(increasing, 0, index, arr[i]);
            if(ceil <= -1)
                continue;
            increasing[ceil] = arr[i];
            tail1[i] = ceil;
        }
    }
    for(int i=0;i<n;i++)
        System.out.println(tail1[i]);

    // for decreasing subsequence
    index = 1;
    reverse(arr);
    decreasing[0] = arr[0];
    tail2[0] = 0; // The first element is always part of the decreasing subsequence
    for(int i=1;i<n;i++){
        if(arr[i] < decreasing[0]){
            decreasing[0] = arr[i];
            tail2[i] = 0;
        } else if(arr[i] > decreasing[index-1]) {
            decreasing[index++] = arr[i];
            tail2[i] = index-1;
        } else {
            int ceil = binarySearch(decreasing, 0, index, arr[i]);
            if(ceil <= -1)
                continue;
            decreasing[ceil] = arr[i];
            tail2[i] = ceil;
        }
    }
    reverse(tail2);
    reverse(arr);
        for(int i=0;i<n;i++)
            System.out.println(tail2[i]);
    // Calculate the maximum length of bitonic subsequence
        for(int i=0; i<n; i++){
            if(tail1[i] != 0 && tail2[i] != 0) {
                result = Integer.max(result, tail1[i] + tail2[i] + 1); // +1 for the peak element
            }
        }
    return result;
    }

    public static void reverse(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static int binarySearch(int[] arr, int left, int right, int key) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right; // Return the position where the key can be inserted
    }

}

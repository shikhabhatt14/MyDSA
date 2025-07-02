package org.example.arrays;

import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = -1;
        System.out.println("Input: " + java.util.Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Output: " + threeSum(nums, target));
    }

    public static List<Integer> threeSum(int[] arr, int sum){
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            int left = i+1;
            int right = arr.length-1;
            int sumMinusFirst = sum - arr[i];
            while(left < right){
                if(arr[left] + arr[right] == sumMinusFirst){
                    return Arrays.asList(arr[i], arr[left], arr[right]);
                } else if(arr[left] + arr[right] < sumMinusFirst){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return Arrays.asList(); // Return an empty list if no triplet found
    }

}

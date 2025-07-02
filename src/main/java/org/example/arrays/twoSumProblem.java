package org.example.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class twoSumProblem {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        // Using a HashMap to find two indices that sum up to the target when array is not sorted
        //int[] result = twoSum(nums, target);
        // Using two-pointer technique requires the array to be sorted
        int[] result = twoSumWithTwoPointer(nums, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }

    public static int[] twoSum(int[] arr, int sum){
        //using hashmap is a better approach to solve the two sum problem but here
        //time complexity is O(n) and space complexity is O(n)
        //if array is sorted, we can use 2 pointer approach then time complexity is
        // O(n) and space complexity is O(1)

        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<arr.length; i++){
            int comp = sum - arr[i];
            if(map.containsKey(comp)){
                result[0] = map.get(comp);
                result[1] = i;
                return result;
            } else {
                map.put(arr[i], i);

            }
        }
        return result;
    }

    public static int[] twoSumWithTwoPointer(int[] arr, int sum){
        int left = 0;
        int right = arr.length - 1;
        int currSum;
        int[] result = new int[2];
        while(left<right){
            currSum = arr[left] + arr[right];
            if(currSum == sum){
                result[0] = left;
                result[1] = right;
                return result;
            } else if(currSum < sum){
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

}

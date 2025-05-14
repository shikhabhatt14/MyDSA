package org.example.hashing;

import java.util.HashSet;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int targetSum = 12;
        findSubArrayWithGivenSum(arr, targetSum);
    }

    public static void findSubArrayWithGivenSum(int[] arr, int targetSum) {
        int n = arr.length;
        int currentSum = 0;
        int start = 0;
        boolean found = false;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];


            if (currentSum == targetSum) {
                System.out.println("Subarray with given sum " + targetSum + " found between indices " + start + " and " + i);
                found = true;
            }

            if(set.contains(currentSum - targetSum)) {
                start = 0;
                for(Integer key : set) {
                    start++;
                    if(key == currentSum - targetSum) {
                        break;
                    }
                }
                found = true;
                System.out.println("Subarray with given sum " + targetSum + " found between indices " + start + " and " + i);
            }

            set.add(currentSum);
        }
        if(!found)
            System.out.println("No subarray with the given sum " + targetSum + " found");
    }

}

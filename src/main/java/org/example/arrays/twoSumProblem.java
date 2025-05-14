package org.example.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class twoSumProblem {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }

    public static int[] twoSum(int[] arr, int sum){
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

}

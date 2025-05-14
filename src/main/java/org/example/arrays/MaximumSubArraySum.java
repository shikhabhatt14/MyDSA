package org.example.arrays;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] arr){
        int max = arr[0];
        int result = arr[0];
        for(int i=1;i<arr.length;i++){
            max = Math.max(max+arr[i], arr[i]);
            result = Math.max(result, max);
        }
        return result;
    }

}

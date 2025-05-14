package org.example.arrays;

public class LeftRotateArrayByDPlaces {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        leftRotate(arr, d);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int leftRotate(int[] arr, int d) {
        d = d % arr.length; // In case d is greater than array length
        reverse(arr, 0, d - 1); // Reverse first d elements
        reverse(arr, d, arr.length - 1); // Reverse remaining elements
        reverse(arr, 0, arr.length - 1); // Reverse the entire array
        return 0;
    }

    public static int[] reverse(int[] arr, int start, int end) {
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}

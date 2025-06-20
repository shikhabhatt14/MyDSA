package org.example.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {64, 34, 90, 12, 22, 11, 25};
        bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swapped = false; // To optimize the sorting process
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                swapped = false;
                if(arr[j] > arr[j+1]){
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false) {
                // If no two elements were swapped in the inner loop, then the array is sorted
                break;
            }
        }
    }

}

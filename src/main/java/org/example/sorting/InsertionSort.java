package org.example.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        insertionSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void insertionSort(int[] arr){
        int n = arr.length;
        int key; // Element to be inserted in the sorted part of the array
        int j;
        for(int i=1;i<n;i++){
            key = arr[i]; // Current element to be inserted
            j=i-1; // Start from the last sorted element
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j]; // Shift larger elements to the right
                j--; // Move to the previous element
            }
            arr[j+1] = key; // Place the current element in its correct position
        }
    }

}

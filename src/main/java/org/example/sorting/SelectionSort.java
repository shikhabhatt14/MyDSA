package org.example.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;
        int min;
        for(int i=0;i<n;i++){
            min =i ; // Assume the first element is the minimum
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[min])
                    min = j; // Update min if a smaller element is found
            }
            // Swap the found minimum element with the first element
            if(min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

}

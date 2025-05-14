package org.example.heap;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {20, 25, 30, 35, 40, 80, 32, 100, 70, 60};
        System.out.println("Original array:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        heapSort(arr);
        System.out.println("\nSorted array:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
    public static void heapSort(int[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr.length);
        maxHeap.setArray(arr);
        maxHeap.buildMaxHeap();
        for(int i =arr.length-1;i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap.maxHeapify(arr, 0, i);
        }
    }

}

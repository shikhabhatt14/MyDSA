package org.example.heap;

public class KLargestElements {

    public static void main(String[] args) {
        int[] arr = {20, 25, 30, 35, 40, 80, 32, 100, 70, 60};
        int k = 3;
        System.out.println("Original array:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("\n" + k + " largest elements in the array are:");
        findKLargest(arr, k);
    }

    public static void findKLargest(int[] arr, int k){
        MinHeap minHeap = new MinHeap(k);
        minHeap.setArray(arr);
        minHeap.minHeapify(arr, 0, k);
        for(int i = k; i < arr.length; i++){
            if(arr[i] > arr[0]){
                arr[0] = arr[i];
                minHeap.minHeapify(arr, 0, k);
            }
        }
        for(int i = 0; i < k; i++){
            System.out.print(arr[i] + ", ");
        }
    }


}

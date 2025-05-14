package org.example.heap;

import java.util.PriorityQueue;

public class SortKSortedArray {

    // This class is used to sort a k-sorted array using a min heap
    // The time complexity of this algorithm is O(n log k) in the worst case.
    // The space complexity of this algorithm is O(k) in the worst case.
    // A k-sorted array is an array where each element is at most k positions away from its sorted position.
    // For example, the array [3, 2, 1, 5, 4] is a 2-sorted array because each element is at most 2 positions away from its sorted position.
    // The algorithm works by maintaining a min heap of size k+1.
    // The first k+1 elements of the array are added to the min heap.
    // Then, for each subsequent element in the array, the minimum element from the heap is removed and added to the sorted array.
    // The new element is then added to the heap.

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4, 6, 7, 8};
        int k = 2; // k is the maximum distance of an element from its sorted position
        System.out.println("Original array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        sortKSortedArray(arr, k);
        System.out.println("\nSorted array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void sortKSortedArray(int[] arr, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i <= k; i++){
            queue.add(arr[i]);
        }
        int index = 0;
        for(int i= k+1; i < arr.length; i++){
            arr[index++] = queue.poll();
            queue.add(arr[i]);
        }
    }

}

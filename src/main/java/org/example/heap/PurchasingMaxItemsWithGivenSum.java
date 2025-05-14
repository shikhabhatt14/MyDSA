package org.example.heap;

public class PurchasingMaxItemsWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {20, 25, 30, 35, 40, 80, 32, 100, 70, 60};
        int sum = 200;
        System.out.println("Original array:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("\nMax items that can be purchased with sum " + sum + ": " + maxItems(arr, sum));
    }

    public static int maxItems(int[] arr, int sum) {
        HeapSort.heapSort(arr);
        System.out.println("\nSorted array:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        int count = 0; int index = 0;
        while(sum > 0){
            if(sum >= arr[index]){
                sum -= arr[index];
                count++;
                index++;
            }
            else{
                break;
            }
        }


        return count;
    }

}

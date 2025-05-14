package org.example.heap;

public class MaxHeap {

    int[] arr;
    int size;
    int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        arr = new int[capacity];
    }

    public void setArray(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
        this.capacity = arr.length;
    }

    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    // This function is used to insert a new element into the heap.
    // It adds the new element at the end of the heap and then moves it to the correct position in the heap.
    public void insert(int x){
        if(size == capacity)
            System.out.println("Heap is full");
        else{
            arr[size] = x;
            size++;
            int i = size-1;
            while(i>0 && arr[parent(i)]<arr[i]){
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;
                i = parent(i);
            }
        }
    }

    // This function is used to extract the maximum element from the heap.
    // It removes the root element and replaces it with the last element in the heap.
    // The last element is then moved to the correct position in the heap using maxHeapify.
    // The time complexity of this function is O(log n) in the worst case.
    public int extractMax(){
        if(size == 0)
            return Integer.MIN_VALUE;
        if(size == 1){
            size--;
            return arr[0];
        }
        int max = arr[0];
        arr[0] = arr[size-1];
        size--;
        maxHeapify(0);
        return max;
    }

    // This function is used to maintain the max-heap property
    // after the root element is removed.
    // It is called recursively on the affected subtree.
    // The largest element is moved to the root and then maxHeapify is called on the affected subtree.
    // The time complexity of this function is O(log n) in the worst case.
    public void maxHeapify(int i){
        int largest = i;
        int left = left(i);
        int right = right(i);
        if(left < size && arr[left] > arr[largest])
            largest = left;
        if(right < size && arr[right] > arr[largest])
            largest = right;
        if(i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(largest);
        }
    }

    public void maxHeapify(int[] arr, int i, int size){
        int largest = i;
        int left = left(i);
        int right = right(i);
        if(left < size && arr[left] > arr[largest])
            largest = left;
        if(right < size && arr[right] > arr[largest])
            largest = right;
        if(i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest, size);
        }
    }

    // This function is used to replace the value of an element in the heap.
    // It replaces the value at index i with x and then moves the element to the correct position in the heap.
    // The time complexity of this function is O(log n) in the worst case.
    // It is used to decrease the key of an element in the heap.
    public void decreaseKey(int i, int x){
        if(i<size){
            arr[i] = x;
            while(i>0 && arr[parent(i)]<arr[i]){
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;
                i = parent(i);
            }
        }
    }

    // This function is used to delete an element in the heap.
    // It decreases the key of the element at index i to Integer.MIN_VALUE and then extracts the minimum element.
    // The time complexity of this function is O(log n) in the worst case.
    public void delete(int i){
        decreaseKey(i, Integer.MAX_VALUE);
        extractMax();
    }

    public void buildMaxHeap() {
        for(int i = size/2 - 1; i >= 0; i--){
            maxHeapify(i);
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        // Test insert
        /*maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(4);
        for(int i = 0; i < maxHeap.size; i++) {
            System.out.print(maxHeap.arr[i] + " ");
        }
        System.out.println("Max Heap created successfully.");*/

        // Test buildMaxHeap
        // In buildMaxHeap, the array is converted into a max-heap by calling maxHeapify on each non-leaf node.
        int[] arr = {40, 20, 30, 35, 25, 80, 32, 100, 70, 60, 50, 11};
        maxHeap.setArray(arr);
        maxHeap.buildMaxHeap();
        System.out.println("Max Heap after maxHeapify of 0:");
        for(int i = 0; i < maxHeap.size; i++) {
            System.out.print(maxHeap.arr[i] + " ");
        }

        // Test extractMax
        // In extractMax, the last element is moved to the root and then maxHeapify is called to maintain the heap property.
        // The last element is not removed from the array, but the size of the heap is decremented.
        /*int[] arr = {20, 25, 30, 35, 40, 80, 32, 100, 70, 60};
        maxHeap.setArray(arr);
        int max = maxHeap.extractMax();
        System.out.println(max+" extracted from Heap. Max Heap after Extraction:");
        for(int i = 0; i < maxHeap.size; i++) {
            System.out.print(maxHeap.arr[i] + " ");
        }*/

        // Test decreaseKey
        // In decreaseKey, the value at index i is replaced with x and then maxHeapify is called to maintain the heap property.
        /*int[] arr = {20, 80, 200, 90, 100, 250, 500, 120};
        maxHeap.setArray(arr);
        maxHeap.decreaseKey(3, 10);
        System.out.println("Max Heap after replacing:");
        for(int i = 0; i < maxHeap.size; i++) {
            System.out.print(maxHeap.arr[i] + " ");
        }*/




        //System.out.println("Min Heap created successfully.");
    }

}

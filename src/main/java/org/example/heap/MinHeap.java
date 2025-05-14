package org.example.heap;

public class MinHeap {

    int[] arr;
    int size;
    int capacity;

    public MinHeap(int capacity) {
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
            while(i>0 && arr[parent(i)]>arr[i]){
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;
                i = parent(i);
            }
        }
    }

    // This function is used to extract the minimum element from the heap.
    // It removes the root element and replaces it with the last element in the heap.
    // The last element is then moved to the correct position in the heap using minHeapify.
    // The time complexity of this function is O(log n) in the worst case.
    public int extractMin(){
        if(size == 0)
            return Integer.MAX_VALUE;
        if(size == 1){
            size--;
            return arr[0];
        }
        int min = arr[0];
        arr[0] = arr[size-1];
        size--;
        minHeapify(0);
        return min;
    }

    // This function is used to maintain the min-heap property
    // after the root element is removed.
    // It is called recursively on the affected subtree.
    // The smallest element is moved to the root and then minHeapify is called on the affected subtree.
    // The time complexity of this function is O(log n) in the worst case.
    public void minHeapify(int i){
        int smallest = i;
        int left = left(i);
        int right = right(i);
        if(left < size && arr[left] < arr[smallest])
            smallest = left;
        if(right < size && arr[right] < arr[smallest])
            smallest = right;
        if(i != smallest){
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(smallest);
        }
    }

    public void minHeapify(int[] arr, int i, int n){
        int smallest = i;
        int left = left(i);
        int right = right(i);
        if(left < n && arr[left] < arr[smallest])
            smallest = left;
        if(right < n && arr[right] < arr[smallest])
            smallest = right;
        if(i != smallest){
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(arr, smallest, n);
        }
    }

    // This function is used to replace the value of an element in the heap.
    // It replaces the value at index i with x and then moves the element to the correct position in the heap.
    // The time complexity of this function is O(log n) in the worst case.
    // It is used to decrease the key of an element in the heap.
    public void decreaseKey(int i, int x){
        if(i<size){
            arr[i] = x;
            while(i>0 && arr[parent(i)]>arr[i]){
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
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    public void buildHeap() {
        for(int i = size/2 - 1; i >= 0; i--){
            minHeapify(i);
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        // Test insert
        /*minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(4);
        for(int i = 0; i < minHeap.size; i++) {
            System.out.print(minHeap.arr[i] + " ");
        }
        System.out.println("Min Heap created successfully.");*/

        // Test buildHeap
        // In buildHeap, the array is converted into a min-heap by calling minHeapify on each non-leaf node.
        int[] arr = {40, 20, 30, 35, 25, 80, 32, 100, 70, 60, 50, 11};
        minHeap.setArray(arr);
        minHeap.buildHeap();
        System.out.println("Min Heap after minHeapify of 0:");
        for(int i = 0; i < minHeap.size; i++) {
            System.out.print(minHeap.arr[i] + " ");
        }

        // Test extractMin
        // In extractMin, the last element is moved to the root and then minHeapify is called to maintain the heap property.
        // The last element is not removed from the array, but the size of the heap is decremented.
        /*int[] arr = {20, 25, 30, 35, 40, 80, 32, 100, 70, 60};
        minHeap.setArray(arr);
        int min = minHeap.extractMin();
        System.out.println(min+" extracted from Heap. Min Heap after Extraction:");
        for(int i = 0; i < minHeap.size; i++) {
            System.out.print(minHeap.arr[i] + " ");
        }*/

        // Test replace
        // In replace, the value at index i is replaced with x and then minHeapify is called to maintain the heap property.
        /*int[] arr = {20, 80, 200, 90, 100, 250, 500, 120};
        minHeap.setArray(arr);
        minHeap.decreaseKey(3, 10);
        System.out.println("Min Heap after replacing:");
        for(int i = 0; i < minHeap.size; i++) {
            System.out.print(minHeap.arr[i] + " ");
        }*/




        //System.out.println("Min Heap created successfully.");
    }

}

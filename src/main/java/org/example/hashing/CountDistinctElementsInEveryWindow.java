package org.example.hashing;

import java.util.HashMap;

public class CountDistinctElementsInEveryWindow {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 3;
        countDistinct(arr, k);
    }

    public static void countDistinct(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.print(map.size() + " ");

        for(int i = k; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            map.put(arr[i - k], map.get(arr[i - k]) - 1);
            if(map.get(arr[i - k]) == 0) {
                map.remove(arr[i - k]);
            }
            System.out.print(map.size() + " ");
        }
    }

}

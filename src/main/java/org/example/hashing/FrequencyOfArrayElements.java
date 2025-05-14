package org.example.hashing;

import java.util.HashMap;

public class FrequencyOfArrayElements {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 2, 5, 5, 1, 1, 9, 10};
        Integer[] arr2 = {1, 2, 2, 4, 5, 7, 7, 8, 8, 10};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer i : arr) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        System.out.println("Frequency of elements in arr: " + map);

        map.clear();

        for(Integer i : arr2) {
           map.put(i, map.getOrDefault(i, 0)+1);
        }
        System.out.println("Frequency of elements in arr2: " + map);
    }
}

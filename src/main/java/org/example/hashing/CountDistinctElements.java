package org.example.hashing;

import java.util.Arrays;
import java.util.HashSet;

public class CountDistinctElements {

    public static void main(String[] args) {

        CountDistinctElements c = new CountDistinctElements();
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Count of distinct elements: " + c.countDistinct(arr1));

        Integer[] arr2 = {1, 2, 2, 2, 5, 5, 1, 1, 9, 10};
        System.out.println("Count of distinct elements: " + c.countDistinct1(arr2));
    }

    //Efficient Implementation
    public int countDistinct(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }
        return set.size();
    }

    //Improved efficient Implementation
    public int countDistinct1(Integer[] arr){
        HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));
        return set.size();
    }

}

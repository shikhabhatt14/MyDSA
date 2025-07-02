package org.example.extra.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctAndDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3};

        // Finding distinct elements
        System.out.print("Distinct elements: ");
        Arrays.stream(arr).distinct().forEach(e -> System.out.print(e + " "));
        System.out.println();

        // Finding duplicate elements
        System.out.print("Duplicate elements: ");
        Arrays.stream(arr)
                .filter(i -> Arrays.stream(arr).filter(j -> j == i).count() > 1)
                .distinct()
                .forEach(e -> System.out.print(e + " "));


        //finding duplicate elements using set
        // Set to store the duplicate elements
        Set<Integer> items = new HashSet<>();

        System.out.print("Duplicate elements using Set: ");

        Arrays.stream(arr).filter(i -> !items.add(i)).forEach(e -> System.out.print(e + " "));;
    }
}

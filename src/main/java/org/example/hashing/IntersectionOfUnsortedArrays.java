package org.example.hashing;

import java.util.HashSet;

public class IntersectionOfUnsortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};

        System.out.println("Intersection of arrays: " + findIntersection(arr1, arr2));
    }

    public static String findIntersection(int[] arr1, int[] arr2) {
        StringBuilder intersection = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr2) {
            set.add(num);
        }

        for (int num : arr1) {
            if (set.contains(num)) {
                intersection.append(num).append(" ");
            }
        }

        return intersection.toString().trim();
    }

}

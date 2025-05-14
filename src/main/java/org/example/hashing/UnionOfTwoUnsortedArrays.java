package org.example.hashing;

import java.util.HashSet;

public class UnionOfTwoUnsortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};

        //int[] union = unionOfArrays(arr1, arr2);

        System.out.print("Union of two unsorted arrays: " + unionOfArrays(arr1, arr2));
        /*for (int num : union) {
            System.out.print(num + " ");
        }*/
    }

    public static HashSet<Integer> unionOfArrays(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {
            set.add(num);
        }

        /*int[] unionArray = new int[set.size()];
        int index = 0;

        for (int num : set) {
            unionArray[index++] = num;
        }*/

        return set;
    }

}

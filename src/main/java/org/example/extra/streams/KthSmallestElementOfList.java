package org.example.extra.streams;

import java.util.List;

public class KthSmallestElementOfList {

    public static void main(String[] args) {
        List<Integer> list = List.of(7, 10, 4, 3, 20, 15);
int k = 3; // We want to find the 3rd smallest element
        int kthSmallest = findKthSmallest(list,k);
        System.out.println("The "+k+"rd smallest element in the list is: " + kthSmallest);
    }

    public static int findKthSmallest(List<Integer> list, int k) {
        if (k < 1 || k > list.size()) {
            throw new IllegalArgumentException("k must be between 1 and the size of the list");
        }
        return list.stream().sorted().skip(k - 1).findFirst().orElseThrow();
    }

}

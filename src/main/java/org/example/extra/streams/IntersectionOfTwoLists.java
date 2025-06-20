package org.example.extra.streams;

import java.util.List;

public class IntersectionOfTwoLists {

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(4, 5, 6, 7, 8);

        List<Integer> intersection = list1.stream().filter(list2::contains).toList();
        System.out.println("Intersection of the two lists: " + intersection);
    }

}

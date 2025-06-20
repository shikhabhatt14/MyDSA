package org.example.extra.streams;

import java.util.List;

public class RemoveDuplicatesFromList {

    public static void main(String[] args) {
        List<String> list1 = List.of("apple", "banana", "apple", "cherry", "banana", "date");
        List<String> uniqueList = list1.stream().distinct().toList();
        System.out.println("List with duplicates removed: " + uniqueList);
    }

}

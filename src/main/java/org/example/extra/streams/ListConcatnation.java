package org.example.extra.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListConcatnation {

    public static void main(String[] args) {
        List<String> list1 = List.of("apple", "elderberry", "cherry");
        List<String> list2 = List.of("date", "banana", "fig");
        List<String> concatenatedList = Stream.concat(list1.stream(), list2.stream()).sorted().toList();
        System.out.println("Concatenated and sorted list: " + concatenatedList);
    }
}

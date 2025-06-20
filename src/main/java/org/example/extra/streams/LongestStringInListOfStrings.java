package org.example.extra.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestStringInListOfStrings {

    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "cherry", "date", "elderberry");
        String longestString = strings.stream()
                .reduce("", (a, b) -> a.length() >= b.length() ? a : b);
        System.out.println("Longest string using reduce: " + longestString);

        // Using max with a custom comparator
        Optional<String> longest = strings.stream().max(Comparator.comparingInt(String::length));
        System.out.println("Longest string using max: " + longest.orElse("No strings found"));
    }

}

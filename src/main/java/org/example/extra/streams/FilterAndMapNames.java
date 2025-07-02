package org.example.extra.streams;

import java.util.List;
import java.util.stream.Collectors;

public class FilterAndMapNames {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Aster", "Aron");

        // Filter names that start with 'A' and convert them to uppercase
        List<String> filteredList = names.stream().filter(str -> str.startsWith("A")).map(String :: toUpperCase).collect(Collectors.toList());

        System.out.println("Filtered and mapped names: " + filteredList);
    }

}

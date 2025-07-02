package org.example.extra.streams;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertListToCommaSeparatedString {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Aster", "Aron");

        String str =  names.stream().collect(Collectors.joining(","));
        System.out.println("Comma-separated string: " + str);
    }

}

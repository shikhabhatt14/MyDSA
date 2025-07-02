package org.example.extra.streams;

import java.util.List;

public class CountSringsWithGivenSubstring {

    public static void main(String[] args) {
        List<String> list = List.of("I love Java",
                "Java is powerful",
                "Python is great",
                "JavaScript is different",
                "Welcome to Java world"
        );

        String substring = "java";

        long count = list.stream().filter(str -> str.toLowerCase().contains(substring)).count();

        System.out.println("Count :: "+count);
    }

}

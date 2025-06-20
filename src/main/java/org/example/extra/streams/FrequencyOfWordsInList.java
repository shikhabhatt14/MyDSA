package org.example.extra.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfWordsInList {

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> frequencyMap = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        frequencyMap.forEach((word, count) -> System.out.println(word + ": " + count));
    }

}

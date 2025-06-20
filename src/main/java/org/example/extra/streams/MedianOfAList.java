package org.example.extra.streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MedianOfAList {

    public static void main(String[] args) {
        // Example list
        List<Integer> list = List.of(1, 3, 3, 6, 7, 8, 9);

        list = list.stream()
                .sorted().toList();

       if(list.size()%2 != 0) {
            // If the list has an odd number of elements, return the middle element
            int median = list.get(list.size() / 2);
            System.out.println("Median: " + median);
        } else {
            // If the list has an even number of elements, return the average of the two middle elements
            double median = (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0;
            System.out.println("Median: " + median);
        }
    }

}

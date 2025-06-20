package org.example.extra.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionListIntoTwoGroupsUsingPredicate {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> partitionedMap = list.stream().
                collect(Collectors.partitioningBy(num -> num % 2 == 0));

        List<Integer> evenList = partitionedMap.get(true);
        List<Integer> oddList = partitionedMap.get(false);

        System.out.println("Even numbers: " + evenList);
        System.out.println("Odd numbers: " + oddList);
    }

}

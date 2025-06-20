package org.example.extra.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SumOfTransactionAmountForEachDay {

    public static void main(String[] args) {
        List<Transaction> list = List.of(
            new Transaction("2023-10-01", 100),
            new Transaction("2023-10-01", 200),
            new Transaction("2023-10-02", 150),
            new Transaction("2023-10-02", 50),
            new Transaction("2023-10-03", 300)
        );

        Map<String, Integer> dailySum = list.stream().collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));
        System.out.println("Sum of transaction amounts for each day: " + dailySum);

    }

}

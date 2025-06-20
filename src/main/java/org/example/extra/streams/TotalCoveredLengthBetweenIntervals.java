package org.example.extra.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TotalCoveredLengthBetweenIntervals {

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(1, 3),
                new Interval(5, 8), new Interval(10, 12));
        int totalCoveredLength = intervals.stream()
                .mapToInt(interval -> interval.getEnd() - interval.getStart())
                .sum();
        System.out.println("Total covered length: " + totalCoveredLength);
    }

}

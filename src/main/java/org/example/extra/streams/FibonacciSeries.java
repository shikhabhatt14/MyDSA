package org.example.extra.streams;

import java.util.stream.Stream;

public class FibonacciSeries {

    public static void main(String[] args) {
        Stream<Integer> fibonacciStream = Stream.iterate(new Integer[]{0,1}, f -> new Integer[]{f[1], f[0] + f[1]})
                .map(f -> f[0]);

        fibonacciStream.limit(10).forEach(System.out::println);
    }

}

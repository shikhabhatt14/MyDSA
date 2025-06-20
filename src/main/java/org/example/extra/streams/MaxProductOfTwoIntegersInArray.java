package org.example.extra.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxProductOfTwoIntegersInArray {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 9, 2};
        int maxProduct = IntStream.range(0, arr.length)
                .mapToObj(i -> IntStream.range(i + 1, arr.length)
                        .map(j -> arr[i] * arr[j])
                        .max()
                        .orElse(Integer.MIN_VALUE))
                .max(Integer::compare)
                .orElse(Integer.MIN_VALUE);

        System.out.println("Maximum product of two integers in the array: " + maxProduct);
    }

}

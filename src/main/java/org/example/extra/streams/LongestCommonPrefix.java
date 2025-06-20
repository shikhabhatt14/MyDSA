package org.example.extra.streams;

import java.util.stream.Stream;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        String prefix = Stream.of(strings).reduce((s1,s2) -> {
            int minLength = Math.min(s1.length(), s2.length());
            int i=0;
            while(i<minLength &&s1.charAt(i)== s2.charAt(i)) {
                i++;
            }
            return s1.substring(0, i);
        }).orElse("");
        System.out.println("Longest Common Prefix: " + prefix);
    }

}

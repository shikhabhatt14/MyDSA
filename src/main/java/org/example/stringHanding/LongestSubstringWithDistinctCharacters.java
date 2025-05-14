package org.example.stringHanding;

import java.util.Arrays;

public class LongestSubstringWithDistinctCharacters {

    public static void main(String[] args) {
        String str = "abcabcdfebb";
        System.out.println("Longest substring with distinct characters: " + longestSubstring(str));
    }

    public static String longestSubstring(String str){
        int[] prevIndex = new int[256];
        Arrays.fill(prevIndex, -1);

        int begin = 0, start = 0, result = 0,maxEnd;
        for(int i=0;i<str.length();i++){
            start = Math.max(start, prevIndex[str.charAt(i)] + 1);
            maxEnd = i-start + 1;
            if(maxEnd > result){
                result = maxEnd;
                begin = start;
            }
            prevIndex[str.charAt(i)] = i;
        }
        System.out.println("Longest substring length: " + result);
        return str.substring(begin, begin + result);
    }
}

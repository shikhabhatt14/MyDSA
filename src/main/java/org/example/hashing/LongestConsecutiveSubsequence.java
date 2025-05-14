package org.example.hashing;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of longest consecutive subsequence is: " + findLongestConsecutiveSubsequence(arr));
    }

    public static int findLongestConsecutiveSubsequence(int[] arr) {
        int result = 0, sum = 0, curr = 0;
        HashSet<Integer> set  = new HashSet<>();
        for (int j : arr) {
            set.add(j);
        }
        for(int j : set) {
            if(!set.contains(j-1)) {
                curr = 1;
                while(set.contains(j + curr))
                    curr++;
                result = Math.max(result, curr);
            }
        }
        return result;
    }
}

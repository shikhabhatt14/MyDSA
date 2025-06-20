package org.example.dynamicProgramming.longestCommonSubsequenceProblem;

public class LongestRepeatingSubsequence {

    // This code finds the length of the longest repeating subsequence in a given string.
    // A repeating subsequence is a subsequence that appears more than once in the string.
    // The function lrs uses dynamic programming to build a table that stores the lengths of the longest repeating subsequences
    // for all prefixes of the string. The final result is found in the bottom-right cell of the table.
    // Time Complexity: O(n^2), where n is the length of the string.
    // Space Complexity: O(n^2) for the dp array.
    //example:
// Input: "AABEBCDD"
// Output: "longest repeating subsequence is of length 3" (The subsequence is "ABD")

    public static void main(String[] args) {
        String s = "AABEBCDD";
        int result = lrs(s, s.length());
        System.out.println("longest repeating subsequence is of length " + result);
    }

    public static int lrs(String s, int l1){
     int[][] dp = new int[l1 + 1][l1 + 1];
     for(int i=1; i<=l1; i++){
         for(int j=1; j<=l1; j++){
             if(s.charAt(i-1) == s.charAt(j-1) && i != j)
                 dp[i][j] = 1 + dp[i-1][j-1];
             else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
         }
     }

      return dp[l1][l1];
    }
}

package org.example.dynamicProgramming;

public class LongestRepeatingSubsequence {

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

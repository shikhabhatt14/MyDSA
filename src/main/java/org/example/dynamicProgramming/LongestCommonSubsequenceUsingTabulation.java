package org.example.dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequenceUsingTabulation {

    public static void main(String[] args) {
        String s1 = "ABCDEFGHIJKLMNOP";
        String s2 = "ACEDBEFGH";
        int result = lcs(s1, s2, s1.length(), s2.length());
        System.out.println("longest common subsequence is of length " + result);
    }

    public static int lcs(String s1, String s2, int l1, int l2){
        int[][] dp = new int[l1+1][l2+1];
        Arrays.fill(dp[0], 0);
        for(int i=0; i<=l2; i++)
            dp[0][i] = 0;

        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Integer.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[l1][l2];
    }

}

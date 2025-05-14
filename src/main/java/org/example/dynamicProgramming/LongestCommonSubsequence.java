package org.example.dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    //longest common subsequence problem using memoization(bottom up approach)
    //time complexity = theta(mn)
    //this is much less than a recursive solution where time complexity increases exponentially

    public static void main(String[] args) {
        String s1 = "ABCDEFGHIJKLMNOP";
        String s2 = "ACEDBEFGH";
        int result = lcs(s1, s2, s1.length(), s2.length());
        System.out.println("longest common subsequence is of length " + result);
    }

    public static int lcs(String s1, String s2, int l1, int l2){
        int[][] memo = new int[l1+1][l2+1];
        for (int[] r : memo)
            Arrays.fill(r, -1);
        if(memo[l1][l2] != -1)
            return memo[l1][l2];
        if(l1 == 0 || l2 == 0)
            memo[l1][l2] =0;
        else if(s1.charAt(l1-1) == s2.charAt(l2-1))
            memo[l1][l2] = 1 + lcs(s1, s2, l1-1, l2-1);
        else
            memo[l1][l2] = Integer.max(lcs(s1, s2, l1-1, l2),
                    lcs(s1, s2, l1, l2-1));
        return memo[l1][l2];
    }
}

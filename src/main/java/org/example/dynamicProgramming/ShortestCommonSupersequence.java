package org.example.dynamicProgramming;

public class ShortestCommonSupersequence {
    //shortest common supersequence problem using memoization(bottom up approach)
    //time complexity = theta(mn)
    //this is much less than a recursive solution where time complexity increases exponentially

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int result = scs(s1, s2, s1.length(), s2.length());
        System.out.println("shortest common supersequence is of length " + result);
    }

    public static int scs(String s1, String s2, int l1, int l2){
        return (l1 + l2 - LongestCommonSubsequence.lcs(s1, s2, l1, l2));
    }
}

package org.example.dynamicProgramming;

public class LongestPalindromicSubsequenceInString {

    public static void main(String[] args) {
        String s1 = "GEEKSFORGEEKS";
        String s2 = new StringBuilder(s1).reverse().toString();
        int result = LongestCommonSubsequence.lcs(s1, s2, s1.length(), s2.length());
        System.out.println("longest palindromic subsequence is of length " + result);
    }

}

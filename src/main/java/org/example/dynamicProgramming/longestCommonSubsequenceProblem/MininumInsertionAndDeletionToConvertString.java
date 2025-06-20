package org.example.dynamicProgramming.longestCommonSubsequenceProblem;

public class MininumInsertionAndDeletionToConvertString {

    public static void main(String[] args) {
        String s1 = "GEEK";
        String s2 = "GEEKSFORGEEKS";
        int result = LongestCommonSubsequence.lcs(s1, s2, s1.length(), s2.length());
        System.out.println("longest common subsequence is of length " + result);
        System.out.println("Min insertion: "+ (s1.length()-result));
        System.out.println("Min deletion: "+ (s2.length()-result));
    }

}

package org.example.recursion;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "ABCDEFGHIJKLMNOP";
        String s2 = "ACEDBEFGH";
        int result = lcs(s1, s2, s1.length(), s2.length());
        System.out.println("longest common subsequence is of length " + result);
    }

    public static int lcs(String s1, String s2, int l1, int l2){
        //base case
        if(l1 == 0 || l2 == 0)
            return 0;
        if(s1.charAt(l1-1) == s2.charAt(l2-1))
            return 1 + lcs(s1, s2, l1-1, l2-1);
        else
            return Integer.max(lcs(s1, s2, l1-1, l2),
                    lcs(s1, s2, l1, l2-1));
    }

}

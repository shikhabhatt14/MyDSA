package org.example.dynamicProgramming.longestCommonSubsequenceProblem;

public class SpaceOptimimizedLongestCommonSubsequence {

    //longest common subsequence problem using space optimized(top down approach)
    //time complexity = theta(mn)
    //this is much less than a recursive solution where time complexity increases exponentially
    //space complexity = O(n) where n is the length of the longest string
    // this is much less than a recursive solution where space complexity increases exponentially
    public static void main(String[] args) {
        String s1 = "ACEDBEFGH";
        String s2 = "ACDFEBCGH";
        int result = lcs(s1, s2);
        System.out.println("longest common subsequence is of length " + result);
    }

    public static int lcs(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int[] curr = new int[l2 + 1];
        int[] prev = new int[l2 + 1];
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr.clone();
        }
        return prev[l2];
    }

}

package org.example.dynamicProgramming.editDistanceProblem;

import java.util.Arrays;

public class EditDistanceProblemUsingMemoization {

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        int l1 =  s1.length();
        int l2 = s2.length();
        int[][] memo = new int[l1+1][l2+1];
        for(int[] r : memo)
            Arrays.fill(r,-1);
        int result1 = editDistance(s1, s2, l1, l2, memo);
        System.out.println("edit distance is " + result1);
    }

    public static int editDistance(String s1, String s2, int l1, int l2, int[][] memo) {

        if(l1 == 0)
            memo[l1][l2] = l2;
        else if(l2 == 0)
            memo[l1][l2] = l1;
        else if(s1.charAt(l1-1) == s2.charAt(l2-1)) {
            memo[l1][l2] = editDistance(s1, s2, l1-1, l2-1, memo);
        }else {
            memo[l1][l2] = 1 + Math.min(
                    editDistance(s1, s2, l1, l2-1, memo), // insert
                    Math.min(
                            editDistance(s1, s2, l1-1, l2, memo), // delete
                            editDistance(s1, s2, l1-1, l2-1, memo) // replace
                    )
            );
        }
        return memo[l1][l2];
    }

}

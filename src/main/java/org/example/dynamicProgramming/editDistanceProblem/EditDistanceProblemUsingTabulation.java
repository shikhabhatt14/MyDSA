package org.example.dynamicProgramming.editDistanceProblem;

public class EditDistanceProblemUsingTabulation {

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        int result1 = editDistance(s1, s2);
        System.out.println("edit distance is " + result1);
    }

    public static int editDistance(String s1, String s2){

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=0; i<=s1.length();i++)
            dp[i][0] = i;

        for(int j=1; j<=s2.length();j++)
            dp[0][j] = j;

        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

}

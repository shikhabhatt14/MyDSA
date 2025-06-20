package org.example.dynamicProgramming.editDistanceProblem;

public class SpaceOptimizedEditDistanceProblem {

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";

        int result2 = editDistanceStorageOptimized(s1, s2);
        System.out.println("edit distance using storage optimized solution is " + result2);
    }

    public static int editDistanceStorageOptimized(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int[] prev = new int[l2+1];
        int[] curr = new int[l2+1];
        for(int j=0; j<=l2; j++)
            prev[j] = j;
        for(int i=1; i<=l1; i++) {
            curr[0] = i;
            for (int j=1; j<=l2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    curr[j] = prev[j-1];
                else{
                    int insert = curr[j-1];
                    int delete = prev[j];
                    int replace = prev[j-1];
                    curr[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr.clone();
        }
        return curr[l2];
    }

}

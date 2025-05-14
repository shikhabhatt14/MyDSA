package org.example.recursion;

public class editDistanceProblem {

    //edit distance problem using recursion
    //time complexity = O(3^n) where n is the length of the longest string
    //problem statement:
    //given two strings, find the minimum number of operations required to convert one string into another
    //the operations allowed are:
    //1. insert a character
    //2. delete a character
    //3. replace a character
    //for example, given s1 = "sunday" and s2 = "saturday", the output should be 3

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        int result = editDistance(s1, s2, s1.length(), s2.length());
        System.out.println("edit distance is " + result);
    }

    public static int editDistance(String s1, String s2, int l1, int l2){
        int result = 0;
        if(l1 == 0)
            return l2;
        if(l2 == 0)
            return l1;
        if(s1.charAt(l1-1) == s2.charAt(l2-1))
            result = editDistance(s1, s2, l1-1, l2-1);
        else{
            int insert = editDistance(s1, s2, l1, l2-1);
            int delete = editDistance(s1, s2, l1-1, l2);
            int replace = editDistance(s1, s2, l1-1, l2-1);
            result = 1 + Math.min(insert, Math.min(delete, replace));
        }
        return result;
    }

}

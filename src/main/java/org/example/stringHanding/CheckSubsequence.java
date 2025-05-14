package org.example.stringHanding;

public class CheckSubsequence {
    //subsequence of ABC is A, B, C, AB, AC, BC, ABC

    public static void main(String[] args) {
        String str1 = "helloworld";
        String str2 = "hlwr";
        boolean result =isSubsequence(str1, str2);
        //boolean result = isSubsequenceRecursive(str1, str2, 0, 0);
        if(result) {
            System.out.println("Yes, " + str2 + " is a subsequence of " + str1);
        } else {
            System.out.println("No, " + str2 + " is not a subsequence of " + str1);
        }
    }

    public static boolean isSubsequence(String str1, String str2){
        int i, j;
        for(i = 0, j=0; i < str1.length() && j < str2.length(); i++) {
            if(str1.charAt(i) == str2.charAt(j))
                j++;
        }
        if(j == str2.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSubsequenceRecursive(String str1, String str2, int i, int j) {
        if(j == str2.length())
            return true;
        if(i == str1.length())
            return false;
        if(str1.charAt(i) == str2.charAt(j))
            return isSubsequenceRecursive(str1, str2, i + 1, j + 1);
        else
            return isSubsequenceRecursive(str1, str2, i + 1, j);
    }

}

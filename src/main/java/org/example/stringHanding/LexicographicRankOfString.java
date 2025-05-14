package org.example.stringHanding;

public class LexicographicRankOfString {

    public static void main(String[] args) {
        String str = "string";
        System.out.println("Lexicographic rank of " + str + " is: " + findRank(str));
    }

    static int findRank(String str){
        int[] countPrev = new int[256];
        int rank = 1;
        int fact = factorial(str.length());

        for(int i=0; i<str.length(); i++)
            countPrev[str.charAt(i)]++;

        for(int i=1; i<256; i++) {
            countPrev[i] += countPrev[i - 1];
           /* if(countPrev[i]>0)
                System.out.println("countPrev[" + i + "] = " + countPrev[i]);*/
        }

        for(int i=0; i<str.length()-1; i++){
            fact = fact / (str.length() - i);
            rank = rank + countPrev[str.charAt(i) - 1] * fact;
            for(int j = str.charAt(i); j < 256; j++)
                countPrev[j]--;
        }
        return rank;
    }

    static int factorial(int n){
        if(n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }

}

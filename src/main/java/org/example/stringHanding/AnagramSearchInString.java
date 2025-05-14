package org.example.stringHanding;

public class AnagramSearchInString {
    public static void main(String[] args) {
        String text = "geeksforgeeks";
        String pat = "eekgs";
        int[] CT = new int[256];
        int[] CP = new int[256];
        int i = 0, j = 0;
        for(i=0;i<pat.length();i++){
            CT[text.charAt(i)]++;
            CP[pat.charAt(i)]++;
        }
        for(i=pat.length(); i<=text.length();i++){
            if(areSame(CT, CP)){
                System.out.println("Anagram found at index: " + (i-pat.length()));
            }
            if(i<text.length()) {
                CT[text.charAt(i)]++;
                CT[text.charAt(i - pat.length())]--;
            }
        }
    }

    public static boolean areSame(int[] CT, int[] CP) {
        for (int i = 0; i < 256; i++) {
            if (CT[i] != CP[i]) {
                return false;
            }
        }
        return true;
    }
}

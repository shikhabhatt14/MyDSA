package org.example.stringHanding;

public class Anagram {

    //Anagram - characters of two string are same but in different order

    static final int CHAR = 256;

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        boolean result = isAnagram(str1, str2);
        if(result) {
            System.out.println("Yes, " + str1 + " and " + str2 + " are anagrams");
        } else {
            System.out.println("No, " + str1 + " and " + str2 + " are not anagrams");
        }
    }

    public static boolean isAnagram(String str1, String str2){
        int[] count = new int[CHAR];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for(int i = 0; i < CHAR; i++) {
            if(count[i] != 0) {
                return false;
            }
        }
        return true;
    }

}

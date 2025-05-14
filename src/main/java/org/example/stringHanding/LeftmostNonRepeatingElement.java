package org.example.stringHanding;

import java.util.Arrays;

public class LeftmostNonRepeatingElement {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int index = leftmostNonRepeatingCharacter(str);
        if(index == -1) {
            System.out.println("No non-repeating character");
        } else {
            System.out.println("Leftmost non-repeating character is " + str.charAt(index));
        }
    }

    public static int leftmostNonRepeatingCharacter(String str){
        int[] freq = new int[256];
        Arrays.fill(freq, -1);
        for(int i = 0; i < str.length(); i++){
            if(freq[str.charAt(i)] == -1){
                freq[str.charAt(i)] = i;
            } else {
                freq[str.charAt(i)] = -2; // mark as repeating
            }
        }
        for(int i=0; i<256; i++){
            if(freq[i] >= 0){
                return freq[i];
            }
        }
        return -1; // no non-repeating character found
    }

}

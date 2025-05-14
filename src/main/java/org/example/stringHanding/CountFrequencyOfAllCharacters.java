package org.example.stringHanding;

public class CountFrequencyOfAllCharacters {

    public static void main(String[] args) {
        String str = "helloworld"; //considering only lower case else size of array will be 256
        int[] freq = new int[32];
        for(int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] != 0) {
                System.out.println((char)(i + 'a') + " : " + freq[i]);
            }
        }

    }

}

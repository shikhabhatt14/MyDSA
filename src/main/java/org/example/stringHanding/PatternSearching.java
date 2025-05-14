package org.example.stringHanding;

import java.util.ArrayList;

public class PatternSearching {


    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba";
        String pat = "aaba";

        int i = 0, j = 0;
        int start = 0, iter = 0;
        while(i<txt.length() && j<pat.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            } else {
                i++;
            }
            if(j == pat.length()){
                System.out.println("Pattern found at index: " + (i-j));
                start = i = i-j+1;
                j = 0;
            }
            iter++;
        }

        System.out.println("Total iterations: " + iter);

        // Construct lps array
        /*int[] lps = new int[pat.length()];
        constructLps(lps, pat);
        for (int i = 0; i < pat.length(); i++)
            System.out.print(lps[i] + " ");*/

        //pattern search using kmp algo
        /*ArrayList<Integer> res = search(pat, txt);
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");*/
    }

    public static void constructLps(int[] lps, String pattern) {
        int len = 0;
        lps[0] = 0; // lps[0] is always 0
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    static ArrayList<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];
        ArrayList<Integer> res = new ArrayList<>();

        constructLps(lps, pat);

        // Pointers i and j, for traversing
        // the text and pattern
        int i = 0;
        int j = 0;

        while (i < n) {
            // If characters match, move both pointers forward
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                // If the entire pattern is matched
                // store the start index in result
                if (j == m) {
                    res.add(i - j);

                    // Use LPS of previous index to
                    // skip unnecessary comparisons
                    j = lps[j - 1];
                }
            }

            // If there is a mismatch
            else {

                // Use lps value of previous index
                // to avoid redundant comparisons
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return res;
    }
}

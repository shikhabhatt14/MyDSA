package org.example.stringHanding;

public class Palindrome {

    public static void main(String[] args) {
        String str = "madaaaaafgaaaaadam";
        int start = 0;
        int end = str.length() - 1;
        boolean isPalindrome = true;
        while (start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        if(isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }

}

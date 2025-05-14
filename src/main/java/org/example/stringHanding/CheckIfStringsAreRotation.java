package org.example.stringHanding;

public class CheckIfStringsAreRotation {

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "deabc";

        if((str1 + str1).indexOf(str2) > 0) {
            System.out.println("Yes, " + str1 + " and " + str2 + " are rotations of each other");
        } else {
            System.out.println("No, " + str1 + " and " + str2 + " are not rotations of each other");
        }
    }
}

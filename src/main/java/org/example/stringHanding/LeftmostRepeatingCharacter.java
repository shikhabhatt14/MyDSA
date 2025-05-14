package org.example.stringHanding;

public class LeftmostRepeatingCharacter {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int index = leftmostRepeatingCharacter(str);
        if(index == -1) {
            System.out.println("No repeating character");
        } else {
            System.out.println("Leftmost repeating character is " + str.charAt(index));
        }

    }

    public static int leftmostRepeatingCharacter(String str){
        boolean[] visited = new boolean[256];
        int index = 0;
        for(int i = str.length()-1; i>=0;i--){
            if(visited[str.charAt(i)]){
                index = i;
            } else {
                visited[str.charAt(i)] = true;
            }
        }
        return index;
    }

}

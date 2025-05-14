package org.example.stringHanding;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String str = "Welcome to   this World";
        char[] arr = str.toCharArray();
        arr  = reverseWords(arr);
        System.out.println(arr); // Output: "World Hello"
    }

    public static char[] reverseWords(char[] arr){

        int start = 0, end; char temp;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == ' ' && arr[i+1] != ' '){
                end = i-1;
                reverse(arr, start, end);
                start = i+1;
            }
        }
        /*int i=0;
        while(i<arr.length){
            if(arr[i] == ' ' && arr[i+1] != ' '){
                end = i-1;
                reverse(arr, start, end);
                start = i+1;
            }
            i++;
        }*/
        end = arr.length-1;
        reverse(arr, start, end);
        reverse(arr,0, end);
        return arr;
    }

    public static void reverse(char[] arr, int start, int end){
        char temp;
        while(end>start){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            end--;
            start++;
        }
    }

}

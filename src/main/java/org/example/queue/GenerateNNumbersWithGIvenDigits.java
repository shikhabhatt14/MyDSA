package org.example.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateNNumbersWithGIvenDigits {

    // Given a number n and two digits n1 and n2, the task is to generate the first n numbers
    // with the digits n1 and n2 in their decimal representation.
    // The numbers should be generated in increasing order.
    // For example, if n = 10, n1 = 5, and n2 = 6, the output should be:
    // 5 6 55 56 65 66 555 556 565 566

    public static void main(String[] args) {
        int n = 10;
        String n1 = "5",n2 = "6";
        printNumbers(n, n1, n2);
    }

    public static void printNumbers(int n, String n1, String n2) {
        Queue<String> q = new LinkedList<>();
        q.add(n1);
        q.add(n2);
        while(n>0){
            String str = q.poll();
            System.out.print(str + " ");
            q.offer(str+n1);
            q.offer(str+n2);
            n--;
        }


    }

}

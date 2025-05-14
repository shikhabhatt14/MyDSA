package org.example.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueUsingRecursion {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Original Queue: " + queue);
        reverse(queue);
        System.out.println("Reversed Queue: " + queue);
    }

    public static void reverse(Queue<Integer> queue) {
        if(queue.isEmpty())
            return;
        int front = queue.poll();
        reverse(queue);
        queue.add(front);
    }

}

package org.example.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueUsingArrayDeque {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>(5);
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println("Queue after enqueuing elements:");
        display(queue);

        System.out.println("Dequeued element: " + queue.poll());
        System.out.println("Queue after dequeuing an element:");
        display(queue);

        System.out.println("Front element: " + queue.peek());
    }

    public static void display(Queue<Integer> queue) {
        for (Integer element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

}

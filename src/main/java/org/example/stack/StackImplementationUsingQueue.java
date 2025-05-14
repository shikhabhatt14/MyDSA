package org.example.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplementationUsingQueue {

    public static void main(String[] args) {
        Queue<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.offer(2);
        stack.add(3);
        stack.offer(4);

        System.out.println("Stack elements: " + stack);
        pop(stack);
        stack.offer(10);
        System.out.println("Stack elements after inserting: " + stack);
    }

    public static void pop(Queue<Integer> queue){
        if(queue.isEmpty())
            System.out.println("Empty Stack. Nothing to pop");
        Queue<Integer> tempQ = new LinkedList<>();
        while(queue.size() > 1){
            tempQ.add(queue.poll());
        }
        System.out.println("Popped element: " + queue.poll());
        while(!tempQ.isEmpty()){
            queue.add(tempQ.poll());
        }

    }

}

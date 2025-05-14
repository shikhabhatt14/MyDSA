package org.example.linkedlist;

public class FloydCycleDetection {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head; // Creating a cycle

        if (hasCycle(head)) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle detected in the linked list.");
        }
    }

    public static boolean hasCycle(Node head){
        if(head == null)
            return false;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow .next;
            fast = fast.next.next;
            if(slow.data == fast.data){
                return true;
            }
        }
        return false;
    }

}

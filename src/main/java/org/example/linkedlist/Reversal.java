package org.example.linkedlist;

public class Reversal {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        Traversal.print(head);

        head = reverseLinkedList(head);

        System.out.println("Reversed List:");
        Traversal.print(head);
    }

    public static Node reverseLinkedList(Node head){
        if(head == null)
            return null;
        Node curr = head.next;
        Node temp = null;
        Node originalHead = head;
        while(curr != null){
            temp = curr.next;
            curr.next = head;
            head = curr;
            curr = temp;
        }
        originalHead.next = null; // Set the next of the original head to null
        return head;
    }
}

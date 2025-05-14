package org.example.linkedlist;

public class DoublyLinkedListReversal {

    public static void main(String[] args) {
        DoublyLinkedListNode head = new DoublyLinkedListNode(1);
        head.next = new DoublyLinkedListNode(2);
        head.next.prev = head;
        head.next.next = new DoublyLinkedListNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new DoublyLinkedListNode(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new DoublyLinkedListNode(5);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Original List:");
        DoublyLinkedListTraversal.printDoublyLinkedList(head);

        head = reverseDoublyLinkedList(head);

        System.out.println("Reversed List:");
        DoublyLinkedListTraversal.printDoublyLinkedList(head);
    }

    public static DoublyLinkedListNode reverseDoublyLinkedList(DoublyLinkedListNode head) {
        if (head == null) {
            return null;
        }

        DoublyLinkedListNode current = head;
        DoublyLinkedListNode temp = null;

        // Swap next and prev for all nodes
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // Move to the next node in the original list
        }

        // Before returning, check if temp is not null
        if (temp != null) {
            head = temp.prev; // Update head to the new first node
        }

        return head;
    }

}

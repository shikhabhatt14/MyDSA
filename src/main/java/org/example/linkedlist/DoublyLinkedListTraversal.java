package org.example.linkedlist;

public class DoublyLinkedListTraversal {

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

        printDoublyLinkedList(head);
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        System.out.print("Forward Traversal: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

        current = head;
        while (current.next != null) {
            current = current.next;
        }

        System.out.print("Backward Traversal: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

}

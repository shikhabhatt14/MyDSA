package org.example.linkedlist;

public class DoublyLinkedListInsertion {

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

        /*Traversal.printDoublyLinkedList(head);

        head = insertAtBeginning(head, 0);
        Traversal.printDoublyLinkedList(head);

        head = insertAtEnd(head, 6);
        Traversal.printDoublyLinkedList(head);*/

        head = insertAtPosition(head, 3, 10);
        DoublyLinkedListTraversal.printDoublyLinkedList(head);
    }

    public static DoublyLinkedListNode insertAtPosition(DoublyLinkedListNode head, int pos, int data){
        DoublyLinkedListNode curr = new DoublyLinkedListNode(data);
        if(head == null) {
            if (pos > 1) {
                System.out.println("Position is greater than the length of the list.");
                return head;
            }
            return curr;
        }
        if(pos == 1){
            curr.next = head;
            head.prev = curr;
            return curr;
        }
        DoublyLinkedListNode temp = head;
        for(int i=1; i<pos-1 && temp != null; i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Position is greater than the length of the list.");
            return head;
        }
        curr.next = temp.next;
        curr.prev = temp;
        temp.next = curr;
        if(curr.next != null){
            curr.next.prev = curr;
        }
        while(curr.prev != null)
            curr = curr.prev;
        return curr;
    }

}

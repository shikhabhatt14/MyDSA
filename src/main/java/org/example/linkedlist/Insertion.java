package org.example.linkedlist;

public class Insertion {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = insertAtBeginning(head, 0);
        head = insertAtEnd(head, 6);
        head = inserAtPosition(head, 3, 10);
        head = inserAtPosition(head, 9, 20);
        Traversal.print(head);
    }

    public static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static Node inserAtPosition(Node head, int pos, int data){
        Node curr = head;
        int count = 1;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        if(pos > count){
            System.out.println("Position is greater than the length of the list.");
            return head;
        }
        if(pos == 1){
            return insertAtBeginning(head, data);
        } else {
            Node newNode = new Node(data);
            curr = head;
            for(int i=1; i<pos-1; i++){
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
        return head;
    }

}

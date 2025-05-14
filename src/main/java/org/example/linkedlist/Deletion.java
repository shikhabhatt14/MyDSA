package org.example.linkedlist;

public class Deletion {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        Traversal.print(head);

        head = deleteNode(head, 3);

        System.out.println("List after deletion:");
        Traversal.print(head);
    }

    public static Node deleteNode(Node head, int key){
        if(head == null){
            System.out.println("List is empty.");
            return null;
        }
        Node curr = head;
        while(curr != null && curr.data != key){
            curr = curr.next;
        }
        if(curr == null){
            System.out.println("Node with value " + key + " not found.");
            return head;
        }
        if(curr == head){
            head = head.next;
        } else {
            Node prev = head;
            while(prev.next != curr){
                prev = prev.next;
            }
            prev.next = curr.next;
        }

        return head;
    }

}

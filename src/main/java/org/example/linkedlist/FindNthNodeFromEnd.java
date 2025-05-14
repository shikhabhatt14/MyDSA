package org.example.linkedlist;

public class FindNthNodeFromEnd {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = 2; // Find the 2nd node from the end
        Node nthNodeFromEnd = findNthNodeFromEnd(head, n);
        if (nthNodeFromEnd != null) {
            System.out.println("The " + n + "th node from the end is: " + nthNodeFromEnd.data);
        } else {
            System.out.println("The list is shorter than " + n + " nodes.");
        }
    }

    public static Node findNthNodeFromEnd(Node head, int n) {
        Node curr = head;
        int count = 0;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        if(n > count){
            return null;
        }
        int pos = count - n;
        curr = head;
        for(int i=1;i<=pos; i++){
            curr = curr.next;
        }
         return curr;
    }

}

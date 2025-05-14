package org.example.linkedlist;

public class LoopDeletion {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next; // Creating a loop

        System.out.println("Original List:");
        Traversal.print(head);

        head = removeLoop(head);

        System.out.println("List after removing loop:");
        Traversal.print(head);
    }

    public static Node removeLoop(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow .next;
            fast = fast.next.next;
            if(slow.data == fast.data){
                break;
            }
        }
        slow = head;
        //to be done


        return head;
    }

}

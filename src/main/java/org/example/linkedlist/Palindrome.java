package org.example.linkedlist;

public class Palindrome {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println(isPalindrome(head)); // Output: true

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        System.out.println(isPalindrome(head2)); // Output: false
    }

    public static boolean isPalindrome(Node head){
    if(head == null)
        return false;
    Node slow = head;
    Node fast = head;

    // Find the middle of the linked list. by end of the loop slow will point to the middle of the list.
    while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;

    }
    // Reverse the second half of the linked list
        Node rev = Reversal.reverseLinkedList(slow.next);
        Node curr = head;
        while(rev != null) {
            if (curr.data != rev.data) {
                return false;
            }
            curr = curr.next;
            rev = rev.next;
        }
        return true;
    }

}

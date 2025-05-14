package org.example.linkedlist;

public class IntersectionPointOfTwoLinkedList {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = new Node(6);
        head2.next = new Node(7);
        head2.next.next = head1.next; // Intersection at node with value 2

        int intersectionPoint = findIntersection(head1, head2);
        if (intersectionPoint != -1) {
            System.out.println("Intersection point is at node with value: " + intersectionPoint);
        } else {
            System.out.println("No intersection point found.");
        }
    }

    public static int findIntersection(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return -1;
        }
        Node curr1 = head1;
        Node curr2 = head2;

        int c1 = 0, c2 = 0;

        while(curr1 != null){
            curr1 = curr1.next;
            c1++;
        }

        while(curr2 != null){
            curr2 = curr2.next;
            c2++;
        }

        int diff = 0;
        Node longer = null;
        if(c1 > c2) {
            diff = c1 - c2;
            longer = head1;
        } else {
            diff = c2 - c1;
            longer = head2;
        }
        int point = -1;
        if(longer == head1)
            point = find(longer, head2, diff);
        else
            point = find(longer, head1, diff);

        return point;
    }

    public static int find(Node longer, Node shorter, int diff){
        while(diff > 0){
            longer = longer.next;
            diff--;
        }
        while(longer != null && shorter != null){
            if(longer == shorter)
                return longer.data;
            longer = longer.next;
            shorter = shorter.next;
        }
        return -1;
    }

}

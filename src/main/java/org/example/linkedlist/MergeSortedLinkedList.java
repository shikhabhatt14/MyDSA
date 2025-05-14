package org.example.linkedlist;

public class MergeSortedLinkedList {

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);

        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        Node mergedList = mergeSortedLists(list1, list2);
        Traversal.print(mergedList);
    }

    public static Node mergeSortedLists(Node list1, Node list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        Node mergedList = null;
        Node head = null;
        if(list1.data < list2.data) {
            mergedList = list1;
            head = list1;
            list1 = list1.next;
        } else {
            mergedList = list2;
            head = list2;
            list2 = list2.next;
        }
        while(list1 != null && list2 != null){
            if (list1.data < list2.data) {
                mergedList.next = list1;
                mergedList = list1;
                list1 = list1.next;
            } else {
                mergedList.next = list2;
                mergedList = list2;
                list2 = list2.next;
            }
        }
        if(list1 != null)
            mergedList.next = list1;
        if(list2 != null)
            mergedList.next = list2;
        return head;
    }

}

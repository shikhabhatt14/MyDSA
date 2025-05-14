package org.example.linkedlist;

import java.util.HashSet;

public class LRUCache {

    /*The Last Recently Used (LRU) cache design is a popular algorithmic approach
    used to manage cache memory in computer systems. It aims to maximize cache
    hit rates by evicting the least recently used items when the cache becomes full.*/

    static final int capacity = 3;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        LRUCache  cache = new LRUCache(); // Capacity of the cache is 3
        DoublyLinkedListNode head = null;
        head= cache.put(head, 1);
        printCache(head);
        head= cache.put(head, 2);
        printCache(head);
        head= cache.put(head, 3);
        printCache(head);
        head= cache.put(head, 4); // This will remove the least recently used item (1)
        printCache(head);
        head= cache.put(head, 2); // This will mark 2 as the most recently used item
        printCache(head);
    }

    public static DoublyLinkedListNode put(DoublyLinkedListNode head, int data){
        DoublyLinkedListNode curr = head;
        if(head == null){
            head = new DoublyLinkedListNode(data);
            set.add(data);
            return head;
        }else if(set.contains(data)){
            System.out.println("Data already exists in the cache. marking it as head");
            while(curr != null){
                if(curr.data == data) {
                    break;
                }
                curr = curr.next;
            }
            curr.prev.next = curr.next;
            if(curr.next != null){
                curr.next.prev = curr.prev;
            }
            curr.next = head;
            curr.prev = null;
            head.prev = curr;
            head = curr;
            return head;
        }else if(set.size() == capacity){
            System.out.println("Cache is full. Removing least recently used data.");
            DoublyLinkedListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.prev.next = null;
            set.remove(temp.data);

        }
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        set.add(data);
        return head;

    }

    public static void printCache(DoublyLinkedListNode head){
        DoublyLinkedListNode curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}

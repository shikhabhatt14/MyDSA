package org.example.hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashChaining {

    int Bucket;
    ArrayList<LinkedList<Integer>> table;

    MyHashChaining(int b) {
        Bucket = b;
        table = new ArrayList<>(b);
        for (int i = 0; i < b; i++) {
            table.add(new LinkedList<>());
        }
    }

    public void insert(int key) {
        int index = key % Bucket;
        LinkedList<Integer> list = table.get(index);
        if (!list.contains(key)) {
            list.add(key);
        }
    }

    public void delete(int key) {
        int index = key % Bucket;
        LinkedList<Integer> list = table.get(index);
        if (list.contains(key)) {
            list.remove(Integer.valueOf(key));
        }
    }

    public boolean search(int key) {
        int index = key % Bucket;
        LinkedList<Integer> list = table.get(index);
        return list.contains(key);
    }

    public void display() {
        for (int i = 0; i < Bucket; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Integer key : table.get(i)) {
                System.out.print(key + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyHashChaining hashTable = new MyHashChaining(7);
        hashTable.insert(10);
        hashTable.insert(20);
        hashTable.insert(30);
        hashTable.insert(40);
        hashTable.insert(50);
        hashTable.insert(60);
        hashTable.insert(70);
        hashTable.insert(80);
        hashTable.insert(90);

        System.out.println("Hash Table:");
        hashTable.display();

        System.out.println("Search for 30: " + hashTable.search(30));
        System.out.println("Search for 100: " + hashTable.search(100));

        hashTable.delete(30);
        System.out.println("After deleting 30:");
        hashTable.display();
    }

}

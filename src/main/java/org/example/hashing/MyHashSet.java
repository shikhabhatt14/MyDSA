package org.example.hashing;

import java.util.HashSet;
import java.util.Iterator;

public class MyHashSet {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<String>();
        set.add("Hello");
        set.add("World");
        set.add("ide");

        System.out.println("HashSet: " + set);

        System.out.println("ide: " + set.contains("ide"));
        System.out.println("ide1: " + set.contains("ide1"));

        //traversal using Iterator
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Element: " + element);
        }

        //traversal using for-each loop
        for (String element : set) {
            System.out.println("Element: " + element);
        }

    }

}

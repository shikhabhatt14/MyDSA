package org.example.hashing;

import java.util.HashMap;

public class MyHashMap {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Hello", 10);
        map.put("World", 20);
        map.put("ide", 30);

        System.out.println(map);

        map.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });

        if(map.containsKey("ide")) {
            System.out.println("Key 'ide' exists with value: " + map.get("ide"));
        } else {
            System.out.println("Key 'ide' does not exist");
        }

        if(map.containsValue(10)) {
            System.out.println("Value 10 exists in the map");
        } else {
            System.out.println("Value 10 does not exist in the map");
        }

        map.remove("ide");

        for(String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }
}

package org.example.hashing;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;

public class MoreThanSpecifiedOccurances {

    public static void main(String[] args) {
        int[] arr = {20, 10, 20, 20, 20, 10, 40, 20, 30};
        int k = 4;
        int result = countMoreThanKOccurrences(arr, k);
    }

    public static int countMoreThanKOccurrences(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            /*if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else if(map.size() < k -1) {  //same logic as below if
                map.put(num, 1);
            }*/
            if(map.size() < k -1) {
                map.put(num, map.getOrDefault(num, 0)+1);
            }else {
                map.replaceAll((key, value) -> value -1);
                map.values().removeIf(value -> value == 0);
            }

        }

        int count = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > arr.length/k) {
                System.out.println("Element with more than " + k + " occurrences: " + key);
                count++;
            }
        }

        System.out.println("Count of elements with more than " + k + " occurrences: " + count);
        return count;
    }

}

package org.example.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MininumNumberOfRefuelingStationsBetweenTwoCities {

    //This is a greedy algorithm problem where we need to find the minimum number of refueling stations needed to reach a target distance.
    //We can use a priority queue to keep track of the maximum distance we can travel with the current fuel.
    //We will iterate through the stations and add the reachable stations to the priority queue.
    //We will then poll the maximum distance from the priority queue and add it to the current fuel.
    //We will repeat this process until we reach the target distance or we run out of stations to refuel.
    //The time complexity of this algorithm is O(n log n) where n is the number of stations.
    //The space complexity of this algorithm is O(n) where n is the number of stations.
    //This algorithm is similar to the "Minimum Number of Refueling Stops" problem on LeetCode.

    /*Given an integer target which represents the total distance to be covered by a car on a straight road.
    Given another array, station[] of size N representing petrol pumps where ith petrol pump is station[i][0]
    position away from the start and has station[i][1] amount of fuel. The car has an infinite petrol capacity
     and starts with M amount of fuel. The task is to find the minimum number of times the car has to stop for
     refueling to reach the end when it uses one unit of fuel for moving one unit distance.*/

    public static void main(String[] args) {
        int target = 100;
        int tankRange = 10;
        int[][] stations = {{10,60}, {20, 30}, {30,30}, {60,40}};
        System.out.println("Minimum number of refueling stations: " + minRefuelStops(target, tankRange, stations));

    }

    public static int minRefuelStops(int target, int tankRange, int[][] stations){
        int numStops = 0;
        int curFuel = tankRange;

        //storing the stations in a list
        Arrays.sort(stations, (a, b) -> a[0] - b[0]);

        int n = stations.length;
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<=n;i++){
            int distance = i==n? target : stations[i][0];
            while(curFuel < distance){
                if(maxPQ.isEmpty())
                    return -1; //no more stations to refuel
                curFuel += maxPQ.poll();
                numStops++;
            }
            if(i<n)
                maxPQ.offer(stations[i][1]);
        }

    return numStops;
    }

}

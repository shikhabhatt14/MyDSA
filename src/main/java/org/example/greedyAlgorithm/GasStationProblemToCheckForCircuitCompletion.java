package org.example.greedyAlgorithm;

public class GasStationProblemToCheckForCircuitCompletion {

    // The problem is to find the starting gas station index from which we can complete the circuit
    // without running out of gas. The gas station is represented as an array of gas and cost.
    // gas[i] is the amount of gas at station i, and cost[i] is the cost to travel from station i to i+1.
    // The solution is to iterate through the gas stations and keep track of the current gas.
    // If the current gas is less than 0, we cannot start from the previous station, so we move to the next station.
    // If we can complete the circuit, we return the starting station index.
    // If we cannot complete the circuit, we return -1.
    // The time complexity of this solution is O(n), where n is the number of gas stations.

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int start = canCompleteCircuit(gas, cost);
        if (start == -1) {
            System.out.println("No solution");
        } else {
            System.out.println("Start at station: " + start);
        }
    }

    public static int canCompleteCircuit(int[] gas, int[] cost){
        int start = 0;
        int currGas = 0;
        int n = gas.length;
        //finding the starting station
        for(int i=0;i<n;i++){
            currGas = currGas + gas[i] - cost[i];
            if(currGas<0) {
                start = i + 1;
                currGas = 0;
            }
        }
        currGas = 0;

        //checking if we can complete the circuit
        for(int i=0;i<n;i++){
            int index = (start + i) % n;
            currGas = currGas + gas[index] - cost[index];
            if(currGas<0)
                return -1;
        }
        return start;
    }

}

package org.example.dynamicProgramming.longestIncreasingSubsequenceProblem.variationsOfLIS;

import java.util.Arrays;

public class BuildMaximumNumberOfNonCrossingBridgesBetweenCities {

    public static void main(String[] args) {
        CityPair[] cityPairs = {
            new CityPair(1, 2),
            new CityPair(2, 3),
            new CityPair(3, 4),
            new CityPair(1, 3),
            new CityPair(2, 4)
        };

        int maxBridges = findMaxNonCrossingBridges(cityPairs);
        System.out.println("Maximum number of non-crossing bridges: " + maxBridges);
    }

    public static int findMaxNonCrossingBridges(CityPair[] cityPairs){
        Arrays.sort(cityPairs);

        int[] lis = new int[cityPairs.length];
        Arrays.fill(lis, 1); // Initialize LIS array with 1

        for(int i=1;i<cityPairs.length;i++){
            for(int j=0;j<i;j++){
                if(cityPairs[i].getCity2() >cityPairs[j].getCity2())
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        int maxBridges = 0;
        for(int i=0;i<lis.length;i++){
            maxBridges = Math.max(maxBridges, lis[i]);
        }
        return maxBridges;
    }

}

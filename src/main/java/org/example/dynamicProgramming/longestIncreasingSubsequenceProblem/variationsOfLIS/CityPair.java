package org.example.dynamicProgramming.longestIncreasingSubsequenceProblem.variationsOfLIS;

public class CityPair implements Comparable<CityPair>{

    private int city1;
    private int city2;

    public CityPair(int city1, int city2) {
        this.city1 = city1;
        this.city2 = city2;
    }

    public int getCity1() {
        return city1;
    }

    public int getCity2() {
        return city2;
    }

    @Override
    public int compareTo(CityPair o) {
        if (this.city1 == o.city1)
            return Integer.compare(this.city2, o.city2);
        return Integer.compare(this.city1, o.city1);
    }
}

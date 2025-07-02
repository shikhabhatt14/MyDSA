package org.example.arrays;

import java.util.Stack;

public class DailyTemperatureProblem {

    public static void main(String[] args) {
        DailyTemperatureProblem problem = new DailyTemperatureProblem();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        problem.dailyTemperatures(temperatures);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        for(int i=0; i<n;i++){
            while(!s.empty() && temperatures[i]>temperatures[s.peek()]){
                days[s.peek()] = i-s.peek();
                s.pop();
            }
            s.push(i);
        }
        for(int i=0;i<n;i++)
            System.out.println(days[i]+" ");
        return days;
    }

}

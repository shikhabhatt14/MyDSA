package org.example.arrays;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {5, 0, 6, 2, 3};
        System.out.println(trap(height));
    }

    public static int trap(int[] arr){
        int n = arr.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = arr[0];
        rmax[n-1] = arr[n-1];
        //calculate lmax
        for(int i=1;i<n;i++)
            lmax[i] = Math.max(lmax[i-1], arr[i]);
        //calculate rmax
        for(int i=n-2;i>=0;i--)
            rmax[i] = Math.max(rmax[i+1], arr[i]);
        int res = 0;
        for(int i=1;i<n-1; i++){
            res = res + Math.min(lmax[i],rmax[i]) - arr[i];
        }
        return res;
    }

}

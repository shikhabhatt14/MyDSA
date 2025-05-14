package org.example.matrix;

public class SpiralTraversal {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        spiralTraversal(matrix);
    }

    public static void spiralTraversal(int[][] mat){
        int top = 0, left = 0;
        int bottom = mat.length -1;
        int right = mat[0].length -1;
        while(top<=bottom && left<=right){
            for(int i=left; i<=right;i++)
                System.out.println(mat[top][i]);
            top++;
            for(int i= top;i<=bottom;i++)
                System.out.println(mat[i][right]);
            right--;
            for(int i = right;i>=left;i--)
                System.out.println(mat[bottom][i]);
            bottom--;
            for(int i=bottom;i>=top;i--)
                System.out.println(mat[i][left]);
            left++;
        }
    }

}

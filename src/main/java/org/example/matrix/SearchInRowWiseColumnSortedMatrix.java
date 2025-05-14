package org.example.matrix;

public class SearchInRowWiseColumnSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        int target = 29;

        boolean found = searchInMatrix(matrix, target);
        System.out.println("Element " + target + (found ? " found" : " not found") + " in the matrix.");
    }

    public static boolean searchInMatrix(int[][] mat, int key){
        int row = 0;
        int col = mat[0].length -1;
        while(row<mat.length && col>0){
            if(mat[row][col] == key)
                return true;
            if(mat[row][col] > key)
                col--;
            else
                row++;
        }
        return false;
    }

}

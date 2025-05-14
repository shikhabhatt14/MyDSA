package org.example.matrix;

public class Transpose {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        //int[][] transposed = transpose(matrix, rows, cols);
        int[][] transposed = transposeSquareMatrix(matrix, rows, cols);

        System.out.println("Transposed Matrix:");

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix, int rows, int cols) {
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }

    public static int[][] transposeSquareMatrix(int[][] matrix, int rows, int cols) {
        if(rows != cols){
            System.out.println("Matrix is not square. returning original matrix.");
        } else {
            System.out.println("Matrix is square. Transposing matrix.");
            int temp;
            for (int i = 0; i < rows; i++) {
                for (int j = i; j < cols; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        return matrix;
    }

}

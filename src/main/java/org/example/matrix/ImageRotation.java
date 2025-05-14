package org.example.matrix;

public class ImageRotation {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] cMatrix = rotateClockwise(matrix, rows, cols);
        System.out.println("Clockwise 90 Degree Rotated Matrix:");
        for (int i = 0; i < cMatrix.length; i++) {
            for (int j = 0; j < cMatrix[i].length; j++) {
                System.out.print(cMatrix[i][j] + " ");
            }
            System.out.println();
        }

        int[][] acMatrix = rotateAntiClockwise(matrix, rows, cols);
        System.out.println("Anti-Clockwise 90 Degree Rotated Matrix:");
        for (int i = 0; i < acMatrix.length; i++) {
            for (int j = 0; j < acMatrix[i].length; j++) {
                System.out.print(acMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotateClockwise(int[][] matrix, int rows, int cols) {
        matrix = Transpose.transpose(matrix, rows, cols);

        // Reverse each row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - j - 1];
                matrix[i][cols - j - 1] = temp;
            }
        }
        return matrix;
    }

    public static int[][] rotateAntiClockwise(int[][] matrix, int rows, int cols) {

        // Reverse each row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - j - 1];
                matrix[i][cols - j - 1] = temp;
            }
        }
        matrix = Transpose.transpose(matrix, rows, cols);

        return matrix;
    }

}

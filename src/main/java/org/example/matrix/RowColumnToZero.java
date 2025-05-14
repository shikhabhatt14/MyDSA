package org.example.matrix;

public class RowColumnToZero {

    // Given a matrix, if an element is 0, set its entire row and column to 0.
    // This is done in O(1) space and O(m*n) time complexity.
    // The algorithm uses the first row and first column of the matrix as markers.
    // If an element is 0, mark the corresponding row and column in the first row and first column.
    // Finally, set the marked rows and columns to 0.
    // The first row and first column are handled separately to avoid overwriting the markers.
    // This algorithm is efficient and works well for large matrices.
    // The space complexity is O(1) because we are using the input matrix itself to store the markers.
    // The time complexity is O(m*n) because we are iterating through the matrix twice.
    // The algorithm is simple and easy to understand.

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        /*int[][] matrix = { { 0, 1, 2, 0 },
            { 3, 4, 0, 2 },
            { 1, 3, 1, 5 } };*/


        setZeroes(matrix);

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] mat){
        int r = mat.length;
        int c = mat[0].length;
        int c0 = 1;
        // First pass to mark the rows and columns that need to be zeroed
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j] == 0){
                    mat[0][j] = 0;
                    if(j == 0)
                        c0 = 0;
                    else
                        mat[i][0] = 0;
                }
            }
        }
        // Second pass to set the elements to zero
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(mat[i][0] == 0 || mat[0][j] == 0)
                    mat[i][j] = 0;
            }
        }

        // Set the first row to zero if needed
        if(mat[0][0] == 0){
            for(int j=0;j<c;j++)
                mat[0][j] = 0;
        }

        // Set the first column to zero if needed
        if(c0 == 0){
            for(int i=0;i<r;i++)
                mat[i][0] = 0;
        }


    }

}

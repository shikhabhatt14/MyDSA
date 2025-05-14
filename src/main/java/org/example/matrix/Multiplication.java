package org.example.matrix;

public class Multiplication {

    public static void main(String[] args) {
        int[][] a = {
            {2, 4},
            {3, 4}
        };
        int[][] b = {
            {1, 2},
            {1, 3}
        };

        multiplyMatrices(a, b);
    }

    public static void multiplyMatrices(int[][] a, int[][] b){
        int arows = a.length;
        int acols = a[0].length;
        int brows = b.length;
        int bcols = b[0].length;
        if(acols != brows){
            System.out.println("Matrix multiplication not possible for this matrix.");
        } else {
            int[][] c = new int[arows][bcols];
            for(int i=0;i<arows;i++){
                for(int j=0;j<bcols;j++){
                    for(int k=0;k<acols;k++){
                        c[i][j] += a[i][k]*b[k][j];
                    }
                }
            }
            System.out.println("Resultant Matrix after multiplication:");
            for(int i=0;i<arows;i++){
                for(int j=0;j<bcols;j++){
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}

package homeWorks;

import java.util.Random;

/**
 * Created by Zveriki on 06.03.2015.
 */
public class MatrixMultiply {

    static Random rnd = new Random(System.nanoTime());

    public static void main(String[] args) {

        int[][] matrixA = generateMatrix(3, 3);
        int[][] matrixB = generateMatrix(3, 5);

        int[][] matrixC = multiplyMatrix(matrixA, matrixB);

        printMatrix(matrixA);
        printMatrix(matrixB);
        printMatrix(matrixC);

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] multiplyMatrix(int[][] matrixA, int[][] matrixB) {
        int[][] matrix = new int[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[i].length; j++) {
                int c = 0;
                for (int r = 0; r < matrixB.length; r++) {
                    c += matrixA[i][r] * matrixB[r][j];
                }
                matrix[i][j] = c;
            }
        }

        return matrix;
    }

    private static int[][] generateMatrix(int width, int height) {

        int[][] matrix = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                matrix[i][j] = rnd.nextInt(10);
            }
        }

        return matrix;
    }
}

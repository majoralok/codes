package com.java.codes.GeeksCodes.code;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
 * The problem is to print all the possible paths from top left to bottom right of a mXn matrix
 * with the constraints that from each cell you can either move only to right or down
 */
public class MatrixTraversal {
    private static void printMatrix(int mat[][], int m, int n, int i, int j, int path[], int idx) {
        path[idx] = mat[i][j];
        // Reached the bottom of the matrix so we are left with only option to move right
        if (i == m - 1) {
            for (int k = j + 1; k < n; k++) {
                path[++idx] = mat[m - 1][k];
            }
            printArray(path);
            return;
        }
        // Reached the right corner of the matrix we are left with only the downward movement.
        if (j == n - 1) {
            for (int k = i + 1; k < m; k++) {
                path[++idx] = mat[k][n - 1];
            }
            printArray(path);
            return;
        }
        printMatrix(mat, m, n, i + 1, j, path, idx + 1);
        printMatrix(mat, m, n, i, j + 1, path, idx + 1);
    }

    private static void printArray(int[] path) {
        Arrays.stream(path).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int mat[][] = {{1, 2, 3},
                {4, 5, 6}};
        int maxLengthOfPath = m + n - 1;
        printMatrix(mat, m, n, 0, 0, new int[maxLengthOfPath], 0);
    }
}

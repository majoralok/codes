package com.java.codes.GeeksCodes.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.lintcode.com/en/old/problem/number-of-distinct-islands-ii
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's connected 4-directionally
 * Count the number of distinct islands.
 */
/*
    Use the following symbols to create the path/direction string or
    U -> up
    L-> left
    R> right
    D -> down
    X-> starting position
    0-> block
 */
public class MaxDistinctIsland {
    // when visited mark the node as 0 (block)
    private static String performDFSForDirection(int[][] grid, int x, int y, int m, int n, String direction) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) return "0";
        grid[x][y] = 0;
        String left = performDFSForDirection(grid, x, y - 1, m, n, "L");
        String right = performDFSForDirection(grid, x, y + 1, m, n, "R");
        String up = performDFSForDirection(grid, x - 1, y, m, n, "U");
        String down = performDFSForDirection(grid, x + 1, y, m, n, "D");
        return direction + left + right + up + down;
    }

    // create a path going up, down, left right
    private static int calculateDistinctIslands(int[][] grid, int m, int n) {
        Set<String> paths = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    String path = performDFSForDirection(grid, i, j, m, n, "X");
                    paths.add(path);
                }
            }
        }
        return paths.size();
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1}};
        System.out.println(calculateDistinctIslands(mat, mat.length, mat[0].length));
    }
}

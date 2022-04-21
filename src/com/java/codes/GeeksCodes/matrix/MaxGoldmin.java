package com.java.codes.GeeksCodes.matrix;

/**
 * https://leetcode.com/problems/path-with-maximum-gold
 * In a gold mine grid of size m x n, each cell in this mine has an integer
 * representing the amount of gold in that cell, 0 if it is empty.
 */
public class MaxGoldmin {
    private int calculateGoldDfs(int[][] grid,int i,int j,int m,int n,boolean[][] visited){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0 || visited[i][j])
            return 0;
        visited[i][j] = true;
        int left = calculateGoldDfs(grid, i,j-1,m, n, visited);
        int right = calculateGoldDfs(grid, i,j+1,m, n, visited);
        int up = calculateGoldDfs(grid, i-1,j,m, n, visited);
        int down = calculateGoldDfs(grid, i+1,j,m, n, visited);
        visited[i][j] = false;
        return grid[i][j] + Math.max(left, Math.max(right, Math.max(up, down)));
    }
    public int getMaximumGold(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] != 0){
                    int gold = calculateGoldDfs(grid, i, j, m, n, visited);
                    max = Math.max(max, gold);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int grid[][] = {{0,6,0},{5,8,7},{0,9,0}};
        MaxGoldmin maxGoldmin = new MaxGoldmin();
        System.out.println(maxGoldmin.getMaximumGold(grid));
    }
}

package com.java.codes.GeeksCodes.dp;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle
 * https://www.interviewbit.com/problems/largest-area-of-rectangle-with-permutations
 * <p>
 * It's a combination of histogram area and normal dp
 */
public class MaxAreaRectangleInMatrix {
    //step1: create row wise histogram
    //step2: calculate area of each row wise histogram
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int mat[][] = new int[m][n];

        //create row wise histogram
        for (int j = 0; j < n; ++j) {
            mat[0][j] = Character.getNumericValue(matrix[0][j]);
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] != '0') {
                    mat[i][j] = mat[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            ans = Math.max(ans, calculateMaxHisgramArea(mat[i], n));
        }
        return ans;
    }

    public int calculateMaxHisgramArea(int hist[], int n) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0, i = 0;
        while (i < n) {
            if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i++);
            } else {
                ans = Math.max(ans, hist[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        while(!stack.isEmpty()){
            ans = Math.max(ans, hist[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        char a[][] = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        MaxAreaRectangleInMatrix matrix = new MaxAreaRectangleInMatrix();
        System.out.println(matrix.maximalRectangle(a));
    }
}

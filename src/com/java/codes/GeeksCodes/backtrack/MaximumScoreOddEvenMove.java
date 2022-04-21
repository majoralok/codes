package com.java.codes.GeeksCodes.backtrack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/maximum-score-possible-after-performing-given-operations-on-an-array
 * <p>
 * Given an array A of size N, the task is to find the maximum score possible of this array. The score of an array
 * is calculated by performing the following operations on the array N times:
 * <p>
 * If the operation is odd-numbered, the score is incremented by the sum of all elements of the current array.
 * If the operation is even-numbered, the score is decremented by the sum of all elements of the current array.
 * After every operation, either remove the first or the last element of the remaining array.
 */
public class MaximumScoreOddEvenMove {
    static int[][][] dp = new int[10][10][10];

    private int maxScoreUtil(int[] arr, int sum, int l, int r, int ops) {
        if (l > r) {
            return 0;
        }
        int currSum = sum;
        if (ops % 2 == 0) {
            currSum *= -1;
        }
        int left = maxScoreUtil(arr, sum - arr[l], l + 1, r, ops + 1);
        int right = maxScoreUtil(arr, sum - arr[r], l, r - 1, ops + 1);
        return currSum + Math.max(left, right);
    }

    private int maxScoreUtilDP(int[] arr, int sum, int l, int r, int ops) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][ops] != -1)
            return dp[l][r][ops];
        int currSum = sum;
        if (ops % 2 == 0) {
            currSum *= -1;
        }
        int left = maxScoreUtilDP(arr, sum - arr[l], l + 1, r, ops + 1);
        int right = maxScoreUtilDP(arr, sum - arr[r], l, r - 1, ops + 1);
        dp[l][r][ops] = currSum + Math.max(left, right);
        return dp[l][r][ops];
    }

    public int maxScore(int arr[]) {
        if (arr == null || arr.length == 0) return 0;
        int sum = Arrays.stream(arr).sum();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int l = 0; l < 10; l++)
                    dp[i][j][l] = -1;
            }
        }
        maxScoreUtilDP(arr, sum, 0, arr.length - 1, 1);
        return maxScoreUtil(arr, sum, 0, arr.length - 1, 1);

    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        MaximumScoreOddEvenMove move = new MaximumScoreOddEvenMove();
        System.out.println(move.maxScore(arr));
    }
}

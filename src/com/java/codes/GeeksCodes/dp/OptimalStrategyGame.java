package com.java.codes.GeeksCodes.dp;

/**
 * roblem statement: Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an
 * opponent by alternating turns. In each turn, a player selects either the first or last coin from the row, removes
 * it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of money we
 * can definitely win if we move first.
 * Note: The opponent is as clever as the user.
 * <p>
 * Let us understand the problem with few examples:
 * 1. 5, 3, 7, 10 : The user collects maximum value as 15(10 + 5)
 * 2. 8, 15, 3, 7 : The user collects maximum value as 22(7 + 15)
 */
public class OptimalStrategyGame {

    static int optimalStrategyOfGame(int[] arr, int n) {
        int dp[][] = new int[n][n];
        int i, j, g;
        for (g = 0; g < n; g++) {
            for (i = 0, j = g; j < n; ++i, ++j) {
                if (g == 0) {
                    dp[i][j] = arr[i];
                } else if (g == 1) {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    int val1 = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    int val2 = arr[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static boolean predictTheWinner(int[] nums, int n) {
        int[] dp = new int[n];
        for (int s = n - 1; s >= 0; s--) {
            for (int e = s; e < n; e++) {
                if (s == e) {
                    dp[s] = nums[s];
                } else {
                    int a = nums[s] - dp[e];
                    int b = nums[e] - dp[e - 1];
                    dp[e] = Math.max(a, b);
                }
            }
        }
        return dp[n - 1] >= 0;
    }

    static public void main(String[] args) {
        System.gc();
        System.out.println(Runtime.getRuntime().freeMemory());
        int[] arr1 = {8, 15, 3, 7};
        int n = arr1.length;
        System.out.println(optimalStrategyOfGame(arr1, n));
        System.out.println(predictTheWinner(arr1, n));

        int[] arr2 = {1, 5, 2};
        n = arr2.length;
        System.out.println(optimalStrategyOfGame(arr2, n));
        System.out.println(predictTheWinner(arr2, n));

        int[] arr3 = {20, 30, 2, 2, 2, 10};
        n = arr3.length;
        System.out.println(optimalStrategyOfGame(arr3, n));
        System.out.println(predictTheWinner(arr3, n));
    }
}

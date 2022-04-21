package com.java.codes.GeeksCodes.code;

public class knapsack {

    static int knapSack(int W, int wt[], int val[], int n) {
        int dp[] = new int[W + 1];
        for (int i = 0; i < n ; i++) {
            for (int w = W; w >= 0; w--) {
                if (wt[i] <= w)
                    dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int val[] = {40, 15, 40};
        int wt[] = {2, 2, 3};

        int W = 6;
        int N = val.length;

        System.out.println(knapSack(W, wt, val, N));
    }
}

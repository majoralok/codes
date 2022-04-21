package com.java.codes.GeeksCodes.code;

//https://leetcode.com/problems/profitable-schemes

public class ProfitableScheme {
    private static int MOD = 1000007;
    private static long profitableScheme(int G, int P, int[] group, int[] profit){
        int dp[][] = new int[P + 1][G + 1];
        dp[0][0] = 1;
        for(int i = 0; i < group.length ; i ++){
            for(int j = P; j >= 0; j --)
                for(int k = G - group[i]; k >= 0; k --){
                    int p = Math.min(P, j + profit[i]);
                    int g = k + group[i];
                    dp[p][g] += dp[j][k];
                    dp[p][g] %= MOD;
                }
        }
        long res = 0l;
        for(int x: dp[P]){
            res += x;
            res %= MOD;
        }
        return res;
    }
    public static void main(String[] args) {
        int G = 5, P = 3;
        int[] group = {2, 2};
        int[] profit = {2, 3};
        System.out.println(profitableScheme(G, P, group, profit));
    }
}

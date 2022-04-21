package com.java.codes.GeeksCodes.generic;

import java.util.ArrayList;
import java.util.List;

/*
get coin or energy in numerous house
 */
public class CoinEnery {
    private class Pair {

        public int energy;
        public int coin;

        public Pair(int energy, int coin) {
            this.energy = energy;
            this.coin = coin;
        }
    }

    private List<Pair> pairList = new ArrayList<>();

    public void InitialPair(int enery) {
        Pair p = new Pair(enery, 0);
        pairList.add(p);
    }

    private Integer computeMaximumPairValue() {
        Integer max = Integer.MIN_VALUE;
        for (Pair p : pairList)
            if (max < p.coin)
                max = p.coin;
        return max;
    }

    public Integer compute(int coins[], int energies[]) {
        int i, len = coins.length, coin, energy, count, listCount = 0;
        for (i = 0; i < len; i++) {
            coin = coins[i];
            energy = energies[i];
            count = (int) Math.pow(2, i);
            while (count != 0) {
                int listCoin = pairList.get(listCount).coin;
                int listEnergy = pairList.get(listCount).energy;
                if (listEnergy == 0) {
                    pairList.add(new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE));
                    pairList.add(new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE));
                } else {
                    pairList.add(new Pair(listEnergy + energy, listCoin));
                    pairList.add(new Pair(listEnergy - 1, listCoin + coin));
                }
                count -= 1;
                listCount += 1;
            }
        }
        return computeMaximumPairValue();
    }

    private int compute(int energy[], int coins[], int initialEnergy) {
        int dp[][] = new int[1001][1001];

        int i, e, n = energy.length;

        for (i = n - 1; i >= 0; --i) {
            for (e = 0; e <= n; ++e) {
                if (i == n - 1) {
                    dp[i][e] = coins[i];
                } else {
                    dp[i][e] = dp[i + 1][Math.min(e + energy[i] - 1, n)];
                    if (e - 1 >= 0) {
                        dp[i][e] = Math.max(dp[i][e], coins[i] + dp[i + 1][e - 1]);
                    }
                    if (e == 0) {
                        dp[i][e] = Math.max(dp[i][e], coins[i]);
                    }
                }
            }
        }
        int ene = Math.min(n, initialEnergy);
        return dp[0][ene];
    }

    public static void main(String[] args) {
        int energy[] = {2, 1, 1};
        int coins[] = {11, 5, 7};
        CoinEnery coinEnery = new CoinEnery();
        coinEnery.InitialPair(2);
        System.out.println(coinEnery.compute(coins, energy));
        //System.out.println(coinEnery.compute(coins, energy, 1));
    }
}
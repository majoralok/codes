package com.java.codes.GeeksCodes.BTree;

import java.util.*;

/**
 * //https://leetcode.com/problems/flower-planting-with-no-adjacent
 * You have n gardens, labeled from 1 to n, and an array paths where paths[i] = [xi, yi] describes a bidirectional path between garden xi to garden yi.
 * In each garden, you want to plant one of 4 types of flowers.
 * All gardens have at most 3 paths coming into or leaving it.
 */

public class FlowerPlanting {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int ans[] = new int[N];
        //BIDIRECTIONAL MAP / GRAPH CREATION
        for (int i = 0; i < paths.length; i++) {
            map.putIfAbsent(paths[i][0], new ArrayList<>());
            map.get(paths[i][0]).add(paths[i][1]);
            map.putIfAbsent(paths[i][1], new ArrayList<>());
            map.get(paths[i][1]).add(paths[i][0]);
        }
        for (int i = 1; i <= N; i++) {
            int color[] = new int[5];
            if(map.get(i) != null) {
                for (Integer a : map.get(i)) {
                    color[ans[a - 1]] = 1;
                }
            }
            for (int j = 1; j <= 4; j++) {
                if (color[j] == 0) {
                    ans[i - 1] = j;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int paths[][] = {{1, 2}, {2,3}, {3,4}, {4,1}, {1,3}, {2,4}};
        FlowerPlanting flowerPlanting = new FlowerPlanting();
        int[] garden = flowerPlanting.gardenNoAdj(n, paths);
        for (int value : garden)
            System.out.print(value + " ");
    }
}

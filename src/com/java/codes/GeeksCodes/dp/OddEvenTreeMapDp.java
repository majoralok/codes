package com.java.codes.GeeksCodes.dp;

import sun.reflect.generics.tree.Tree;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Classic Treemmap and Dynamic Programming problem
 * https://leetcode.com/problems/odd-even-jump
 * You are given an integer array arr. From some starting index, you can make a series of jumps.
 * The (1st, 3rd, 5th, ...) jumps in the series are called odd-numbered jumps, and the (2nd, 4th, 6th, ...)
 * jumps in the series are called even-numbered jumps. Note that the jumps are numbered, not the indices.
 * Return the number of good starting indices.
 */
public class OddEvenTreeMapDp {
    /*
    Create a higher and lower boolean array to store if possible to reach the end or not using the Tree map floor
    key and Ceiling key concept. This problem is just testing these to treemap property
     */
    public static int oddEvenJumps(int[] arr) {
        int res = 1;
        if (arr == null || arr.length == 0) return 0;
        int n = arr.length;
        boolean higher[] = new boolean[n];
        boolean lower[] = new boolean[n];
        higher[n - 1] = true;
        lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n-1], n-1);
        for (int i = n - 2; i >= 0; --i) {
            Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(arr[i]);
            if(Objects.nonNull(ceilingEntry)) higher[i] = lower[ceilingEntry.getValue()];
            if(Objects.nonNull(floorEntry)) lower[i] = higher[floorEntry.getValue()];
            if(higher[i]) res++;
            map.put(arr[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {5,1,3,4,2};
        int arr1[] = {10, 13, 12, 14, 15};
        int arr2[] = {2, 3, 1, 1, 4};
        System.out.println(oddEvenJumps(arr1));
        System.out.println(oddEvenJumps(arr2));
    }
}
/*
Data Stream as Disjoint Intervals
Design Log Storage System
Satisfiability of Equality Equations
 */
package com.java.codes.GeeksCodes.code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There is a long road with markers on it after each unit of distance. There are some ubers standing on the road.
 * You are given the starting and ending coordinate of each uber (both inclusive).
 *
 * Note: At any given marker there may be multiple ubers or there may be none at all.
 * Your task is to find the number of markers on which at least one uber is present.
 * An uber with coordinates (l, r) is considered to be present on a marker m if and only if l ≤ m ≤ r.
 * For coordinates=[[4, 7], [-1, 5], [3, 6]], the output should be easyCountUber(coordinates) = 9.
 */
public class CountIntervalLength {
    private static int countCoordinatesLength(int[][] coordinates) {
        int n = coordinates.length;
        int length = 0;
        Arrays.sort(coordinates, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            int start = coordinates[i][0], end = coordinates[i][1];
            while (i < n && end >= coordinates[i][0]) {
                end = Math.max(end, coordinates[i][1]);
                i++;
            }
            i--;
            length += (end-start+1);
        }
        return length;
    }

    public static void main(String[] args) {
        int[][] coordinates = {{4, 7}, {-1, 5}, {3, 6}};
        System.out.println(countCoordinatesLength(coordinates));
    }
}

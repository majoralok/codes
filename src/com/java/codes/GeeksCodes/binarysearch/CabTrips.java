package com.java.codes.GeeksCodes.binarysearch;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer n representing a desired number of trips, and an array cabTravelTime representing your cabs and how long it takes each cab (at that index of the array) to make a trip, return the minimum time required to make n trips.
 *
 * Assume that cabs can run simultaneously and there is no waiting period between trips. There may be multiple cabs with the same time cost.
 *
 * Examples
 * If n=3 and cabTravelTime=[1,2], then the answer is 2. This is because the first cab (index 0, cost 1) can make 2 trips costing a total of 2 time units, and the second cab can make a single trip costing 2 at the same time.
 *
 * n=10
 * cabTravelTime=[1,3,5,7,8]
 */
public class CabTrips {

    private static int solve(int n, int[] c) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int res = 0;
        for(int t : c)
            minHeap.offer(new int[] {t, t});
        while(n > 0) {
            int[] cur = minHeap.poll();
            res = Math.max(res, cur[1]);
            cur[1] += cur[0];
            minHeap.offer(cur);
            n--;
        }
        return res;
    }
    private static int solve2(int n, int[] kArr) {
        int l = 0;
        int h = 20;
        int m = h + (l - h) / 2;
        while (l < h) {
            m = h + (l - h) / 2;
            int trips = 0;
            for (int k : kArr) {
                trips += (m / k);
            }
            if (trips == n) {
                break;
            } else if (trips < n) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int n1 =10, n2 = 3;
        int[] c1= {1,3,5,7,8}, c2= {3,4,8};
        System.out.println(solve2(n1, c1));
        System.out.println(solve(n2, c2));
    }
}

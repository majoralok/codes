package com.java.codes.GeeksCodes.disjointSet;

import java.util.Arrays;
import java.util.Comparator;

public class JobScheduling {

    private static int getNonOverlappingIndex(Job[] arr, int i) {
        int low = 0, high = i - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].end <= arr[i].start) {
                if (arr[mid + 1].end <= arr[i].start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int findMaxProfit(Job[] arr) {
        int size = arr.length;
        int total[] = new int[size];
        Arrays.sort(arr, Comparator.comparing(Job::getEnd));// can use start and end both
        total[0] = arr[0].getProfit();
        for (int i = 1; i < size; i++) {
            int inclProf = arr[i].getProfit();
            int j = getNonOverlappingIndex(arr, i);
            if (j != -1) {
                inclProf += total[j];
            }
            total[i] = Math.max(total[i - 1], inclProf);
        }
        return total[size - 1];
    }

    public static void main(String[] args) {
        Job arr[] = {new Job(3, 10, 20),
                new Job(1, 2, 50),
                new Job(6, 19, 100),
                new Job(2, 100, 200)};
        System.out.println(findMaxProfit(arr));
    }

    static class Job {
        private int start;
        private int end;
        private int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getProfit() {
            return profit;
        }
    }
}

package com.java.codes.GeeksCodes.heap;

import javafx.util.Pair;

import java.util.*;

/**
 * There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.
 * We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:
 * <p>
 * Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
 * Every worker in the paid group must be paid at least their minimum-wage expectation.
 * <p>
 * Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
 */
public class MinCostWorker {
    private class MyComparator implements Comparator<Pair<Double, Integer>> {
        @Override
        public int compare(Pair<Double, Integer> pair1, Pair<Double, Integer> pair2) {
            Double key1 = pair1.getKey();
            Double key2 = pair2.getKey();
            return key1.compareTo(key2);
        }
    }

    private Double minCost(int quality[], int wage[], int n, int k) {
        List<Pair<Double, Integer>> wageQuality = new ArrayList<>();
        Queue<Integer> minQualities = new PriorityQueue<>(k, Collections.reverseOrder());
        int i;
        Double sum=0d, ans;
        for (i = 0; i < n; i++) {
            wageQuality.add(new Pair((double) wage[i] / quality[i], quality[i]));
        }
        Collections.sort(wageQuality, new MyComparator());
        for (i = 0; i < k; i++) {
            sum += wageQuality.get(i).getValue();
            minQualities.add(wageQuality.get(i).getValue());
        }
        ans = sum * wageQuality.get(k-1).getKey();
        for(i=k;i<n;i++){
            int maxQuantity = minQualities.peek();
            if(maxQuantity > wageQuality.get(i).getValue()){
                minQualities.poll();
                minQualities.add(wageQuality.get(i).getValue());
                sum += wageQuality.get(i).getValue() - maxQuantity;
            }
            ans = Math.min(ans, sum * wageQuality.get(i).getKey());
        }
        return ans;
    }

    public static void main(String[] args) {
        int wage[] = {70, 50, 30};
        int quality[] = {10, 20, 5};
        int k = 2;
        MinCostWorker minCostWorker = new MinCostWorker();
        System.out.println(minCostWorker.minCost(quality, wage, wage.length, k));
    }
}

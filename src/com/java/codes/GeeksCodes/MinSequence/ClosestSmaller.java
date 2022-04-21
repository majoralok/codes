package com.java.codes.GeeksCodes.MinSequence;

import java.util.TreeSet;

public class ClosestSmaller {
    private void closestSmaller(int arr[]) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            Integer lower = set.lower(arr[i]);
            if (lower != null) {
                System.out.print(lower + " ");
            } else
                System.out.print("-1" + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 5, 11, 6, 20, 12};
        ClosestSmaller closestSmaller = new ClosestSmaller();
        closestSmaller.closestSmaller(arr);
    }
}

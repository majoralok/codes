package com.java.codes.GeeksCodes.slidingwindow;

import java.util.Stack;

public class MaximumSlidingWindow {
    static void print_max(int a[], int n, int k) {
        int[] max_upto = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        //Update max_upto array similar to finding next greater element
        for (int i = 1; i < n; i++) {
            while (!s.empty() && a[s.peek()] < a[i]) {
                max_upto[s.pop()] = i - 1;
            }
            s.push(i);
        }
        while (!s.empty()) {
            max_upto[s.pop()] = n - 1;
        }
        int j = 0;
        for (int i = 0; i <= n - k; i++) {
            while (j < i || max_upto[j] < i + k - 1) {
                j++;
            }
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {9, 7, 2, 4, 6, 8, 2, 1, 5};
        int n = a.length;
        int k = 3;
        print_max(a, n, k);
    }
}

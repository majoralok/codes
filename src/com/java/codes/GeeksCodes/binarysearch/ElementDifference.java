package com.java.codes.GeeksCodes.binarysearch;

import java.util.Arrays;

/**
 * Given two arrays A[] and B[] containing positive integers and an integer 'd'.
 * we need to return the count of elements,A[i], in A[] that satisfies below condition
 * | A[i] - B[j] | > d (0<=j<n where n is size of B).
 * e.g.
 * Input : A = [7, 6, 9] B = [13, 1, 4] and d = 3
 * Output : 1
 * Explanation : For A[i] = 7, Difference | A[i] - B[j] | is greater than d for B[j] = 13, 1 but equal to 3 for B[j] = 4. Hence, 7 does not qualify.
 * Similary for 6, the differences are [7, 5, 2]. since 2 is less equal to 3 hence this element does not qualify as well.
 * Whereas for 9, the differences are [4, 8, 5]. here difference with each element of B is greater than d. So we have found 1 such element.
 * So the output would be 1.
 */

public class ElementDifference {

    private static boolean isPossibleUsingBinarySearch(int[] b, int a, int d) {
        int low = 0, high = b.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (b[mid] >= (a - d) && b[mid] <= (a + d)) {
                return false;
            } else if (b[mid] < (a - d)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return true;
    }

    private static int CountElementsWithMoreDiff(int a[], int b[], int d) {
        int cnt = 0;
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (isPossibleUsingBinarySearch(b, a[i], d))
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] A = {7, 2, 9};
        int[] B = {13, 3, 4};
        int d = 3;
        System.out.println(CountElementsWithMoreDiff(A, B, d));
    }
}

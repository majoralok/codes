package com.java.codes.GeeksCodes.sort;

/**
 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/?ref=leftbar-rightbar
 */
public class KthSmallestElement {
    private static void swap(Integer arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(Integer[] arr, int l, int r) {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, j, i);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    public static int kthSmallest(Integer[] arr, int l, int r, int k) {
            int pos = partition(arr, l, r);
            if (pos == k - 1)
                return arr[pos];
            if (pos > k - 1)
                return kthSmallest(arr, l, pos - 1, k);
            return kthSmallest(arr, pos + 1, r, k);
    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{12, 3, 5, 7, 4, 19, 82};
        int k = 2;
        System.out.print("K'th smallest element is " + kthSmallest(arr, 0, arr.length - 1, k));
    }
}

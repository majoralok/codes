package com.java.codes.GeeksCodes.sort;
//Search an element in a sorted and rotated array

/***
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */

public class CircularBinarySearch {

    private static int search(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            if (arr[low] <= arr[mid]) {
                if (key >= arr[low] && key <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (key >= arr[mid] && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {7, 8, 9, 1, 2, 3, 4, 5, 6,};
        int key = 1;
        int i = search(arr, 0, arr.length - 1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }
}

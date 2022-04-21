package com.java.codes.GeeksCodes.heap;

import java.util.Arrays;

//Heap can be used for Priority Queue
public class HeapSort {

    private void heapify(int arr[], int i, int n) {
        int l = 2*i+1;
        int r = 2*i+2;
        int largest = i;
        if(l<n && arr[largest] < arr[l]) {
             largest = l;
        }
        if(r < n && arr[largest] < arr[r]){
            largest = r;
        }
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest ] = temp;
            heapify(arr, largest, n);
        }
    }

    public void createHeap(int arr[], int n) {
        for (int i = (n - 2) / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    public static void main(String[] args) {
        int data[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        HeapSort heapSort = new HeapSort();
        heapSort.createHeap(data, data.length);
        Arrays.stream(data).forEach(System.out::println);
    }
}

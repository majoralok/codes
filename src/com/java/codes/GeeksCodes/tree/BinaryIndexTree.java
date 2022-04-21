package com.java.codes.GeeksCodes.tree;

public class BinaryIndexTree {
    int BITTree[] = new int[100];

    private void contructBITTreeUtil(int n, int i, int value) {
        i = i + 1;
        while (i <= n) {
            BITTree[i] += value;
            i += i & (-i);
        }
    }

    public void constructBIT(int arr[]) {
        int n = arr.length, i;
        for (i = 0; i <= n; i++) {
            BITTree[i] = 0;
        }
        for (i = 0; i < n; i++) {
            contructBITTreeUtil(n, i, arr[i]);
        }

    }

    public static void main(String[] args) {
        int data[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryIndexTree binaryIndexTree = new BinaryIndexTree();
        binaryIndexTree.constructBIT(data);
    }
}

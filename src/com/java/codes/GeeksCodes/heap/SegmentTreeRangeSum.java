package com.java.codes.GeeksCodes.heap;

public class SegmentTreeRangeSum {
    private int seg[];

    private int getMin(int x, int y) {
        return x < y ? x : y;
    }

    private int getMid(int x, int y) {
        return x + (y - x) / 2;
    }

    private int sumRangeQueryUtil(int ss, int se, int qs, int qe, int i) {
        if (qs <= ss && qe >= se)
            return seg[i];
        if (qs > se || qe < ss)
            return 0;
        int mid = getMid(ss, se);
        return sumRangeQueryUtil(ss, mid, qs, qe, 2 * i + 1) + sumRangeQueryUtil(mid + 1, se, qs, qe, 2 * i + 2);
    }

    public int sumRangeQuery(int n, int qs, int qe) {
        if (qs > qe || qs < 0 || qe > n - 1)
            return -1;
        return sumRangeQueryUtil(0, n - 1, qs, qe, 0);
    }

    private int constructSegmentTreeUtil(int arr[], int ss, int se, int i) {
        if (ss == se) {
            seg[i] = arr[ss];
            return seg[i];
        }
        int mid = getMid(ss, se);
        seg[i] = constructSegmentTreeUtil(arr, ss, mid, 2 * i + 1) +
                constructSegmentTreeUtil(arr, mid + 1, se, 2 * i + 2);
        return seg[i];
    }

    public void constructSegmentTree(int arr[], int n) {
        int x = (int) (Math.log(n) / Math.log(2));
        int size = (int) (2 * Math.pow(2, x) - 1);
        seg = new int[size];
        constructSegmentTreeUtil(arr, 0, n - 1, 0);

    }

    private void updateUtil(int arr[], int ss, int se, int si, int index, int value) {
        if(index<ss || index>se) return;
        if (ss == se) {
            arr[index] = value;
            seg[si] = value;
            return;
        }
        int mid = getMid(ss, se);
        if (index >= ss && index <= mid) {
            updateUtil(arr, ss, mid, 2 * si + 1, index, value);
        } else {
            updateUtil(arr, mid + 1, se, 2 * si + 2, index, value);
        }
        seg[si] = seg[2 * si + 1] + seg[2 * si + 2];
    }

    private void update(int arr[], int index, int value, int n) {
        if (index < 0 || index > n) {
            return;
        }
        updateUtil(arr, 0, n - 1, 0, index, value);
    }

    public static void main(String[] args) {
        int data[] = {5, 1, 2, 4};
        SegmentTreeRangeSum treeRangeSum = new SegmentTreeRangeSum();
        treeRangeSum.constructSegmentTree(data, data.length);
        int sumRange = treeRangeSum.sumRangeQuery(data.length, 0, 3);
        System.out.println(sumRange);
        treeRangeSum.update(data, 2, 9, 4);
        sumRange = treeRangeSum.sumRangeQuery(data.length, 0, 3);
        System.out.println(sumRange);
        //Arrays.stream(treeRangeSum.seg).forEach(System.out::println);
    }
}

package com.java.codes.GeeksCodes.heap;

public class SegmentTreeMinRange {
    int seg[];

    private int getMid(int x, int y) {
        return x + (y - x) / 2;
    }

    private int getMin(int x, int y) {
        return x < y ? x : y;
    }

    private int RangeMinQueryUtil(int ss, int se, int qs, int qe, int index) {
        if (qs <= ss && qe >= se)
            return seg[index];
        if (se < qs || ss > qe)
            return Integer.MAX_VALUE;
        int mid = getMid(ss, se);
        return getMin(RangeMinQueryUtil(ss, mid, qs, qe, 2 * index + 1),
                RangeMinQueryUtil(mid + 1, se, qs, qe, 2 * index + 2));
    }

    private int RangeMinQuery(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe)
            return -1;
        return RangeMinQueryUtil(0, n - 1, qs, qe, 0);
    }

    private int constructSegmentTreeUtil(int arr[], int ss, int se, int si) {
        if (ss == se) {
            seg[si] = arr[ss];
            return seg[si];
        }
        int mid = getMid(ss, se);
        constructSegmentTreeUtil(arr, ss, mid, si * 2 + 1);
        constructSegmentTreeUtil(arr, mid + 1, se, si * 2 + 2);
        seg[si] = getMin(seg[si*2+1], seg[si*2+1]);
        return seg[si];
    }

    private void constructSegmentTree(int arr[], int n) {
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        int max_size = (int) (2 * Math.pow(2, x) - 1);
        seg = new int[max_size];
        constructSegmentTreeUtil(arr, 0, n - 1, 0);
    }

    public static void main(String[] args) {
        int data[] = {5, 7, 2, 4};
        int x = (int) Math.ceil(Math.log(6) / Math.log(2));
        int max_size = (int) (2 * Math.pow(2, x) - 1);
        SegmentTreeMinRange segmentTree = new SegmentTreeMinRange();
        segmentTree.constructSegmentTree(data, data.length);
        System.out.println(segmentTree.RangeMinQuery(data.length, 0, 2));
        //Arrays.stream(segmentTree.seg).forEach(System.out::println);
    }
}

package com.java.codes.GeeksCodes.backtrack;

/**
 * https://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps
 */
public class MaxNumWithKSwaps {
    static String max;

    //This method will backtrack all possible numbers and populate max when its greater
    public void findMaximumNum(String str, int k) {
        if (str.compareTo(max)>0)
            max = str;
        if (k == 0) return;
        for (int i = 0; i < str.length() - 1; ++i) {
            for (int j = i + 1; j < str.length(); ++j) {
                if (str.charAt(i) < str.charAt(j)) {
                    String swaped = swap(str, i, j);
                    findMaximumNum(swaped, k - 1);
                }
            }
        }
    }

    public String swap(String str, int i, int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);
        String left = str.substring(0, i);
        String middle = str.substring(i + 1, j);
        String right = str.substring(j + 1);
        return left + jth + middle + ith + right;
    }

    public static void main(String[] args) {
        String str = "4321";
        int k = 4;
        MaxNumWithKSwaps maxNumWithKSwaps = new MaxNumWithKSwaps();
        max = str;
        maxNumWithKSwaps.findMaximumNum(str, k);
        System.out.print(max + "\n");
    }
}

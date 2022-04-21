package com.java.codes.GeeksCodes.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=Q1fLW_zQr3M&ab_channel=Pepcoding
 * Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the
 * sum of two subsets is as minimum as possible
 */
public class TugOfWar {
    int minDiff;
    String ans;
    private void tugOfWarUtil(int arr[], List<Integer> set1, List<Integer> set2, int sum1, int sum2, int idx){
        if(idx == arr.length){
            int delta = Math.abs(sum1-sum2);
            if(delta < minDiff){
                minDiff = delta;
                ans = set1+" "+ set2;
            }
            return;
        }
        if(set1.size() < (arr.length+1)/2){
            set1.add(arr[idx]);
            tugOfWarUtil(arr, set1, set2, sum1+arr[idx], sum2, idx+1);
            set1.remove(Integer.valueOf(arr[idx]));
        }
        if(set2.size() < (arr.length+1)/2){
            set2.add(arr[idx]);
            tugOfWarUtil(arr, set1, set2, sum1, sum2+arr[idx], idx+1);
            set2.remove(Integer.valueOf(arr[idx]));
        }
    }
    public String tugOfWar(int arr[]){
        minDiff = Integer.MAX_VALUE;
        tugOfWarUtil(arr, new LinkedList<>(), new LinkedList<>(), 0, 0, 0);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3, 4, 5, 6};
            TugOfWar a = new TugOfWar();
            a.tugOfWar(arr);
        System.out.println(a.ans);
    }
}

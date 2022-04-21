package com.java.codes.GeeksCodes.code;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array
 * <p>
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer
 * appears once or twice, return an array of all the integers that appears twice.
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 */
public class FindDuplicateNumber {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int n : nums){
            int index = Math.abs(n)-1;
            if(nums[index]<0) result.add(index+1);
            nums[index] = -nums[index];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 7, 2, 3, 1};
        System.out.println(findDuplicates(arr));
    }

}

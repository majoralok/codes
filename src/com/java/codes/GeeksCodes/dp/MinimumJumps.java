package com.java.codes.GeeksCodes.dp;

/**
 * https://leetcode.com/problems/jump-game-ii
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
 * then 3 steps to the last index.
 */
public class MinimumJumps {

    //This method will store the max distance we can cover while going through all the values in arr
    private static int calculateMinJumps(int[] num) {
        if (num.length < 2) return 0;
        int jumps = 1;
        int minJumpValue = num[0];
        int limit = num[0];
        for (int i = 0; i < num.length; i++) {
            if (i > limit) {
                jumps++;
                limit = minJumpValue;
            }
            minJumpValue = Math.max(minJumpValue, i + num[i]);
        }
        return jumps;
    }

    public static void main(String[] args) {
        int num[] = {2, 3, 1, 1, 4};
        System.out.println(calculateMinJumps(num));
    }
}

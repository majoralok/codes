package com.java.codes.GeeksCodes.slidingwindow;

/**
 * https://www.geeksforgeeks.org/maximum-length-of-consecutive-1s-or-0s-after-flipping-at-most-k-characters/
 */
public class MaximumConsecutive1or0 {
    //c is char to be flipped
    private static int maxLength(String str, int k, char c) {
        int max = -1, left = 0, right = 0;
        int N = str.length();
        int cnt = 0;
        for (; right < N; right++) {
            if (str.charAt(right) == c)
                cnt += 1;
            while (cnt > k) {
                if (str.charAt(left) == c)
                    cnt -= 1;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    private static int maxConsecutiveSegment(String s, int k) {
        return Math.max(maxLength(s, k, '0'), maxLength(s, k, '1'));
    }

    public static void main(String[] args) {
        String S = "1000";
        int K = 1;
        System.out.println(maxConsecutiveSegment(S, K));
    }
}

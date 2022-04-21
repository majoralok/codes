package com.java.codes.GeeksCodes.disjointSet;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/task-scheduler
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 */
public class CPUScheduling {
    private static int leastInterval(char[] tasks, int n) {
        int[] char_Map = new int[26];
        for (char c : tasks) {
            char_Map[c - 'A']++;
        }
        Arrays.sort(char_Map);
        int mxCount = char_Map[25]-1;
        int idleCount = mxCount * n;
        for(int i=24;i>=0;i--){
            idleCount -= Math.min(char_Map[i], mxCount);
        }
        return tasks.length + Math.max(idleCount, 0);
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'B', 'A', 'B', 'A', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}

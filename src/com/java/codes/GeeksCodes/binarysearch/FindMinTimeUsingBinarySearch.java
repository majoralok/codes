package com.java.codes.GeeksCodes.binarysearch;

/**
 * https://www.geeksforgeeks.org/find-minimum-time-to-finish-all-jobs-with-given-constraints/
 *
 * Given an array of jobs with different time requirements. There are K identical assignees available and
 * we are also given how much time an assignee takes to do one unit of the job. Find the minimum time to finish all jobs with following constraints.
 * An assignee can be assigned only contiguous jobs. For example, an assignee cannot be assigned jobs 1 and 3, but not 2.
 * Two assignees cannot share (or co-assigned) a job, i.e., a job cannot be partially assigned to one assignee and partially to other.
 */
public class FindMinTimeUsingBinarySearch {
    static int getMax(int arr[], int n) {
        int result = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > result)
                result = arr[i];
        return result;
    }

    static boolean isPossible(int time, int K, int job[], int n) {
        int cnt = 1;
        int curr_time = 0;
        for (int i = 0; i < n; ) {
            if (curr_time + job[i] > time) {
                curr_time = 0;
                cnt++;
            } else {
                curr_time += job[i];
                i++;
            }
        }
        return (cnt <= K);
    }

    static int findMinTime(int K, int T, int job[], int n) {
        int end = 0, start = 0;
        for (int i = 0; i < n; ++i)
            end += job[i];
        int ans = end;
        int job_max = getMax(job, n);
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid >= job_max && isPossible(mid, K, job, n)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return (ans * T);
    }

    public static void main(String arg[]) {
        int job[] = {10, 7, 8, 12, 6, 8};
        int n = job.length;
        int k = 4, T = 5;
        System.out.println(findMinTime(k, T, job, n));
    }
}

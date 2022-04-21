package com.java.codes.GeeksCodes.binarysearch;

/**
 * Given an array arr[] consisting of N positive integers and a  positive integer K such that there are N countries,
 * each country has arr[i] players, the task is to find the maximum number of teams that can be formed by forming teams
 * of size K such that each player in the team is from a different country.
 * Maximum number of teams of size K possible with each player from different country
 * https://www.geeksforgeeks.org/maximum-number-of-teams-of-size-k-possible-with-each-player-from-different-country
 */
public class MaxTeams {

    public static boolean is_possible(int[] teams, int T, int k) {
        int sum = 0;
        for (int i = 0; i < teams.length; i++) {
            sum += Math.min(T, teams[i]);
        }
        return (sum >= (T * k));
    }

    public static int countOfTeams(int[] teams_list, int N, int K) {
        int lb = 0;
        double ub = 25;
        while (lb <= ub) {
            int mid = lb + (int) (ub - lb) / 2;
            if (is_possible(teams_list, mid, K)) {
                if (!is_possible(teams_list, mid + 1, K)) {
                    return mid;
                } else {
                    lb = mid + 1;
                }
            } else {
                ub = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        int[] arr = {2, 10};
        int K = 2;
        int N = arr.length;
        System.out.println(countOfTeams(arr, N, K));
    }
}

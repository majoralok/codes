package com.java.codes.GeeksCodes.disjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class JobSequencing {
    char id;
    int deadline, profit;

    public int getProfit() {
        return this.profit;
    }

    public int getDeadline(){ return this.deadline;}

    @Override
    public String toString() {
        return "JobSequencing{" +
                "id=" + id +
                ", deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }

    static class DisjointSet {
        int parent[];

        // Constructor
        DisjointSet(int n) {
            parent = new int[n + 1];

            // Every node is a parent of itself
            for (int i = 0; i <= n; i++)
                parent[i] = i;
        }

        int find(int s) {
            if (s == parent[s])
                return s;
            return parent[s] = find(parent[s]);
        }

        void merge(int u, int v) {
            parent[v] = u;
        }
    }

    public JobSequencing(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    public static int findMaxDeadline(ArrayList<JobSequencing> arr) {
        return arr.stream().max(Comparator.comparing(JobSequencing::getDeadline)).orElseThrow(NoSuchElementException::new).deadline;
    }

    public static void printJobScheduling(ArrayList<JobSequencing> arr) {
        Collections.sort(arr, Comparator.comparing(JobSequencing::getProfit, Comparator.reverseOrder()));
        int maxDeadline = findMaxDeadline(arr);
        DisjointSet dsu = new DisjointSet(maxDeadline);
        for (JobSequencing temp : arr) {
            int availableSlot = dsu.find(temp.deadline);
            if (availableSlot > 0) {
                dsu.merge(dsu.find(availableSlot - 1), availableSlot);
                System.out.print(temp.id + " ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ArrayList<JobSequencing> arr = new ArrayList<>();
        arr.add(new JobSequencing('a', 2, 100));
        arr.add(new JobSequencing('b', 1, 19));
        arr.add(new JobSequencing('c', 2, 27));
        arr.add(new JobSequencing('d', 1, 25));
        arr.add(new JobSequencing('e', 3, 15));
        System.out.println("Following jobs need to be executed for maximum profit");
        JobSequencing.printJobScheduling(arr);
    }
}
/*
    arr.sort(Comparator.comparing(JobSequencing::getProfit));
    arr.forEach(System.out::println);
 */
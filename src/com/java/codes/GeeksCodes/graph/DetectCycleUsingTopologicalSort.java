package com.java.codes.GeeksCodes.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/detect-cycle-in-directed-graph-using-topological-sort
 */
public class DetectCycleUsingTopologicalSort {
    int V;
    private ArrayList<ArrayList<Integer>> adj;

    public DetectCycleUsingTopologicalSort(int v) {
        this.V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    private void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    private void dfs(int u, Stack<Integer> s, boolean[] visited) {
        visited[u] = true;
        for (Integer it : adj.get(u)) {
            if (!visited[it])
                dfs(it, s, visited);
        }
        s.push(u);
    }

    private boolean check_cycle() {
        Map<Integer, Integer> pos = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, stack, visited);
            }
        }
        int ind = 0;
        while (!stack.isEmpty()) {
            pos.put(stack.pop(), ind++);
        }

        for (int i = 0; i < V; i++) {
            for (Integer it : adj.get(i)) {
                // If parent vertex does not appear first
                if (pos.get(i) > pos.get(it)) {
                    // Cycle exists
                    return true;
                }
            }
        }
        return false;
    }

    // Driver code
    public static void main(String[] args) {
        DetectCycleUsingTopologicalSort sort = new DetectCycleUsingTopologicalSort(4);
        sort.addEdge(0, 1);
        sort.addEdge(0, 2);
        sort.addEdge(1, 2);
        sort.addEdge(2, 0);
        sort.addEdge(2, 3);
        if (sort.check_cycle()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

package com.java.codes.GeeksCodes.graph;

import java.util.Vector;

/**
 * https://www.geeksforgeeks.org/maximum-number-of-edges-among-all-connected-components-of-an-undirected-graph/
 */

public class MaxEdgeGraph {
    private static int dfs(int s, Vector<Vector<Integer>> adj, boolean visited[]) {
        int adjListSize = adj.get(s).size();
        visited[s] = true;
        for (int i = 0; i < adj.get(s).size(); i++) {
            if (visited[adj.get(s).get(i)] == false) {
                adjListSize += dfs(adj.get(s).get(i), adj, visited);
            }
        }
        return adjListSize;
    }

    private static int maxEdges(Vector<Vector<Integer>> adj, int nodes) {
        int res = Integer.MIN_VALUE;
        boolean visited[] = new boolean[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            if (visited[i] == false) {
                int adjListSize = dfs(i, adj, visited);
                res = Math.max(res, adjListSize / 2);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int nodes = 3;
        Vector<Vector<Integer>> adj = new Vector<>();

        for (int i = 0; i < nodes + 1; i++)
            adj.add(new Vector<>());

        // Edge from vertex 1 to vertex 2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // Edge from vertex 2 to vertex 3
        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(1).add(3);
        adj.get(3).add(1);
        System.out.println(maxEdges(adj, nodes));
    }
}

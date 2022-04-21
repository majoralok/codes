package com.java.codes.GeeksCodes.graph;

import java.util.LinkedList;

public class DirectedGraphCyleDFSColor {
    private static final int WHITE = 0;
    private static final int RED = 1;
    private static final int BLACK = 2;

    private static class Graph {
        int V;
        LinkedList<Integer> adj[];

        public Graph(int v) {
            this.V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
        }

        private boolean isCycleUtil(int v, int color[]) {
            color[v] = RED;
            for (int u : adj[v]) {
                if (color[u] == WHITE && isCycleUtil(u, color))
                    return true;
                if (color[u] == RED)
                    return true;
            }
            color[v] = BLACK;
            return false;
        }

        public boolean isCycle() {
            int color[] = new int[V];
            for (int i = 0; i < V; i++)
                color[i] = WHITE;
            for (int v = 0; v < V; v++) {
                if (color[v] == WHITE && isCycleUtil(v, color))
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println(graph.isCycle() ? "Cycle is present" : "Cycle is not Present");
    }
}

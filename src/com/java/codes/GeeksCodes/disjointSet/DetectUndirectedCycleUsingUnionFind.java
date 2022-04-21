package com.java.codes.GeeksCodes.disjointSet;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/union-find
 * undirected graph contains cycle or not
 */
public class DetectUndirectedCycleUsingUnionFind {
    //this method does not handle case for self loop
    static class Graph {
        int V, E;
        Edge edge[];

        static class Edge {
            int src;
            int dst;

            public Edge(int src, int dst) {
                this.src = src;
                this.dst = dst;
            }
        }

        public Graph(int v, int e) {
            this.V = v;
            this.E = e;
            edge = new Edge[e];
            for (int i = 0; i < e; i++) {
                edge[i] = new Edge(0, 0);
            }
        }

        public void merge(int[] parent, int u, int v) {
            parent[v] = u;
        }

        public int find(int parent[], int u) {
            if (parent[u] == -1)
                return u;
            return find(parent, parent[u]);
        }

        public boolean isCycle(Graph graph) {
            int parent[] = new int[graph.V];
            Arrays.fill(parent, -1);
            ;
            for (Edge edge : graph.edge) {
                int x = graph.find(parent, edge.src);
                int y = graph.find(parent, edge.dst);
                if (x == y) return true;
                graph.merge(parent, x, y);
            }
            return false;
        }

        public static void main(String[] args) {
            Graph graph = new Graph(3, 2);
            graph.edge[0].src = 0;
            graph.edge[0].dst = 1;

            // add edge 1-2
            graph.edge[1].src = 1;
            graph.edge[1].dst = 2;

            if (graph.isCycle(graph))
                System.out.println("graph contains cycle");
            else
                System.out.println("graph doesn't contain cycle");
        }
    }
}

package com.java.codes.GeeksCodes.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraphCycleBFS {
    static class Graph {
        int V;
        LinkedList<Integer> adj[];

        public Graph(int v) {
            this.V = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
        }

        public boolean isCycle() {
            int cnt = 0;
            Queue<Integer> que = new LinkedList<>();
            int indegree[] = new int[V];
            Arrays.fill(indegree, 0);
            for (int u = 0; u < V; u++) {
                for (int i : adj[u]) {
                    indegree[i] += 1;
                }
            }
            for (int u = 0; u < V; u++) {
                if (indegree[u] == 0)
                    que.offer(u);
            }
            while (!que.isEmpty()) {
                Integer v = que.poll();
                for (int i : adj[v]) {
                    if(--indegree[i] == 0)
                        que.offer(i);
                }
                cnt++;
            }
            if (cnt != V)
                return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1, 1);
        System.out.println(graph.isCycle() ? "Cycle is Present" : "Cycle is not Present");
    }
}

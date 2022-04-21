package com.java.codes.GeeksCodes.graph;

import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/detect-cycle-undirected-graph/?ref=lbp
 */

public class UndirectedGraphCycleDFS {
    private static class Graph {
        int V;
        LinkedList<Integer>[] adj;

        public Graph(int v) {
            this.V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);

        }

        private boolean isCycleUtil(int v, int parent, boolean[] visited) {
            visited[v] = true;
            for(int u :  adj[v]){
                if(!visited[u]){
                    if(isCycleUtil(u, v, visited))
                        return true;
                } else if(u != parent)
                    return true;
            }
            return false;
        }

        public boolean isCycle() {
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;
            for (int u = 0; u < V; u++) {
                if (!visited[u])
                    if (isCycleUtil(u, -1, visited))
                        return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        System.out.println(graph.isCycle() ? "Cycle is Present" : "Cycle is not Present");
    }
}

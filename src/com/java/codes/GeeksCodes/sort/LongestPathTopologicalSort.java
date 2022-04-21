package com.java.codes.GeeksCodes.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
 */
public class LongestPathTopologicalSort {
    static class Node {
        int val;
        int weight;

        Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
        int getV() {
            return val;
        }
        int getWeight() {
            return weight;
        }
    }

    static class Graph {
        int V;
        List<List<Node>> adj;

        Graph(int v) {
            V = v;
            adj = new ArrayList<>(v);
            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v, int weight) {
            Node node = new Node(v, weight);
            adj.get(u).add(node); // Add v to u's list
        }

        void topologicalSortUtil(int v, boolean visited[],Stack<Integer> stack) {
            visited[v] = true;
            for (int i = 0; i < adj.get(v).size(); i++) {
                Node node = adj.get(v).get(i);
                if (!visited[node.getV()])
                    topologicalSortUtil(node.getV(), visited, stack);
            }
            stack.push(v);
        }

        void longestPath(int s) {
            Stack<Integer> stack = new Stack<Integer>();
            int dist[] = new int[V];
            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);
            for (int i = 0; i < V; i++)
                dist[i] = Integer.MIN_VALUE;

            dist[s] = 0;

            while (stack.isEmpty() == false) {
                int u = stack.pop();
                if (dist[u] != Integer.MIN_VALUE) {
                    for (int i = 0; i < adj.get(u).size(); i++) {
                        Node node = adj.get(u).get(i);
                        if (dist[node.getV()] < dist[u] + node.getWeight())
                            dist[node.getV()] = dist[u] + node.getWeight();
                    }
                }
            }
            for (int i = 0; i < V; i++)
                if (dist[i] == Integer.MIN_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int s = 1;
        System.out.print("Following are longest distances from source vertex " + s + " \n");
        g.longestPath(s);
    }
}

package com.java.codes.GeeksCodes.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 */
public class KahnTopologicalSortGraph {
    int V;
    List<Integer>[] vertx;

    public KahnTopologicalSortGraph(int v) {
        this.V = v;
        vertx = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            vertx[i] = new ArrayList<>();
        }
    }

    private void addEdge(int u, int v) {
        vertx[u].add(v);
    }

    private void topologicalSort() {
        Integer indegree[] = new Integer[V];
        int cnt = 0;
        int result[] = new int[V];
        for (int i = 0; i < V; i++) {
            indegree[i] = 0;
        }
        for (int i = 0; i < V; i++) {
            for (int val: vertx[i]) {
                indegree[val]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                que.offer(i);
        }
        while (!que.isEmpty()) {
            Integer value = que.poll();
            result[cnt++] = value;
            for (int val : vertx[value]) {
                if (--indegree[val] == 0) {
                    que.offer(val);
                }
            }
        }
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        KahnTopologicalSortGraph graph = new KahnTopologicalSortGraph(6);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.topologicalSort();
    }
}

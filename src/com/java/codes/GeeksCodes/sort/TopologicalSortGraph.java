package com.java.codes.GeeksCodes.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TopologicalSortGraph {
    int v;
    List<List<Integer>> adj;
    public TopologicalSortGraph(int v){
        this.v = v;
        adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int v, int u){
        adj.get(v).add(u);
    }
    private void topologicalSortUtil(int index, Stack<Integer> stack, boolean[] visited){
        visited[index] = true;
        Iterator<Integer> itr = adj.get(index).iterator();
        while(itr.hasNext()){
            Integer i = itr.next();
            if(!visited[i]){
                topologicalSortUtil(i, stack, visited);
            }
        }
        stack.push(index);
    }

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[v];
        int i;
        for(i=0;i<v;i++){
            visited[i] = false;
        }
        for(i=0;i<v;i++){
            if(!visited[i]){
                topologicalSortUtil(i, stack, visited);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    public static void main(String[] args) {
        TopologicalSortGraph graph = new TopologicalSortGraph(6);
        /*graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);*/
        graph.addEdge(0,1);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);
        graph.topologicalSort();
    }
}

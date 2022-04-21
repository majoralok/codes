package com.java.codes.GeeksCodes.tree;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-height-trees
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any
 * connected graph without simple cycles is a tree. *
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates
 * that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as
 * the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees,
 * those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 * <p>
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 * <p>
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 * <p>
 * This example is a classic case of how adjacency matrix works along with Uber question of hops
 */
// in this exaple we need to compute the result till the size of result is not <=2
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0 || n == 1) return Arrays.asList(0);
        List<Integer> result = new ArrayList<>();
        List<Integer> adj[] = new ArrayList[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            adj[x].add(y);
            adj[y].add(x);
        }
        for (int i = 0; i < n; i++) {
            if (adj[i].size() == 1) {
                queue.offer(i);
            }
        }
        while (n > 2) {
            int size = queue.size();
            n = n - size;
            while (size-- > 0) {
                int key = queue.poll();
                for (int index : adj[key]) {
                    adj[index].remove(new Integer(key));
                    if (adj[index].size() == 1) {
                        queue.offer(index);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int edges[][] = {{1, 0}, {1, 2}, {1, 3}};
        MinimumHeightTrees trees = new MinimumHeightTrees();
        List<Integer> ans = trees.findMinHeightTrees(n, edges);
        System.out.println(ans);
        n = 6;
        edges = new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        ans = trees.findMinHeightTrees(n, edges);
        System.out.println(ans);
        n = 2;
        edges = new int[][]{{1, 0}};
        ans = trees.findMinHeightTrees(n, edges);
        System.out.println(ans);
        n = 6;
        edges = new int[][]{{1, 0}, {0, 2}, {3, 0}, {3, 4}, {5, 4}};
        ans = trees.findMinHeightTrees(n, edges);
        System.out.println(ans);
    }
}

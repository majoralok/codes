package com.java.codes.GeeksCodes.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TraverseWholeMatrix {
    static int MAX = 100;

    private static void dfs(int i, int j, int[][] adj, boolean visit[][], int N, int M) {
        visit[i][j] = true;
        if (i + 1 < N && !visit[i + 1][j] && adj[i][j] >= adj[i + 1][j])
            dfs(i + 1, j, adj, visit, N, M);
        if (j + 1 < M && !visit[i][j + 1] && adj[i][j] >= adj[i][j + 1])
            dfs(i, j + 1, adj, visit, N, M);
        if (i - 1 >= 0 && !visit[i - 1][j] && adj[i][j] >= adj[i - 1][j])
            dfs(i - 1, j, adj, visit, N, M);
        if (j - 1 >= 0 && !visit[i][j - 1] && adj[i][j] >= adj[i][j - 1])
            dfs(i, j - 1, adj, visit, N, M);
    }

    private static void printMinSources(int[][] adj, int N, int M) {
        List<Pair<Integer, Pair<Integer, Integer>>> x = new ArrayList<>();
        boolean visit[][] = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                x.add(new Pair(adj[i][j], new Pair(i, j)));
                visit[i][j] = false;
            }
        }
        Collections.sort(x, new Comparator<Pair<Integer, Pair<Integer, Integer>>>() {
            @Override
            public int compare(Pair<Integer, Pair<Integer, Integer>> o1, Pair<Integer, Pair<Integer, Integer>> o2) {
                return o2.getKey() - o1.getKey();
            }
        });
        for (int k = 0; k < x.size(); k++) {
            int i = x.get(k).getValue().getKey();
            int j = x.get(k).getValue().getValue();
            if (!visit[i][j]) {
                System.out.println(i + " " + j);
                dfs(i, j, adj, visit, N, M);
            }
        }
    }

    public static void main(String[] args) {
        int N = 4, M = 3;

        int adj[][] = {{1, 1, 1}, {1, 1, 1}, {2, 3, 1}, {1, 1, 1}};
        printMinSources(adj, N, M);
    }
}

package com.java.codes.GeeksCodes.graph;

import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode.com/problems/evaluate-division
 * https://leetcode.com/discuss/interview-question/483660/google-phone-currency-conversion
 * <p>
 * Rates: ['USD', 'JPY', 110] ['US', 'AUD', 1.45] ['JPY', 'GBP', 0.0070]
 * To/From currency ['GBP', 'AUD']
 * Find the rate for the 'To/From' curency. In this case, the correct result is 1.89
 */
public class EquationDivisionMapGraph {
    private static class Node {
        String key;
        Double value;

        public Node(String k, Double v) {
            this.key = k;
            this.value = v;
        }
    }
    private static Double dfs(Map<String, List<Node>> graphMap, String source, String dest, HashSet<String> visited) {
        if(!graphMap.containsKey(source) || !graphMap.containsKey(dest)) return -1.0;
        if(source.equals(dest)) return 1.0;
        visited.add(source);
        for(Node node: graphMap.get(source)){
            if(!visited.contains(node.key)){
                Double ans = dfs(graphMap, node.key, dest, visited);
                if(ans != -1.0){
                    return ans * node.value;
                }
            }
        }
        return -1.0;
    }
    private static Double[] calculateQueryPathValue(Map<String, List<Node>> graphMap, List<Pair<String, String>> query) {
        Double[] result = new Double[query.size()];
        for(int i=0;i<query.size();i++){
            String source = query.get(i).getKey();
            String dest = query.get(i).getValue();
            result[i] = dfs(graphMap, source, dest, new HashSet<>());
        }
        return result;
    }

    private static Map createMapGraph(List<Pair<String, String>> equations, Double[] weight) {
        Map<String, List<Node>> graphMap = new HashMap<>();
        for (int i = 0; i < weight.length; i++) {
            String source = equations.get(i).getKey();
            String dest = equations.get(i).getValue();
            graphMap.putIfAbsent(source, new ArrayList<>());
            graphMap.putIfAbsent(dest, new ArrayList<>());
            graphMap.get(source).add(new Node(dest, weight[i]));
            graphMap.get(dest).add(new Node(source, 1 / weight[i]));
        }
        return graphMap;
    }

    public static void main(String[] args) {
        Double weight[] = {5.0, 10.0};
        List<Pair<String, String>> equations = new ArrayList<>();
        equations.add(new Pair<>("a", "b"));
        equations.add(new Pair<>("b", "c"));
        List<Pair<String, String>> query = new ArrayList<>();
        query.add(new Pair<>("a", "c"));
        Map mapGraph = EquationDivisionMapGraph.createMapGraph(equations, weight);
        Double[] result = calculateQueryPathValue(mapGraph, query);
        for (double d : result)
            System.out.print(d + " ");
    }
}

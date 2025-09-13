package graph.graphproblems;

import java.util.ArrayList;
import java.util.List;

public class MinReorder {
    public static void main(String[] args) {
        //https://leetcode.com/problems/minimum-number-of-edges-to-reverse-to-make-path-from-source-to-destination/description/
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int n = 6;
        System.out.println(minReorder(n, connections));
    }

    public static int minReorder(int n, int[][] connections) {
        // Create an adjacency list to represent the graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the graph with edges and their directions
        for (int[] conn : connections) {
            graph.get(conn[0]).add(new int[]{conn[1], 1}); // Original direction
            graph.get(conn[1]).add(new int[]{conn[0], 0}); // Reverse direction
        }

        // Perform DFS to count the number of edges to be reversed
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }
    private static int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] neighbor : graph.get(node)) {
            int nextNode = neighbor[0];
            int needsChange = neighbor[1];

            if (!visited[nextNode]) {
                changes += needsChange; // Count if we need to change the direction
                changes += dfs(nextNode, graph, visited); // Recur for the next node
            }
        }

        return changes;
    }
}

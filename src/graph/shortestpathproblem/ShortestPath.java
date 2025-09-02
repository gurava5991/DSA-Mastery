package graph.shortestpathproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
class ShortestPath {
    public static void main(String[] args) {
        //[[1,2,2], [2,5,5], [2,3,4], [1,4,1],[4,3,3],[3,5,1]]
        System.out.println(shortestPath(5, 6, new int[][]{{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}}));
    }
    public static List<Integer> shortestPath(int n, int m, int[][] edges) {
        int[] dis = new int[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
            parent[i] = i; // initialize parent of each node as itself
        }

        // Construct graph
        List<Pair>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w)); // since undirected
        }

        // Dijkstra's algorithm using PriorityQueue
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1 , p2)-> p1.weight - p2.weight);
        dis[1] = 0;
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;

            for (Pair neighbor : graph[u]) {
                int v = neighbor.node;
                int wt = neighbor.weight;

                if (dis[u] + wt < dis[v]) {
                    dis[v] = dis[u] + wt;
                    pq.add(new Pair(v, dis[v]));
                    parent[v] = u; // update parent
                }
            }
        }

        // If node n is not reachable
        if (dis[n] == Integer.MAX_VALUE) return List.of(-1);

        // Reconstruct path from n to 1
        List<Integer> path = new ArrayList<>();
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        path.add(dis[n]);

        return path;

    }
}





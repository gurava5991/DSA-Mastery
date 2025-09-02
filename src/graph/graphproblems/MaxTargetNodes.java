package graph.graphproblems;

import java.util.*;

public class MaxTargetNodes {
    public static void main(String[] args) {
        //[0,1],[0,2],[2,3],[2,4]
        int[][] edges1 = {
                {0,1}
        };
        //dges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2
        int[][] edges2 = {
                {0,1}
        };
        int k = 0;

        int[] arr = maxTargetNodes(edges1 , edges2 , k);
        System.out.println(Arrays.toString(arr));

    }
    private static int bfsCount(int node , List<Integer>[] graph1 , int k , int n){
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        int count = 1 , dist = 0;
        while(!queue.isEmpty() && dist < k){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                int curr = queue.poll();
                for(int neighbour : graph1[curr]){
                    if(!visited[neighbour]){
                        queue.add(neighbour);
                        visited[neighbour] = true;
                        count++;
                    }
                }
            }
            dist++;
        }
        return count;
    }
    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length , m = edges2.length;
        List<Integer>[] graph1 = new ArrayList[n + 1];
        List<Integer>[] graph2 = new ArrayList[m + 1];
        for(int i = 0 ; i <= n ; i++){
            graph1[i] = new ArrayList<>();
        }
        for(int i = 0 ; i <= m ; i++){
            graph2[i] = new ArrayList<>();
        }
        for(int[] edge : edges1){
            int u = edge[0] , v = edge[1];
            graph1[u].add(v);
            graph1[v].add(u);
        }
        for(int[] edge : edges2){
            int u = edge[0] , v = edge[1];
            graph2[u].add(v);
            graph2[v].add(u);
        }

        int[] targetNodes = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            targetNodes[i] = bfsCount(i , graph1 , k , n + 1 );
        }

        int goldenNode = 0;
        for(int i = 0 ; i <= m ; i++){
            int cnt = bfsCount(i , graph2 , k - 1 , m + 1);
            goldenNode = Math.max(goldenNode , cnt);
        }
        for(int i = 0 ; i <= n ; i++){
            targetNodes[i] += goldenNode;
        }
        return targetNodes;


    }
}

# Graph Patterns 
## Pattern1 : Using BFS Traversal 
- [BFS](https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1)

Intuition:
The traversal techniques form the basics of any graph problem. One of the two traversal techniques is Breadth First Search(BFS), also known as Level Order Traversal. Breadth-First Search (BFS) is a traversal technique that explores all the neighbors of a node before moving to the next level of neighbors. It uses a queue data structure.

Approach:
* Mark all nodes as unvisited. Create an empty queue.
* Enqueue the source node. Mark the source node as visited.
* While the queue is not empty:
* Dequeue the front node. Process the node.
* For each adjacent unvisited node, enqueue the adjacent node and mark it as visited.
* Repeat the process until all nodes are visited.

```java
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        // Code here
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        ArrayList<Integer> ans = new ArrayList<>();
        visited[0] = true;
        while(!queue.isEmpty()){
            int parent = queue.poll();
            ans.add(parent);
            for(Integer child : adj.get(parent)){
                if(visited[child] == false){
                    queue.add(child);
                    visited[child] = true;
                }
            }
        }
        return ans;

    }
}
```

Time Complexity: O(V+E) (where E represents the number of edges in the graph)
All the V nodes are traversed during the traversal and all the E edges are processed once taking an overall time complexity of O(V+E).

Space Complexity: O(V)
The BFS traversal uses a queue data structure to process the nodes in a level-order fashion. In the worst case, all the nodes will be present in the queue leading to space requirement of O(V).

- [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/description/)

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

```java
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
```

Approach:

* Identify the initial rotten oranges (2) and add their positions to a queue
* Count the total number of fresh oranges (1) for later comparison
* Use BFS to simulate the spread of rotting from the rotten oranges to adjacent fresh oranges.
* For each rotten orange, try to rot its neighboring fresh oranges in all four directions (up, down, left, right).After processing all rotten oranges at the current level of BFS, increment the time if any fresh oranges were rotted in that round.
* If all fresh oranges were successfully rotted (count == countFresh), return the total time taken.
* Otherwise, return -1 indicating some fresh oranges could not be rotted.

```java
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int countFresh = 0;
        boolean[][] vis = new boolean[n][m];

        // Step 1: Initialize the queue with all rotten oranges and count fresh oranges.
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i , j});
                    vis[i][j] = true;
                }
                if(grid[i][j] == 1)
                    countFresh++;
            }
        }

        int time = 0;
        int count = 0;
        int[][] dir = new int[][]{{0 , -1} , {0 , 1} ,{1 , 0} , {-1, 0}}; // Directions for moving in the grid.

        // Step 2: Perform BFS to spread rotting to adjacent fresh oranges.
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isRotted = false;
            for(int i = 0 ; i < size ; i++){
                int[] parent = queue.poll();
                int x = parent[0] , y = parent[1];
                
                for(int j = 0 ; j < 4 ; j++){
                    int nx = dir[j][0] + x;
                    int ny = dir[j][1] + y;
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny] && grid[nx][ny] == 1 ) {
                        queue.add(new int[]{nx , ny});
                        vis[nx][ny] = true;
                        count++;
                        isRotted = true;
                    }
                }
            }
            if(isRotted) // Increase time if rotting spread this round.
                 time++;
        }

        // Step 3: Return result based on whether all fresh oranges were rotted.
        return count == countFresh ? time : -1;
    }
}

```
Time Complexity: O(N*M) (where N and M are the dimensions of grid)
In the worst case, each fresh orange in the grid will be rotten and for each rotten orange, its 4 neighbors are checked taking O(4*N*M) time.

Space Complexity: O(N*M)
Using a queue data structure, which will store all cells if a grid is full of rotten oranges taking O(N*M) space.



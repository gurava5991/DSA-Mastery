# Binary Tree 

A Binary Tree is a hierarchical data structure in which each node has at most two children, referred to as the left child and the right child. Binary trees are widely used in computer science for various purposes, such as searching, sorting, and hierarchical data representation.

**Key Terminology**

1. **Node:** The basic unit of a binary tree containing data and references to its children.
2. **Root:** The topmost node of the tree. It has no parent.
3. **Parent:** A node that has children.
4. **Child:** A node that is a descendant of another node.
5. **Leaf Node :** A node with no children.
6. **Height of a Node:** The number of edges on the longest path from the node to a leaf.
7. **Depth of a Node:** The number of edges from the root to the node.
8. **Subtree:** A tree consisting of a node and all its descendants.
9. **Level:** All nodes at the same depth form a level of the tree.
10. **Full Binary Tree:** A tree where every node has either 0 or 2 children.
11. **Complete Binary Tree:** A tree where all levels, except possibly the last, are completely filled, and all nodes are as far left as possible.
12. **Perfect Binary Tree:** A tree where all interior nodes have two children, and all leaves are at the same level.
13. **Balanced Binary Tree:** A tree where the difference in height between the left and right subtrees of any node is at most one.


### Types of Binary Trees

**Full Binary Tree:** Each node has 0 or 2 children.<br>
Example <br>
```java
   1
  / \
 2   3
/ \  
```
**Perfect Binary Tree:** All internal nodes have 2 children, and all leaves are at the same level.

```java
     1
   /   \
  2     3
 / \   / \
4   5 6   7
```

**Complete Binary Tree:** All levels are completely filled except possibly the last level, which is filled from left to right.

```java
     1
   /   \
  2     3
 / \   /
4   5 6
```

**Skewed Binary Tree:** A tree where all nodes have only one child (either left or right).

```java
     1              1
    /                \
   2                  2
  /                     \
 3                       3  
```
**Balanced Binary Tree:**The height difference between the left and right subtrees of any node is at most one.

**Binary Tree Representation in java** 

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
    }
}

```
**Binary Tree Traversal :** 

A Traversal of tree is a process to traversal a tree in a systematic way to so that each node is visited exactly once.

**Types of Traversal :** 

**1 . Preorder Traversal :** 

The Preorder Traversal of a binary tree is defined recursively as follows 

* visit the root
* Traverse the left subtree in preorder 
* Traverse the right subtree in preorder

```java
import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize a node with a value
    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    // Helper function to perform preorder traversal
    private void preOrderHelper(TreeNode node, List<Integer> ans) {
        // If the current node is null, return (base case for recursion)
        if (node == null) {
            return;
        }

        // Append the current node's value to the list
        ans.add(node.data);
        // Recursively traverse the left subtree
        preOrderHelper(node.left, ans);
        // Recursively traverse the right subtree
        preOrderHelper(node.right, ans);
    }

    // Function to initiate preorder traversal and return the resulting list
    public List<Integer> preorder(TreeNode root) {
        // Create an empty list to store preorder traversal values
        List<Integer> ans = new ArrayList<>();
        // Call the helper function with the root node and the list
        preOrderHelper(root, ans);
        // Return the resulting list containing preorder traversal values
        return ans;
    }

    // Main method to test the preorder traversal
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create an instance of the Solution class
        Solution solution = new Solution();
        // Getting preorder traversal
        List<Integer> result = solution.preorder(root);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

```

Iterative Approach for the Preorder Traversal : 

An iterative approach maintains a stack structure to simulate the recursive nature of the traversal without using actual recursion. The stack follows a last-in-first-out methodology and stores the nodes yet to be processed mimicking the depth-first search characteristic of preorder traversal.

```java
class Solution {
    public List<Integer> preorder(TreeNode root) {
        //your code goes here
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            result.add(curr.data);

            if(curr.right != null){
                st.push(curr.right);
            }
            if(curr.left != null){
                st.push(curr.left);
            }
        }
        
        return result;

    }
}
```

Inorder Traversal : 

The Inorder Traversal of a binary tree is defined recursively as follows

* Traverse the left subtree in Inorder
* visit the root
* Traverse the right subtree in Inorder

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        printInorder(root);
    }
    private static void printInorder(TreeNode root) {
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
```
**Using Iterative Approach:** 

```java
class Solution {
    public List<Integer> inorder(TreeNode root) {
        //your code goes here
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;

        while(!st.isEmpty() || curr != null){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            result.add(curr.data);
            curr = curr.right;
        }
        return result;

    }
}
```

**PostOrder Traversal** 

The PostOrder Traversal of a binary tree is defined recursively as follows

* Traverse the left subtree in postorder 
* Traverse the right subtree in postorder
* visit the root

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        printPostorder(root);
    }
    private static void printPostorder(TreeNode root) {
        if(root ==  null)
            return;
        printPreorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val + " ");
        
    }
}
```

Postorder Traversal using Iterative - 2 Stacks 

To achieve postorder traversal iteratively, we can use a two-stack approach. This method involves performing a modified traversal that processes nodes in the order of left, right, and root. We then reverse the result to get the correct postorder sequence. The first stack helps in managing the nodes during traversal, while the second stack collects nodes in a manner that makes it easy to reverse their order at the end. This approach efficiently simulates the recursive process without actually using recursion.

**Approach To perform postorder traversal iteratively using two stacks:**

* Initialize two stacks: one for the traversal and another to hold nodes in a way that will help retrieve the postorder sequence.
* Push the root node onto the first stack to start the traversal process.<br>
While the first stack is not empty:<br>
* Pop a node from the first stack and push it onto the second stack.
* Push the left child of the node (if it exists) onto the first stack.
* Push the right child of the node (if it exists) onto the first stack.
* Once the first stack is empty, pop all nodes from the second stack and collect them to form the postorder traversal sequence.

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public List<Integer> postorder(TreeNode root) {
        //your code goes here
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 =  new Stack<>();

        List<Integer> result = new ArrayList<>();

        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode curr = stack1.pop();
            stack2.push(curr);

            if(curr.left != null){
                stack1.push(curr.left);
            }

            if(curr.right != null){
                stack1.push(curr.right);
            }
        }

        while(!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            result.add(node.data);
        }
        return result;




    }
}
```

**Level Order Traversal(Queue Based Approach) :**

**Intuition for Level Order Traversal**

**Level-order traversal** involves visiting nodes of a binary tree level by level, starting from the root and moving downward. Nodes at each level are processed from left to right. The traversal uses a queue to maintain the order in which nodes should be processed, ensuring that each level is visited completely before moving to the next.

**Steps for Level Order Traversal**

1. **Initialize a Queue:**

* Create a queue to hold nodes.
* Add the root node to the queue.

2. **Process the Nodes:**
* While the queue is not empty 
* Remove the front node from the queue.
* Add the value of the node to the result.
* Enqueue the left child (if it exists).
* Enqueue the right child (if it exists).

3. Complete All Levels:

* Continue the process until all nodes are visited

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null; right = null; }
 * }
 **/

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}

class Solution {
    // Function to perform level-order traversal of a binary tree
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Create a list to store the levels
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            // If the tree is empty, return an empty list
            return ans;
        }
        
        // Create a queue to store nodes for level-order traversal
        Queue<TreeNode> q = new LinkedList<>();
        // Add the root node to the queue
        q.add(root);
        
        while (!q.isEmpty()) {
            // Get the size of the current level
            int size = q.size();
            // Create a list to store nodes at the current level
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                // Get the front node from the queue
                TreeNode node = q.poll();
                // Add the node value to the current level list
                level.add(node.data);
                
                // Enqueue the child nodes if they exist
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            // Add the current level to the answer list
            ans.add(level);
        }
        // Return the level-order traversal of the tree
        return ans;
    }
    
    // Main method to test the level-order traversal
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        // Create an instance of the Solution class
        Solution solution = new Solution();
        // Perform level-order traversal
        List<List<Integer>> result = solution.levelOrder(root);
        
        // Printing the level-order traversal result
        System.out.println("Level Order Traversal of Tree:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}

```

**Time Complexity:** O(N) where N is the number of nodes in the binary tree. Each node of the binary tree is enqueued and dequeued exactly once, hence all nodes need to be processed and visited. Processing each node takes constant time operations which contributes to the overall linear time complexity.

**Space Complexity:** O(N) where N is the number of nodes in the binary tree. In the worst case, the queue has to hold all the nodes of the last level of the binary tree; the last level could at most hold N/2 nodes, hence the space complexity of the queue is proportional to O(N). The resultant vector answer also stores the values of the nodes level by level and hence contains all the nodes of the tree contributing to O(N) space as well.

**Important Interview Questions Based Level Order Traversal :** 

## Reverse Level Order Traversal (easy)

[Reverse Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/)

Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

```java
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
```
This Problem follows Level Order Traversal pattern. The only difference will be that instead of appending the current level at the end , we will append the current level at the beginning of List.

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level_size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0 ; i < level_size ; i++){
                TreeNode current = queue.poll();
                currentLevel.add(current.val);
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            result.add(0 , currentLevel);
        }
        return result;
        
    }
}
```

**Time Complexity:** O(N) where N is the number of nodes in the binary tree. Each node of the binary tree is enqueued and dequeued exactly once, hence all nodes need to be processed and visited. Processing each node takes constant time operations which contributes to the overall linear time complexity.

**Space Complexity:** O(N) where N is the number of nodes in the binary tree. In the worst case, the queue has to hold all the nodes of the last level of the binary tree; the last level could at most hold N/2 nodes, hence the space complexity of the queue is proportional to O(N). The resultant vector answer also stores the values of the nodes level by level and hence contains all the nodes of the tree contributing to O(N) space as well.

## ZIGZAG Traversal 
[zigzag Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

```java
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
```

**Approach**

1. Begin by initializing an empty queue for node storage during traversal and a 2D vector to capture the level order traversal. If the binary tree is empty, return this empty 2D vector immediately. Additionally, create a leftToRight flag to track the traversal direction. When leftToRight is true, nodes are inserted into the level vector from left to right; when false, they are inserted from right to left.
2. Enqueue the root node of the binary tree into the queue to start the traversal.
3 . Proceed with the following steps while the queue is not empty:
* Determine the current size of the queue, which reflects the number of nodes present at the current level of the tree.
* Create a vector named level to store the nodes' values at the current level.
* For each node at the current level, remove the front node from the queue, store its value in the level vector (inserting from left to right if leftToRight is true, or from right to left if false), and enqueue its child nodes (if they exist).

4. After processing all nodes at the current level, append the level vector to the ans 2D vector. Toggle the leftToRight flag to reverse the traversal direction for the subsequent level.
5. After all levels have been processed, return the ans 2D vector, which contains the zigzag level-order traversal of the binary tree.

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // List to store the result of zigzag traversal
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.offer(root);

        boolean leftToRight = true;

        while(!nodesQueue.isEmpty()){
            int levelSize = nodesQueue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < levelSize ; i++){
                TreeNode curr = nodesQueue.poll();
                if(leftToRight) level.add(curr.val);
                else level.add(0 , curr.val);
                if(curr.left != null){
                    nodesQueue.offer(curr.left);
                }
                if(curr.right != null){
                    nodesQueue.offer(curr.right);
                }
            }
            leftToRight = (!leftToRight);
            result.add(level);

        }
        return result;
        
    }
}
```

**Time Complexity:** O(N) where N is the number of nodes in the binary tree. Each node of the binary tree is enqueued and dequeued exactly once, hence all nodes need to be processed and visited. Processing each node takes constant time operations which contributes to the overall linear time complexity.

**Space Complexity:** O(N) where N is the number of nodes in the binary tree. In the worst case, the queue has to hold all the nodes of the last level of the binary tree; the last level could at most hold N/2 nodes, hence the space complexity of the queue is proportional to O(N). The resultant vector answer also stores the values of the nodes level by level and hence contains all the nodes of the tree contributing to O(N) space as well.

Problems on Level Order Traversal 
[Level Averages in a Binary Tree (easy)](https://leetcode.com/problems/average-of-levels-in-binary-tree/)
[Level Maximum in a Binary Tree](https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/) : maxValue = Math.max(maxValue, currentNode.val)

## Minimum Depth of a Binary Tree

[Minimum Depth of a Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)

```java
Find the minimum depth of a binary tree. The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.
```

This problem follows the Binary Tree Level Order Traversal pattern. We can follow the same BFS approach. The only difference will be, instead of keeping track of all the nodes in a level, we will only track the depth of the tree. As soon as we find our first leaf node, that level will represent the minimum depth of the tree.

```java
class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    public static int findMinimumDepth(TreeNode root) {
        if (root == null) return 0;

        // Initialize a queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int minimumTreeDepth = 0;

        while (!queue.isEmpty()) {
            minimumTreeDepth++;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                // Get the next node
                TreeNode currentNode = queue.poll();

                // Check if this is a leaf node
                if (currentNode.left == null && currentNode.right == null) {
                    return minimumTreeDepth;
                }

                // Insert the children of the current node into the queue
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return minimumTreeDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        
        System.out.println("Tree Minimum Depth: " + findMinimumDepth(root));

        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);

        System.out.println("Tree Minimum Depth: " + findMinimumDepth(root));
    }
}

```

**The time complexity** of the above algorithm is O(N), where N is the total number of nodes in the tree. This is due to the fact that we traverse each node once.<br>
**The space complexity** of the above algorithm will be O(N) which is required for the queue. Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level), therefore we will need O(N) space to store them in the queue.

Follow-up Question : [Maximum Depth of a Binary Tree(Height of bt)](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

Level Order Successor of a Node in Binary Tree 

```java
Given a binary tree and a node, find the level order successor of the given node in the tree. The level order successor is the node that appears right after the given node in the level order traversal.
```

**Algorithm**

1. Initialize a queue and add the root node to it.

2. While the queue is not empty:

* Dequeue the front node.
* Check if the previous node matches the target node.
* If it does, return the current node.
* Enqueue the left and right children of the current node (if they exist).

3. If the loop completes without finding a successor, return null.

```java
import java.util.*;

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, TreeNode target) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            // Add children to the queue
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);

            // Check if the previous node was the target
            if (currentNode == target) {
                return queue.peek(); // The next node in the queue is the successor
            }
        }

        return null; // No successor found
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode target = root.left; // Node with value 2
        TreeNode successor = findSuccessor(root, target);

        if (successor != null) {
            System.out.println("The level order successor of node " + target.value + " is " + successor.value);
        } else {
            System.out.println("The node " + target.value + " has no level order successor.");
        }
    }
}
```

## Connect Level Order Siblings (medium)

```java
Given a binary tree, connect each node with its level order successor. The last node of each level should point to a null node.
```

This problem follows the Binary Tree Level Order Traversal pattern. We can follow the same BFS approach. The only difference is that while traversing a level we will remember the previous node to connect it with the current node.

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = this.next = null;
    }
}

public class Solution {
    public static void connectLevelOrderSiblings(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode prevNode = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (prevNode != null) {
                    prevNode.next = currentNode;
                }
                prevNode = currentNode;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            // The next pointer of the last node in the level is already null.
        }
    }

    public static void printLevelOrder(TreeNode root) {
        TreeNode nextLevelRoot = root;
        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;

            while (current != null) {
                System.out.print(current.val + " -> ");
                if (nextLevelRoot == null) {
                    if (current.left != null) nextLevelRoot = current.left;
                    else if (current.right != null) nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        connectLevelOrderSiblings(root);
        printLevelOrder(root);
    }
}
```

### Depth First Search Tree Problems
This pattern is based on the Depth First Search (DFS) technique to traverse a tree.

We will be using recursion (or we can also use a stack for the iterative approach) to keep track of all the previous (parent) nodes while traversing. This also means that the space complexity of the algorithm will be O(H), where H is the maximum height of the tree.

## **112. Path Sum**

### **🔹 Problem Statement**
Given the `root` of a **binary tree** and an integer `targetSum`, return **true** if the tree has a **root-to-leaf path** such that adding up all the values along the path equals `targetSum`.

A **leaf** is a node with no children.

---

### **🔹 Example 1**
#### **Input:**
```
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \      \
  7    2      1
```
`targetSum = 22`

#### **Output:**
```
true
```
#### **Explanation:**
- There exists a root-to-leaf path: `5 → 4 → 11 → 2 = 22`

---

### **🔹 Example 2**
#### **Input:**
```
        1
       / \
      2   3
```
`targetSum = 5`

#### **Output:**
```
false
```
#### **Explanation:**
- No root-to-leaf path adds up to `5`.

---

### **🔹 Example 3**
#### **Input:**
```
root = []
targetSum = 0
```
#### **Output:**
```
false
```
#### **Explanation:**
- The tree is empty, so no path exists.

---

## **🔹 Intuition**
- We **traverse the tree** from the root to each leaf.
- At each node, we **subtract its value** from `targetSum`.
- When we reach a **leaf node**, check if the remaining `targetSum` is **0**.
- If we find such a path, return `true`.
- If we exhaust all paths and don’t find one, return `false`.

---

## **🔹 Approach**
- Use **DFS (Depth-First Search)**.
- **Base case:** If the tree is empty (`root == null`), return `false`.
- Recursively **check left and right subtrees** with the updated sum (`targetSum - root.val`).
- If we reach a **leaf node**, check if the remaining sum is **0**.

---

## **🔹 Code (Recursive DFS)**
```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: If root is null, there is no path
        if (root == null) return false;

        // Check if we are at a leaf node and targetSum equals node's value
        if (root.left == null && root.right == null && targetSum == root.val)
            return true;

        // Recur on left and right subtrees with the remaining sum
        return hasPathSum(root.left, targetSum - root.val) || 
               hasPathSum(root.right, targetSum - root.val);
    }
}
```

---

## **🔹 Code Walkthrough**
#### **For Input:**
```
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \      \
  7    2      1
```
`targetSum = 22`

1. Start at `root = 5`, `targetSum = 22`
    - `22 - 5 = 17`, so we recurse on both `left (4)` and `right (8)`.
2. Move to `4`, `targetSum = 17`
    - `17 - 4 = 13`, recurse on `left (11)`.
3. Move to `11`, `targetSum = 13`
    - `13 - 11 = 2`, recurse on both `left (7)` and `right (2)`.
4. Move to `7`, `targetSum = 2`
    - `7` is a leaf but `2 - 7 ≠ 0`, return `false`.
5. Move to `2`, `targetSum = 2`
    - `2` is a leaf and `2 - 2 = 0`, return `true`.

Since we found a valid path (`5 → 4 → 11 → 2`), we return `true`.

---

## **🔹 Time and Space Complexity**
| Approach     | Time Complexity | Space Complexity |
|-------------|---------------|----------------|
| **Recursive DFS** | **O(N)** (Visit all nodes in worst case) | **O(H)** (Recursive stack height, where `H` is tree height) |

---

## All Paths for a Sum (medium)
https://leetcode.com/problems/path-sum-ii/
> Given a binary tree and a number `S`, find all paths from root-to-leaf such that the sum of all the node values of each path equals `S`.

### **Test Cases**
#### **Test Case 1**
🔹 **Input Tree:**
```
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \    / \
  7    2  5   1
```
🔹 **Input:** `targetSum = 22`
🔹 **Output:**
```java
[
    [5, 4, 11, 2],
    [5, 8, 4, 5]
]
```
### **Intuition**
- This problem is solved using **Depth-First Search (DFS)** with **backtracking**.
- We maintain a list `paths` to track the current path.
- If we reach a **leaf node** and the remaining `targetSum` becomes **zero**, we add a **copy** of the path to `resultPaths`.
- After exploring **both left and right subtrees**, we remove the last element (**backtrack**) to ensure that previous paths are not affected.

---
```java
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resultPaths = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        pathSumHelper(root, targetSum, paths, resultPaths);
        return resultPaths;
    }

    public void pathSumHelper(TreeNode root, int targetSum, List<Integer> paths, List<List<Integer>> resultPaths) {
        if (root == null)
            return;

        // Add current node to the path
        paths.add(root.val);

        // If it's a leaf node and the remaining sum is 0, we found a valid path
        if (root.left == null && root.right == null && targetSum == root.val) {
            resultPaths.add(new ArrayList<>(paths)); // Copy list before adding
        } else {
            // Recur for left and right subtree
            pathSumHelper(root.left, targetSum - root.val, paths, resultPaths);
            pathSumHelper(root.right, targetSum - root.val, paths, resultPaths);
        }

        // Backtracking step: Remove last element after processing both children
        paths.remove(paths.size() - 1);
    }
}
```

### **Complexity Analysis**
- **Time Complexity:** \( O(N) \), since we visit each node **once**.
- **Space Complexity:** \( O(H) \), where \( H \) is the height of the tree (for recursion stack).

---

### **Problem Statement**
Given a binary tree, find the root-to-leaf path with the **maximum sum**.

### **Example Walkthrough**
#### **Test Case 1**
🔹 **Input Tree:**
```
       10
      /  \
     5    20
    / \   / \
   1   8 15  25
```
🔹 **Output:**
```java
[10, 20, 25]
```
🔹 **Explanation:**
- Possible root-to-leaf paths:
    - **10 → 5 → 1** (Sum = 16)
    - **10 → 5 → 8** (Sum = 23)
    - **10 → 20 → 15** (Sum = 45)
    - **10 → 20 → 25** (Sum = 55) ✅ **(Maximum)**
- The maximum sum path is `[10, 20, 25]` with sum **55**.

---

### **Intuition**
- This is a classic **DFS (Depth-First Search) problem**.
- We traverse the tree while maintaining a running sum.
- At each leaf node, we check if the **current path sum is the maximum** and update our result accordingly.
- The final answer is the path with the maximum sum.

---

### **Approach**
1. **Use DFS (Recursive Approach)**
    - Traverse the tree while maintaining the sum of the current path.
    - If a leaf node is reached, check if the sum is the largest seen so far.
    - Store the path corresponding to this maximum sum.

2. **Backtracking**
    - Since we need to return the **exact path**, we use a **list** to track the current path.
    - When backtracking, remove the last element from the list.

---

### **Code Implementation**
```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Solution {
    private int maxSum = Integer.MIN_VALUE;
    private List<Integer> maxPath = new ArrayList<>();

    public List<Integer> maxSumPath(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> currentPath = new ArrayList<>();
        findMaxPath(root, 0, currentPath);
        return maxPath;
    }

    private void findMaxPath(TreeNode node, int currentSum, List<Integer> currentPath) {
        if (node == null) return;

        // Add current node to path
        currentPath.add(node.val);
        currentSum += node.val;

        // If it's a leaf node, check if it's the max sum path
        if (node.left == null && node.right == null) {
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxPath = new ArrayList<>(currentPath);
            }
        }

        // Recur for left and right subtree
        findMaxPath(node.left, currentSum, currentPath);
        findMaxPath(node.right, currentSum, currentPath);

        // Backtracking: Remove the last element
        currentPath.remove(currentPath.size() - 1);
    }
}
```

---

### **Complexity Analysis**
- **Time Complexity:** \( O(N) \) since we traverse each node **once**.
- **Space Complexity:** \( O(H) \) (height of the tree), used for recursion stack and storing the path.

---

## **129. Sum Root to Leaf Numbers**

### **Problem Statement**
You are given the `root` of a binary tree containing digits from `0-9` only.  
Each **root-to-leaf path** represents a number formed by concatenating the node values along the path.

Return **the sum of all root-to-leaf numbers**.

A **leaf node** is a node with no children.

---

### **Example Walkthrough**

#### **Example 1**
🔹 **Input:**
```
       1
      / \
     2   3
```
🔹 **Paths & Numbers:**
- `1 → 2` → `12`
- `1 → 3` → `13`

🔹 **Output:**
```
12 + 13 = 25
```

#### **Example 2**
🔹 **Input:**
```
       4
      / \
     9   0
    / \
   5   1
```
🔹 **Paths & Numbers:**
- `4 → 9 → 5` → `495`
- `4 → 9 → 1` → `491`
- `4 → 0` → `40`

🔹 **Output:**
```
495 + 491 + 40 = 1026
```

---

### **Intuition**
- Use **Depth-First Search (DFS)** to explore all root-to-leaf paths.
- Keep track of the **current number** formed by concatenating node values.
- When a **leaf node** is reached, add the number to the total sum.
- Backtrack to explore other paths.

---

### **Approach**
1. Start DFS traversal from the root.
2. Maintain a **currentSum** which stores the number formed so far.
    - `currentSum = currentSum * 10 + root.val`
3. When a **leaf node** is reached, add `currentSum` to the total sum.
4. Recursively traverse **left** and **right** subtrees.
5. **Base Case:** If `root == null`, return `0`.

---

### **Code Implementation**
#### **Recursive DFS Approach**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root , 0);
    }
    public int sumNumbersHelper(TreeNode root , int currentSum){
        //base cases 
        if(root == null)
            return 0;
        currentSum = currentSum * 10 + root.val;
        if(root.left == null && root.right == null)
            return currentSum;
        int left = sumNumbersHelper(root.left , currentSum);
        int right = sumNumbersHelper(root.right , currentSum);
        return left + right;
    }
}
```

---

### **Complexity Analysis**
- **Time Complexity:** \( O(N) \)
    - Each node is visited **once** in DFS traversal.
- **Space Complexity:** \( O(H) \)
    - **Recursive Stack Space** where \( H \) is the height of the tree.
    - Worst case: \( O(N) \) (Skewed tree), Best case: \( O(\log N) \) (Balanced tree).

---

## **Check if there is a Root-to-Leaf Path with a Given Sequence**

### **Problem Statement**
Given a **binary tree** and an **array of integers (sequence)**, check if there exists a **root-to-leaf path** in the tree that matches the given sequence.

✅ **Constraints:**
- The sequence must be **fully matched** from root to a **leaf**.
- The sequence **cannot stop in between** and must end at a **leaf** node.

---

### **Example Walkthrough**

#### **Example 1**
🔹 **Input:**
```
Tree:
       1
      / \
     2   3
    /
   4

Sequence: [1, 2, 4]
```
🔹 **Valid Paths:**
- `1 → 2 → 4` ✅ (Matches)
- `1 → 3` ❌ (Doesn't match)

🔹 **Output:**
```java
true
```

---

#### **Example 2**
🔹 **Input:**
```
Tree:
       1
      / \
     2   3
    / \
   4   5

Sequence: [1, 2, 5]
```
🔹 **Valid Paths:**
- `1 → 2 → 4` ❌ (Doesn't match)
- `1 → 2 → 5` ✅ (Matches)

🔹 **Output:**
```java
true
```

---

#### **Example 3**
🔹 **Input:**
```
Tree:
       1
      / \
     2   3
    /
   4

Sequence: [1, 3, 4]
```
🔹 **Paths in Tree:**
- `1 → 2 → 4` ❌ (Doesn't match)
- `1 → 3` ❌ (Doesn't match)

🔹 **Output:**
```java
false
```

---

### **Intuition**
- Perform **DFS** and check if the **current node matches the sequence at the corresponding index**.
- Move to the next index in the sequence and traverse **left** and **right** subtrees.
- If a **leaf node** is reached, check if the sequence is completely matched.

---

### **Approach**
1. Start **DFS traversal** from the root.
2. **Check conditions** at each node:
    - If the **current node's value** does not match the sequence at the current index, return `false`.
    - If we reach the **end of the sequence**, check if it is a **leaf node**.
3. Recursively check for **left** and **right** child nodes.
4. If any path matches, return `true`.

---

### **Code Implementation**
```java
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode node, int[] arr, int index) {
        if (node == null || index >= arr.length || node.val != arr[index])
            return false;

        // If we reached the last element of sequence, it must be a leaf node
        if (index == arr.length - 1)
            return node.left == null && node.right == null;

        // Recur for left and right child
        return dfs(node.left, arr, index + 1) || dfs(node.right, arr, index + 1);
    }
}
```

---

### **Complexity Analysis**
- **Time Complexity:** \( O(N) \)
    - We traverse the tree once in DFS.
- **Space Complexity:** \( O(H) \)
    - **Recursive Stack Space** where \( H \) is the height of the tree.
    - Worst case: \( O(N) \) (Skewed tree), Best case: \( O(\log N) \) (Balanced tree).

## **437. Path Sum III**

### **Problem Statement**
Given the **root** of a binary tree and an integer **targetSum**, return **the number of paths** where the sum of the values along the path equals **targetSum**.

✅ **Constraints:**
- The path **does not need to start or end at the root or a leaf**.
- The path must move **downward only** (from parent to child).
- The **node values** can be **positive, negative, or zero**.

---

### **Example Walkthrough**

#### **Example 1**
🔹 **Input:**
```
       10
      /  \
     5   -3
    / \    \
   3   2    11
  / \   \
 3  -2   1

targetSum = 8
```
🔹 **Valid Paths that sum to 8:**
1. `5 → 3`
2. `5 → 2 → 1`
3. `-3 → 11`
4. `10 → -3 → 11`

🔹 **Output:**
```java
3
```

---

#### **Example 2**
🔹 **Input:**
```
      1
     / \
    2   3
   / \ / \
  4  5 6  7

targetSum = 7
```
🔹 **Valid Paths:**
1. `2 → 5`
2. `3 → 4`
3. `7`

🔹 **Output:**
```java
3
```

---

### **Intuition**
1. **Brute Force Approach (DFS for Each Node)**
    - For every **node in the tree**, start a DFS to find paths **that sum to targetSum**.
    - Since each node can be a starting point, we **call DFS for every node**.
    - **Time Complexity:** \( O(N^2) \) (for each node, DFS runs in worst case \( O(N) \))

2. **Optimized Approach (Using Prefix Sum HashMap)**
    - Instead of checking every path separately, maintain a **prefix sum hash map**.
    - The **prefix sum** stores the cumulative sum of values from the root to the current node.
    - If `currentSum - targetSum` exists in the hash map, it means we found a valid path.
    - **Time Complexity:** \( O(N) \)

---

### **Optimized Approach: Using Prefix Sum HashMap**
✅ We store **prefix sums** in a **HashMap** to optimize the search.

#### **Algorithm**
1. **Use DFS Traversal**: Keep track of the **current sum** while traversing.
2. **Use a HashMap** (`prefixSumMap`):
    - Stores **prefix sums** and **their counts** encountered so far.
    - If `currentSum - targetSum` exists in `prefixSumMap`, it means we found a **valid subpath**.
3. **Backtrack**: Remove current path sum from the HashMap while returning to the parent node.

---

### **Code Implementation**
```java
import java.util.*;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1);  // Base case: a sum of 0 exists once (empty path)
        return dfs(root, 0, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefixSumMap) {
        if (node == null) return 0;

        // Add current node's value to the sum
        currSum += node.val;

        // Check how many times (currSum - targetSum) appeared in the prefixSumMap
        int count = prefixSumMap.getOrDefault(currSum - targetSum, 0);

        // Add the current sum into the hashmap
        prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);

        // Recursively call left and right children
        count += dfs(node.left, currSum, targetSum, prefixSumMap);
        count += dfs(node.right, currSum, targetSum, prefixSumMap);

        // Backtrack: remove the current sum from the hashmap (as it's not needed in another path)
        prefixSumMap.put(currSum, prefixSumMap.get(currSum) - 1);

        return count;
    }
}
```

---

### **Time and Space Complexity**
- **Time Complexity:** \( O(N) \)
    - Each node is visited **once**.
    - HashMap operations are **O(1)**.
- **Space Complexity:** \( O(H) \) (Recursive stack space + HashMap)
    - Worst case: **O(N)** (skewed tree), Best case: **O(log N)** (balanced tree).

---

































package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CreateTree {
    public static TreeNode buildTree(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode node = queue.poll();
            if (arr[i] != -1) {
                node.left = new TreeNode(arr[i]);
                queue.offer(node.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                node.right = new TreeNode(arr[i]);
                queue.poll();
            }
            i++;
        }
        return root;
    }
}

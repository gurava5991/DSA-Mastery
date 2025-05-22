package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1};
        TreeNode root = CreateTree.buildTree(arr);
        printInorder(root);
        System.out.println();
        printPreorder(root);
        System.out.println();
        printPostorder(root);
    }

    private static void printPostorder(TreeNode root) {
        if(root != null){
            printPreorder(root.left);
            printPostorder(root.right);
            System.out.print(root.val + " ");
        }
    }

    private static void printPreorder(TreeNode root) {
        if(root != null){
            System.out.print(root.val + " ");
            printPreorder(root.left);
            printPostorder(root.right);
        }
    }

    private static void printInorder(TreeNode root) {
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}

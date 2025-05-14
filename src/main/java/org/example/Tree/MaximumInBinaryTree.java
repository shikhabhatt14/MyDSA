package org.example.Tree;

public class MaximumInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        System.out.println("Maximum value in the binary tree: " + findMax(root));
    }

    public static int findMax(TreeNode root){
        if(root == null)
            return Integer.MIN_VALUE;
        int maxLeft = findMax(root.left);
        int maxRight = findMax(root.right);
        return Math.max(root.key, Math.max(maxLeft, maxRight));
    }

}

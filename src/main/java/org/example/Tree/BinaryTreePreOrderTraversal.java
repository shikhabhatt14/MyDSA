package org.example.Tree;

public class BinaryTreePreOrderTraversal {

    //Type of Depth First Traversal where the root node is visited first, followed by the left subtree and then the right subtree.

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("In-order Traversal:");
        preOrderTraversal(root);
    }

    public static void preOrderTraversal(TreeNode root){
        if(root != null) {
            System.out.println(root.key);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

}

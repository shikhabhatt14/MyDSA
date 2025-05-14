package org.example.Tree;

public class BinaryTreePostOrderTraversal {

    //type of Depth First Traversal where we visit the left subtree, then the right subtree, and finally the root node.

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("In-order Traversal:");
        postOrderTraversal(root);
    }

    public static void postOrderTraversal(TreeNode root){
        if(root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.key);
        }
    }

}

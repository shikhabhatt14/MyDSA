package org.example.Tree;

public class BinaryTreeInOrderTraversal {

    //type of Depth First Traversal where we traverse the left subtree, then the root node, and finally the right subtree.

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("In-order Traversal:");
        inOrderTraversal(root);
    }

    public static void inOrderTraversal(TreeNode root){
        if(root != null) {
            inOrderTraversal(root.left);
            System.out.println(" " + root.key);
            inOrderTraversal(root.right);
        }
    }

}

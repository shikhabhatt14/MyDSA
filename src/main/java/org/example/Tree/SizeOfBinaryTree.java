package org.example.Tree;

public class SizeOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        System.out.println("Size of the binary tree: " + size(root));
    }

    public static int size(TreeNode root){
        if(root == null)
            return 0;
        return 1+size(root.left)+size(root.right);
    }

}

package org.example.Tree;

public class HeightOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        System.out.println("Height of the binary tree: " + height(root));
    }

    public static int height(TreeNode root){
        if (root == null) {
            return 0;
        }
        int hLeft = height(root.left);
        int hright = height(root.right);
        return Math.max(hLeft, hright) + 1;
    }

}

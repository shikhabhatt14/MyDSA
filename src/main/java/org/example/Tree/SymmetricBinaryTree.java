package org.example.Tree;

public class SymmetricBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean isSymmetric = isSymmetric(root);
        System.out.println("Is the binary tree symmetric? " + isSymmetric);
    }

    public static boolean isSymmetric(TreeNode root){
        if(root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode leftSub, TreeNode rightSub){
        if(leftSub == null && rightSub == null)
            return true;
        if(leftSub ==null || rightSub == null || leftSub.key != rightSub.key)
            return false;
        return isMirror(leftSub.left, rightSub.right) && isMirror(leftSub.right, rightSub.left);
    }

}

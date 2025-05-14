package org.example.Tree;

public class ChildrenSumProperty {


    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);*/

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(4);

        System.out.println("Does the tree satisfy the children sum property? " + isChildrenSumProperty(root));
    }

    public static boolean isChildrenSumProperty(TreeNode root){
        if(root == null)
            return true;
        if(root.left ==  null && root.right == null)
            return true;
        int sum = 0;
        if(root.left != null)
            sum += root.left.key;
        if(root.right != null)
            sum += root.right.key;
        if(root.key == sum && isChildrenSumProperty(root.left) && isChildrenSumProperty(root.right))
            return true;
        else
            return false;

    }


}

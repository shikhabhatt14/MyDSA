package org.example.Tree;

public class PrintNodesAtKDistanceFromRoot {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        int k = 3;
        System.out.println("Nodes at distance " + k + " from the root:");
        printNodesAtKDistance(root, k);
    }

    public static void printNodesAtKDistance(TreeNode root, int k){
        if(root != null){
            if(k ==0)
                System.out.println(root.key);
            printNodesAtKDistance(root.left, k-1);
            printNodesAtKDistance(root.right, k-1);
        }
    }

}

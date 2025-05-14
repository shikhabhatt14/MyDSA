package org.example.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);

        System.out.println("Left view of the binary tree:");
        //printLeftViewRecursive(root);
        printLeftViewIterative(root);

    }

    public static void printLeftViewRecursive(TreeNode root){
        if(root != null){
            System.out.println(root.key);
            if(root.left != null)
                printLeftViewRecursive(root.left);
            if(root.right != null)
                printLeftViewRecursive(root.right);
        }
    }

    public static void printLeftViewIterative(TreeNode root){
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int count = queue.size();
                for(int i=0;i<count;i++){
                    TreeNode curr = queue.poll();
                    if(i==0)
                        System.out.print(curr.key +" ");
                    if(curr.left != null)
                        queue.add(curr.left);
                    if(curr.right != null)
                        queue.add(curr.right);
                }
            }
        }
    }

}
